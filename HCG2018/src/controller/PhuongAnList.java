package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class PhuongAnList {
	
	Scanner nhap = new Scanner(System.in);
	private String nameDSS;
	private ArrayList<String> nameMTs = new ArrayList<>();
	private ArrayList<String> namePAs = new ArrayList<>();
	private ArrayList<Phuongan> arr = new ArrayList<Phuongan>();
	
	
	public ArrayList<Phuongan> getArr() {
		return arr;
	}

	public void setArr(ArrayList<Phuongan> arr) {
		this.arr = arr;
	}

	public String getNameDSS() {
		return nameDSS;
	}

	public void setNameDSS(String nameDSS) {
		this.nameDSS = nameDSS;
	}

	public ArrayList<String> getNameMTs() {
		return nameMTs;
	}

	public void setNameMTs(ArrayList<String> nameMTs) {
		this.nameMTs = nameMTs;
	}

	public ArrayList<String> getNamePAs() {
		return namePAs;
	}

	public void setNamePAs(ArrayList<String> namePAs) {
		this.namePAs = namePAs;
	}

	public void ReadFromExcel(String nameFile){
		Workbook workbook;
		// create workbook to open file
        try {
			workbook = Workbook.getWorkbook(new File(nameFile));
	        
	        Sheet sheet = workbook.getSheet(0);
	        // get number row and col contain data
	        int rows = sheet.getRows();
	        int cols = sheet.getColumns();
	        nameDSS = (sheet.getCell(0, 0)).getContents();
	        for (int col=1; col<cols; col++){
	        	String nameMT = sheet.getCell(col, 0).getContents();
	        	nameMTs.add(nameMT);
	        }
	        for	(int row = 1; row < rows; row++){
	        	String namePa = (sheet.getCell(0, row)).getContents();
	        	namePAs.add(namePa);
	        }
	        for	(int row = 1; row < rows; row++){
	        	for (int col = 1; col < cols; col++){
	        		Cell cell = sheet.getCell(col,row);
	        		Float value = Float.parseFloat(cell.getContents());
	        		Phuongan pa= new Phuongan(namePAs.get(row-1),nameMTs.get(col-1),value);
	        		arr.add(pa);
	        	}
	        }
	        workbook.close();
        } catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Choose(String chon){
//		System.out.println("Danh sach cac muc tieu: Nhan gia tri cac muc tieu de chon");
//		for(int i=0; i< nameMTs.size(); i++){
//			System.out.println((i+1)+": "+nameMTs.get(i));
//		}
		// Moi lua chon cach nhau mot dau cach; khi len giao dien thi chuyen phan này thanh check box
		//String chon = nhap.nextLine();
		String[] mTs = chon.split("\\s");
		ArrayList<Phuongan> pa	= new ArrayList<>();
		ArrayList<String> nameMT= new ArrayList<>();
		ArrayList<String> namePA= new ArrayList<>();
		for (String w : mTs) {
			Integer x = Integer.parseInt(w);
			for (Phuongan phuongan : arr) {
				if (phuongan.getNameMT().contains(nameMTs.get(x))) {
					pa.add(phuongan);
				}
				if (!namePA.contains(phuongan)) {
					namePA.add(phuongan.getNamePA());
				}
			}
			nameMT.add(nameMTs.get(x));
		}
		
		this.setNamePAs(namePA);
		this.setNameMTs(nameMT);
		this.setArr(arr);
	}
	
	public String DisplayPA(ArrayList<Phuongan> arr,String namePA){
		//System.out.println("Phương án: "+ namePA);
		String rtn = namePA;
		for (Phuongan phuongan : arr) {
			if(phuongan.getNamePA().contains(namePA)){
				//System.out.println(phuongan.getNameMT()+" : "+ phuongan.getValue());
				rtn+=","+phuongan.getNameMT()+","+ phuongan.getValue();
			}
		}
		return rtn;
	}
	
	public Phuongan TimMax(ArrayList<Phuongan> list){
		Phuongan max = list.get(0);
		for (int i = 1; i< list.size(); i++){
			if (max.getValue() < list.get(i).getValue()){
				max=list.get(i);
			}
		}
		return max;
	}
	public Phuongan TimMin(ArrayList<Phuongan> list){
		Phuongan min = list.get(0);
		for (int i = 1; i< list.size(); i++){
			if (min.getValue() > list.get(i).getValue()){
				min=list.get(i);
			}
		}
		return min;
	}
	public String Maximin(ArrayList<String> namePAs,ArrayList<Phuongan> arr){
		ArrayList<Phuongan> minRows = new ArrayList<>();
		for (String namepa : namePAs) {
			ArrayList<Phuongan> arrRow = new ArrayList<>();
			for (Phuongan pa : arr) {
				if (namepa.contains(pa.getNamePA())) {
					arrRow.add(pa);
				}
			}
			minRows.add(TimMin(arrRow));
		}
		
		return TimMax(minRows).getNamePA();
	}
	public String Maximax(ArrayList<String> namePAs,ArrayList<Phuongan> arr){
		ArrayList<Phuongan> maxRows = new ArrayList<>();
		for (String namepa : namePAs) {
			ArrayList<Phuongan> arrRow = new ArrayList<>();
			for (Phuongan pa : arr) {
				if (namepa.contains(pa.getNamePA())) {
					arrRow.add(pa);
				}
			}
			maxRows.add(TimMax(arrRow));
		}
		
		return TimMax(maxRows).getNamePA();
	}
	public String Hurwicz(ArrayList<String> namePAs,ArrayList<Phuongan> arr,int anpha){
		// anpha tren thuc te tu 0 den 100; khi tinh se chia cho 100
		//int anpha;
		//System.out.println("Nhập hệ số lạc quan anpha: từ 0 -> 100");
		//anpha = nhap.nextInt();
		if (anpha>=0 && anpha<=100) {
			ArrayList<Phuongan> PAs = new ArrayList<>();
			for (String namepa : namePAs) {
				ArrayList<Phuongan> arrRow = new ArrayList<>();
				for (Phuongan pa : arr) {
					if (namepa.contains(pa.getNamePA())) {
						arrRow.add(pa);
					}
				}
				float max = TimMax(arrRow).getValue();
				float min = TimMin(arrRow).getValue();
				float value = max*anpha/100+ min*(1-anpha/100);
				Phuongan choose = new Phuongan(namePAs.get(0),"",value);
				PAs.add(choose);
			}
			return TimMax(PAs).getNamePA();
		} else System.out.println("Nhập sai giá trị của hệ số anpha");
		return "";
	}
	public String Savage_Niehans(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs){
		ArrayList<Phuongan> matrixTV = arr;
		for (String namemt : nameMTs) {
			ArrayList<Phuongan> arrRow = new ArrayList<>();
			for (Phuongan pa : matrixTV) {
				if (namemt.contains(pa.getNameMT())) {
					arrRow.add(pa);
				}
			}
			float value = TimMax(arrRow).getValue();
			for (Phuongan pa : matrixTV) {
				if (namemt.contains(pa.getNameMT())) {
					pa.setValue(value - pa.getValue());
				}
			}
		}
		ArrayList<Phuongan> maxRows = new ArrayList<>();
		for (String namepa : namePAs) {
			ArrayList<Phuongan> arrRow = new ArrayList<>();
			for (Phuongan pa : matrixTV) {
				if (namepa.contains(pa.getNamePA())) {
					arrRow.add(pa);
				}
			}
			maxRows.add(TimMax(arrRow));
		}
		
		return TimMin(maxRows).getNamePA();
	}
	public String Bayes(ArrayList<Float> xacSuat,ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs){
		//ArrayList<Float> xacSuat = new ArrayList<>();
		float tongxs=0;
		for (float p : xacSuat) {
			//System.out.println("Nhập mức độ xảy ra trạng thái "+ string);
			// gia tri cua p  0 -> 100; 
			//float p = nhap.nextFloat();
			tongxs+=p;
			
		}
		for (Float f : xacSuat) {
			f=f/tongxs;
		}
		
		ArrayList<Phuongan> matrixTV = arr;
		for (int i =0; i< nameMTs.size(); i++) {
			for (Phuongan pa : matrixTV) {
				if (nameMTs.get(i).contains(pa.getNameMT())) {
					pa.setValue(xacSuat.get(i)*pa.getValue());
				}
			}
		}
		ArrayList<Phuongan> sumRows = new ArrayList<>();
		for (String namepa : namePAs) {
			float tong=0;
			for (Phuongan pa : matrixTV) {
				if (namepa.contains(pa.getNamePA())) {
					tong+=pa.getValue();
				}
			}
			
			sumRows.add(new Phuongan(namepa, "",tong));
		}
		
		return TimMax(sumRows).getNamePA();
	}
	public String Laplace(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs){
		float xacSuat = 1 / (namePAs.size());
		ArrayList<Phuongan> matrixTV = arr;
		for (int i =0; i< nameMTs.size(); i++) {
			for (Phuongan pa : matrixTV) {
				if (nameMTs.get(i).contains(pa.getNameMT())) {
					pa.setValue(xacSuat*pa.getValue());
				}
			}
		}
		ArrayList<Phuongan> sumRows = new ArrayList<>();
		for (String namepa : namePAs) {
			float tong=0;
			for (Phuongan pa : matrixTV) {
				if (namepa.contains(pa.getNamePA())) {
					tong+=pa.getValue();
				}
			}
			
			sumRows.add(new Phuongan(namepa, "",tong));
		}
		
		return TimMax(sumRows).getNamePA();
	}
	public String Hodges_Lehmann(float lamda,ArrayList<Float> xacSuat,ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs){
		//System.out.println("Nhập hệ số tin cậy: lamda= ");
		// gia tri cua p  0 -> 1; 
		//float lamda = nhap.nextFloat();
		//ArrayList<Float> xacSuat = new ArrayList<>();
		float tongxs=0;
		for (float p : xacSuat)
		{
			tongxs+=p;
		}
		
		for (String string : nameMTs) {
			//System.out.println("Nhập mức độ xảy ra trạng thái "+ string);
			// gia tri cua p  0 -> 100; 
			//float p = nhap.nextFloat();
			
			
		}
		for (double f : xacSuat) {
			f=f/tongxs;
		}
		ArrayList<Phuongan> matrixTV = arr;
		for (int i =0; i< nameMTs.size(); i++) {
			for (Phuongan pa : matrixTV) {
				if (nameMTs.get(i).contains(pa.getNameMT())) {
					pa.setValue( xacSuat.get(i)*pa.getValue());
				}
			}
		}
		ArrayList<Phuongan> sumRows = new ArrayList<>();
		for (String namepa : namePAs) {
			float tong=0;
			for (Phuongan pa : matrixTV) {
				if (namepa.contains(pa.getNamePA())) {
					tong+=pa.getValue();
				}
			}
			sumRows.add(new Phuongan(namepa, "",tong*lamda));
		}
		
		ArrayList<Phuongan> minRows = new ArrayList<>();
		for (String namepa : namePAs) {
			ArrayList<Phuongan> arrRow = new ArrayList<>();
			for (Phuongan pa : arr) {
				if (namepa.contains(pa.getNamePA())) {
					arrRow.add(pa);
				}
			}
			Phuongan min = TimMin(arrRow);
			min.setValue( min.getValue()*(1-lamda));
			minRows.add(min);
		}
		for(int i=0; i< namePAs.size(); i++){
			sumRows.get(i).setValue(sumRows.get(i).getValue()+ minRows.get(i).getValue());
		}
		
		return TimMax(sumRows).getNamePA();
	}
	public String QDMo(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs){
		String choosePA="";
		//Xac dinh thai do cua nguoi ra quyet dinh
		// gom:biquan, giua bi quan va tgian, trung gian, giua tgian va lac quan, lac quan
		System.out.println("Chọn thái độ muốn quyết định: ");
		System.out.println("1. Bi quan");
		System.out.println("2. Giữa bi quan và trạng thái trung gian");
		System.out.println("3. Trạng thái trung gian");
		System.out.println("4. Giữa trạng thái trung gian và lạc quan");
		System.out.println("5. Lạc quan");
		int thaiDo = nhap.nextInt();
		switch (thaiDo) {
		case 1:
			choosePA=Maximin(namePAs,arr);
			break;
		case 2:
			choosePA=QDMoBTG(namePAs,arr);
			break;
		case 3:
			double x = 0.3;
			float z = (float)x;
			ArrayList<Float> trongSo = new ArrayList<Float>();
			trongSo.add(z);
			choosePA=QDMoTG(trongSo,namePAs,arr,nameMTs);
			break;
		case 4:
			choosePA=QDMoTGL(namePAs,arr);
			break;
		case 5: 
			choosePA=Maximax(namePAs, arr);
			break;
		default:
			break;
		}
		
		return choosePA;
	}
	public String QDMoTG(ArrayList<Float> trongSo,ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs){
		//ArrayList<Float> trongSo = new ArrayList<>();
		float tongxs=0;
		for (Float p : trongSo) {
			//System.out.println("Nhập mức độ xảy ra trạng thái "+ string);
			// gia tri cua p  0 -> 100; 
			//float p = nhap.nextFloat();
			tongxs+=p;
			
		}
		for (Float f : trongSo) {
			f=f/tongxs;
		}
		ArrayList<Phuongan> matixTV =arr;
		for (int i =0; i< nameMTs.size(); i++) {
			for (Phuongan pa : matixTV) {
				if (nameMTs.get(i).contains(pa.getNameMT())) {
					pa.setValue(trongSo.get(i)*pa.getValue());
				}
			}
		}
		ArrayList<Phuongan> TTRows = new ArrayList<>();
		for (String namepa : namePAs) {
			float tong=0;
			for (Phuongan pa : matixTV) {
				if (namepa.contains(pa.getNamePA())) {
					tong+=pa.getValue();
				}
			}
			TTRows.add(new Phuongan(namepa, "",tong));
		}
		return TimMax(TTRows).getNamePA();
	}
	public String QDMoBTG(ArrayList<String> namePAs,ArrayList<Phuongan> arr){
		ArrayList<Phuongan> mulRows = new ArrayList<>();
		for (String namepa : namePAs) {
			float tich=1;
			for (Phuongan pa : arr) {
				if (namepa.contains(pa.getNamePA())) {
					tich*=pa.getValue();
				}
			}
			Phuongan p = new Phuongan(namepa,"",tich);
			mulRows.add(p);
		}
		return TimMax(mulRows).getNamePA();
	}
	public String QDMoTGL(ArrayList<String> namePAs,ArrayList<Phuongan> arr){
		ArrayList<Phuongan> sumRows = new ArrayList<>();
		for (String namepa : namePAs) {
			float tong=0;
			for (Phuongan pa : arr) {
				if (namepa.contains(pa.getNamePA())) {
					tong=pa.getValue()+tong-pa.getValue()*tong;
				}
			}
			Phuongan p = new Phuongan(namepa,"",tong);
			sumRows.add(p);
		}
		return TimMax(sumRows).getNamePA();
	}
	
}
