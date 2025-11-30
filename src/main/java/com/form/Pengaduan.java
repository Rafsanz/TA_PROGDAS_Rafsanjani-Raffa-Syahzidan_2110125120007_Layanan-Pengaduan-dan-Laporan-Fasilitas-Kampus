package com.form;

public class Pengaduan {
    private String nama;
    private String lokasi;
    private String kategori;
    private String deskripsi;


    public Pengaduan(String nama, String lokasi, String kategori, String deskripsi) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
    }


    public String getNama() { return nama; }
    public String getLokasi() { return lokasi; }
    public String getKategori() { return kategori; }
    public String getDeskripsi() { return deskripsi; }
}
