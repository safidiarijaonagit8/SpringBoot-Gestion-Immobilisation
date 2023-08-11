package immo.entity;

import java.awt.Color;

import java.io.IOException;
import java.util.List;
 

 
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import jakarta.servlet.http.HttpServletResponse;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Formatter;

 
 
public class OpenPdfExporter {
    private  List<Amortissement> detailsList;
    private List<ImmoAnnee> lista;
     
    public OpenPdfExporter( List<Amortissement> detailsList) {
        this.detailsList = detailsList;
    }

    public OpenPdfExporter(List<Amortissement> detailsList,List<ImmoAnnee> lista) {
        this.lista = lista;
    }
    
    

    
    
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(6);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Date Debut ", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Date Fin", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Anterieure", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Exercice", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Cumul", font));
        table.addCell(cell);    
        
        cell.setPhrase(new Phrase("Valeur Net Comptable", font));
        table.addCell(cell);  
    }
    
       private void writeTableHeader1(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(6);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Article ", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Date Debut", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Date Fin", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Anterieure", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Exercice", font));
        table.addCell(cell);    
        
        cell.setPhrase(new Phrase("Cumul", font));
        table.addCell(cell);  
        
        cell.setPhrase(new Phrase("Valeur Net Comptable", font));
        table.addCell(cell);  
    }
     
    private void writeTableData(PdfPTable table) {
         SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
         formatter = new SimpleDateFormat("dd MMMM yyyy");  
         
          NumberFormat nf= NumberFormat.getInstance();
          nf.setMaximumFractionDigits(5);
      
        for (Amortissement details : detailsList) {
             String dateDebut = formatter.format(details.getDateDebut());  
            table.addCell(dateDebut);
             String dateFin = formatter.format(details.getDateFin());  
            table.addCell(dateFin);
           
            table.addCell(nf.format(details.getAnterieure())+" Ar");
           
            table.addCell(nf.format(details.getExercice())+" Ar");
           
            table.addCell(nf.format(details.getCumul())+" Ar");
        
            table.addCell(nf.format(details.getVnc())+" Ar");
            
        }
    }
      private void writeTableData1(PdfPTable table) {
         SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
         formatter = new SimpleDateFormat("dd MMMM yyyy");  
         
          NumberFormat nf= NumberFormat.getInstance();
          nf.setMaximumFractionDigits(5);
      
        for (ImmoAnnee details : lista) {
            table.addCell(details.getArticle());
            
             String dateDebut = formatter.format(details.getDateDebut());  
            table.addCell(dateDebut);
             String dateFin = formatter.format(details.getDateFin());  
            table.addCell(dateFin);
           
            table.addCell(nf.format(details.getAnterieure())+" Ariary"); //2 chifrres apres la virgule
           
            table.addCell(nf.format(details.getExercice())+" Ar");
           
            table.addCell(nf.format(details.getCumul())+" Ar");
        
            table.addCell(nf.format(details.getVnc())+" Ar");
            
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLACK);
         
        Paragraph p = new Paragraph("TABLEAU AMORTISSEMENT", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {2.5f, 2.5f, 3.0f, 3.0f, 3.0f,3.0f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table); 
         
        document.close();
      }
       public void export1(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18); 
        font.setColor(Color.BLACK);
         
        Paragraph p = new Paragraph("TABLEAU PAR ANNEE", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 2.5f, 2.0f, 2.0f, 2.5f,2.5f,2.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader1(table);
        writeTableData1(table);
         
        document.add(table);
         
        document.close();
      }
}
    
