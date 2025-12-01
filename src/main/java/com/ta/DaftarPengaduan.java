package com.ta;

import com.model.Database;
import com.model.Pengaduan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DaftarPengaduan extends JPanel {

    public DaftarPengaduan() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] kolom = {"Nama", "Lokasi", "Kategori", "Deskripsi"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0);

        // Isi data dari database
        for (Pengaduan p : Database.getAll()) {
            model.addRow(new Object[]{
                    p.getNama(),
                    p.getLokasi(),
                    p.getKategori(),
                    p.getDeskripsi()
            });
        }

        JTable table = new JTable(model);
        table.setFillsViewportHeight(true); // agar tabel memenuhi scroll pane meski data sedikit

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}