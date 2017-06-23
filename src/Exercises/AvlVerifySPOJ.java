package Exercises;

import Lists.ArrayList;
import java.util.Scanner;

public class AvlVerifySPOJ {
	public static void main(String args){
		int[] tree = new int[200];
		ArrayList<String> testsList = new ArrayList();

		Scanner scan = new Scanner(System.in);

		int numberOfTests = scan.nextInt();
		scan.nextLine();
		
		for(int i = 0; i < numberOfTests; i++){
			testsList.add(scan.nextLine());
		}
		
		
	}
}
