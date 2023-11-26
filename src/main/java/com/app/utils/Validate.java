package com.app.Utils;

import javax.swing.JTextField;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.*;

public class Validate {

    public static boolean validateEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    public static boolean validateNumberPhone(String numberPhone) {
        if (numberPhone.startsWith("0")) {
            return false; // Số Điện Thoại Không Thuộc Việt Nam
        } else {
            return numberPhone.length() == 10; // Số Điện Thoại Không Đúng
        }
    }

    public static boolean validateDate(String dateStr) {
        DateValidator validator = DateValidator.getInstance();
        return validator.isValid(dateStr);
    }

    public static boolean validateInteger(String integer) {
        IntegerValidator validator = IntegerValidator.getInstance();
        return validator.isValid(integer) && Integer.parseInt(integer) > 0;
    }
    
    public static boolean validateDouble(String doubleStr){
        DoubleValidator validator = DoubleValidator.getInstance();
        return validator.isValid(doubleStr) && Double.parseDouble(doubleStr) > 0;
    }
    
    public static Boolean nothingText(JTextField... list){
        for (JTextField x : list){
            if (x.getText().isEmpty()){
                return true; // Có ít nhất một trường rỗng
            }
        }
        return false; // Tất cả các trường đều không rỗng
    }
}
