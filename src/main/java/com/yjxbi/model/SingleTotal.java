package com.yjxbi.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class SingleTotal implements Serializable {

	private static final long serialVersionUID = -4615414446272787901L;
	
	private String ftccurrency;
	
	private BigDecimal totaloperationamountall;
	
	private BigDecimal totalbusiamountall;
	
	private BigDecimal totalforeignall;

	public String getFtccurrency() {
		return ftccurrency;
	}

	public void setFtccurrency(String ftccurrency) {
		this.ftccurrency = ftccurrency;
	}

	public BigDecimal getTotaloperationamountall() {
		return totaloperationamountall;
	}

	public void setTotaloperationamountall(BigDecimal totaloperationamountall) {
		this.totaloperationamountall = totaloperationamountall;
	}

	public BigDecimal getTotalbusiamountall() {
		return totalbusiamountall;
	}

	public void setTotalbusiamountall(BigDecimal totalbusiamountall) {
		this.totalbusiamountall = totalbusiamountall;
	}

	public BigDecimal getTotalforeignall() {
		return totalforeignall;
	}

	public void setTotalforeignall(BigDecimal totalforeignall) {
		this.totalforeignall = totalforeignall;
	}
	
	public String getTotalShow(){
		return "运作量:"+getTotaloperationamountall()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+"业务量:"+getTotalbusiamountall()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+"外汇额度"+getTotalforeignall();
	}
	
	
}