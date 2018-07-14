package com.poslovna.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.poslovna.model.Account;
import com.poslovna.model.StatementAnalysis;
import com.poslovna.repository.StatementAnalysisRepository;



public class ReportsService {
	
	
	@Autowired
	private StatementAnalysisRepository statementAnalysisRepository;
	
	
public static ByteArrayInputStream accountsReport(List<Account> accounts, String title) {
		

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
	
        
        
        try {

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{5, 5, 10, 5, 5, 5});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            
            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Vlasnik racuna", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            
            hcell = new PdfPCell(new Phrase("Datum otvaranja racuna", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
          
            hcell = new PdfPCell(new Phrase("Broj racuna", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            
            hcell = new PdfPCell(new Phrase("Validnost", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Banka", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Valuta", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
          
            
            PdfPCell cell;
            
            for (Account account : accounts) {

            	
            	if(account.getIndividual() == null) {
            		
            		cell = new PdfPCell(new Phrase(account.getLegalEntity().getName().toString()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
            		
            	}
            	
            	else{
            		
            		cell = new PdfPCell(new Phrase(account.getIndividual().getName().toString()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
            	}
            	
            	

                cell = new PdfPCell(new Phrase(account.getOpeningdate().toString()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(account.getAccountnum().toString()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                if(account.getIsValid()){
                	
                	cell = new PdfPCell(new Phrase("VALIDAN"));
                    cell.setPaddingLeft(5);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(cell);
                }
                else{
                	cell = new PdfPCell(new Phrase("NEVALIDAN"));
                    cell.setPaddingLeft(5);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(cell);
                }
                
                cell = new PdfPCell(new Phrase(account.getBank().getName().toString()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(account.getCurrency().getName().toString()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
            
            }
            
        
            PdfWriter.getInstance(document, out);
            document.open();
            
        
            
            document.addTitle("Racuni banke '" + title + "'");
            document.add(table);
            
            document.close();
            
        } catch (DocumentException ex) {
        
            Logger.getLogger(ReportsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return new ByteArrayInputStream(out.toByteArray());
	}





public static ByteArrayInputStream clientReport(List<StatementAnalysis>base, String accountnum, String datefrom,String dateto) {
	

    Document document = new Document();
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    
  
    
    

    
    
    try {

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{5, 5, 10, 5, 5, 5});

        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        
        
        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("Vlasnik racuna", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
        
        hcell = new PdfPCell(new Phrase("Datum", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
      
        hcell = new PdfPCell(new Phrase("Svrha", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
        
        hcell = new PdfPCell(new Phrase("Vrednost", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
        hcell = new PdfPCell(new Phrase("Trenutno stanje", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
        hcell = new PdfPCell(new Phrase("Primalac", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
      
        
        PdfPCell cell;
        
        for (StatementAnalysis statement :base) {
        
        	if(statement.getDailyAccountBalance()!=null){
        	if(statement.getDailyAccountBalance().getBankaccount().getAccountnum().equals(accountnum)) {
        		if(statement.getDailyAccountBalance().getBankaccount().getLegalEntity()!=null){
        		cell = new PdfPCell(new Phrase(statement.getDailyAccountBalance().getBankaccount().getLegalEntity().getName()));
        		}else{
        			cell = new PdfPCell(new Phrase(statement.getDailyAccountBalance().getBankaccount().getIndividual().getName()));
        		}
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
        		
        
        		
        		cell = new PdfPCell(new Phrase(statement.getDateOfReceipt()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
        	
                cell = new PdfPCell(new Phrase(statement.getPurposeOfPayment()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
        	
        	

          
            
            cell = new PdfPCell(new Phrase(statement.getAmount().toString()));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
            
           
            	
            
            
            cell = new PdfPCell(new Phrase(statement.getDailyAccountBalance().getNewState().toString()));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(statement.getCreditorReceiver()));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
           
            
        	}
        }
        }
        
    
        PdfWriter.getInstance(document, out);
        document.open();
        
    
        
        document.addTitle("Izvod klijenta '" + accountnum + "'");
        document.add(table);
        
        document.close();
        
    } catch (DocumentException ex) {
    
        Logger.getLogger(ReportsService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    return new ByteArrayInputStream(out.toByteArray());
}




 












}
