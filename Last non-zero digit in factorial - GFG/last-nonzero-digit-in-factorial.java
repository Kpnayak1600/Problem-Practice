//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int ans = ob.lastNon0Digit(N);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java


class Solution{
    public static java.math.BigInteger factorial(int N){
        if(N==1){
            return java.math.BigInteger.valueOf(1);
        }
        return java.math.BigInteger.valueOf(N).multiply(factorial(N-1));
    }
    int nonDigit(int N){
        java.math.BigInteger fact = factorial(N);
        //System.out.println(fact);
        java.math.BigInteger res = new java.math.BigInteger("0");
        java.math.BigInteger d = java.math.BigInteger.TEN;
        for(;fact.compareTo(java.math.BigInteger.valueOf(0))>0;fact=fact.divide(d)){
            res = fact.remainder(java.math.BigInteger.valueOf(10));
            if(!res.equals(java.math.BigInteger.valueOf(0))){
                break;
            }
        }
        return res.intValue();
    }
    int lastNon0Digit(int N){
        // Code here
        return nonDigit(N);
    }
}