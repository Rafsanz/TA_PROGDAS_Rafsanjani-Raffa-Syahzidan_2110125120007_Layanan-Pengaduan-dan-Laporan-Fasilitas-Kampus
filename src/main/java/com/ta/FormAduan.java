package com.ta;

import com.model.Database;
import com.model.Pengaduan;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.sql.SQLOutput;
import java.util.Objects;

public class FormAduan extends JPanel {

    public FormAduan() {
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        initUI();
    }

    private void initUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        JTextField fieldNama = new JTextField(20);
        JTextField fieldLokasi = new JTextField(20);
        String[] kategoriOptions = {"Listrik", "Air", "Bangunan", "AC", "Lampu", "Lainnya"};
        JComboBox<String> comboKategori = new JComboBox<>(kategoriOptions);
        JTextArea areaDeskripsi = new JTextArea(6, 25);
        areaDeskripsi.setLineWrap(true);
        areaDeskripsi.setWrapStyleWord(true);
        JScrollPane scrollDeskripsi = new JScrollPane(areaDeskripsi);

        JButton submit = new JButton("Kirim");

        //judul
        JLabel titleLabel = new JLabel("Form Pengaduan Fasilitas Rusak");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);

        //nama
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1;
        add(fieldNama, gbc);

        //lokasi
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Lokasi:"), gbc);
        gbc.gridx = 1;
        add(fieldLokasi, gbc);

        //kategori
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Kategori:"), gbc);
        gbc.gridx = 1;
        add(comboKategori, gbc);

        //deskripsi
        gbc.gridx = 0; gbc.gridy = 4;
        add(new JLabel("Deskripsi:"), gbc);
        gbc.gridx = 1;
        add(scrollDeskripsi, gbc);

        //tombol kirim
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(submit, gbc);

        submit.addActionListener(e -> simpan(fieldNama, fieldLokasi, comboKategori, areaDeskripsi));
    }

    private void simpan(JTextField namaField, JTextField lokasiField,
                        JComboBox<String> kategoriCombo, JTextArea deskripsiArea) {
        String nama = namaField.getText();
        String lokasi = lokasiField.getText();
        String kategori = Objects.toString(kategoriCombo.getSelectedItem(), "");
        String deskripsi = deskripsiArea.getText();

        if (isKosong(nama) || isKosong(lokasi) || isKosong(deskripsi)) {
            JOptionPane.showMessageDialog(this, "Semua field wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Database.tambah(new Pengaduan(nama, lokasi, kategori, deskripsi));
        JOptionPane.showMessageDialog(this, "Pengaduan berhasil dikirim!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

        // Reset form
        namaField.setText("");
        lokasiField.setText("");
        deskripsiArea.setText("");
        kategoriCombo.setSelectedIndex(0);
        namaField.requestFocus();

        closeInternalFrame();
    }
    private void closeInternalFrame() {
        // Dapatkan JInternalFrame yang membungkus panel ini
        JInternalFrame frame = (JInternalFrame) SwingUtilities.getAncestorOfClass(JInternalFrame.class, this);
        if (frame != null) {
            try {
                frame.setClosed(true); // ini akan menutup frame
            } catch (PropertyVetoException e) {
                System.out.println("Error");
            }
        }
    }

    public static boolean isKosong(String s) {
        return s == null || s.trim().isEmpty();
    }
}