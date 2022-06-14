package com.elhawary.excel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elhawary.excel.model.BankTransaction;
import com.elhawary.excel.response.Response;
import com.elhawary.excel.service.BankTransactionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin("http://localhost:4200")
public class BankTransactionController {

	@Autowired
	private BankTransactionService bankTransactionService;

	@PostMapping("shareExcelFile")
	public ResponseEntity<Response> shareExcelFile(@RequestParam("excel") MultipartFile excel) {
		bankTransactionService.saveBankTransaction(excel);
		return new ResponseEntity<Response>(new Response("success"), HttpStatus.CREATED);

	}

	@GetMapping("getAllUsers")
	public ResponseEntity<List<BankTransaction>> getAllUsers() {
		List<BankTransaction> list = bankTransactionService.findAll() ;
		return new ResponseEntity<List<BankTransaction>>(list, HttpStatus.OK);
	}

}
