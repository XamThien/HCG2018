package controller;

public class XacSuat_Bayes_hodges_lehmann {
	private String namemt;
	private float xacsuat;
	public XacSuat_Bayes_hodges_lehmann(String namemt, float xacsuat) {
		super();
		this.namemt = namemt;
		this.xacsuat = xacsuat;
	}
	public XacSuat_Bayes_hodges_lehmann() {
		
	}
	public String getNamemt() {
		return namemt;
	}
	public void setNamemt(String namemt) {
		this.namemt = namemt;
	}
	public float getXacsuat() {
		return xacsuat;
	}
	public void setXacsuat(float xacsuat) {
		this.xacsuat = xacsuat;
	}
	
}
