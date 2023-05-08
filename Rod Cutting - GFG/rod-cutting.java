//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        int dp[][] = new int[price.length+1][n+1];
        for(int i[]: dp){
            Arrays.fill(i,-1);
        }
        return helper(price,price.length,n,dp);
    }
    int helper(int[]price,int ind,int len,int[][]dp){
        if(ind==0){
            return 0;
        }
        if(dp[ind][len]!=-1){
            return dp[ind][len];
        }
        // take 
        int take = Integer.MIN_VALUE;
        if(len>=ind){
            take = price[ind-1]+helper(price,ind,len-ind,dp);
        }
        // not take
        int ntake = helper(price,ind-1,len,dp);
        return dp[ind][len]=Math.max(take,ntake);
    }
}