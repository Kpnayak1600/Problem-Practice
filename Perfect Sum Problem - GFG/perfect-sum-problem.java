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
	   int dp[][] = new int[n+1][sum+1];
	   for(int i[]:dp){
	       Arrays.fill(i,-1);
	   }
	   return perfectSumHelper(arr,n,sum,dp);
	} 
	int perfectSumHelper(int[] arr,int n,int sum,int [][]dp){
	   if(n==1){
	        if(sum==0 && arr[n-1]==0){
	            return 2;
	        }
	        if(sum==0 || arr[n-1]==sum){
	            return 1;
	        }
	        return 0;
	    }
	    if(dp[n][sum]!=-1){
	        return dp[n][sum];
	    }
	    // take
	    int take = 0;
	    if(sum>=arr[n-1]){
	        take = perfectSumHelper(arr,n-1,sum-arr[n-1],dp);
	    }
	    // not take
	    int ntake = perfectSumHelper(arr,n-1,sum,dp);
	    return dp[n][sum] = (take + ntake)%1000000007;
	}
}