package com.yjxbi.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.yjxbi.commons.utils.CoreUtils;
import com.yjxbi.commons.utils.CustomerConstants;
import com.yjxbi.commons.utils.FtcontractConstants;

public class SingleSource implements Serializable {

	private static final long serialVersionUID = -7213721078063723448L;
	
	private String customdate;
	
	private String ftcontractcode;
	
	private String ftcontractcode2;
	
	private String contractype2;
	
	private String contractype2value;
	
	private String agentorself;
	
	private String customerno;
	
	private String iszzkf;
	
	private String principal1;
	
	private String developedept;
	
	private String principal2no;
	
	private String operationdept;
	
	private String mainregion;
	
	private String ftccurrency;
	
	private String operationamount;
	
	//private String busiamount;
	
	private BigDecimal paymentofagent;
	
	private String buyCustomerType;
	
	//private BigDecimal mockagentfeewithouttax2;
	
	private String paymentofget;
	
	private String totalforeign;
	
	private String customercode;
	
	private String totalftcamount;
	
	private String customername;
	
	private String operationname;

	public String getCustomdate() {
		return customdate;
	}

	public void setCustomdate(String customdate) {
		this.customdate = customdate;
	}

	public String getFtcontractcode() {
		return ftcontractcode;
	}

	public void setFtcontractcode(String ftcontractcode) {
		this.ftcontractcode = ftcontractcode;
	}

	public String getFtcontractcode2() {
		return ftcontractcode2;
	}

	public void setFtcontractcode2(String ftcontractcode2) {
		this.ftcontractcode2 = ftcontractcode2;
	}

	public String getContractype2() {
		return contractype2;
	}

	public void setContractype2(String contractype2) {
		this.contractype2 = contractype2;
	}

	public String getAgentorself() {
		return agentorself;
	}

	public void setAgentorself(String agentorself) {
		this.agentorself = agentorself;
	}

	public String getCustomerno() {
		return customerno;
	}

	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}

	public String getIszzkf() {
		return iszzkf;
	}

	public void setIszzkf(String iszzkf) {
		this.iszzkf = iszzkf;
	}

	public String getPrincipal1() {
		return principal1;
	}

	public void setPrincipal1(String principal1) {
		this.principal1 = principal1;
	}

	public String getDevelopedept() {
		return developedept;
	}

	public void setDevelopedept(String developedept) {
		this.developedept = developedept;
	}

	public String getPrincipal2no() {
		return principal2no;
	}

	public void setPrincipal2no(String principal2no) {
		this.principal2no = principal2no;
	}

	public String getOperationdept() {
		return operationdept;
	}

	public void setOperationdept(String operationdept) {
		this.operationdept = operationdept;
	}

	public String getMainregion() {
		return mainregion;
	}

	public void setMainregion(String mainregion) {
		this.mainregion = mainregion;
	}

	public String getFtccurrency() {
		return ftccurrency;
	}

	public void setFtccurrency(String ftccurrency) {
		this.ftccurrency = ftccurrency;
	}

	public String getOperationamount() {
		if (getContractype2().equals(FtcontractConstants.CONTRACT_IMP)
				|| getContractype2().equals(FtcontractConstants.CONTRACT_EXP)
				|| getContractype2().equals(FtcontractConstants.CONTRACT_SAL)) {
			return getTotalftcamount();
		}

		return null;
	}

	public void setOperationamount(String operationamount) {
		this.operationamount = operationamount;
	}

	public String getBusiamount() {

		if (getContractype2().equals(FtcontractConstants.CONTRACT_IMP)
				&& ((Integer.parseInt(getBuyCustomerType()) & CustomerConstants.TYPE_EA) == CustomerConstants.TYPE_EA)) {
			return getTotalftcamount();
		}

		if (getContractype2().equals(FtcontractConstants.CONTRACT_EXP)
				&& ((Integer.parseInt(getBuyCustomerType()) & CustomerConstants.TYPE_EA) == CustomerConstants.TYPE_EA)) {
			return getTotalftcamount();
		}

		if (getContractype2().equals(FtcontractConstants.CONTRACT_SAL)
				&& ((Integer.parseInt(getBuyCustomerType()) & CustomerConstants.TYPE_EA) == CustomerConstants.TYPE_EA)) {
			return getTotalftcamount();
		}

		return null;

	}

	public BigDecimal getPaymentofagent() {
		return paymentofagent;
	}

	public void setPaymentofagent(BigDecimal paymentofagent) {
		this.paymentofagent = paymentofagent;
	}

	public BigDecimal getMockagentfeewithouttax2() {
		BigDecimal mockagentfeewithouttax2 = getPaymentofagent();
		BigDecimal rate = CoreUtils.ONE;
		if(getCustomercode().indexOf("A")>0)
			rate = new BigDecimal("1.06");
		else if(getCustomercode().indexOf("B")>0)
			rate = new BigDecimal("1.17");
		else
			rate = CoreUtils.ONE;
		
		return mockagentfeewithouttax2.divide(rate, 2, BigDecimal.ROUND_HALF_UP);
	
	}

	public String getPaymentofget() {
		return paymentofget;
	}

	public void setPaymentofget(String paymentofget) {
		this.paymentofget = paymentofget;
	}

	public String getTotalforeign() {
		return totalforeign;
	}

	public void setTotalforeign(String totalforeign) {
		this.totalforeign = totalforeign;
	}

	public String getCustomercode() {
		return customercode;
	}

	public void setCustomercode(String customercode) {
		this.customercode = customercode;
	}

	public String getBuyCustomerType() {
		return buyCustomerType;
	}

	public void setBuyCustomerType(String buyCustomerType) {
		this.buyCustomerType = buyCustomerType;
	}

	public String getTotalftcamount() {
		return totalftcamount;
	}

	public void setTotalftcamount(String totalftcamount) {
		this.totalftcamount = totalftcamount;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getContractype2value() {
		return contractype2value;
	}

	public void setContractype2value(String contractype2value) {
		this.contractype2value = contractype2value;
	}

	public String getOperationname() {
		return operationname;
	}

	public void setOperationname(String operationname) {
		this.operationname = operationname;
	}
	
	
}