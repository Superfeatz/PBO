# World of Zuul

World of Zuul adalah game petualangan berbasis teks yang dibuat dengan Java. Pemain dapat menjelajahi ruangan-ruangan, mengambil item, dan berinteraksi dengan lingkungan game.

## Daftar Isi
- [Fitur](#fitur)
- [Cara Bermain](#cara-bermain)
- [Struktur Project](#struktur-project)
- [Command yang Tersedia](#command-yang-tersedia)

## Fitur
- Navigasi antar ruangan
- Sistem inventory
- Pengambilan dan peletakan item
- Batas berat inventory
- Deskripsi ruangan yang detail
- Multiple exit directions
- Command parser yang fleksibel

## Cara Bermain
1. Jalankan class Game dengan method main()
2. Gunakan command yang tersedia untuk berinteraksi dengan game
3. Jelajahi ruangan-ruangan yang ada
4. Kumpulkan item-item yang tersedia
5. Ketik 'quit' untuk keluar dari game

## Struktur Project
```
WorldOfZuul/
├── Game.java           # Class utama game
├── Room.java          # Representasi ruangan
├── Parser.java        # Parser untuk command
├── CommandWords.java  # Daftar command valid
├── Command.java       # Object command
├── Item.java          # Representasi item
└── Inventory.java     # Sistem inventory
```

## Command yang Tersedia
- `go [arah]` - Berpindah ke ruangan lain (north/south/east/west/up/down)
- `look` - Melihat detail ruangan saat ini
- `take [item]` - Mengambil item
- `drop [item]` - Menjatuhkan item
- `inventory` - Melihat isi inventory
- `help` - Menampilkan bantuan
- `quit` - Keluar dari game


## Troubleshooting

### Error Umum
1. **ClassNotFoundException**
   - Pastikan semua file ada dalam project
