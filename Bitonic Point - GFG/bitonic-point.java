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

            int ans = new Solution().findMaximum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int findMaximum(int[] nums, int n) {
        int l=1, r=n-2;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return nums[mid];
            }else if(nums[mid]>nums[mid-1]){
                l=mid+1;
            }else {
                r=mid-1;  
            }
        }            
        return n;
    }
}