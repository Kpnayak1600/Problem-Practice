//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    ArrayList<String> permutation(String S){
        // Code Here
        ArrayList<String> res = new ArrayList<>();
        permutationHelper(S,res,"",0);
        return res;
    }
    void permutationHelper(String S,ArrayList<String>res,String temp,int ind){
        if(ind==S.length()){
            res.add(temp);
            return;
        }
        // take char+space
        if(ind != S.length()-1){
            permutationHelper(S,res,temp+S.charAt(ind)+" ",ind+1);
        }
        // take char
        permutationHelper(S,res,temp+S.charAt(ind),ind+1);
    }
}