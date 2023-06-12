//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends






class Solution{
    public int cutRod(int price[], int n) {
        return helper(price,price.length,n);
    }
    int helper(int[]price,int ind,int len){
        int arr[] = new int[len+1];
        // in arr we need 0 element as base case
        // in java every array is initiated with 0 
        // so need to write code for base case
        for(int i=1;i<ind+1;i++){
            for(int j=1;j<len+1;j++){
                // take 
                int take = Integer.MIN_VALUE;
                if(j>=i){
                    take = price[i-1]+arr[j-i];
                }
                // not take
                int ntake = arr[j];
                arr[j] = Math.max(take,ntake);
            }
        }
        return arr[len];
    }
}