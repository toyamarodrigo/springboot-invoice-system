package com.rt.springboot.app.view.xls;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.rt.springboot.app.models.entity.Invoice;
import com.rt.springboot.app.models.entity.ItemInvoice;

@Component("invoice/view.xlsx")
public class InvoiceXlsxView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		MessageSourceAccessor message = getMessageSourceAccessor();
		
		response.setHeader("Content-Disposition", "attachment; filename=\"invoice_view.xlsx\"");
		Invoice invoice = (Invoice) model.get("invoice");
		Sheet sheet = workbook.createSheet("Factura Spring");
				
		sheet.createRow(0).createCell(0).setCellValue(message.getMessage("text.factura.ver.datos.cliente"));
		sheet.createRow(1).createCell(0).setCellValue(invoice.getClient().getFirstName() + " " + invoice.getClient().getLastName());
		sheet.createRow(2).createCell(0).setCellValue(invoice.getClient().getEmail());
		
		sheet.createRow(4).createCell(0).setCellValue(message.getMessage("text.factura.ver.datos.factura"));
		sheet.createRow(5).createCell(0).setCellValue(message.getMessage("text.cliente.factura.folio")+ ": " + invoice.getId());
		sheet.createRow(6).createCell(0).setCellValue(message.getMessage("text.cliente.factura.descripcion")+ ": " + invoice.getDescription());
		sheet.createRow(7).createCell(0).setCellValue(message.getMessage("text.cliente.factura.fecha")+ ": " + invoice.getCreateAt());
		
		CellStyle theaderStyle = workbook.createCellStyle();
		theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
		theaderStyle.setBorderTop(BorderStyle.MEDIUM);
		theaderStyle.setBorderRight(BorderStyle.MEDIUM);
		theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
		theaderStyle.setFillForegroundColor(IndexedColors.GOLD.index);
		theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		CellStyle tbodyStyle = workbook.createCellStyle();
		tbodyStyle.setBorderBottom(BorderStyle.THIN);
		tbodyStyle.setBorderTop(BorderStyle.THIN);
		tbodyStyle.setBorderRight(BorderStyle.THIN);
		tbodyStyle.setBorderLeft(BorderStyle.THIN);
		
		Row header = sheet.createRow(9);
		header.createCell(0).setCellValue(message.getMessage("text.factura.form.item.nombre"));
		header.createCell(1).setCellValue(message.getMessage("text.factura.form.item.precio"));
		header.createCell(2).setCellValue(message.getMessage("text.factura.form.item.cantidad"));
		header.createCell(3).setCellValue(message.getMessage("text.factura.form.item.total"));
		
		header.getCell(0).setCellStyle(theaderStyle);
		header.getCell(1).setCellStyle(theaderStyle);
		header.getCell(2).setCellStyle(theaderStyle);
		header.getCell(3).setCellStyle(theaderStyle);
		
		int rownum = 10;
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		
		for(ItemInvoice item : invoice.getItems()) {
			row = sheet.createRow(rownum ++);
			
			cell = row.createCell(0);
			cell.setCellValue(item.getProduct().getName());
			cell.setCellStyle(tbodyStyle);
			
			cell = row.createCell(1);
			cell.setCellValue(item.getProduct().getPrice());
			cell.setCellStyle(tbodyStyle);
			
			cell = row.createCell(2);
			cell.setCellValue(item.getAmount());
			cell.setCellStyle(tbodyStyle);
			
			cell = row.createCell(3);
			cell.setCellValue(item.calculateImport());
			cell.setCellStyle(tbodyStyle);
		}
		
		Row finaltotal = sheet.createRow(rownum);
		cell = finaltotal.createCell(2);
		cell.setCellValue(message.getMessage("text.factura.form.total"));
		cell.setCellStyle(tbodyStyle);
		
		cell = finaltotal.createCell(3);
		cell.setCellValue(invoice.getTotal());
		cell.setCellStyle(tbodyStyle);
		
	}

}
