package com.sahu.dto;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class BillDto {

	private Integer billId;
	private String countryCode;
	private String customerName;
	private double totalBillAmount;
	private double paidAmount;
	private double dueAmount;
	private OffsetDateTime billDate;
	private OffsetDateTime dueDate;
}
