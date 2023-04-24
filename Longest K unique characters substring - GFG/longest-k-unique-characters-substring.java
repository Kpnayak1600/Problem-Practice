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
        int i=0,j=0;
        int res = -1;
        Map<Character,Integer> mp = new HashMap<>();
        while(j<s.length()){
            char c = s.charAt(j);
            mp.put(c,mp.getOrDefault(c,0)+1);
            if(mp.size()<k){
                j++;
            }else if(mp.size() == k){
                res = Math.max(res,j-i+1);
                j++;
            }else if(mp.size()>k){
                while(mp.size()>k){
                    if(mp.containsKey(s.charAt(i))){
                        mp.put(s.charAt(i),mp.get(s.charAt(i))-1);
                    }
                    if(mp.get(s.charAt(i))==0){
                        mp.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return res;
    }
}