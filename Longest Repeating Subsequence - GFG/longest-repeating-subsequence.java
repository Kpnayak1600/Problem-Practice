//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int LongestRepeatingSubsequence(String str){
       // we always prev array for each row so size
        // of prev array must be the size of row
        // here i hv taken length of string text 2 as size of row
        int prev[] = new int[str.length()+1];
        // for prev array as a base case we need to fill
        // 0 in the array but since in java all array
        // is by default initialised by 0 so no need
        // to fill again
        for(int i=1;i<str.length()+1;i++){
            // we always prev array for each row so size
            // of prev array must be the size of row
            // here i hv taken length of string text 2 as size of row
            int cur[] = new int[str.length()+1];
            // for prev array as a base case we need to fill
            // 0 in the array but since in java all array
            // is by default initialised by 0 so no need
            // to fill again
            for(int j=1;j<str.length()+1;j++){
                // matched
                if(i!=j && str.charAt(i-1)==str.charAt(j-1)){
                    cur[j] = 1+prev[j-1];
                }else{
                    //not matched
                    cur[j] = Math.max(prev[j],cur[j-1]);
                }
            }
            prev = cur;
        }
        return prev[str.length()];
    }
}