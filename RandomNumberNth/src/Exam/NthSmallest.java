package Exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NthSmallest {

	public static void main(String[] args) {
		Random rm = new Random();
		ArrayList<Integer> al = new ArrayList<Integer>();
         int j;
         for(int i=0;i<500;i++) {
        	 al.add(i, rm.nextInt(10000));
        	System.out .println(al.get(i));
        	}
         
         System.out.println("Sorted Array ");
         
         Collections.sort(al);
         for(int i=0;i<500;i++) {
        	System.out .println(al.get(i));
         }
         
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        int Nth;
         do {
        	 System.out.println("Enter the Nth number [1-500]: ");
              Nth = sc.nextInt();
         }while (Nth<1||Nth>500);
        	 
         
         System.out.println("The Nth smallest number is: ");
         
         System.out.println(al.get(Nth-1));
         
	}		
		
}


