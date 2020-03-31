package com.rt.springboot.app.view.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.rt.springboot.app.models.entity.Invoice;

@Component("invoice/view")
public class InvoicePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Invoice invoice = (Invoice) model.get("invoice");
		
		PdfPTable table = new PdfPTable(1);
		table.addCell("Client Details");
		table.addCell(invoice.getClient().getFirstName() + " " + invoice.getClient().getLastName());
		table.addCell(invoice.getClient().getEmail());
		
		PdfPTable table2 = new PdfPTable(1);
		table2.addCell("Invoice Details: ");
		table2.addCell("Page: " + invoice.getId());
		table2.addCell("Description: " + invoice.getDescription());
		table2.addCell("Date: " + invoice.getCreateAt());
		
		document.add(table);
		document.add(table2);
		
	}
	
	
	
}
