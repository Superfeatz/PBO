/**
 * Class TicketMachine - mesin penjual tiket sederhana
 */
public class TicketMachine {
    private int harga;           // harga tiket
    private int saldo;          // uang yang dimasukkan
    private int total;          // total uang yang terkumpul
    private int jumlahTiket;    // jumlah tiket yang tersedia
    
    /**
     * Membuat mesin tiket baru yang menjual tiket dengan harga tertentu.
     * Jumlah tiket awal diset ke 100.
     */
    public TicketMachine(int hargaTiket) {
        harga = hargaTiket;
        saldo = 0;
        total = 0;
        jumlahTiket = 100;
    }
    
    /**
     * Mengembalikan harga tiket.
     */
    public int getHarga() {
        return harga;
    }
    
    /**
     * Mengembalikan jumlah uang yang sudah dimasukkan untuk tiket berikutnya.
     */
    public int getSaldo() {
        return saldo;
    }
    
    /**
     * Mengembalikan jumlah tiket yang tersisa.
     */
    public int getJumlahTiket() {
        return jumlahTiket;
    }
    
    /**
     * Menerima sejumlah uang dari pelanggan.
     */
    public void masukkanUang(int jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Uang " + jumlah + " berhasil dimasukkan.");
            System.out.println("Saldo Anda sekarang: " + saldo);
        } else {
            System.out.println("Masukkan jumlah uang yang valid!");
        }
    }
    
    /**
     * Mencetak tiket jika sudah dibayar cukup.
     */
    public void cetakTiket() {
        if (jumlahTiket <= 0) {
            System.out.println("Maaf, tiket sudah habis!");
            return;
        }
        
        if (saldo >= harga) {
            // Mencetak tiket
            System.out.println("\n##################");
            System.out.println("# TIKET");
            System.out.println("# Harga: " + harga + " rupiah");
            System.out.println("##################\n");
            
            // Update jumlah uang yang terkumpul
            total += harga;
            
            // Kembalikan uang lebih
            int kembalian = saldo - harga;
            if (kembalian > 0) {
                System.out.println("Kembalian Anda: " + kembalian);
            }
            
            // Reset saldo dan kurangi jumlah tiket
            saldo = 0;
            jumlahTiket--;
            
            System.out.println("Sisa tiket: " + jumlahTiket);
        } else {
            System.out.println("Uang tidak cukup. Anda perlu memasukkan " + 
                             (harga - saldo) + " rupiah lagi.");
        }
    }
    
    /**
     * Mengembalikan uang yang dimasukkan jika pelanggan berubah pikiran.
     */
    public int batalkanTransaksi() {
        int kembalian = saldo;
        saldo = 0;
        if (kembalian > 0) {
            System.out.println("Mengembalikan uang sebesar: " + kembalian);
        } else {
            System.out.println("Tidak ada uang yang dikembalikan.");
        }
        return kembalian;
    }
    
    /**
     * Untuk admin: mengecek total uang yang terkumpul.
     */
    public int cekTotal() {
        return total;
    }
    
    /**
     * Untuk admin: menambah stok tiket.
     */
    public void tambahStok(int jumlah) {
        if (jumlah > 0) {
            jumlahTiket += jumlah;
            System.out.println("Stok tiket ditambah " + jumlah);
            System.out.println("Total tiket sekarang: " + jumlahTiket);
        } else {
            System.out.println("Masukkan jumlah yang valid!");
        }
    }
}