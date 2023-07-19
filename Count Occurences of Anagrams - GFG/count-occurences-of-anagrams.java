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
        int nt = txt.length();
        int pt = pat.length();
        int arr[] = new int[26];
        for(int i=0;i<pt;i++){
            arr[pat.charAt(i)-'a']++;
        }
        ///System.out.println(Arrays.toString(arr));
        int temp = pt;
        int i=0;
        int j=0;
        int res = 0;
        while(j<nt){
            char c = txt.charAt(j);
            if(pat.contains(c+"")){
                arr[c-'a']--;
                temp = arr[c-'a']>=0?temp-1:temp;
                //System.out.println(arr[c-'a'] +" "+temp);
            }
            if(j-i+1 == pt){
                if(temp==0){
                    res++;
                }
                if(pat.contains(txt.charAt(i)+"")){
                    arr[txt.charAt(i)-'a']++;
                    if(arr[txt.charAt(i)-'a']>=1){
                        temp++;
                    }
                }
                i++;
            }
            j++;
        }
        //System.out.println(temp);
        return res;
    }
}