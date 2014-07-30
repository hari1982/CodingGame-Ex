package exercise.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StockFinder {

	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] sValues = new int[n];
		int[] sTrends = new int[0];
		//System.out.println(sTrends[0]);
		ArrayList<Integer> stockValues = new ArrayList<Integer>();
		ArrayList<Integer> stockTrends = new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			//stockValues.add(scanner.nextInt());
			sValues[i] = scanner.nextInt();
		}
		long startTime = System.currentTimeMillis();
		int k = 1;
		for(int value : sValues){
			if(k >= sValues.length)
				break;
			int[] values = getStockTrends(value, Arrays.copyOfRange(sValues, k, sValues.length));
			/*for(int j : values)
				System.out.println(j);*/
			int orginalLength = sTrends.length;
			sTrends = Arrays.copyOf(sTrends, values.length + orginalLength);
			for(int j : values){
				sTrends[orginalLength] = j;
				orginalLength++;
			}
			/*for(int j : values){
				stockTrends.add(j);
			}*/
			k++;
		}
		
		Arrays.sort(sTrends);
		//Collections.sort(stockTrends);
		//int stockLoss = stockTrends.get(0);
		int stockLoss = sTrends[0];
		if(stockLoss>0)
			stockLoss = 0;
		System.out.println(stockLoss);
		
		double totalTime = ((System.currentTimeMillis() - startTime)/1000.0);
		System.out.println("Total Seconds: "+ totalTime);
	}
	
	public static int[] getStockTrends(int currentValue,
			int[] stocks){
		System.out.println(stocks);
		int[] retval = new int[stocks.length];
		int i = 0;
		
		for(int v : stocks){
			retval[i] = (v-currentValue);
			i++;
		}
		return retval;
	}
}
