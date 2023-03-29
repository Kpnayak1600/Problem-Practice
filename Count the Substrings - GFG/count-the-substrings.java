//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countSubstring(String S) 
    { 
        if(S.length() == 1){
            return 0;
        }
        
        
        int[][] dp = new int[S.length()][S.length()];
        
        int count = 0;
        for(int g = 0; g < S.length(); g++){
            for(int i = 0, j = g; j < S.length(); i++, j++){
                if(g == 0){
                    dp[i][j] = Character.isUpperCase(S.charAt(i)) == true? 0: 1; 
                } else{
                    boolean lc = Character.isLowerCase(S.charAt(j));
                    if(lc){
                        dp[i][j] = dp[i][j - 1] + 1;
                    } else{
                        dp[i][j] = dp[i][j - 1];
                    }
                }
                
                if(dp[i][j] != 0 && (j - i + 1) == (2 * dp[i][j])){
                    count++;
                }
            }
        }
        
        return count;
    }
}


