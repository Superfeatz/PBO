# Kalkulator Java
Program kalkulator sederhana yang diimplementasikan dalam bahasa Java untuk BlueJ.

## Fitur
- Operasi matematika dasar:
  - Penjumlahan
  - Pengurangan
  - Perkalian
  - Pembagian
- Interface yang interaktif
- Penanganan pembagian dengan nol
- Format output dengan 2 angka desimal
- Loop untuk multiple kalkulasi

## Cara Penggunaan
1. Klik kanan pada class Kalkulator di BlueJ
2. Pilih 'new Kalkulator()'
3. Klik kanan pada objek yang dibuat
4. Pilih 'void mulai()'
5. Ikuti menu yang ditampilkan:
   - Pilih operasi (1-5)
   - Masukkan angka pertama
   - Masukkan angka kedua
   - Lihat hasil
   - Ulangi atau pilih 5 untuk keluar

## Contoh Penggunaan
```
=== Kalkulator Sederhana ===
1. Penjumlahan
2. Pengurangan
3. Perkalian
4. Pembagian
5. Keluar
Pilih operasi (1-5): 1
Masukkan angka pertama: 10
Masukkan angka kedua: 5
Hasil: 10.00 + 5.00 = 15.00
```

## Struktur Program
- `Kalkulator` - Class utama
  - `mulai()` - Memulai program
  - `tampilkanMenu()` - Menampilkan menu operasi
  - `tambah()` - Metode penjumlahan
  - `kurang()` - Metode pengurangan
  - `kali()` - Metode perkalian
  - `bagi()` - Metode pembagian

