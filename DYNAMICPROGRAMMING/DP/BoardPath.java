package DP;

public class BoardPath {

	public static void main(String[] args) {
		int n=1000;
//		new int[n] means n size ka storage bnaya hai kyuki worst case me yhi hoga 
      System.out.println(BPrecursion(0,n));
      System.out.println(BPTD(0,n,new int[n]));
      System.out.println(BPBU(n));
      System.out.println(BPBUSE(n));
	}
	public static int BPrecursion(int current,int end){
//		there is two base case positive and negative base case
//		positive base case
		if(current==end) {
//			return 1 means we sucessfully hit one way to reach
			return 1; 
		}
//		negative base case boundary ke bahr jb chla jaata hai
		if(current>end) {
			return 0;
		}

//		for smaller problem we have add all show count krna pdega
		int count =0;
		for(int dice=1;dice<=6;dice++) {
			
			count+=BPrecursion(current+dice, end);
		}

		
		return count;
	}
	public static int BPTD(int current,int end,int[] strg) {
		if(current==end) {
//			return 1 means we sucessfully hit one way to reach
			return 1; 
		}
//		negative base case boundary ke bahr jb chla jaata hai
		if(current>end) {
			return 0;
		}
		if(strg[current]!=0) {
			return strg[current];
		}

//		for smaller problem we have add all show count krna pdega
		int count =0;
		for(int dice=1;dice<=6;dice++) {
			
			count+=BPTD(current+dice, end,strg);
		}

		strg[current]=count;
		return count;
	}
	public static int BPBU(int end) {
		int[] strg=new int[end+6];
		strg[end]=1;
		for(int i=end-1;i>=0;i++) {
			strg[i]=strg[i+1]+strg[i+2]+strg[i+3]+strg[i+4]+strg[i+5]+strg[i+6];
			
		}
		return strg[0];
	}
	public static int BPBUSE(int end) {
//	the size 6 is always constant whatever value is	
		int[] strg=new int[6];
		strg[0]=1;
		for(int slide=1;slide<=end;slide++) {
			int sum=strg[0]+strg[1]+strg[2]+strg[3]+strg[4]+strg[5];
			strg[5]=strg[4];
			strg[4]=strg[3];
			strg[3]=strg[2];
			strg[2]=strg[1];
			strg[1]=strg[0];
			strg[0]=sum;
		}
		return strg[0];
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
