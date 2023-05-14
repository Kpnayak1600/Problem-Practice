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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java



//User function Template for Java

class Solution{
    static int countWays(int N, String S){
        int dp[][][] = new int[N+1][N+1][2];
        for(int i[][]:dp){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }
        // last prameter of helper() function is 
        // keep track of true or false i.e 1-> true
        // 0 - false;
        return helper(S,0,N-1,1,dp);
    }
    static int helper(String S,int i,int j,int isTrue,int dp[][][]){
        // Base case if empty string
        if(i>j){
            return 0;
        }
        // Base case if string has one char
        if(i==j){
            if(isTrue==1){
                return S.charAt(i)=='T'?1:0;
            }else{
                return S.charAt(i)=='F'?1:0;
            }
        }
        if(dp[i][j][isTrue]!=-1){
            return dp[i][j][isTrue];
        }
        int ans = 0;
        for(int k=i+1;k<j;k+=2){
            int leftT = helper(S,i,k-1,1,dp);
            int leftF = helper(S,i,k-1,0,dp);
            int rightT = helper(S,k+1,j,1,dp);
            int rightF = helper(S,k+1,j,0,dp);
            if(S.charAt(k)=='&'){
                ans += isTrue == 1 ? leftT*rightT : leftF*rightF + leftT*rightF + leftF*rightT;
            }else if(S.charAt(k)=='|'){
                ans += isTrue == 1 ? leftT*rightT + leftT*rightF + leftF*rightT : leftF*rightF;
            }else if(S.charAt(k)=='^'){
                ans += isTrue == 1 ? leftT*rightF + leftF*rightT : leftT*rightT + leftF*rightF;
            }
        }
        return dp[i][j][isTrue]=ans%1003;
    }
}