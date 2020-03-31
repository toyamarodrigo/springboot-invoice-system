package com.rt.springboot.app.view.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.rt.springboot.app.models.entity.Invoice;
import com.rt.springboot.app.models.entity.ItemInvoice;

@Component("invoice/view")
public class InvoicePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Invoice invoice = (Invoice) model.get("invoice");
		
		PdfPTable table = new PdfPTable(1);
		table.setSpacingAfter(20);
		table.addCell("Client Details");
		table.addCell(invoice.getClient().getFirstName() + " " + invoice.getClient().getLastName());
		table.addCell(invoice.getClient().getEmail());
		
		PdfPTable table2 = new PdfPTable(1);
		table2.setSpacingAfter(20);
		table2.addCell("Invoice Details: ");
		table2.addCell("Page: " + invoice.getId());
		table2.addCell("Description: " + invoice.getDescription());
		table2.addCell("Date: " + invoice.getCreateAt());
		
		document.add(table);
		document.add(table2);
	
		PdfPTable table3 = new PdfPTable(4);
		table3.addCell("Product: ");
		table3.addCell("Price: ");
		table3.addCell("Amount: ");
		table3.addCell("Total: ");
		
		for(ItemInvoice item : invoice.getItems()) {
			table3.addCell(item.getProduct().getName());
			table3.addCell(item.getProduct().getPrice().toString());
			table3.addCell(item.getAmount().toString());
			table3.addCell(item.calculateImport().toString());
		}
		
		PdfPCell cell = new PdfPCell(new Phrase("Total: "));
		cell.setColspan(3);
		cell.setHorizontalAlignment(PdfCell.ALIGN_RIGHT);
		table3.addCell(cell);
		table3.addCell(invoice.getTotal().toString());
		
		document.add(table3);
		
	}
	
	
	
}
