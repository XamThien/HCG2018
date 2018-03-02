package controller;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test t = new test();
		if(t.checkFileExcel("G:/HeChuyenGia/HCG2018/Book1.xls"))
			{
			
				System.out.println("ok");
			};
		//t.readFileExcel("E:/hoctap/HeChuyenGia/Book1.xls");
	}

}
