/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user only
 */
public class Tempat {

    private int tinggi; // tinggi tempat Game
    private int lebar;  // lebar tempat Game
    private ArrayList<Sel> daftarSel; // daftar sel

    private String isi; // isi file konfigurasi

    public static int batasKanan;
    public static int batasBawah;

    public Tempat() {
        daftarSel = new ArrayList<>();
    }

    /**
     * Fungsi pembaca file konfigurasi. Hasil pembacaan file akan disimpan di
     * atribut 'isi' dan juga di atribut daftarSel
     *
     * @param file
     */
    public void bacaKonfigurasi(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String hasilBaca = "";
            int dataInt;
            int baris = 0;
            int kolom = 0;

            while ((dataInt = fis.read()) != -1) {
                if ((char) dataInt != '\n') {
                    switch ((char) dataInt) {
                        case '#':
                            {
                                hasilBaca = hasilBaca + (char) dataInt;
                                Sel sel = new Sel();
                                sel.setTinggi(50);
                                sel.setLebar(50);
                                this.setTinggi(50);
                                this.setLebar(50);
                                sel.setNilai((char) dataInt);
                                sel.setWarna(Color.RED);
                                sel.setBaris(baris);
                                sel.setKolom(kolom);
                                this.tambahSel(sel);
                                kolom++;
                                break;
                            }
                        case '.':
                            {
                                hasilBaca = hasilBaca + (char) dataInt;
                                Sel sel = new Sel();
                                sel.setTinggi(50);
                                sel.setLebar(50);
                                this.setTinggi(50);
                                this.setLebar(50);
                                sel.setNilai((char) dataInt);
                                sel.setWarna(Color.WHITE);
                                sel.setBaris(baris);
                                sel.setKolom(kolom);
                                this.tambahSel(sel);
                                kolom++;
                                break;
                            }
                        case '@':
                            {
                                hasilBaca = hasilBaca + (char) dataInt;
                                Sel sel = new Sel();
                                sel.setTinggi(50);
                                sel.setLebar(50);
                                this.setTinggi(50);
                                this.setLebar(50);
                                sel.setNilai((char) dataInt);
                                sel.setWarna(Color.BLUE);
                                sel.setBaris(baris);
                                sel.setKolom(kolom);
                                this.tambahSel(sel);
                                kolom++;
                                break;
                            }
                        case 'o':
                            {
                                hasilBaca = hasilBaca + (char) dataInt;
                                Sel sel = new Sel();
                                sel.setTinggi(50);
                                sel.setLebar(50);
                                this.setTinggi(50);
                                this.setLebar(50);
                                sel.setNilai((char) dataInt);
                                sel.setWarna(Color.PINK);
                                sel.setBaris(baris);
                                sel.setKolom(kolom);
                                this.tambahSel(sel);
                                kolom++;
                                break;
                            }
                        default:
                            break;
                    }
                } else {
                    baris++;
                    kolom = 0;
                    hasilBaca = hasilBaca + (char) dataInt;
                }
            }
            
            this.setIsi(hasilBaca);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void simpanKonfigurasi(File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            String a = "";
            char b = 0;
            for (int i = 0; i < daftarSel.size(); i++) {
                a += daftarSel.get(i).getNilai();
            }
            fos.write(a.getBytes());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fungsi penambah daftar sel.
     *
     * @param sel
     */
    public void tambahSel(Sel sel) {
        daftarSel.add(sel);
    }

    /**
     * @return the tinggi
     */
    public int getTinggi() {
        return tinggi;
    }

    /**
     * @param tinggi the tinggi to set
     */
    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    /**
     * @return the lebar
     */
    public int getLebar() {
        return lebar;
    }

    /**
     * @param lebar the lebar to set
     */
    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    /**
     * @return the daftarSel
     */
    public ArrayList<Sel> getDaftarSel() {
        return daftarSel;
    }

    /**
     * @param daftarSel the daftarSel to set
     */
    public void setDaftarSel(ArrayList<Sel> daftarSel) {
        this.daftarSel = daftarSel;
    }

    /**
     * @return the isi
     */
    public String getIsi() {
        return isi;
    }

    /**
     * @param isi the isi to set
     */
    public void setIsi(String isi) {
        this.isi = isi;
    }

}
