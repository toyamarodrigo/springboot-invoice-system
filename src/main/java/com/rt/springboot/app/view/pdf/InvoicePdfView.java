package com.rt.springboot.app.view.pdf;


import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.MessageSourceAccessor;
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
		
		MessageSourceAccessor message = getMessageSourceAccessor();

		// Detalles del Cliente
		PdfPTable table = new PdfPTable(1);
		table.setSpacingAfter(20);
		PdfPCell cell = null;		
		cell = new PdfPCell(new Phrase(message.getMessage("text.factura.ver.datos.cliente")));
		cell.setBackgroundColor(new Color(184, 218, 255));
		cell.setPadding(8f);
		table.addCell(cell);
		table.addCell(invoice.getClient().getFirstName() + " " + invoice.getClient().getLastName());
		table.addCell(invoice.getClient().getEmail());
		
		// Detalles de Factura
		PdfPTable table2 = new PdfPTable(1);
		table2.setSpacingAfter(20);
		cell = new PdfPCell(new Phrase(message.getMessage("text.factura.ver.datos.factura")));
		cell.setBackgroundColor(new Color(195, 230, 203));
		cell.setPadding(8f);
		table2.addCell(cell);
		table2.addCell(message.getMessage("text.cliente.factura.folio")+ ": " + invoice.getId());
		table2.addCell(message.getMessage("text.cliente.factura.descripcion")+ ": " + invoice.getDescription());
		table2.addCell(message.getMessage("text.cliente.factura.fecha")+ ": " + invoice.getCreateAt());
	
		// Tabla de Productos
		PdfPTable table3 = new PdfPTable(4);
		table3.setWidths(new float[] {3.5f, 1, 1, 1});
		table3.addCell(message.getMessage("text.factura.form.item.nombre"));
		table3.addCell(message.getMessage("text.factura.form.item.precio"));
		table3.addCell(message.getMessage("text.factura.form.item.cantidad"));
		table3.addCell(message.getMessage("text.factura.form.item.total"));
		
		for(ItemInvoice item : invoice.getItems()) {
			table3.addCell(item.getProduct().getName());
			table3.addCell(item.getProduct().getPrice().toString());
			cell = new PdfPCell(new Phrase(item.getAmount().toString()));
			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			table3.addCell(cell);
			table3.addCell(item.calculateImport().toString());
		}
		
		cell = new PdfPCell(new Phrase(message.getMessage("text.factura.form.total")));
		cell.setColspan(3);
		cell.setHorizontalAlignment(PdfCell.ALIGN_RIGHT);
		table3.addCell(cell);
		table3.addCell(invoice.getTotal().toString());
		
		document.add(table);
		document.add(table2);
		document.add(table3);
	}
	
	
	
}
