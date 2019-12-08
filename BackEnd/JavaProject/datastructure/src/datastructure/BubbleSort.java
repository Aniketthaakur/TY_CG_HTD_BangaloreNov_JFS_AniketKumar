package datastructure;

public class BubbleSort {
	void bubbleSort(int[] ar)
	{
		int temp;
		
		for(int i=0;i<ar.length;i++) 
		{
			for(int j=0;j<ar.length;j++)
			{
				if(ar[i]<ar[j])
				{
					temp=ar[i];
					ar[i]=ar[j];
					ar[j]=temp;
				}
			}
		}
		for(int i=0;i<ar.length;i++)
		{
			System.out.println(ar[i]);
		}
	}

}
