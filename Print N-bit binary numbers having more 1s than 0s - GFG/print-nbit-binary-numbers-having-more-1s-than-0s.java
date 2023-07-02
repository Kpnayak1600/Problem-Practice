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
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        Helper(res,"",0,0,N);
        return res;
    }
    void Helper(ArrayList<String> res,String temp,int countOne,int countZero,int n){
        if(countOne+countZero==n){
            res.add(temp);
            return;
        }
        Helper(res,temp+"1",countOne+1,countZero,n);
        if(countOne>countZero){
            Helper(res,temp+"0",countOne,countZero+1,n);
        }
    }
}