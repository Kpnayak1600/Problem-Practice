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
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean[]prev = new boolean[sum+1];
        prev[0] = true;
        for(int i=1;i<N+1;i++){
            boolean[]cur = new boolean[sum+1];
            cur[0]=true;
            for(int j=1;j<sum+1;j++){
                // logic of recursion
                // take
                boolean take=false;
                if(j>=arr[i-1]){
                    take = prev[j-arr[i-1]]; 
                }
                // ntake
                boolean ntake = prev[j];
                cur[j] = take||ntake;
            }
            prev = cur;
        }
        return prev[sum];
    }
}