package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

public class SaleSumDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sellerName;
	private Double sum;
	
	public SaleSumDTO() {
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @param sellerName
	 * @param sum
	 */
	public SaleSumDTO(Seller seller, Double sum) {
		this.sellerName = seller.getName();
		this.sum = sum;
	}



	/**
	 * @return the sellerName
	 */
	public String getSellerName() {
		return sellerName;
	}

	/**
	 * @param sellerName the sellerName to set
	 */
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	/**
	 * @return the sum
	 */
	public Double getSum() {
		return sum;
	}

	/**
	 * @param sum the sum to set
	 */
	public void setSum(Double sum) {
		this.sum = sum;
	}
	
	

}
