package com.yjxbi.model;

import java.io.Serializable;

public class HrmreSource implements Serializable {

	private static final long serialVersionUID = 4633518004960195L;

	private String xttype;

    private String sqname;

    private String createdate;
    
    private String createreason;
    
    private String remark;
    
    private String yjbegintm;
    
    private String yjendtm;
    
    private String realize;
    
    private String byuser;
    
    private String sjbegintm;
    
    private String sjendtm;
    
    private String checkstate;

	public String getXttype() {
		return xttype;
	}

	public void setXttype(String xttype) {
		this.xttype = xttype;
	}

	public String getSqname() {
		return sqname;
	}

	public void setSqname(String sqname) {
		this.sqname = sqname;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getCreatereason() {
		return createreason;
	}

	public void setCreatereason(String createreason) {
		this.createreason = createreason;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getYjbegintm() {
		return yjbegintm;
	}

	public void setYjbegintm(String yjbegintm) {
		this.yjbegintm = yjbegintm;
	}

	public String getYjendtm() {
		return yjendtm;
	}

	public void setYjendtm(String yjendtm) {
		this.yjendtm = yjendtm;
	}

	public String getRealize() {
		return realize;
	}

	public void setRealize(String realize) {
		this.realize = realize;
	}

	public String getByuser() {
		return byuser;
	}

	public void setByuser(String byuser) {
		this.byuser = byuser;
	}

	public String getSjbegintm() {
		return sjbegintm;
	}

	public void setSjbegintm(String sjbegintm) {
		this.sjbegintm = sjbegintm;
	}

	public String getSjendtm() {
		return sjendtm;
	}

	public void setSjendtm(String sjendtm) {
		this.sjendtm = sjendtm;
	}

	public String getCheckstate() {
		return checkstate;
	}

	public void setCheckstate(String checkstate) {
		this.checkstate = checkstate;
	}
    
    

}