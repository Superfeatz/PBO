// Game.java
public class Game {
    private Parser parser;
    private Room currentRoom;
    private Inventory playerInventory;
        
    public Game() {
        parser = new Parser();
        playerInventory = new Inventory();
        createRooms();
    }

    private void createRooms() {
        Room outside, theater, pub, lab, office, basement;
        
        // create the rooms
        outside = new Room("di luar gedung kampus");
        theater = new Room("di dalam teater kampus");
        pub = new Room("di pub kampus");
        lab = new Room("di laboratorium komputer");
        office = new Room("di ruang administrasi");
        basement = new Room("di ruang bawah tanah");
        
        // initialize room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);
        
        pub.setExit("east", outside);
        
        lab.setExit("north", outside);
        lab.setExit("east", office);
        
        office.setExit("west", lab);
        office.setExit("down", basement);
        
        basement.setExit("up", office);
        
        // add items to rooms
        theater.addItem(new Item("kunci", "Kunci emas yang berkilau", 1));
        pub.addItem(new Item("buku", "Buku tua misterius", 2));
        lab.addItem(new Item("komputer", "Komputer antik", 5));
        
        currentRoom = outside;  // start game outside
    }

    public void play() {
        printWelcome();
        
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Terima kasih telah bermain. Sampai jumpa!");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Selamat datang di World of Zuul!");
        System.out.println("World of Zuul adalah game petualangan yang sangat menarik.");
        System.out.println("Ketik 'help' jika kamu butuh bantuan.");
        System.out.println();
        printLocationInfo();
    }

    private void printLocationInfo() {
        System.out.println("Kamu " + currentRoom.getDescription());
        System.out.print("Exits: ");
        System.out.println(currentRoom.getExitString());
        System.out.println();
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("Saya tidak mengerti apa yang kamu maksud...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("look")) {
            look();
        }
        else if (commandWord.equals("take")) {
            takeItem(command);
        }
        else if (commandWord.equals("drop")) {
            dropItem(command);
        }
        else if (commandWord.equals("inventory")) {
            showInventory();
        }
        
        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("Kamu tersesat. Kamu sendirian. Kamu berkeliling");
        System.out.println("di kampus.");
        System.out.println();
        System.out.println("Command yang tersedia:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("Pergi kemana?");
            return;
        }

        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Tidak ada pintu ke arah itu!");
        }
        else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    private void look() {
        System.out.println(currentRoom.getLongDescription());
    }

    private void takeItem(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("Ambil apa?");
            return;
        }

        String itemName = command.getSecondWord();
        Item item = currentRoom.removeItem(itemName);
        
        if(item == null) {
            System.out.println("Item tersebut tidak ada di ruangan ini!");
        }
        else if(playerInventory.addItem(item)) {
            System.out.println("Kamu mengambil " + itemName);
        }
        else {
            currentRoom.addItem(item);
            System.out.println("Kamu tidak bisa membawa lebih banyak barang!");
        }
    }

    private void dropItem(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("Jatuhkan apa?");
            return;
        }

        String itemName = command.getSecondWord();
        Item item = playerInventory.removeItem(itemName);
        
        if(item == null) {
            System.out.println("Kamu tidak memiliki item tersebut!");
        }
        else {
            currentRoom.addItem(item);
            System.out.println("Kamu menjatuhkan " + itemName);
        }
    }

    private void showInventory() {
        System.out.println(playerInventory.getItemString());
    }

    private boolean quit(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Quit apa?");
            return false;
        }
        else {
            return true;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}