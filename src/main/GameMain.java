/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JFrame;
import view.GameFrame;

/**
 *
 * @author user only
 */
public class GameMain {
    public static void main(String[] args) {
        GameFrame game = new GameFrame("My Game");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
