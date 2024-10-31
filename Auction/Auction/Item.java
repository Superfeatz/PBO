import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class untuk menyimpan detail barang yang dilelang
 */
class Item {
    private String nama;
    private String deskripsi;
    private double hargaAwal;
    private double hargaTertinggi;
    private String penawarTertinggi;
    private boolean statusLelang;
    
    public Item(String nama, String deskripsi, double hargaAwal) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.hargaAwal = hargaAwal;
        this.hargaTertinggi = hargaAwal;
        this.penawarTertinggi = "Belum ada";
        this.statusLelang = true;
    }
    
    // Getters
    public String getNama() { return nama; }
    public String getDeskripsi() { return deskripsi; }
    public double getHargaAwal() { return hargaAwal; }
    public double getHargaTertinggi() { return hargaTertinggi; }
    public String getPenawarTertinggi() { return penawarTertinggi; }
    public boolean getStatusLelang() { return statusLelang; }
    
    // Setters
    public void setHargaTertinggi(double harga) { this.hargaTertinggi = harga; }
    public void setPenawarTertinggi(String penawar) { this.penawarTertinggi = penawar; }
    public void tutupLelang() { this.statusLelang = false; }
}