//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    int findMaxSum(int arr[], int n) {
        int dp[] = new int[n];
        int prev1 = arr[0];
        int prev2 = 0;
        for(int i=1;i<n;i++){
            // pick 
            int pick = arr[i];
            if(i>1){
                pick += prev2;
            }
            // not pick
            int nPick = prev1;
            prev2 = prev1;
            prev1 = Math.max(pick,nPick);
        }
        return prev1;
    }
}



