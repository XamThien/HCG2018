package controller;

public class MainClass {
	  public static void main(String args[]) throws Exception {
	    String s = "0123456789";
	    byte ptext[] = s.getBytes("UTF8");
	    String name = "";
	    for (int i = 0; i < ptext.length; i++) {
	      
	      name+=ptext[i];
	      
	    }
	    System.out.print(name);
	  }
	}