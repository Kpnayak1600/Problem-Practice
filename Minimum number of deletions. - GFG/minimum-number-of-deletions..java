// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution { 
    int minDeletions(String S, int x){
        // Reversing string S using StringBuilder default method
        StringBuilder S1 = new StringBuilder(S);
        S1.reverse(); // reverse StringBuilder input1
        int t[][]=new int[x+1][x+1];
        for(int i=0;i<x+1;i++){
            for(int j=0;j<x+1;j++){
                if(i==0||j==0){
                    t[i][j]=0;
                }
                else if(S.charAt(i-1)==S1.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }
                else{
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return x-t[x][x];
    
        
    }
} 