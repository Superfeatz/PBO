import java.util.Scanner;

// Kelas dasar Ticket
abstract class Ticket {
    protected double baseFare;

    public Ticket(double baseFare) {
        this.baseFare = baseFare;
    }

    // Metode abstrak untuk menghitung tarif
    public abstract double calculateFare();

    // Metode untuk menampilkan informasi tiket
    public abstract String getInfo();

    // Metode untuk menampilkan fasilitas yang ditawarkan
    public abstract String getBenefits();
}

// Kelas EconomyTicket
class EconomyTicket extends Ticket {
    public EconomyTicket(double baseFare) {
        super(baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 0.9; // Diskon 10%
    }

    @Override
    public String getInfo() {
        return "Kelas: Ekonomi, Tarif: " + calculateFare();
    }

    @Override
    public String getBenefits() {
        return "Fasilitas Ekonomi: Kursi standar, 1x makanan ringan, Bagasi 20kg";
    }
}

// Kelas BusinessTicket
class BusinessTicket extends Ticket {
    public BusinessTicket(double baseFare) {
        super(baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.25; // Biaya tambahan 25%
    }

    @Override
    public String getInfo() {
        return "Kelas: Bisnis, Tarif: " + calculateFare();
    }

    @Override
    public String getBenefits() {
        return "Fasilitas Bisnis: Kursi lebih luas, 2x makanan lengkap, Bagasi 30kg, Akses lounge";
    }
}

// Kelas FirstClassTicket
class FirstClassTicket extends Ticket {
    public FirstClassTicket(double baseFare) {
        super(baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.5; // Biaya tambahan 50%
    }

    @Override
    public String getInfo() {
        return "Kelas: First Class, Tarif: " + calculateFare();
    }

    @Override
    public String getBenefits() {
        return "Fasilitas First Class: Kursi tidur penuh, 3x makanan premium, Bagasi 50kg, Akses lounge VIP, Layanan pribadi";
    }
}

// Kelas utama untuk interaksi pengguna
public class TicketReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sistem Reservasi Tiket Pesawat");
        System.out.print("Masukkan tarif dasar tiket: ");
        double baseFare = scanner.nextDouble();
        scanner.nextLine(); // Membersihkan newline

        System.out.println("Pilih opsi:");
        System.out.println("1. Lihat deskripsi kelas penerbangan");
        System.out.println("2. Pilih tiket penerbangan");
        System.out.print("Masukkan pilihan (1/2): ");
        int option = scanner.nextInt();

        if (option == 1) {
            // Menampilkan deskripsi kelas penerbangan
            System.out.println("\nDeskripsi Kelas Penerbangan:");
            System.out.println("1. Ekonomi: " + new EconomyTicket(baseFare).getBenefits());
            System.out.println("2. Bisnis: " + new BusinessTicket(baseFare).getBenefits());
            System.out.println("3. First Class: " + new FirstClassTicket(baseFare).getBenefits());
            System.out.println();
        }

        System.out.println("Pilih kelas penerbangan:");
        System.out.println("1. Ekonomi");
        System.out.println("2. Bisnis");
        System.out.println("3. First Class");
        System.out.print("Masukkan pilihan (1/2/3): ");
        int choice = scanner.nextInt();

        Ticket ticket;
        switch (choice) {
            case 1:
                ticket = new EconomyTicket(baseFare);
                break;
            case 2:
                ticket = new BusinessTicket(baseFare);
                break;
            case 3:
                ticket = new FirstClassTicket(baseFare);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                scanner.close();
                return; // Keluar dari program jika pilihan tidak valid
        }

        System.out.println("Informasi Tiket: " + ticket.getInfo());
        scanner.close();
    }
}
