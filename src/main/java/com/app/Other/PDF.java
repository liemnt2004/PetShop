package com.app.Other;

import com.app.Entitys.ChiTietHoaDon;
import com.app.Entitys.SanPham;
import com.app.Entitys.ThuCung;
import com.itextpdf.text.*;
import com.app.Daos.*;
import com.itextpdf.text.pdf.BaseFont;

import com.itextpdf.text.pdf.PdfPCell;

import com.itextpdf.text.pdf.PdfPTable;

import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

import com.app.Entitys.DichVu;
import com.app.Entitys.PDFPRINTF;

import java.io.IOException;

import java.util.logging.Level;

import java.util.logging.Logger;
import java.util.*;

public class PDF {

    public static void printPDF(String namePDF, ArrayList<PDFPRINTF> list , String tongtien) {

// Step 1: Create a Document object
        Document document = new Document(PageSize.A6);

        try {

            String filePath = "..\\PetShop\\src\\main\\resources\\PDF\\" + namePDF + ".pdf";

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

// Step 2: Specify a font that supports Vietnamese characters
            BaseFont baseFont = BaseFont.createFont("..\\PetShop\\src\\main\\java\\com\\app\\Other\\ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            Font vietnameseFont = new Font(baseFont, 12);

            document.open();

            try {

                Image logo = Image.getInstance("..\\PetShop\\src\\main\\java\\com\\app\\img\\logo_menu.png");

                logo.setAlignment(Element.ALIGN_CENTER);

                document.add(logo);

                document.add(new Paragraph("")); // Add spacing

                Paragraph companyName = new Paragraph("DOCA", vietnameseFont);

                companyName.setAlignment(Element.ALIGN_CENTER);
                document.add(new Paragraph(""));
                document.add(new Paragraph("\n"));

                document.add(companyName);
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("")); // Add spacing

                Paragraph orderDetails = new Paragraph("HÓA ĐƠN BÁN HÀNG", vietnameseFont);

                orderDetails.setAlignment(Element.ALIGN_CENTER);

                document.add(orderDetails);

                document.add(new Paragraph("")); // Add spacing

// Main
                PdfPTable table = new PdfPTable(3);

                table.setWidthPercentage(100);

                table.addCell(new Phrase("Tên sản phẩm", vietnameseFont));

                table.addCell(new Phrase("Số lượng", vietnameseFont));

                table.addCell(new Phrase("Thành tiền", vietnameseFont));

                for (PDFPRINTF pdf : list) {
                    if (pdf.getMasp().startsWith("SP")) {
                        table.addCell(new Phrase(new SanPhamDAO().selectNameSP(pdf.getMasp()), vietnameseFont));
                        table.addCell(new Phrase(pdf.getSoluong(), vietnameseFont));
                        table.addCell(new Phrase(pdf.getTongTien(), vietnameseFont));
                    } else if (pdf.getMasp().startsWith("TC")) {
                        table.addCell(new Phrase(pdf.getMasp(), vietnameseFont));
                        table.addCell(new Phrase("1", vietnameseFont));
                        table.addCell(new Phrase(pdf.getTongTien(), vietnameseFont));
                    } else {
                        table.addCell(new Phrase(new DichVuDao().selectname(pdf.getMasp()), vietnameseFont));
                        table.addCell(new Phrase("Lần", vietnameseFont));
                       table.addCell(new Phrase(pdf.getTongTien(), vietnameseFont));
                    }

                }

                table.addCell(new Phrase("Tổng Tiền", vietnameseFont));

                PdfPCell cell = new PdfPCell(new Phrase(tongtien, vietnameseFont));

                cell.setColspan(2);

                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

                table.addCell(cell);

                table.addCell(new Phrase(tongtien, vietnameseFont));
                document.add(table);

                document.add(new Paragraph("")); // Add spacing

                document.add(new Paragraph("")); // Add spacing

// Footer
                Paragraph footer = new Paragraph(
                        "96/10 Thạnh Xuân 25 , Phường Thạnh Xuân , Quận 12 , Thành Phố Hồ Chí Minh", vietnameseFont);

                footer.setAlignment(Element.ALIGN_CENTER);

                document.add(footer);

            } catch (BadElementException | IOException ex) {

                Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);

            }

            document.close();

            writer.close();

            System.out.println("PDF created successfully at: " + filePath);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
