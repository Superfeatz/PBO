// Abstract class MakhlukHidup
abstract class MakhlukHidup {
    protected String nama;
    protected int umur;
    
    public MakhlukHidup(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }
    
    // Abstract methods yang wajib diimplementasikan oleh class turunan
    abstract void bernapas();
    abstract void berkembangBiak();
    abstract void makan();
    
    // Method konkrit yang bisa digunakan langsung
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
    }
}

// Class Manusia yang mewarisi MakhlukHidup
class Manusia extends MakhlukHidup {
    private String pekerjaan;
    
    public Manusia(String nama, int umur, String pekerjaan) {
        super(nama, umur);
        this.pekerjaan = pekerjaan;
    }
    
    @Override
    void bernapas() {
        System.out.println("Manusia bernapas menggunakan paru-paru");
    }
    
    @Override
    void berkembangBiak() {
        System.out.println("Manusia berkembang biak dengan melahirkan");
    }
    
    @Override
    void makan() {
        System.out.println("Manusia makan makanan yang dimasak");
    }
    
    public void bekerja() {
        System.out.println("Manusia bekerja sebagai " + pekerjaan);
    }
}

// Class Hewan yang mewarisi MakhlukHidup
class Hewan extends MakhlukHidup {
    private String jenis;
    
    public Hewan(String nama, int umur, String jenis) {
        super(nama, umur);
        this.jenis = jenis;
    }
    
    @Override
    void bernapas() {
        System.out.println("Hewan bernapas menggunakan " + 
            (jenis.equals("ikan") ? "insang" : "paru-paru"));
    }
    
    @Override
    void berkembangBiak() {
        System.out.println("Hewan berkembang biak dengan bertelur atau melahirkan");
    }
    
    @Override
    void makan() {
        System.out.println("Hewan makan makanan mentah");
    }
}

// Class Tumbuhan yang mewarisi MakhlukHidup
class Tumbuhan extends MakhlukHidup {
    private String jenisDaun;
    
    public Tumbuhan(String nama, int umur, String jenisDaun) {
        super(nama, umur);
        this.jenisDaun = jenisDaun;
    }
    
    @Override
    void bernapas() {
        System.out.println("Tumbuhan bernapas melalui stomata daun");
    }
    
    @Override
    void berkembangBiak() {
        System.out.println("Tumbuhan berkembang biak dengan biji atau tunas");
    }
    
    @Override
    void makan() {
        System.out.println("Tumbuhan membuat makanan sendiri melalui fotosintesis");
    }
    
    public void fotosintesis() {
        System.out.println("Tumbuhan melakukan fotosintesis dengan daun " + jenisDaun);
    }
}

// Main class untuk testing
public class Main {
    public static void main(String[] args) {
        Manusia manusia = new Manusia("John", 25, "Programmer");
        Hewan hewan = new Hewan("Leo", 5, "singa");
        Tumbuhan tumbuhan = new Tumbuhan("Mawar", 1, "majemuk");
        
        System.out.println("=== Info Manusia ===");
        manusia.tampilkanInfo();
        manusia.bernapas();
        manusia.makan();
        manusia.berkembangBiak();
        manusia.bekerja();
        
        System.out.println("\n=== Info Hewan ===");
        hewan.tampilkanInfo();
        hewan.bernapas();
        hewan.makan();
        hewan.berkembangBiak();
        
        System.out.println("\n=== Info Tumbuhan ===");
        tumbuhan.tampilkanInfo();
        tumbuhan.bernapas();
        tumbuhan.makan();
        tumbuhan.berkembangBiak();
        tumbuhan.fotosintesis();
    }
}