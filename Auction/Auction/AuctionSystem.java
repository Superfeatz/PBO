import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class utama yang mengelola sistem lelang
 */
public class AuctionSystem {
    private ArrayList<Item> daftarItem;
    private ArrayList<Person> daftarPeserta;
    
    public AuctionSystem() {
        daftarItem = new ArrayList<>();
        daftarPeserta = new ArrayList<>();
    }
    
    /**
     * Mendaftarkan peserta baru
     */
    public void daftarPeserta(String nama, String kontak) {
        Person pesertaBaru = new Person(nama, kontak);
        daftarPeserta.add(pesertaBaru);
        System.out.println("Peserta " + nama + " berhasil didaftarkan.");
    }
    
    /**
     * Menambahkan item baru untuk dilelang
     */
    public void tambahItem(String nama, String deskripsi, double hargaAwal) {
        Item itemBaru = new Item(nama, deskripsi, hargaAwal);
        daftarItem.add(itemBaru);
        System.out.println("Item " + nama + " berhasil ditambahkan ke lelang.");
    }
    
    /**
     * Melakukan penawaran untuk suatu item
     */
    public void lakukanPenawaran(String namaPeserta, String namaItem, double hargaTawar) {
        // Cari peserta
        Person peserta = null;
        for (Person p : daftarPeserta) {
            if (p.getNama().equals(namaPeserta)) {
                peserta = p;
                break;
            }
        }
        
        if (peserta == null) {
            System.out.println("Peserta tidak ditemukan!");
            return;
        }
        
        // Cari item
        Item item = null;
        for (Item i : daftarItem) {
            if (i.getNama().equals(namaItem)) {
                item = i;
                break;
            }
        }
        
        if (item == null) {
            System.out.println("Item tidak ditemukan!");
            return;
        }
        
        // Cek status lelang
        if (!item.getStatusLelang()) {
            System.out.println("Maaf, lelang untuk item ini sudah ditutup!");
            return;
        }
        
        // Proses penawaran
        if (hargaTawar > item.getHargaTertinggi()) {
            item.setHargaTertinggi(hargaTawar);
            item.setPenawarTertinggi(namaPeserta);
            peserta.tambahPenawaran(namaItem, hargaTawar);
            System.out.println("Penawaran berhasil!");
            System.out.println("Harga tertinggi saat ini: " + hargaTawar);
        } else {
            System.out.println("Penawaran gagal! Harga tawaran harus lebih tinggi dari " + 
                             item.getHargaTertinggi());
        }
    }
    
    /**
     * Menutup lelang untuk suatu item
     */
    public void tutupLelang(String namaItem) {
        for (Item item : daftarItem) {
            if (item.getNama().equals(namaItem)) {
                item.tutupLelang();
                System.out.println("Lelang untuk " + namaItem + " telah ditutup!");
                System.out.println("Pemenang: " + item.getPenawarTertinggi());
                System.out.println("Harga akhir: " + item.getHargaTertinggi());
                return;
            }
        }
        System.out.println("Item tidak ditemukan!");
    }
    
    /**
     * Menampilkan semua item yang sedang dilelang
     */
    public void tampilkanItemLelang() {
        System.out.println("\n=== DAFTAR ITEM LELANG ===");
        for (Item item : daftarItem) {
            System.out.println("\nNama: " + item.getNama());
            System.out.println("Deskripsi: " + item.getDeskripsi());
            System.out.println("Harga awal: " + item.getHargaAwal());
            System.out.println("Harga tertinggi saat ini: " + item.getHargaTertinggi());
            System.out.println("Penawar tertinggi: " + item.getPenawarTertinggi());
            System.out.println("Status: " + (item.getStatusLelang() ? "Masih dibuka" : "Sudah ditutup"));
        }
    }
    
    /**
     * Menampilkan riwayat penawaran seorang peserta
     */
    public void tampilkanRiwayatPenawaran(String namaPeserta) {
        for (Person peserta : daftarPeserta) {
            if (peserta.getNama().equals(namaPeserta)) {
                System.out.println("\n=== RIWAYAT PENAWARAN " + namaPeserta + " ===");
                for (String item : peserta.getPenawaran().keySet()) {
                    System.out.println("Item: " + item + ", Tawaran: " + 
                                     peserta.getPenawaran().get(item));
                }
                return;
            }
        }
        System.out.println("Peserta tidak ditemukan!");
    }
}