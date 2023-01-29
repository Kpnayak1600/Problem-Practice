//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    void solve(ArrayList<String>res,int N,int one,int zero,String temp){
        if(N==0){
            res.add(temp);
            return;
        }
        //take one
        temp +="1";
        solve(res,N-1,one+1,zero,temp);
        // not take one
        temp = temp.substring(0,temp.length()-1);
        if(one>zero){
            // take zero
            temp +="0";
            solve(res,N-1,one,zero+1,temp);
            // not take zero
            temp = temp.substring(0,temp.length()-1);
        }
        return;
    }
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        String temp = "";
        solve(res,N,0,0,temp);
        return res;
    }
}