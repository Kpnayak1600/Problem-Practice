//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.factorial(N));
        }
    }
}
// } Driver Code Ends


class Solution{
    static long factorial(int N){
        // code here
        return factorialHelper(1,N);
    }
    static long factorialHelper(long fact ,int N){
        if(N==0){
            return fact;
        }
        return factorialHelper(fact*N,N-1);
    }
}