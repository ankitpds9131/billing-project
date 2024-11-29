package com.sahu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sahu.dto.BillDto;
import com.sahu.service.BillService;

@RestController
public class BillController {

	@Autowired
	private BillService billService;
	
	@PostMapping("/saveBill")
	public String saveBill(@RequestBody BillDto dto) {
		String message = billService.saveBill(dto);
		return message;
	}
	
	@GetMapping("/fetchBill")
	public BillDto fetchBills(@RequestParam Integer billId) {
		BillDto fetchBill = billService.fetchBill(billId);
		return fetchBill;
	}
	
	@GetMapping("/fetchAllBills")
	public List<BillDto> fetchAllBills(){
		List<BillDto> listOfBillDto = billService.fetchAllBills();
		return listOfBillDto;
	}
	
}
