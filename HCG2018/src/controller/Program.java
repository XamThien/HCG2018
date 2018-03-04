package controller;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		// G:/HeChuyenGia/HCG2018/Book1.xls
		Scanner nhap = new Scanner(System.in);
		//System.out.print("Nhap ten file :");
		String dA="";
		String fileName = "Book1.xls";//nhap.nextLine();
		String as;
		do{
			PhuongAnList paList = new PhuongAnList();
			paList.ReadFromExcel(fileName);
			System.out.println("Danh sach cac muc tieu cho viec chon lua "+ paList.getNameDSS());
			paList.Choose("2");
			System.out.println("Danh sach cac phuong phap lua chon: ");
			System.out.println("1. Phuong phap Maximin");
			System.out.println("2. Phuong phap Maximax");
			System.out.println("3. Phuong phap HURWICZ **");
			System.out.println("4. Phuong phap SAVAGE-NIEHANS");
			System.out.println("5. Phuong phap BAYES **");
			System.out.println("6. Phuong phap LAPLACE");
			System.out.println("7. Phuong phap HODGES-LEHMANN **");
			System.out.println("8. Phuong phap Quyet dinh mo ***");
			System.out.print("Moi nhap ma phuong phap muon dung: ");
			ArrayList<String> nameMTs = new ArrayList<>();
			 ArrayList<String> namePAs = new ArrayList<>();
			 ArrayList<Phuongan> arr = new ArrayList<Phuongan>();
			 arr = paList.getArr();
			 nameMTs = paList.getNameMTs();
			 namePAs = paList.getNamePAs();
			int ma = nhap.nextInt();
			switch (ma) {
			case 1:
				dA=paList.Maximin();
				break;
			case 2:
				dA=paList.Maximax();
				break;
			case 3:
				dA=paList.Hurwicz(namePAs,arr,23);
				break;
			case 4:
				dA=paList.Savage_Niehans();
				break;
			case 5:
				double xx = 34.23;
				float zz = (float)xx;
				dA=paList.Bayes(zz,namePAs,arr,nameMTs);
				break;
			case 6:
				dA=paList.Laplace();
				break;
			case 7:
				
				// 0,3 không phải là kiểu float ????
				double x = 0.3;
				float z = (float)x;
				dA=paList.Hodges_Lehmann(z,23,namePAs,arr,nameMTs);
				break;
			case 8:
				dA=paList.QDMo();
				break;
			default:
				break;
			}
			System.out.println("Ket qua cua lua chon la: "+dA);
			System.out.println("Thong tin chi tiet cua phuong an "+dA);
			System.out.println(paList.DisplayPA(arr,dA));
			System.out.println("Co tiep tuc tim kiem lua chon va phuong phap (Y/N)");
			as = nhap.nextLine();
		} while (as.equalsIgnoreCase("Y"));
	}
}
