package controller;

public class Phuongan {
	private String namePA;
	private String nameMT;
	private float value;
	
	public Phuongan(){
		
	}
	public Phuongan(String namePA, String nameMT, float value) {
		this.namePA = namePA;
		this.nameMT = nameMT;
		this.value = value;
	}
	public String getNamePA() {
		return namePA;
	}
	public void setNamePA(String namePA) {
		this.namePA = namePA;
	}
	public String getNameMT() {
		return nameMT;
	}
	public void setNameMT(String nameMT) {
		this.nameMT = nameMT;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}

	public float CongPA(Phuongan pa){
		float values = this.value+pa.value-this.value*pa.value;
		return values;
	}
}
