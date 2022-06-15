package com.elhawary.excel.excelHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import com.elhawary.excel.model.BankMapping;
import com.elhawary.excel.model.BankTransaction;


public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" ;
	
	public static boolean hasExcelFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	
	
	public List<BankTransaction> mappingExcelToBankTransaction(MultipartFile excel,BankMapping bankFileMapping) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(excel.getInputStream());
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			List<BankTransaction> bankTransiactions = new ArrayList<BankTransaction>();
			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cellsInRow = currentRow.iterator();
				BankTransaction bankTransiaction = new BankTransaction();
				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					if (currentCell.getSheet().getRow(0).getCell(cellIdx).getRichStringCellValue().toString()
							.equalsIgnoreCase((String) bankFileMapping.getBankCode())) {
						bankTransiaction.setBankCode((String) currentCell.getStringCellValue());
					} else if (currentCell.getSheet().getRow(0).getCell(cellIdx).getRichStringCellValue().toString()
							.equalsIgnoreCase((String) bankFileMapping.getDonatorName())) {
						bankTransiaction.setDonatorName((String) currentCell.getStringCellValue());
					} else if (currentCell.getSheet().getRow(0).getCell(cellIdx).getRichStringCellValue().toString()
							.equalsIgnoreCase((String) bankFileMapping.getProjectCode())) {
						bankTransiaction.setProjectCode((String) currentCell.getStringCellValue());
					} else if (currentCell.getSheet().getRow(0).getCell(cellIdx).getRichStringCellValue().toString()
							.equalsIgnoreCase((String) bankFileMapping.getAmount())) {
						bankTransiaction.setAmount((long) currentCell.getNumericCellValue());
					} else if (currentCell.getSheet().getRow(0).getCell(cellIdx).getRichStringCellValue().toString()
							.equalsIgnoreCase((String) bankFileMapping.getFromAccnt())) {
						bankTransiaction.setFromAccnt((String) currentCell.getStringCellValue());
					} else if (currentCell.getSheet().getRow(0).getCell(cellIdx).getRichStringCellValue().toString()
							.equalsIgnoreCase((String) bankFileMapping.getToAccnt())) {
						bankTransiaction.setToAccnt((String) currentCell.getStringCellValue());
					}

					cellIdx++;
				}
				
				bankTransiactions.add(bankTransiaction);
			}
			workbook.close();
			return bankTransiactions;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	
}
