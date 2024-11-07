## Deskripsi

Latihan ini mensimulasikan aplikasi jejaring sosial skala kecil dengan mengelola pengguna dan interaksi mereka melalui postingan dan suka.

## Struktur Proyek

Proyek ini dibagi menjadi beberapa kelas utama:
1. **`User`**: Mewakili pengguna dalam jaringan yang dapat membuat postingan, menyukai postingan, dan mengikuti pengguna lain.
2. **`Post`**: Mewakili postingan yang dibuat oleh pengguna, dengan fungsi untuk menerima "like" dari pengguna lain.
3. **`Network`**: Mengelola koleksi pengguna dan semua postingan dalam jaringan.

## Penjelasan Setiap Kelas

### 1. Kelas `User`
Kelas ini berfungsi untuk menyimpan informasi tentang pengguna, seperti nama pengguna (*username*), daftar postingan yang dibuat, daftar pengguna yang diikuti, dan referensi ke `Network`. Kelas ini memiliki beberapa metode, termasuk:
- **`createPost`**: Membuat postingan baru dan menambahkannya ke jaringan.
- **`likePost`**: Menambahkan "like" ke postingan tertentu.
- **`follow`**: Memungkinkan pengguna mengikuti pengguna lain.

### 2. Kelas `Post`
Kelas `Post` mewakili setiap postingan yang dibuat oleh pengguna dan memiliki informasi berikut:
- **`content`**: Isi dari postingan.
- **`author`**: Penulis atau pengguna yang membuat postingan.
- **`likes`**: Daftar pengguna yang menyukai postingan tersebut.

Metode dalam kelas `Post`:
- **`addLike`**: Menambahkan "like" dari pengguna lain, jika pengguna belum menyukai postingan tersebut.
- **`getLikeCount`**: Menghitung jumlah "like" yang diterima postingan.

### 3. Kelas `Network`
Kelas `Network` mengelola pengguna dan postingan dalam jaringan sosial. Fungsinya termasuk:
- **`addUser`**: Menambahkan pengguna baru ke jaringan.
- **`addPost`**: Menambahkan postingan baru ke daftar semua postingan dalam jaringan.
- **`getUsers`**: Mengambil daftar semua pengguna dalam jaringan.
- **`getAllPosts`**: Mengambil daftar semua postingan dalam jaringan.

### 4. Kelas `Main`
Kelas ini adalah titik masuk (*entry point*) untuk aplikasi. Melalui antarmuka berbasis teks, pengguna dapat:
1. Membuat pengguna baru.
2. Membuat postingan baru.
3. Menyukai sebuah postingan.
4. Mengikuti pengguna lain.
5. Melihat semua postingan yang ada.

Metode utama dalam kelas `Main`:
- **`createUser`**: Membuat pengguna baru dan menambahkannya ke jaringan.
- **`createPost`**: Mengizinkan pengguna membuat postingan baru.
- **`likePost`**: Memungkinkan pengguna menyukai postingan tertentu.
- **`followUser`**: Mengizinkan pengguna mengikuti pengguna lain.
- **`viewAllPosts`**: Menampilkan semua postingan yang telah dibuat dalam jaringan.

## Cara Menjalankan Program

1. Jalankan kelas `Main`.
2. Pilih opsi dari menu utama untuk membuat pengguna, membuat postingan, menyukai postingan, mengikuti pengguna lain, atau melihat semua postingan.
3. Masukkan input yang diperlukan berdasarkan pilihan menu.
4. Gunakan opsi "6" untuk keluar dari aplikasi.

## Contoh Output

![Screenshot (154)](https://github.com/user-attachments/assets/52954d39-6c0d-4a93-8762-a2634991895c)

