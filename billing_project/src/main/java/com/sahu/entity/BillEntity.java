package com.sahu.entity;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BillEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billId;
	private String countryCode;
	private String customerName;
	private double totalBillAmount;
	private double paidAmount;
	private double dueAmount;
	private OffsetDateTime billDate;
	private OffsetDateTime dueDate;
	
}
