//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }
// } Driver Code Ends


class Solution{
    //Function to sort an array using quick sort algorithm.
    static int pivot(int[]arr,int l,int r){
        int i=l-1;
        int j=r+1;
        int pivot= arr[l];
         while (true) {
            do{
                i++;
            }while(arr[i]<pivot);
            do{
                j--;
            }while(arr[j]>pivot);
            if(i>=j){
                return j;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    static void quickSort(int arr[], int low, int high){
        // code here
       if(high<=low){
            return ;
        }
        int pivot = pivot(arr,low,high);
        quickSort(arr, low, pivot);
        quickSort(arr, pivot+1, high);
    }
}
