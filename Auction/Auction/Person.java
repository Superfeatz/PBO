import java.util.ArrayList;
import java.util.HashMap;
/**
 * Class untuk menyimpan informasi peserta lelang
 */
class Person {
    private String nama;
    private String kontak;
    private HashMap<String, Double> penawaran;
    
    public Person(String nama, String kontak) {
        this.nama = nama;
        this.kontak = kontak;
        this.penawaran = new HashMap<>();
    }
    
    public String getNama() { return nama; }
    public String getKontak() { return kontak; }
    public HashMap<String, Double> getPenawaran() { return penawaran; }
    
    public void tambahPenawaran(String namaItem, double harga) {
        penawaran.put(namaItem, harga);
    }
}
