package com.proj.pro.vo;

import java.sql.*;
import java.text.SimpleDateFormat;

public class InfoVO {
	private String memid, ifct, ifname, ifshow, iftel, ifpri, ifaddr, iflink, ifrtt, ifrbd, rdate, name;
	private int ifno, ifmno, ifrno, ifrst, ifrcnt, iflike, clike, mcnt, pcnt;	
	private Date redate;
	private Time retime;
	
	
	public int getMcnt() {
		return mcnt;
	}
	public void setMcnt(int mcnt) {
		this.mcnt = mcnt;
	}
	public int getPcnt() {
		return pcnt;
	}
	public void setPcnt(int pcnt) {
		this.pcnt = pcnt;
	}
	public int getClike() {
		return clike;
	}
	public void setClike(int clike) {
		this.clike = clike;
	}
	public int getIflike() {
		return iflike;
	}
	public void setIflike(int iflike) {
		this.iflike = iflike;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIfct() {
		return ifct;
	}
	public void setIfct(String ifct) {
		this.ifct = ifct;
	}
	public String getIfname() {
		return ifname;
	}
	public void setIfname(String ifname) {
		this.ifname = ifname;
	}
	public String getIfshow() {
		return ifshow;
	}
	public void setIfshow(String ifshow) {
		this.ifshow = ifshow;
	}
	public String getIftel() {
		return iftel;
	}
	public void setIftel(String iftel) {
		this.iftel = iftel;
	}
	public String getIfpri() {
		return ifpri;
	}
	public void setIfpri(String ifpri) {
		this.ifpri = ifpri;
	}
	public String getIfaddr() {
		return ifaddr;
	}
	public void setIfaddr(String ifaddr) {
		this.ifaddr = ifaddr;
	}
	public String getIflink() {
		return iflink;
	}
	public void setIflink(String iflink) {
		this.iflink = iflink;
	}
	public String getIfrtt() {
		return ifrtt;
	}
	public void setIfrtt(String ifrtt) {
		this.ifrtt = ifrtt;
	}
	public String getIfrbd() {
		return ifrbd;
	}
	public void setIfrbd(String ifrbd) {
		this.ifrbd = ifrbd;
	}
	public int getIfno() {
		return ifno;
	}
	public void setIfno(int ifno) {
		this.ifno = ifno;
	}
	public int getIfmno() {
		return ifmno;
	}
	public void setIfmno(int ifmno) {
		this.ifmno = ifmno;
	}
	public int getIfrno() {
		return ifrno;
	}
	public void setIfrno(int ifrno) {
		this.ifrno = ifrno;
	}
	public int getIfrst() {
		return ifrst;
	}
	public void setIfrst(int ifrst) {
		this.ifrst = ifrst;
	}
	public int getIfrcnt() {
		return ifrcnt;
	}
	public void setIfrcnt(int ifrcnt) {
		this.ifrcnt = ifrcnt;
	}
	
	public String getRdate() {
		return rdate;
	}
	public void setRdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm:ss");
		this.rdate = form1.format(redate) + " " + form2.format(retime);
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public Date getRedate() {
		return redate;
	}
	public void setRedate(Date redate) {
		this.redate = redate;
	}
	public Time getRetime() {
		return retime;
	}
	public void setRetime(Time retime) {
		this.retime = retime;
	}
	
	
	// VO클래스의 데이터 유뮤 체크를 하기 위해 
	@Override
	public String toString() {
		return "InfoVO [memid=" + memid + ", ifct=" + ifct + ", ifname=" + ifname + ", ifshow=" + ifshow + ", iftel="
				+ iftel + ", ifpri=" + ifpri + ", ifaddr=" + ifaddr + ", iflink=" + iflink + ", ifrtt=" + ifrtt
				+ ", ifrbd=" + ifrbd + ", rdate=" + rdate + ", name=" + name + ", ifno=" + ifno + ", ifmno=" + ifmno
				+ ", ifrno=" + ifrno + ", ifrst=" + ifrst + ", ifrcnt=" + ifrcnt + ", iflike=" + iflike + ", clike="
				+ clike + "]";
	}
	
	
}
