package com.app.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.smtp.SMTPTransport;
import java.util.Random;

public class Mail {

    public static int sendEmail(String email) {
        Random random = new Random();
//        TaiKhoanDAO dao = new TaiKhoanDAO();
//        String matKhau = dao.getPass(email);
        int number = random.nextInt(900000) + 100000;
        String host = "smtp.gmail.com";
        String username = "linhmtmps32069@fpt.edu.vn";// thay đổi ở đây 
        String accessToken = "favyguxgosjprpbi";// thay đổi ở đây 
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", host);

        Session session = Session.getInstance(props, null);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Thông báo từ Dịch vụ DoCa Shop. Mã xác nhận bạn là: ");
            message.setText("Chào bạn,\n"
                    + " Bạn đã yêu cầu lấy lại mật khẩu cho tài khoản của mình trên Doca Shop.\n"
                    + " Dưới đây là mã xác nhận của bạn:\n\n"
                    + " Mã xác nhận: " + String.valueOf(number) + "\n\n"
                    + " Vui lòng nhập mã này vào trang web để hoàn tất quá trình đặt lại mật khẩu.\n"
                    + " Lưu ý rằng mã này sẽ chỉ có hiệu lực trong một khoảng thời gian ngắn.\n\n"
                    + " Trân trọng,\n"
                    + " Đội ngũ hỗ trợ Doca Shop"
            );

            SMTPTransport transport = (SMTPTransport) session.getTransport("smtp");
            transport.connect(host, username, accessToken);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
           
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return number;
    }

    public static void main(String[] args) {

        sendEmail("mylinh.khanhhung@gmail.com");
    }
    

}
