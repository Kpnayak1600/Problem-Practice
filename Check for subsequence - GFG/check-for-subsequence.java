//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            
            String a = sc.next();
            String b = sc.next();
            Solution ob = new Solution();
            if(ob.isSubSequence(a,b))
            System.out.println(1);
            else
            System.out.println(0);
 		
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    boolean isSubSequence(String A, String B){
        return helper(A,B,0,0);
    }
    boolean helper(String A,String B,int i,int j){
        if(A.length()==j){
            return true;
        }
        if(B.length()==i){
            return false;
        }
        if(A.charAt(j)==B.charAt(i)){
            j+=1;
        }
        return helper(A,B,i+1,j);
    }
}