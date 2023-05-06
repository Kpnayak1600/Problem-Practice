//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution { 
    static int knapSack(int W, int wt[], int val[], int n) { 
         int dp[][] = new int [n+1][W+1];
         for(int[] i : dp){
             Arrays.fill(i,-1);
         }
         knapSackHelper(W,wt,val,n,dp);
         return dp[n][W];
    } 
    static int knapSackHelper(int W,int []wt,int val[],int n,int[][]dp){
        if(W==0 ||n==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        // take 
        int take = 0;
        if(W>=wt[n-1]){
            take = val[n-1]+knapSackHelper(W-wt[n-1],wt,val,n-1,dp);
        }
        // not take
        int ntake = knapSackHelper(W,wt,val,n-1,dp);
        return dp[n][W] = Math.max(take,ntake);
    }
}


