//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends






// User function Template for Java

class Solution {
    
   
    public long count(int S[], int m, int n) {
        // code here.
        long t[][]= new long[m+1][n+1];
        
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j]=1;
                }
               
            }
        }
        for(int p=1;p<m+1;p++){
            for(int q=1;q<n+1;q++){
                if(S[p-1]<=q){
                    t[p][q]=((t[p][q-S[p-1]])+(t[p-1][q]));
                }
                else{
                    t[p][q]=t[p-1][q];
                }    
            }
        }
        return t[m][n];
    }
}