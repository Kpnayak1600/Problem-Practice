//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static long nthFibonacci(long n){
        // code here
        long dp[] = new long [(int)n+1];
        Arrays.fill(dp,-1);
        return nthFibonacciHelper(n,dp);
    }
    static long nthFibonacciHelper(long n,long[]dp){
        if(n<=2){
            return 1;
        }
        if(dp[(int)n]!=-1){
            return dp[(int)n];
        }
        return dp[(int)n] = (nthFibonacciHelper(n-1,dp)+nthFibonacciHelper(n-2,dp))%1000000007;
    }
}