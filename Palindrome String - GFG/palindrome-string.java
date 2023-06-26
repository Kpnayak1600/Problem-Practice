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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        // code here
        return isPalindromeHelper(S,0,S.length()-1);
    }
    int isPalindromeHelper(String s ,int i,int j){
        if(i>j){
            return 1;
        }
        if(s.charAt(i)!=s.charAt(j)){
            return 0;
        }
        return isPalindromeHelper(s,i+1,j-1);
    }
};