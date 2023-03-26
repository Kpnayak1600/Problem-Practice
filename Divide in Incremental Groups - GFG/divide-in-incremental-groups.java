//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int count(int N,int K,int pr,int dp[][][])
    {
        if(K==1)
        {
            if(N>=pr)
            return 1;
            return 0;
        }
        if(N<=0)
        return 0;
        if(dp[N][pr][K]!=-1)
        return dp[N][pr][K];
        int ct=0;
        for(int i=pr;i<N;i++)
        {
            ct+=count(N-i,K-1,i,dp);
        }
        return dp[N][pr][K]=ct;
    }
    public int countWaystoDivide(int N, int K) {
        int dp[][][]=new int[N+1][N+1][K+1];
        for(int i=0;i<=N;i++)
        {
            for(int j=0;j<=N;j++)
            Arrays.fill(dp[i][j],-1);
        }
        return count(N,K,1,dp);
        // Code here
    }
}

