package com.app.utils;


import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NT Thân
 */
public class XImage {
    public static ImageIcon insertIcon(int width, int height, String link) {
        try {
            ImageIcon ico = new ImageIcon(link);
            Image img = ico.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            return icon;
        } catch (Exception e) {
            return null;
        }

    }
}
