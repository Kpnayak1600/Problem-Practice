//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S[] = read.readLine().split(" ");
            
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();

            System.out.println(ob.countCarry(A,B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countCarry(Long A , Long B){
        // code here
        long c = 0;
        int count = 0;
        while(A!=0 && B!=0){
            long sum = c + A%10 + B%10;
            c = sum/10;
            if(c>0){
                count++;
            }
            A/=10;B/=10;
        }
        // while(A!=0){
        //     long sum = c + A%10;
        //     c = sum/10;
        //     if(c>0){
        //         count++;
        //     }
        //     A/=10;
        // }
        // while(B!=0){
        //     long sum = c + B%10;
        //     c = sum/10;
        //     if(c>0){
        //         count++;
        //     }
        //     B/=10;
        // }
        return count;
    }
};