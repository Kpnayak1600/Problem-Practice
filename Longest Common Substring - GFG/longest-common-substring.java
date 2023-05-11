//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int arr [] = new int [m+1];
        // base case for arr array is fill prev arr
        // by zero but in java by default a array is filled with 0
        // so no need to fill manually
        int ans = 0;
        for(int i=1;i<n+1;i++){
            for(int j=m;j>0;j--){
                // Matched
                if(S1.charAt(i-1)==S2.charAt(j-1)){
                    arr[j] = 1+arr[j-1];
                    ans = Math.max(ans,arr[j]);
                }else{
                    // not matched
                    arr[j] = 0;
                }
            }
        }
        return ans;
    }
}