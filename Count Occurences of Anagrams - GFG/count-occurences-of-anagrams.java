//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(String pat, String txt) {
        // code here
        int i=0,j=0;
        int np = pat.length();
        int nt = txt.length();
        Map<Character,Integer> mp = new HashMap<>();
        for(int k=0;k<np;k++){
            mp.put(pat.charAt(k),mp.getOrDefault(pat.charAt(k),0)+1);
        }
        int count = mp.size();
        int res = 0;
        while(j<nt){
            if(mp.containsKey(txt.charAt(j))){
                mp.put(txt.charAt(j),mp.get(txt.charAt(j))-1);
                if(mp.get(txt.charAt(j))==0){
                    count--;
                }
            }
            if(j-i+1 < np){
                j++;
            }else if(j-i+1 == np){
                if(count ==0){
                    res++;
                }
                if(mp.containsKey(txt.charAt(i))){
                    mp.put(txt.charAt(i),mp.get(txt.charAt(i))+1);
                    if(mp.get(txt.charAt(i))==1){
                        count++;
                    }
                }
                i++;j++;
            }
        }
        return res;
    }
}