<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.utils;
import javax.swing.JTextField;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.*;
/**
 *
 * @author ACER
 */
=======
package com.app.Utils;

import javax.swing.JTextField;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.*;

>>>>>>> 9c206f2d380673b96f6f59bbb98d259e3187909c
public class Validate {

    public static boolean validateEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    public static boolean validateNumberPhone(String numberPhone) {
<<<<<<< HEAD
        if (!numberPhone.startsWith("0")) {
=======
        if (numberPhone.startsWith("0")) {
>>>>>>> 9c206f2d380673b96f6f59bbb98d259e3187909c
            return false; // Số Điện Thoại Không Thuộc Việt Nam
        } else {
            return numberPhone.length() == 10; // Số Điện Thoại Không Đúng
        }
    }

    public static boolean validateDate(String dateStr) {
        DateValidator validator = DateValidator.getInstance();
<<<<<<< HEAD
        return validator.isValid(dateStr,"dd-MM-yyyy");
=======
        return validator.isValid(dateStr);
>>>>>>> 9c206f2d380673b96f6f59bbb98d259e3187909c
    }

    public static boolean validateInteger(String integer) {
        IntegerValidator validator = IntegerValidator.getInstance();
        return validator.isValid(integer) && Integer.parseInt(integer) > 0;
    }
    
    public static boolean validateDouble(String doubleStr){
        DoubleValidator validator = DoubleValidator.getInstance();
        return validator.isValid(doubleStr) && Double.parseDouble(doubleStr) > 0;
    }
    
<<<<<<< HEAD
 public static Boolean nothingText(JTextField... list){
        for (JTextField x : list){
            if (x.getText().isEmpty()){
                return true;
=======
    public static Boolean nothingText(JTextField... list){
        for (JTextField x : list){
            if (x.getText().isEmpty()){
                return true; // Có ít nhất một trường rỗng
>>>>>>> 9c206f2d380673b96f6f59bbb98d259e3187909c
            }
        }
        return false; // Tất cả các trường đều không rỗng
    }
<<<<<<< HEAD

=======
>>>>>>> 9c206f2d380673b96f6f59bbb98d259e3187909c
}
