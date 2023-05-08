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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution{
	public int minDifference(int arr[], int n) { 
	    // Your code goes here
	    int sum =0;
	    for(int i=0;i<n;i++){
	        sum +=arr[i];
	    }
	    boolean dp[][] = new boolean[n+1][sum+1];
	    for(int i=0;i<n+1;i++){
	        for(int j=0;j<sum+1;j++){
	            if(j==0){
	                dp[i][j]=true;
	            }else if(i==0){
	                dp[i][j]=false;
	            }
	            if(i>0 && j>0){
	                // take
	                boolean take = false;
	                if(j>=arr[i-1]){
	                    take = dp[i-1][j-arr[i-1]];
	                }
	                // not take
	                boolean ntake = dp[i-1][j];
	                dp[i][j] = take||ntake;
 	            }
	        }
	    }
	    ArrayList<Integer> a = new ArrayList<>();
	    for(int i=0;i<dp[0].length;i++){
	        if(dp[n][i]){
	            a.add(i);
	        }
	    }
	    int diff = Integer.MAX_VALUE;
	    for(int i=0;i<=a.size()/2;i++){
	        // (sum-a.get(i))-a.get(i)) = sum - 2*a.get(i)
	        diff = Math.min(diff,Math.abs(sum-2*a.get(i)));
	    }
	    return diff;
	} 
}
