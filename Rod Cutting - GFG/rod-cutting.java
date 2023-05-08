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
        return helper(price,price.length,n);
    }
    int helper(int[]price,int ind,int len){
        int[][]dp = new int[ind+1][len+1];
        for(int i=0;i<ind+1;i++){
            for(int j=0;j<len+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                if(i>0&&j>0){
                    // take 
                    int take = Integer.MIN_VALUE;
                    if(j>=i){
                        take = price[i-1]+dp[i][j-i];
                    }
                    // not take
                    int ntake = dp[i-1][j];
                    dp[i][j] = Math.max(take,ntake);
                }
            }
        }
        return dp[ind][len];
    }
}