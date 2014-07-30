package exercise.level1;

import java.util.Arrays;
import java.util.Scanner;

public class StockFinder2 {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if(n>=100000){
			System.out.println("Value is more than 100000");
			return;
		}
		
		int stockLoss = 0;
		int lastStock = 0;
		int highestStock = 0;
		int currentValue = 0;
		int tempLoss = 0;
		for(int i=0; i<n; i++){
			currentValue = scanner.nextInt();
			if(i==0){
				highestStock = currentValue;
			}else{
				if(currentValue<lastStock){
					tempLoss =  currentValue - highestStock;
				}else if(currentValue>highestStock)
					highestStock = currentValue;
			
				if(tempLoss<stockLoss)
					stockLoss = tempLoss;
			}
			
			lastStock = currentValue;
		}
		System.out.println(stockLoss);
	}
}
