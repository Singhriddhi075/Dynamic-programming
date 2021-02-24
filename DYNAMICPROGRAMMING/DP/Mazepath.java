package DP;

import java.util.Arrays;

public class Mazepath {
// er=end row,ec=end colomn,cc=current row,cc=current colomn,Mp=mazepath,ch=horizontal count,cv=vertical count
	public static void main(String[] args) {
		int n=20;
//      System.out.println(MpRecursion(0,0,n,n));
		System.out.println(MpTD(0,0,n,n,new int[n+1][n+1]));
		System.out.println(MPBU(n,n));
		System.out.println(MPBUSE(n,n));
	}
	public static int MpRecursion(int cr,int cc,int er,int ec) {
		if(cr==er && cc==ec) {
			return 1;
		}
		if(cr>er || cc>ec) {
			return 0;
		}
		int ch=MpRecursion(cr,cc+1,er,ec);
		int cv=MpRecursion(cr+1,cc,er,ec);
	
	return ch+cv;

 }
	public static int MpTD(int cr,int cc,int er,int ec,int[][]strg) {
		if(cr==er && cc==ec) {
			return 1;
		}
		if(cr>er || cc>ec) {
			return 0;
		}
//		reuse
		if(strg[cr][cc]!=0) {
			return strg[cr][cc];
		}
		int ch=MpTD(cr,cc+1,er,ec,strg);
		int cv=MpTD(cr+1,cc,er,ec,strg);
	    strg[cr][cc]=ch+cv;
	return ch+cv;

 }
	public static int MPBU(int er,int ec) {
		int[][] strg=new int[er+2][er+2];
		for(int row=er;row>=0;row--) {
			for(int col=ec;col>=0;col--) {
				if(row==er && col==ec) {
					strg[row][col]=1;
				}else {
					strg[row][col]=strg[row][col+1]+strg[row+1][col];
				}
			}
		}
		return strg[0][0];
	}
	public static int MPBUSE(int er,int ec) {
		int[] strg=new int[ec+1];
		Arrays.fill(strg, 1);
		for(int slide=er-1;slide>=0;slide--) {
			for(int col=ec;col>=0;col--) {
				if(col==ec) {
					strg[col]=1;
					
				}else {
					strg[col]=strg[col]+strg[col+1];
				}
			}
		}
		return strg[0];
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}