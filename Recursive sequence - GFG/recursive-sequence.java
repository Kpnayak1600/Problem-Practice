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
    static long sequence(int N){   
        // code here
        int count = 1;
        long temp = 1;
        long res = 0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                temp *= count;
                //System.out.print(count+" * ");
                count++;
            }
            res += temp;
            //System.out.println(" = "+temp);
            //System.out.print(" + ");
            //System.out.println(res);
            temp =1;
        }
        return res;
    }
}