//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        int start =0;
        int end = n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            //System.out.println(start+" "+end+" "+mid+" "+arr[mid]);
            if(arr[mid]<=arr[(mid+1)%n]&&arr[mid]<=arr[(mid+n-1)%n]){
                return mid;
            }else if(arr[mid]<arr[0]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return 0;
    }
}