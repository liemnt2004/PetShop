package com.app.utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

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

    public static boolean save(File src) {
        File dst = new File("src\\main\\java\\com\\app\\img", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static ImageIcon read(String fileName) {
        File path = new File("src\\main\\java\\com\\app\\img", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    public static File saveExel(File src) {
        File dst = new File("Excel", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            return dst;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static File saveQR(File src) {
        File dst = new File("QR", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            return dst;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
