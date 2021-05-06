package com.devsuperior.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;


@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SaleRepository sellerRepository;
	
	//Method to return a DTO list from entities(original objects) list using lambda expression
	@Transactional(readOnly = true)//Workaround to inject all sellers to memory and keep them in cash(only works because of the limited number of sellers)
	public Page<SaleDTO>findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale>result = repository.findAll(pageable);
		return result.map(saleEntry -> new SaleDTO(saleEntry));
	}
	
	@Transactional(readOnly = true)//JPA signature method to make the sum of all sales by seller using JPQL annotation on the repository
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}
}
