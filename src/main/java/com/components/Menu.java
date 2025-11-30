package com.components;

import com.ta.DaftarPengaduan;
import com.ta.FormAduan;
import net.miginfocom.swing.MigLayout;
import raven.swing.blur.BlurBackground;
import raven.swing.blur.BlurChild;
import raven.swing.blur.style.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Objects;

public class Menu extends JPanel {
    private BlurBackground background;
    private BlurChild blurChild;
    private DesktopPaneCustom pane;
    private DaftarPengaduan listLapor;

    public Menu(DesktopPaneCustom pane){
        this.pane = pane;
        init();
    }

    //inisialisasi
    private void init(){
        background = new BlurBackground(new ImageIcon(Objects.requireNonNull(getClass().getResource("/ta/image/background.png"))).getImage());
        background.setLayout(new MigLayout("al center center"));
        blurChild = new BlurChild((raven.swing.blur.style.Style) getStyle());
        blurChild.setLayout(new MigLayout("insets 50,wrap 5,gap 20"));
        background.add(blurChild);

        setLayout(new BorderLayout());

        add(background);

        createMenu();
    }

    //bikin object item di halaman menu
    private void createMenu(){
        Item itemLapor = new Item("Form Lapor", "ta/menu/lapor.svg");
        Item itemDaftar = new Item("Daftar Laporan", "ta/menu/daftar.svg");

        itemLapor.addActionListener(e -> {
            pane.addFrame("Form Pengaduan", new FormAduan());
        });
        itemDaftar.addActionListener(e -> {
            pane.addFrame("Daftar Aduan", new DaftarPengaduan());
        });

        blurChild.add(itemLapor);
        blurChild.add(itemDaftar);
    }

    //styling import library-nya raven
    private Style getStyle() {
        return new Style()
                .setBlur(30)
                .setBorder(new StyleBorder(30)
                        .setBorderWidth(1.5f)
                        .setOpacity(0.25f)
                        .setBorderColor(new GradientColor(new Color(150, 150, 150), new Color(230, 230, 230), new Point2D.Float(0,0), new Point2D.Float(0,1)))
                        .setDropShadow(new StyleDropShadow(new Color(0,0,0), 0.2f, new Insets(12, 12, 20, 20)))
                )
                .setOverlay(new StyleOverlay(new Color(255,255,255), 0.1f));
    }

}
