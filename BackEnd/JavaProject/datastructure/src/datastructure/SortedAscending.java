package datastructure;

public class SortedAscending {
  public static void sortAsc(int[] ar)
   {
	   int min;
	   for(int i=0;i<ar.length;i++)
	   {
		   for(int j=i+1;j<ar.length;j++)
		   {
			   if(ar[i]<ar[j])
			   {
				   min=ar[i];
				   System.out.println(min);
				   break;
			   }
		   }
	   }
   }
}
