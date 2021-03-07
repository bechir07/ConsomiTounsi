package tn.esprit.spring.Service;
import tn.esprit.spring.entities.*;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
public class Bill_PdfServiceImpl {

	private List<Bill> listBill;
    
    public Bill_PdfServiceImpl(List<Bill> listBill) {
        this.listBill = listBill;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
        
        cell.setPhrase(new Phrase("bill_id", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("total_price", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("state", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("payment_type", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("date_of_bill", font));
        table.addCell(cell);  
        
        cell.setPhrase(new Phrase("command_reference", font));
        table.addCell(cell); 
    }
     
    private void writeTableData(PdfPTable table) {
        for (Bill bill : listBill) {
            table.addCell(String.valueOf(bill.getBill_id()));
            table.addCell(String.valueOf(bill.getTotal_price()));
            table.addCell(bill.getState().toString());
            table.addCell(bill.getPayment_type().toString());
            table.addCell(String.valueOf(bill.getDate_of_bill()));
            table.addCell(bill.getCommand().toString());
           
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 3.5f, 1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
