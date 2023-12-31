package com.app.utils;

import java.util.Date;
import javax.swing.JTextField;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.DoubleValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.IntegerValidator;

public class Validate {

    public static boolean validateEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    public static boolean validateNumberPhone(String numberPhone) {
        if (!numberPhone.startsWith("0")) {
            return false; // Số Điện Thoại Không Thuộc Việt Nam
        } else {
            return numberPhone.length() == 10; // Số Điện Thoại Không Đúng
        }
    }

    public static boolean validateDate(String dateStr) {
        DateValidator validator = DateValidator.getInstance();
        return validator.isValid(dateStr, "dd/MM/yyyy");
    }

    public static boolean validateInteger(String integer) {
        IntegerValidator validator = IntegerValidator.getInstance();
        return validator.isValid(integer) && Integer.parseInt(integer) > 0;
    }

    public static boolean validateDouble(String doubleStr) {
        DoubleValidator validator = DoubleValidator.getInstance();
        return validator.isValid(doubleStr) && Double.parseDouble(doubleStr) > 0;
    }
    
     public static boolean isOver18(Date dob) {
        Date currentDate = new Date();

        // Sử dụng millisecond để tính tuổi
        long millisecondsPerYear = 1000L * 60 * 60 * 24 * 365;
        long ageInMilliseconds = currentDate.getTime() - dob.getTime();

        int age = (int) (ageInMilliseconds / millisecondsPerYear);

        return age >= 18;
    }

    public static Boolean nothingText(JTextField... list) {
        for (JTextField x : list) {
            if (x.getText().isEmpty()) {
                return true;
            }
        }
        return false; // Tất cả các trường đều không rỗng
    }

    public static String nothingText1(JTextField... list) {
        for (JTextField x : list) {
            if (x.getText().isEmpty()) {
                return x.getToolTipText() + " không được rỗng!"; // Có ít nhất một trường rỗng
            }
        }
        return null; // Tất cả các trường đều không rỗng
    }

}
