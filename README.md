# Layanan Pengaduan dan Laporan Fasilitas Kampus
Dibuat sebagai tugas akhir mata kuliah **Pemrograman Berorientasi Objek**.
## Deskripsi
Aplikasi desktop berbasis Java Swing dengan tampilan modern untuk melaporkan dan melihat daftar pengaduan fasilitas rusak.

Program ini memiliki form untuk melaporkan fasilitas kampus Tekkom yang rusak atau tidak berfungsi dengan baik.

> 💡 **Catatan**: Aplikasi ini menggunakan **efek blur latar belakang** dan **animasi ikon**, sehingga tampilan terlihat sangat modern meskipun dibangun dengan Java Swing.

## Fitur Visual 
- **Efek blur background** menggunakan library kustom `swing-blur-background`
- **Animasi ikon saat hover** dengan `swing-animation-icon`
- **Tema gelap FlatLaf** ala macOS
- **Tata letak responsif** dengan MigLayout

## Cara Menjalankan

### Prasyarat
- **JDK 24**
- **IntelliJ IDEA** (disarankan)
- Maven (otomatis terintegrasi di IntelliJ)

### Langkah-langkah
1. Clone repositori:
   ```bash
   git clone https://github.com/Rafsanz/TA_PROGDAS_Rafsanjani-Raffa-Syahzidan_2110125120007_Layanan-Pengaduan-dan-Laporan-Fasilitas-Kampus.git
   ```
2. Buka folder proyek di IntelliJ IDEA → Pilih "Open as Maven Project"
3. Tunggu proses import dependensi selesai (IntelliJ akan otomatis membaca pom.xml)
4. Jalankan kelas utama: com.ta.MainApp

## Dependensi
Project ini mengimport library eksternal seperti:
- FlatLaf : Tema modern untuk antarmuka Swing
- MigLayout : Layout manager canggih untuk tata letak fleksibel
- TwelveMonkeys : Dukungan format gambar tambahan
- swing-blur-background (raven) : Efek latar belakang blur transparan
- swing-animation-icon (raven) : Animasi ikon saat mouse hover

## Penyimpanan Data
- Data pengaduan disimpan sementara di memori (ArrayList).
- Semua data akan hilang saat aplikasi ditutup.

## Teknologi
- Bahasa Pemrograman: Java 24
- GUI Framework: Java Swing + FlatLaf
- Layout Manager: MigLayout + GridBagLayout
- Build Tool: Apache Maven
- IDE: IntelliJ IDEA

## Screenshot
Home / Main Menu
<img width="882" height="589" alt="image" src="https://github.com/user-attachments/assets/a6cc2fc8-64c2-42de-aab8-df788a050fc2" />

Form Lapor
<img width="888" height="590" alt="image" src="https://github.com/user-attachments/assets/f4c731e2-bdca-4446-a60f-2b33619e3307" />

