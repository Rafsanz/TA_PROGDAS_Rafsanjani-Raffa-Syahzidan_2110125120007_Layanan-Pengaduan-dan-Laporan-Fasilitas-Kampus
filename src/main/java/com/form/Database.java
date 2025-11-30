package com.form;

import java.util.ArrayList;

public class Database {
    private static ArrayList<Pengaduan> data = new ArrayList<>();

    public static void tambah(Pengaduan p) {
        data.add(p);
    }

    public static ArrayList<Pengaduan> getAll() {
        return data;
    }
}
