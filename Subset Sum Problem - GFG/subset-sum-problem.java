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



//User function Template for Java



//User function Template for Java



//User function Template for Java

class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean dp[][]= new boolean[N+1][sum+1];
        for(int i=0;i<N+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    dp[i][j]=false;
                }
                if(j==0){
                    dp[i][j]=true;
                }
                if(i>0&&j>0){
                    //take
                    boolean take = false;
                    if(j>=arr[i-1]){
                        take = dp[i-1][j-arr[i-1]];
                    }
                    // not take
                    boolean ntake = dp[i-1][j];
                    dp[i][j] = take||ntake;
                }
            }
        }
        return dp[N][sum];
    }
}