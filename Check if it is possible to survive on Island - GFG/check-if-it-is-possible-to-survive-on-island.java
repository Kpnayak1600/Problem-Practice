//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            String arr[] = in.readLine().trim().split("\\s+");
            int S = Integer.parseInt(arr[0]);
            int N = Integer.parseInt(arr[1]);
            int M = Integer.parseInt(arr[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.minimumDays(S, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumDays(int S, int N, int M){
        // code here
        int sunday= S/7;
        int buyingDay = S-sunday;
        int ans =0;
        int total = S*M; // itna food to chhahie use jinda rhne ke //lie
        if(total%N==0)
            ans = total/N;
        else
            ans = total/N +1;
        
          // agar N=1 M=1 S=10  means sunday ko hm nhi buy kr skte to 1 din 
        // km ho gya or 1 din men 1 din ka bojan hi buy kr skte hen to fir to mr jaega vo
       
        if(ans<=buyingDay)   return ans;
        else
        return -1;
    }
}