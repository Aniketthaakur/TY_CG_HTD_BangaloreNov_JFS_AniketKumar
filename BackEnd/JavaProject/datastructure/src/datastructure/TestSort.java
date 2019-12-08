package datastructure;

import java.util.Scanner;

public class TestSort {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the size of array:");
	int n=sc.nextInt();
	int ar[]=new int[n];
	System.out.println("enter array element");
	for(int i=0;i<ar.length;i++)
	{
		ar[i]=sc.nextInt();
		
	}
	
	SortedAscending.sortAsc(ar);
	
	BubbleSort b=new BubbleSort();
	b.bubbleSort(ar);
}
}
