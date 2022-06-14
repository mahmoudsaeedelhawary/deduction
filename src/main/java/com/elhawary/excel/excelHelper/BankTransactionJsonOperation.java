package com.elhawary.excel.excelHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import com.elhawary.excel.model.BankMapping;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BankTransactionJsonOperation {

	private final static String path = "D:\\FFS company\\excel\\";

	public static BankMapping getDataFromJSONFile(String bankName)
			throws StreamReadException, DatabindException, IOException {
		BankMapping bankFileMapping = new BankMapping();
		try {
			File reader = new File(path + bankName + ".json");
			if (!reader.exists()) {
				BankTransactionJsonOperation.createJSONFile(bankName);
			}
			bankFileMapping = new ObjectMapper().readValue(reader, BankMapping.class);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bankFileMapping;
	}

	@SuppressWarnings("unchecked")
	public static void createJSONFile(String bankName) {
		JSONObject object = new JSONObject();

		object.put("bankName", bankName);
		object.put("donatorName", "From_Name");
		object.put("bankCode", "BANK_CODE");
		object.put("projectCode", "PCODE");
		object.put("toAccnt", "To_Accnt");
		object.put("fromAccnt", "From_Accnt");
		object.put("amount", "amnt");

		try (FileWriter file = new FileWriter(path + bankName + ".json")) {
			file.write(object.toString());
			System.out.println("Successfully Copied JSON Object to File...");
			file.flush();
		} catch (Exception e) {
			System.out.println(e);

		}
	}
}
