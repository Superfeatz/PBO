# Technical Support System

Sistem Technical Support sederhana yang dibangun menggunakan Java. Sistem ini menyediakan antarmuka interaktif untuk membantu pengguna dengan masalah teknis umum.

## Daftar Isi
- [Penggunaan](#penggunaan)
- [Struktur Project](#struktur-project)
- [Fitur](#fitur)

## Penggunaan
1. Klik kanan pada class TechSupportSystem
2. Pilih opsi 'void main(String[] args)'
3. Sistem akan menampilkan pesan selamat datang
4. Masukkan pertanyaan atau keluhan Anda
5. Sistem akan memberikan respons otomatis
6. Untuk keluar dari sistem, ketik 'bye'

## Struktur Project
```
TechSupportSystem/
│
├── TechSupportSystem.java   # Class utama untuk menjalankan sistem
├── InputReader.java         # Class untuk menangani input pengguna
└── Responder.java          # Class untuk menghasilkan respons
```

## Fitur
- Interface berbahasa Indonesia
- Input dan output interaktif via console
- Respons otomatis untuk pertanyaan umum
- Sistem exit yang mudah dengan keyword 'bye'
- Daftar respons yang bisa dikustomisasi
- Random response generator untuk variasi jawaban


## Troubleshooting

### Error saat Compile
1. Pastikan semua file ada dalam project yang sama
2. Periksa syntax Java
3. Pastikan nama class sesuai dengan nama file

### Program Tidak Berjalan
1. Pastikan semua class sudah di-compile
2. Periksa apakah JDK terinstall dengan benar
3. Restart BlueJ jika diperlukan

## Tips Penggunaan
- Gunakan pertanyaan yang jelas dan spesifik
- Satu pertanyaan untuk satu masalah
- Ikuti instruksi yang diberikan sistem
- Simpan log percakapan jika diperlukan
