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
    static int knapSack(int W, int wt[], int val[], int n){ 
        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                // Base condition of recursion
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                // logical part of recursion
                if(i>0&&j>0){
                    // take
                    int take = 0;
                    if(j>=wt[i-1]){
                        take = val[i-1]+dp[i-1][j-wt[i-1]];
                    }
                    // not take
                    int ntake = dp[i-1][j];
                    dp[i][j] = Math.max(take,ntake);
                }
            }
        }
        return dp[n][W];
    } 
}


