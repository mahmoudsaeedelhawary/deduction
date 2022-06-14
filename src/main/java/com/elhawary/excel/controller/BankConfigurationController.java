package com.elhawary.excel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elhawary.excel.model.BankConfiguration;
import com.elhawary.excel.response.Response;
import com.elhawary.excel.service.BankConfigurationService;

@RestController
public class BankConfigurationController {

	@Autowired
	private BankConfigurationService bankConfigurationService ;
	@PostMapping("saveBankConfiqurationMapping")
	public ResponseEntity<Response> saveBankConfiqurationMapping(@RequestBody BankConfiguration bankConfiguration) {
		bankConfigurationService.save(bankConfiguration);
		return new ResponseEntity<Response>(new Response("success"), HttpStatus.CREATED);

	}
}
