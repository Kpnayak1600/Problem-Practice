//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[]){
        int dp[][] = new int[N+1][W+1];
        for(int i=0;i<N+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                if(i>0&&j>0){
                    // take
                    int take = Integer.MIN_VALUE;
                    if(j>=wt[i-1]){
                        take = val[i-1]+dp[i][j-wt[i-1]];
                    }
                    // not take 
                    int ntake = dp[i-1][j];
                    dp[i][j] = Math.max(take,ntake);
                }
            }
        }
        return dp[N][W];
    }
}