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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str){
        // code here
        int dp[][] = new int[str.length()+1][str.length()+1];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        return helper(str,0,str.length()-1,dp);
    }
    static int helper(String str,int i,int j,int[][]dp){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(isPalindrome(str,i,j)){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int tempAns = 1+helper(str,i,k,dp)+helper(str,k+1,j,dp);
            ans = Math.min(ans,tempAns);
        }
        return dp[i][j]=ans;
    }
    static boolean isPalindrome(String str,int i,int j){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}