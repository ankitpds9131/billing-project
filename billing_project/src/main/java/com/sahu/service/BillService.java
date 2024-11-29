package com.sahu.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.dto.BillDto;
import com.sahu.entity.BillEntity;
import com.sahu.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;
	
	public String saveBill(BillDto dto) {
		
		
		BillEntity entity = new BillEntity();
		entity.setCountryCode(dto.getCountryCode());
		entity.setBillDate(OffsetDateTime.now());
		entity.setCustomerName(dto.getCustomerName());
		entity.setDueAmount(dto.getTotalBillAmount()-dto.getPaidAmount());
		entity.setTotalBillAmount(dto.getTotalBillAmount());
		entity.setPaidAmount(dto.getPaidAmount());
		entity.setDueDate(OffsetDateTime.now().plusMonths(1));
		
		billRepository.save(entity);
		
		return "Bill Details Saved Successfully";
	}
	
	
	public BillDto fetchBill(Integer billId) {
		
		BillEntity entity = billRepository.getById(billId);
		
		BillDto dto = new BillDto();
		
		BeanUtils.copyProperties(entity, dto);
		
		return dto;
		
	}
	
	public List<BillDto> fetchAllBills(){
		List<BillEntity> billEntities = billRepository.findAll();
		
		List<BillDto> billDtos = billEntities.stream().map(this::convertToDto).collect(Collectors.toList());
		
		
		return billDtos;
		
	}
	
	private BillDto convertToDto(BillEntity entity) {
		BillDto dto = new BillDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	
	
}
