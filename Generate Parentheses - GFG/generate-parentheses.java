//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<String> AllParenthesis(int n) 
    {
      List<String> res = new ArrayList<>();
       Helper(n,0,0,res,"");
        return res;
    }
    void Helper(int n,int open,int close,List<String>res,String temp){
        if(open==n+1){
            return;
        }
        if(close==n){
            res.add(temp);
            return;
        }
        Helper(n,open+1,close,res,temp+"(");
        if(open>close){
            Helper(n,open,close+1,res,temp+")");
        }
    }
}