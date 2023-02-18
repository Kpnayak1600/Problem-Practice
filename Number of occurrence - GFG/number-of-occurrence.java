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
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int lastIndex(int[]arr,int n,int x){
        int start =0;
        int end = n-1;
        int res = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid]==x){
                res = mid;
                start = mid +1;
            }else if(arr[mid]>x){
                end = mid -1;
            }else {
                start = mid +1;
            }
        }
        return res;
    }
    int firstIndex(int[]arr,int n,int x){
        int start =0;
        int end = n-1;
        int res = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid]==x){
                res = mid;
                end = mid-1;
            }else if(arr[mid]>x){
                end = mid -1;
            }else {
                start = mid +1;
            }
        }
        return res;
    }
    int count(int[] arr, int n, int x) {
        // code here
        int l = lastIndex(arr,n,x);
        if(l==-1)
            return 0;
        int f = firstIndex(arr,n,x);
        return l-f+1;
    }
}