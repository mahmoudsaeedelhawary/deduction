package com.elhawary.excel.excelHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.elhawary.excel.model.BankConfiguration;
import com.elhawary.excel.model.BankFile;
import com.elhawary.excel.model.BankFileStatus;
import com.elhawary.excel.model.BankMapping;
import com.elhawary.excel.model.BankTransaction;
import com.elhawary.excel.model.BankTransactionStatus;
import com.elhawary.excel.repository.BankFileRepository;
import com.elhawary.excel.repository.BankFileStatusRepository;
import com.elhawary.excel.repository.BankTransactionStatusRepository;
import com.elhawary.excel.service.BankConfigurationService;
import com.elhawary.excel.service.BankFileService;

public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	@Autowired
	private BankFileRepository bankFileService ;
	
	@Autowired
	private BankFileStatusRepository bankFileStatusRepository ;
	
	@Autowired
	private BankTransactionStatusRepository bankTransactionStatusRepository ;
	
	
	@Autowired
	private BankConfigurationService bankConfigurationService ;
	
	public static boolean hasExcelFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<BankTransaction> mappingExcelToBankTransaction(MultipartFile excel) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(excel.getInputStream());
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			List<BankTransaction> bankTransiactions = new ArrayList<BankTransaction>();
			BankFile bankFile ;
//			Optional<BankFile> optionalBankFile = bankFileService.findByFileName(excel.getOriginalFilename()) ;
//			if (optionalBankFile.isPresent()) {
//				bankFile = optionalBankFile.get() ;
//			} else {
//			    bankFile =new BankFile() ;
//			    BankFileStatus bankFileStatus = new BankFileStatus() ;
//				
//				bankFileStatus.setName_arabic("جديد");
//				bankFileStatus.setName_english("new");
//				bankFile.setBankFileStatus(bankFileStatus);
//				bankFile.setFileName(excel.getOriginalFilename());
//				bankFileService.save(bankFile) ;
//			}
				
				bankFile =new BankFile() ;
				bankFile.getBankFileStatus().setName_arabic("جديد");
				bankFile.getBankFileStatus().setName_english("new");
				bankFile.setFileName(excel.getOriginalFilename());
				bankFileService.save(bankFile) ;
			
//			BankMapping bankFileMapping = null ;
//			Optional<BankConfiguration> bankConfiguration = bankConfigurationService.findByBankName(bankFile.getFileName());
//			if (bankConfiguration.isPresent()) {
//				 bankFileMapping = bankConfiguration.get().getBankMapping() ;
//			} else {
//				bankFileMapping = new BankMapping("From_Name", "BANK_CODE", "PCODE", "amnt", "From_Accnt", "To_Accnt");
//			}
			
				BankMapping	bankFileMapping = new BankMapping("From_Name", "BANK_CODE", "PCODE", "amnt", "From_Accnt", "To_Accnt");
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
					} else {
						bankFile.getBankFileStatus().setName_arabic("اسماء القوائم بها خطأ");
						bankFile.getBankFileStatus().setName_english("Invalid table heade");
						bankFileService.save(bankFile) ;
					}

					cellIdx++;
				}

				if (checkIsEmpty(bankTransiaction)) {
					bankTransiaction.getBankTransactionStatus().setName_arabic("يحتوي علي خطأ");
					bankTransiaction.getBankTransactionStatus().setName_english("validtion error");
					
					bankFile.getBankFileStatus().setName_arabic("اسماء القوائم بها خطأ");
					bankFile.getBankFileStatus().setName_english("Loaded with Errors");
					bankFileService.save(bankFile) ;
					
				} else {
					bankTransiaction.getBankTransactionStatus().setName_arabic("new");
					bankTransiaction.getBankTransactionStatus().setName_english("جديد");
				}
				
				bankFile.getBankFileStatus().setName_arabic("تم التحميل بنجاح");
				bankFile.getBankFileStatus().setName_english("Loaded Successfully");
				bankFileService.save(bankFile) ;
				
				bankTransiaction.setBankFile(bankFile);
				bankTransiactions.add(bankTransiaction);
			}
			workbook.close();
			return bankTransiactions;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	
	public static void createTransaction() {
		
	}
	

	public static boolean checkIsEmpty(BankTransaction bankTransiaction) {
		if (bankTransiaction.getDonatorName().isEmpty()  || bankTransiaction.getBankCode().isEmpty() 
				|| bankTransiaction.getProjectCode().isEmpty() || bankTransiaction.getToAccnt().isEmpty() 
				|| bankTransiaction.getFromAccnt().isEmpty() || bankTransiaction.getAmount() == null)
			return true;
		return false;
	}
	
}
