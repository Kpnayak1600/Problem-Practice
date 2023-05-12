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
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return helper(str,str,str.length(),str.length(),dp);
    }
   int helper(String text1,String text2,int t1,int t2,int[][]dp){
        if(t1==0||t2==0){
            return 0;
        }
        if(dp[t1][t2]!=-1){
            return dp[t1][t2];
        }
        // matched
        if(t1!=t2 && text1.charAt(t1-1)==text2.charAt(t2-1)){
            return dp[t1][t2] = 1+helper(text1,text2,t1-1,t2-1,dp);
        }else{
            // not matched
            return dp[t1][t2] = Math.max(helper(text1,text2,t1-1,t2,dp),helper(text1,text2,t1,t2-1,dp));
        }
    }
}