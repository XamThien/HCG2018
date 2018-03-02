package controller;
/*
 * 
 * doc file word chua danh sach ten va so ng do choi 
 * ghi ten ra array list
 * va so ra mang
 * 
 * */
public class Detail {
	private String tt;
	private String name;
	private int batdau;
	private int ketthuc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBatdau() {
		return batdau;
	}
	public void setBatdau(int batdau) {
		this.batdau = batdau;
	}
	public int getKetthuc() {
		return ketthuc;
	}
	public void setKetthuc(int ketthuc) {
		this.ketthuc = ketthuc;
	}
	
	
	public String getTt() {
		return tt;
	}
	public void setTt(String tt) {
		this.tt = tt;
	}
	public Detail(String tt,String name, int batdau, int ketthuc) {
		this.tt=tt;
		this.name = name;
		this.batdau = batdau;
		this.ketthuc = ketthuc;
	}
	public Detail() {
		
	}
	@Override
	public String toString() {
		return "Ten=" + name + ":====>" + tt ;
	}
	
}

