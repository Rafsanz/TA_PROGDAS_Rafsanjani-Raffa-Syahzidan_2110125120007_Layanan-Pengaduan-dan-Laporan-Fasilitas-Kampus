package com.ta;

import com.components.DesktopPaneCustom;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {

    private DesktopPaneCustom pane = new DesktopPaneCustom();

    public MainApp(){
        setTitle("Layanan Pengaduan dan Laporan Fasilitas Kampus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(900, 600));
        setLocationRelativeTo(null);
        getContentPane().add(pane);
    }

    public static void main(String[] args) {
        FlatMacDarkLaf.setup(); //ini theme dari library-nya flatLaf
        EventQueue.invokeLater(() -> new MainApp().setVisible(true));
    }
}
