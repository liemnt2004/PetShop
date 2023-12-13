package com.app.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PassHashing {

    public static String generateRandomPassword() {
        // Định dạng mật khẩu: ít nhất một chữ cái thường, một chữ cái hoa, và một chữ số
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        while (true) {
            password.setLength(0); // Xóa mật khẩu trước đó

            // Tạo mật khẩu ngẫu nhiên với độ dài mong muốn
            for (int i = 0; i < 8; i++) {
                int randomChar = random.nextInt(62); // Sử dụng 62 ký tự in ASCII
                char baseChar = (randomChar < 26) ? 'A' : (randomChar < 52) ? 'a' : '0';
                password.append((char) (baseChar + randomChar % 26));
            }

            // Kiểm tra xem mật khẩu có đúng định dạng hay không
            if (password.toString().matches(passwordRegex)) {
                break; // Nếu đúng định dạng, thoát khỏi vòng lặp
            }
        }

        return password.toString();
    }

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static String hashPassword(String password) {
        String salt = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        return salt;
    }

    public static boolean verifyPassword(String password, String saltedHashedPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), saltedHashedPassword);
        return result.verified;
    }

}
