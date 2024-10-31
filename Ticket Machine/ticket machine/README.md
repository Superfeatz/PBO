# Ticket Machine Java
Implementasi mesin tiket sederhana dalam bahasa Java untuk BlueJ.

## Fitur
- Pembuatan tiket dengan harga yang dapat dikonfigurasi
- Sistem pembayaran dengan kembalian
- Penghitungan total pendapatan
- Pengelolaan stok tiket
- Validasi input uang
- Interface yang user-friendly


## Cara Penggunaan
1. Klik kanan pada class TicketMachine di BlueJ
2. Pilih 'new TicketMachine(harga)'
   - Contoh: new TicketMachine(5000)
3. Gunakan method yang tersedia:
   - `getHarga()` - Melihat harga tiket
   - `getSaldo()` - Melihat saldo yang sudah dimasukkan
   - `masukkanUang(jumlah)` - Memasukkan uang
   - `cetakTiket()` - Mencetak tiket
   - `batalkanTransaksi()` - Membatalkan transaksi

## Contoh Penggunaan
```java
TicketMachine mesin = new TicketMachine(5000);
mesin.masukkanUang(3000);
mesin.masukkanUang(3000);
mesin.cetakTiket();
```

## Struktur Program
- `TicketMachine` - Class utama
  - Constructor - Inisialisasi mesin dengan harga tiket
  - Getter methods - Mengakses informasi mesin
  - Action methods - Melakukan operasi tiket
  - Admin methods - Mengelola mesin

## Fitur Keamanan
- Validasi input uang (harus positif)
- Pengecekan saldo sebelum mencetak tiket
- Pengecekan stok tiket
- Sistem kembalian otomatis

## Error Handling
- Penanganan input uang negatif
- Penanganan saldo tidak cukup
- Penanganan stok habis
- Pesan error yang informatif

## Debug Mode
Untuk administrator:
1. `cekTotal()` - Melihat total pendapatan
2. `tambahStok(jumlah)` - Menambah stok tiket
3. `resetMesin()` - Mereset mesin ke kondisi awal

## Pengujian
Skenario test yang disarankan:
1. Pembelian tiket normal
2. Pembelian dengan uang pas
3. Pembelian dengan kembalian
4. Pembatalan transaksi
5. Pembelian saat stok habis

