# Car Rental System Documentation

## Deskripsi Latihan
Sistem Rental Mobil adalah aplikasi berbasis Java yang mengimplementasikan konsep OOP (Object-Oriented Programming) untuk mengelola penyewaan kendaraan. Sistem ini memungkinkan pengguna untuk melihat daftar mobil yang tersedia, melakukan penyewaan, dan melihat status rental aktif.

## Struktur Proyek
Proyek terdiri dari beberapa kelas utama yang saling terhubung:

### 1. Class Vehicle (Parent Class)
- Kelas abstrak yang menjadi dasar untuk semua jenis kendaraan
- Properties:
  - vehicleId: ID unik kendaraan
  - brand: Merek kendaraan
  - model: Model kendaraan
  - rentalRate: Tarif sewa per hari
  - isAvailable: Status ketersediaan

### 2. Class Car (Child Class)
- Turunan dari kelas Vehicle
- Properti tambahan:
  - numSeats: Jumlah kursi
  - transmission: Jenis transmisi (Manual/Automatic)

### 3. Class Customer
- Mengelola informasi pelanggan
- Properties:
  - customerId: ID unik pelanggan
  - name: Nama pelanggan
  - phoneNumber: Nomor telepon

### 4. Class Rental
- Menangani transaksi penyewaan
- Properties:
  - vehicle: Kendaraan yang disewa
  - customer: Pelanggan yang menyewa
  - rentalDate: Tanggal sewa
  - daysRented: Durasi sewa

### 5. Class RentalSystem
- Kelas utama yang mengintegrasikan semua fungsionalitas
- Fitur:
  - Manajemen daftar kendaraan
  - Manajemen pelanggan
  - Proses penyewaan
  - Menu interaktif

## Fitur Sistem
1. **Melihat Daftar Mobil**
   - Menampilkan semua mobil yang tersedia
   - Informasi detail setiap mobil (ID, merek, model, tarif, dll.)

2. **Penyewaan Mobil**
   - Input data pelanggan
   - Pemilihan mobil dari daftar
   - Penentuan durasi sewa
   - Kalkulasi biaya total

3. **Melihat Rental Aktif**
   - Daftar semua penyewaan yang sedang berlangsung
   - Detail penyewaan (pelanggan, mobil, tanggal)

## Implementasi OOP
1. **Inheritance (Pewarisan)**
   - Vehicle sebagai parent class
   - Car sebagai child class yang mewarisi Vehicle

2. **Encapsulation (Enkapsulasi)**
   - Penggunaan access modifier (private, protected, public)
   - Getter dan setter methods

3. **Abstraction (Abstraksi)**
   - Vehicle sebagai abstract class
   - Abstract method getVehicleType()

## Cara Penggunaan
1. **Kompilasi Program**
   ```
   - Buat file terpisah untuk setiap class
   - Compile semua file Java
   ```

2. **Menjalankan Program**
   ```
   - Jalankan class RentalSystem
   - Pilih opsi dari menu utama:
     1. View Available Cars
     2. Rent a Car
     3. View Active Rentals
     4. Exit
   ```

3. **Proses Rental**
   ```
   - Pilih opsi 2 dari menu utama
   - Pilih nomor mobil yang tersedia
   - Masukkan data penyewa:
     - Nama
     - Nomor telepon
   - Masukkan durasi sewa
   - Sistem akan menampilkan detail rental dan total biaya
   ```

## Contoh Output
![Screenshot (153)](https://github.com/user-attachments/assets/925604fb-9d45-4106-b202-940e5e4bfea7)



