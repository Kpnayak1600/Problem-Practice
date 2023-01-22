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
            System.out.println(ob.isPrime(N));
        }
    }
}
// } Driver Code Ends


class Solution{
    static int check(int n,int i){
        if(n==1){
            return 0;
        }
        if(i>Math.sqrt(n)){
            return 1;
        }
        return n%i!=0 ? check(n,i+1):0;
    }
    static int isPrime(int N){
        // code here
        return check(N,2);
    }
}