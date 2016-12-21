package com.yjxbi.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class SingleTotalSum implements Serializable {

	private static final long serialVersionUID = 8497052152717539502L;
	
	private BigDecimal totalrmbftcamountsum;
	
	private BigDecimal totalrmbbusiamountsum;
	
	private BigDecimal paymentofagentsum;
	
	private BigDecimal paymentofgetsum;
	
	private BigDecimal totalusdftcamountsum;

	public BigDecimal getTotalrmbftcamountsum() {
		return totalrmbftcamountsum;
	}

	public void setTotalrmbftcamountsum(BigDecimal totalrmbftcamountsum) {
		this.totalrmbftcamountsum = totalrmbftcamountsum;
	}

	public BigDecimal getTotalrmbbusiamountsum() {
		return totalrmbbusiamountsum;
	}

	public void setTotalrmbbusiamountsum(BigDecimal totalrmbbusiamountsum) {
		this.totalrmbbusiamountsum = totalrmbbusiamountsum;
	}

	public BigDecimal getPaymentofagentsum() {
		return paymentofagentsum;
	}

	public void setPaymentofagentsum(BigDecimal paymentofagentsum) {
		this.paymentofagentsum = paymentofagentsum;
	}

	public BigDecimal getPaymentofgetsum() {
		return paymentofgetsum;
	}

	public void setPaymentofgetsum(BigDecimal paymentofgetsum) {
		this.paymentofgetsum = paymentofgetsum;
	}

	public BigDecimal getTotalusdftcamountsum() {
		return totalusdftcamountsum;
	}

	public void setTotalusdftcamountsum(BigDecimal totalusdftcamountsum) {
		this.totalusdftcamountsum = totalusdftcamountsum;
	}
	
}