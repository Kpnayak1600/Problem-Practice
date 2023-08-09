//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends




// User function Template for Java
class Solution {
    static boolean isValid(int mid ,int []stalls,int k){
        int cows = 1;
        int lastPos = stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastPos>=mid){
                cows++;
                lastPos = stalls[i];
            }
        }
        return cows>=k;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int i=0;
        int j=stalls[n-1]-stalls[0];
        //System.out.println(Arrays.toString(stalls)+" "+i+" "+j);
        for(int r=1;r<stalls.length;r++){
            i = Math.min(i,stalls[r]-stalls[r-1]);
        }
        int res = 0;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(isValid(mid,stalls,k)){
                res = mid;
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return res;
    }
}