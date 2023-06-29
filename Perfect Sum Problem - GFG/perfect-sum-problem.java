//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
	public int perfectSum(int arr[],int n, int sum) { 
	    // Your code goes here
	   int prev [] = new int [sum+1];
	   prev[0] = 1;
	   for(int i=1;i<n+1;i++){
	       int cur[] = new int[sum+1];
	       for(int j=0;j<sum+1;j++){ 
               // take
               int take = 0;
               if(j>=arr[i-1]){
                   take = prev[j-arr[i-1]];
               }
               // not take
               int ntake = prev[j];
               cur[j] = (take+ntake)%1000000007;
	       }
	       prev = cur;
	   }
	   return prev[sum];
	} 
}