package controller;

public class Number {
	private String so;
	private int tanxuat;
	public Number(String so, int tanxuat) {
		
		this.so = so;
		this.tanxuat = tanxuat;
	}
	public Number() {
		
	
	}
	public String getSo() {
		return so;
	}
	public void setSo(String so) {
		this.so = so;
	}
	public int getTanxuat() {
		return tanxuat;
	}
	public void setTanxuat(int tanxuat) {
		this.tanxuat = tanxuat;
	}
	@Override
	public String toString() {
		return "Number [so=" + so + ", tanxuat=" + tanxuat + "]";
	}
	
}
