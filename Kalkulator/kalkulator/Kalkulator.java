import java.util.Scanner;

public class Kalkulator {
    private Scanner input;
    
    public Kalkulator() {
        input = new Scanner(System.in);
    }
    
    public void mulai() {
        while (true) {
            tampilkanMenu();
            int pilihan = input.nextInt();
            
            if (pilihan == 5) {
                System.out.println("Terima kasih telah menggunakan kalkulator!");
                break;
            }
            
            System.out.print("Masukkan angka pertama: ");
            double angka1 = input.nextDouble();
            
            System.out.print("Masukkan angka kedua: ");
            double angka2 = input.nextDouble();
            
            double hasil = 0;
            
            switch (pilihan) {
                case 1:
                    hasil = tambah(angka1, angka2);
                    System.out.printf("Hasil: %.2f + %.2f = %.2f%n", 
                        angka1, angka2, hasil);
                    break;
                case 2:
                    hasil = kurang(angka1, angka2);
                    System.out.printf("Hasil: %.2f - %.2f = %.2f%n", 
                        angka1, angka2, hasil);
                    break;
                case 3:
                    hasil = kali(angka1, angka2);
                    System.out.printf("Hasil: %.2f * %.2f = %.2f%n", 
                        angka1, angka2, hasil);
                    break;
                case 4:
                    if (angka2 != 0) {
                        hasil = bagi(angka1, angka2);
                        System.out.printf("Hasil: %.2f / %.2f = %.2f%n", 
                            angka1, angka2, hasil);
                    } else {
                        System.out.println("Error: Pembagian dengan nol!");
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println();
        }
    }
    
    private void tampilkanMenu() {
        System.out.println("=== Kalkulator Sederhana ===");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");
        System.out.println("5. Keluar");
        System.out.print("Pilih operasi (1-5): ");
    }
    
    private double tambah(double a, double b) {
        return a + b;
    }
    
    private double kurang(double a, double b) {
        return a - b;
    }
    
    private double kali(double a, double b) {
        return a * b;
    }
    
    private double bagi(double a, double b) {
        return a / b;
    }
    
    public static void main(String[] args) {
        Kalkulator calc = new Kalkulator();
        calc.mulai();
    }
}