//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        Map<Character,Integer>mp = new HashMap<>();
        int i=0;
        int j=0;
        int res = -1;
        while(j<s.length()){
            char c = s.charAt(j);
            mp.put(c,mp.getOrDefault(c,0)+1);
            while(mp.size()>k){
                char x = s.charAt(i);
                mp.put(x,mp.get(x)-1);
                if(mp.get(x)==0){
                    mp.remove(x);   
                }
                i++;
            }
            if(mp.size()==k){
                res = Math.max(res,j-i+1);
            }
            j++;
        }
        return res;
    }
}