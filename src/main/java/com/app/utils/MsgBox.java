
package com.app.utils;


import java.awt.Component;
import javax.swing.JOptionPane;
import com.app.Entitys.Log;

public class MsgBox {

    public static void AlertSuccess(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message,
                "Hệ thống quản lý PetShop", JOptionPane.INFORMATION_MESSAGE);
        Log.info(message);
    }

    public static void AlertFall(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message,
                "Hệ thống quản lý PetShop", JOptionPane.INFORMATION_MESSAGE);
        Log.error(message);
    }

    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message,
                "Hệ thống quản lý PetShop",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    public static String prompt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message,
                "Hệ thống quản lý PetShop", JOptionPane.INFORMATION_MESSAGE);
    }
}
