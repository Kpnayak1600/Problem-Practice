//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int startNum(int N){
        int x = N-1;
        int res = (x*(x+1))/2;
        return res+1;
    }
    static long product(int N,int res){
        if(N==0){
            return 1;
        }
        return res*product(N-1,res+1);
    }
    static long sequence(int N){
        // code here
        if(N==1){
            return 1;
        }
        return sequence(N-1)+product(N,startNum(N));
    }
}