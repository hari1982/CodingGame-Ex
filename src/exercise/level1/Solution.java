/**
 * @author HariBabu.T
 *
 *
 */
package exercise.level1;

import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

	/*
	 * 8
-28189131 593661218
102460950 1038903636
938059973 -816049599
-334087877 -290840615
842560881 -116496866
-416604701 690825290
19715507 470868309
846505116 -694479954
	 */
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] yValues = new int[n];
		int[] xValues = new int[n];
		int minX = 0;
		int maxX = 0;
		int minY = 0;
		int maxY = 0;
		if(n==1){
		    int X = in.nextInt();
			int Y = in.nextInt();
			System.out.println(0);
			return;
		}
		char a ='0';
		boolean negativeValues = false;
		for (int i = 0; i < n; i++) {
			int X = in.nextInt();
			int Y = in.nextInt();
			xValues[i] = X;
			yValues[i] = Y;
			if(X<=minX)
			    minX =X;
			if(X>=maxX)
			    maxX =X;
			if(Y<=minY)
			    minY =Y;
			if(Y>=maxY)
			    maxY=Y;
			if(X<0 || Y<0)
			   negativeValues = true;
		}
		System.err.println("Max Y:" + maxY);
		System.err.println("Min Y:" + minY);
		int cableLen = maxX-minX;
		int midLine = (maxY+minY)/2;
		System.err.println("Bef Mid Line" + midLine);
		Arrays.sort(yValues);
		if(yValues.length%2==0)
		    midLine = yValues[((n-1)/2)-1] ;
		else
	        midLine=yValues[(yValues.length-1)/2];
		//if(midLine<0) midLine = 0;
		
		/*System.err.println("Bef Mid Line" + midLine);
		int lBound = midLine;
		int uBound = midLine;
		if(negativeValues){
		while(Arrays.binarySearch(yValues,midLine)<-1){
		    lBound=lBound-1;
		    uBound=uBound+1;
		    if(Arrays.binarySearch(yValues,lBound)>-1){
		         midLine = lBound;
		         break;
		    }
		    if(Arrays.binarySearch(yValues,uBound)>-1){
		         midLine = uBound;
		         break;
		    }
		  
		}
		}else{
		    while(Arrays.binarySearch(yValues,midLine)<-1){
		        midLine+=1;
		    }
		}*/
		
		System.err.println("Adj Mid Line" + midLine);
		
		for(int i=0;i<n;i++){
		     
		     int vLen = midLine - yValues[i];
		     if(vLen==0)
		        continue;
		     if(vLen<0)
		        vLen = -(vLen);
		     cableLen=cableLen + vLen;
		}
		System.out.println(cableLen);
	}
}