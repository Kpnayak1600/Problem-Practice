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
	   for(int i=0;i<n+1;i++){
	       for(int j=0;j<sum+1;j++){
	           if(i==0&&j==0){
	               dp[i][j] = 1;
	           }
	           if(i>0){
	               // take
	               int take = 0;
	               if(j>=arr[i-1]){
	                   take = dp[i-1][j-arr[i-1]];
	               }
	               // not take
	               int ntake = dp[i-1][j];
	               dp[i][j] = (take+ntake)%1000000007;
	           }
	       }
	   }
	   return dp[n][sum];
	} 
}