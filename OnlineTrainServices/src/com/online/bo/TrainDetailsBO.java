package com.online.bo;

public class TrainDetailsBO {
	private int tNo,avl;
	private String tName,fStation,tStation,dTime,aTime;
	private float price;
	public int gettNo() {
		return tNo;
	}
	public void settNo(int tNo) {
		this.tNo = tNo;
	}
	public int getAvl() {
		return avl;
	}
	public void setAvl(int avl) {
		this.avl = avl;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getfStation() {
		return fStation;
	}
	public void setfStation(String fStation) {
		this.fStation = fStation;
	}
	public String gettStation() {
		return tStation;
	}
	public void settStation(String tStation) {
		this.tStation = tStation;
	}
	public String getdTime() {
		return dTime;
	}
	public void setdTime(String dTime) {
		this.dTime = dTime;
	}
	public String getaTime() {
		return aTime;
	}
	public void setaTime(String aTime) {
		this.aTime = aTime;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
