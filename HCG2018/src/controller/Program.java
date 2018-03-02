package controller;

import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		// G:/HeChuyenGia/HCG2018/Book1.xls
		Scanner nhap = new Scanner(System.in);
		System.out.print("Nhap ten file :");
		String dA="";
		String fileName = "Book1.xls";//nhap.nextLine();
		String as;
		do{
			PhuongAnList paList = new PhuongAnList();
			paList.ReadFromExcel(fileName);
			System.out.println("Danh sach cac muc tieu cho viec chon lua "+ paList.getNameDSS());
			paList.Choose();
			System.out.println("Danh sach cac phuong phap lua chon: ");
			System.out.println("1. Phuong phap Maximin");
			System.out.println("2. Phuong phap Maximax");
			System.out.println("3. Phuong phap HURWICZ");
			System.out.println("4. Phuong phap SAVAGE-NIEHANS");
			System.out.println("5. Phuong phap BAYES");
			System.out.println("6. Phuong phap LAPLACE");
			System.out.println("7. Phuong phap HODGES-LEHMANN");
			System.out.println("8. Phuong phap Quyet dinh mo");
			System.out.print("Moi nhap ma phuong phap muon dung: ");
			int ma = nhap.nextInt();
			switch (ma) {
			case 1:
				dA=paList.Maximin();
				break;
			case 2:
				dA=paList.Maximax();
				break;
			case 3:
				dA=paList.Hurwicz();
				break;
			case 4:
				dA=paList.Savage_Niehans();
				break;
			case 5:
				dA=paList.Bayes();
				break;
			case 6:
				dA=paList.Laplace();
				break;
			case 7:
				dA=paList.Hodges_Lehmann();
				break;
			case 8:
				dA=paList.QDMo();
				break;
			default:
				break;
			}
			System.out.println("Ket qua cua lua chon la: "+dA);
			System.out.println("Thong tin chi tiet cua phuong an "+dA);
			paList.DisplayPA(dA);
			System.out.println("Co tiep tuc tim kiem lua chon va phuong phap (Y/N)");
			as = nhap.nextLine();
		} while (as.equalsIgnoreCase("Y"));
	}
}
