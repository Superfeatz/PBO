// Class TechSupportSystem.java
public class TechSupportSystem {
    private Responder responder;
    private InputReader reader;
    private boolean finished;

    public TechSupportSystem() {
        responder = new Responder();
        reader = new InputReader();
        finished = false;
    }

    public void start() {
        printWelcome();
        while(!finished) {
            String input = reader.getInput().trim().toLowerCase();
            
            if(input.startsWith("bye")) {
                finished = true;
            }
            else {
                String response = responder.generateResponse();
                System.out.println(response);
            }
        }
        printGoodbye();
    }

    private void printWelcome() {
        System.out.println("Selamat datang di System Technical Support");
        System.out.println("Silakan jelaskan masalah Anda.");
        System.out.println("Ketik 'bye' untuk keluar.\n");
    }

    private void printGoodbye() {
        System.out.println("Terima kasih telah menggunakan Technical Support System. Sampai jumpa!");
    }

    public static void main(String[] args) {
        TechSupportSystem supportSystem = new TechSupportSystem();
        supportSystem.start();
    }
}