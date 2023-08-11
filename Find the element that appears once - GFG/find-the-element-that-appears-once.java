//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Sol{
    public static int bs(int arr[], int low, int high){
        if (low==high){
            return arr[low];
        }
        int mid = (low + high) / 2;
        // If mid is even and element next to mid is
        // same as mid, then output element lies on
        // right side, else on left side
        if (mid%2 == 0){
            if (arr[mid] == arr[mid+1])
                return bs(arr, mid+2, high);
            else
                return bs(arr, low, mid);
        }
        else{  // If mid is odd
            if (arr[mid] == arr[mid-1])
                return bs(arr, mid+1, high);
            else
                return bs(arr, low, mid-1);
        }
    }
    public static int search(int arr[], int n){
        return bs(arr,0,n-1);
    }
}