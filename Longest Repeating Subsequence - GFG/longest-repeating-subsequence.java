//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int LongestRepeatingSubsequence(String str){
       int dp[][] = new int [str.length()+1][str.length()+1];
        for(int i=0;i<str.length()+1;i++){
            for(int j=0;j<str.length()+1;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                }
                if(i>0 && j>0){
                    // matched
                    if(i!=j && str.charAt(i-1)==str.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                    }else{
                        //not matched
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[str.length()][str.length()];
    }
}