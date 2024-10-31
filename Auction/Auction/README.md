# Auction System Java
Sistem lelang sederhana yang diimplementasikan dalam bahasa Java untuk BlueJ.

## Fitur
- Pendaftaran peserta lelang
- Penambahan item lelang
- Sistem penawaran
- Tracking pemenang lelang
- Riwayat penawaran
- Validasi penawaran
- Multiple item lelang

## Persyaratan Sistem
- Java Development Kit (JDK) 8 atau lebih tinggi
- BlueJ IDE

## Cara Instalasi
1. Buka BlueJ
2. Buat project baru
3. Buat class-class yang diperlukan:
   - AuctionSystem
   - Item
   - Person
4. Copy-paste source code ke masing-masing class
5. Compile semua class

## Cara Penggunaan
1. Buat objek AuctionSystem baru
2. Gunakan method yang tersedia:
   - `daftarPeserta(nama, kontak)` - Mendaftarkan peserta baru
   - `tambahItem(nama, deskripsi, hargaAwal)` - Menambah item lelang
   - `lakukanPenawaran(namaPeserta, namaItem, hargaTawar)` - Melakukan penawaran
   - `tutupLelang(namaItem)` - Menutup lelang
   - `tampilkanItemLelang()` - Melihat semua item
   - `tampilkanRiwayatPenawaran(namaPeserta)` - Melihat riwayat penawaran

## Contoh Penggunaan
```java
AuctionSystem lelang = new AuctionSystem();

// Daftarkan peserta
lelang.daftarPeserta("John", "john@email.com");

// Tambah item
lelang.tambahItem("Lukisan", "Lukisan antik", 5000000);

// Lakukan penawaran
lelang.lakukanPenawaran("John", "Lukisan", 5500000);

// Lihat status
lelang.tampilkanItemLelang();

// Tutup lelang
lelang.tutupLelang("Lukisan");
```

## Struktur Program
### Class
1. `AuctionSystem`
   - Class utama untuk mengelola sistem lelang
2. `Item`
   - Menyimpan informasi item lelang
3. `Person`
   - Mengelola data peserta lelang

### Method Utama
- Registrasi dan manajemen peserta
- Pengelolaan item lelang
- Proses penawaran
- Pelaporan dan monitoring

## Validasi dan Keamanan
- Validasi harga penawaran
- Pengecekan status lelang
- Validasi peserta
- Pencatatan riwayat

## Error Handling
- Penanganan peserta tidak ditemukan
- Penanganan item tidak ditemukan
- Penanganan penawaran tidak valid
- Penanganan lelang sudah ditutup

## Best Practices
- Selalu validasi input
- Simpan riwayat penawaran
- Batasi akses method sensitif
- Dokumentasikan perubahan status
- Buat backup data regular

## Debug Mode
Fitur untuk administrator:
- Monitoring aktivitas sistem
- Reset status lelang
- Export data lelang
- Manajemen peserta

## Pengujian
Skenario test yang disarankan:
1. Registrasi peserta
2. Penambahan item
3. Proses penawaran
4. Penutupan lelang
5. Penanganan error

