package DP;

import java.util.Arrays;
import java.util.Scanner;

public class palidromepartioning {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
		String s = scn.next();

		System.out.println(palidromepartioningRec(s, 0, s.length() - 1));
		int[][] strg = new int[s.length()][s.length()];
		for (int i = 0; i < strg.length; i++) {
			Arrays.fill(strg[i], -1);
		}
		System.out.println(palidromepartioningTD(s, 0, s.length() - 1,strg));
         System.out.println(palidromepartioningBU(s));
	}

	public static int palidromepartioningRec(String s, int si, int ei) {
		if (ispalidrome(s, si, ei)) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = si; k <= ei - 1; k++) {
			int fb = palidromepartioningRec(s, si, k);
			int sp = palidromepartioningRec(s, k + 1, ei);
			int total = fb + sp + 1;
			if (total < min)
				min = total;

		}
		return min;
	}

	public static boolean ispalidrome(String s, int si, int ei) {
		int l = si;
		int r = ei;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

	public static int palidromepartioningTD(String s, int si, int ei, int[][] strg) {
		if (ispalidrome(s, si, ei)) {
			return 0;
		}
		if (strg[si][ei] != -1) {
			return strg[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int k = si; k <= ei - 1; k++) {
			int fb = palidromepartioningTD(s, si, k, strg);
			int sp = palidromepartioningTD(s, k + 1, ei, strg);
			int total = fb + sp + 1;
			if (total < min)
				min = total;

		}
		strg[si][ei] = min;
		return min;
	}

	public static int palidromepartioningBU(String s) {
		boolean[][] isStringpalidrome=palidromeInfo(s);
		int[][] strg = new int[s.length()][s.length()];
		int n = s.length();
		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				
				if (isStringpalidrome[si][ei]) {
					strg[si][ei] = 0;
				} 
				else {

					int min = Integer.MAX_VALUE;
					for (int k = si; k <= ei - 1; k++) {
						int fb = strg[si][k];
						int sp = strg[k + 1][ei];
						int total = fb + sp + 1;
						if (total < min)
							min = total;

					}
					strg[si][ei] = min;
				}

			}
		}
		return strg[0][n-1];
	}
	public static boolean[][] palidromeInfo(String s){
		boolean[][] isStringpalidrome=new boolean[s.length()][s.length()];
		for(int i=0;i<isStringpalidrome.length;i++) {
			Arrays.fill(isStringpalidrome[i], true);
		}
		for(int row=s.length()-2;row>=0;row--) {
			for(int col=row+1;col<s.length();col++) {
				if(s.charAt(row)==s.charAt(col)) {
					isStringpalidrome[row][col]=isStringpalidrome[row+1][col-1];
				}else {
					isStringpalidrome[row][col]=false;
				}
			}
		}
		return isStringpalidrome;
	}

}
