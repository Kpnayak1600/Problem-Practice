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
        int prev[] = new int[W+1];
        // Base condition of recursion
        // no need to write as in java array is initialised with 0
        // if other than 0 is to fill as base case then we hava to initialise with that
        prev[0] = 0; 
        for(int i=1;i<n+1;i++){
            int cur[] = new int[W+1];
            cur[0] =0;
            for(int j=1;j<W+1;j++){
                // logical part of recursion
                // take
                int take = 0;
                if(j>=wt[i-1]){
                    take = val[i-1]+prev[j-wt[i-1]];
                }
                // not take
                int ntake = prev[j];
                cur[j] = Math.max(take,ntake);
            }
            prev = cur;
        }
        return prev[W];
    } 
}


