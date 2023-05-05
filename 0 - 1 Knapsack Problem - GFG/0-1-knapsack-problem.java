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
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) { 
        int dp[][] = new int[W+1][n+1];
        for(int [] i : dp){
            Arrays.fill(i,-1);
        }
        knapSackHelper(W,wt,val,n,dp);
        // for(int [] i : dp){
        //     System.out.println(Arrays.toString(i));
        // }
        return dp[W][n];
    } 
    static int knapSackHelper(int W,int wt[],int val[],int n,int[][] dp){
        if(n==0 || W ==0){
            return 0;
        }
        if(dp[W][n]!=-1){
            return dp[W][n];
        }
        // take
        int take =0;
        if(W>=wt[n-1]){
            take = val[n-1]+knapSackHelper(W-wt[n-1],wt,val,n-1,dp);
        }
        int ntake = knapSackHelper(W,wt,val,n-1,dp);
        return dp[W][n] = Math.max(take,ntake);
    }
}


