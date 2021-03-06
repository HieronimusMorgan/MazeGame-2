/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Tempat;

/**
 *
 * @author user only
 */
public class GameFrame extends JFrame {

    private TempatPanel tempatPanel;

    private JLabel perintahlabel;
    private JTextField perintahText;
    private JButton okButton;

    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenuItem exitMenuItem;
    private JMenuItem bacaKonfigurasiMenuItem;
    private JMenuItem simpanKonfigurasiItem;

    public GameFrame(String title) {
        this.setTitle(title);
        this.init();
    }

    public GameFrame(String title, TempatPanel tempatPanel) {
        setTitle(title);
        this.tempatPanel = tempatPanel;
        this.init();
    }

    public GameFrame(TempatPanel tempatPanel) {
        this.tempatPanel = tempatPanel;
        this.init();
    }

    public void init() {
        // set ukuran dan layout
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());

        // set menu Bar
        menuBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        exitMenuItem = new JMenuItem("Keluar");
        bacaKonfigurasiMenuItem = new JMenuItem("Baca");
        simpanKonfigurasiItem = new JMenuItem("Simpan");

        gameMenu.add(bacaKonfigurasiMenuItem);
        gameMenu.add(simpanKonfigurasiItem);
        gameMenu.add(exitMenuItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);

        //action perform for exitMenuItem
        exitMenuItem.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        bacaKonfigurasiMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jf = new JFileChooser();
                int returnVal = jf.showOpenDialog(null);
                Tempat tempat = new Tempat();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    tempat.bacaKonfigurasi(jf.getSelectedFile());

                }
                Tempat.batasKanan = 500;
                Tempat.batasBawah = 500;
                tempatPanel = new TempatPanel(tempat);
                GameFrame game = new GameFrame(tempatPanel);
            }
        }
        );

        simpanKonfigurasiItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jf = new JFileChooser();
                int returnVal = jf.showOpenDialog(null);
                if (returnVal == JFileChooser.SAVE_DIALOG) {
                    tempatPanel.getTempat().simpanKonfigurasi(jf.getSelectedFile());
                }
            }
        });
        // panel selatan
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());

        this.perintahlabel = new JLabel("Perintah");
        southPanel.add(perintahlabel);

        this.perintahText = new JTextField(20);
        //perintahText.setSize(5, 20);
        southPanel.add(perintahText);

        this.okButton = new JButton("OK");
        southPanel.add(okButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (perintahText.getText().equalsIgnoreCase("R")) {
                    pindahKanan();
                } else if (perintahText.getText().equalsIgnoreCase("L")) {
                    pindahKiri();
                } else if (perintahText.getText().equalsIgnoreCase("U")) {
                    pindahAtas();
                } else if (perintahText.getText().equalsIgnoreCase("D")) {
                    pindahBawah();
                }
            }
        });

        // set contentPane
        Container cp = this.getContentPane();
        if (tempatPanel != null) {
            cp.add(getTempatPanel(), BorderLayout.CENTER);
        }
        cp.add(southPanel, BorderLayout.SOUTH);

        // set visible= true
        this.setVisible(true);
    }

    /**
     * Fungsi untuk memindahkan sel dan menggambar ulang
     */
    public void pindahKanan() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKanan();
            }

        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    public void pindahKiri() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKiri();
            }

        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    public void pindahAtas() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserAtas();
            }

        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    public void pindahBawah() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserBawah();
            }

        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    /**
     * @return the tempatPanel
     */
    public TempatPanel getTempatPanel() {
        return tempatPanel;
    }

    /**
     * @param tempatPanel the tempatPanel to set
     */
    public void setTempatPanel(TempatPanel tempatPanel) {
        this.tempatPanel = tempatPanel;
    }

}
