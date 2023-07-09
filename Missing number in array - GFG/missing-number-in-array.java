//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(array, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int missingNumber(int nums[], int x) {
        // Your Code Here
        int n = nums.length;
        // for(int i=0;i<n;i++){
        //     while(arr[i]<n && arr[i]!=arr[arr[i]-1]){
        //       int temp = arr[i];
        //       arr[i]=arr[temp-1];
        //       arr[temp-1] = temp;
        //     }
        // }
        int i=0;
        while(i<nums.length){
            if(nums[i]<n&&nums[i]!=nums[nums[i]-1]){
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }else{
                i++;
            }
        }
        for(i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return x;
    }
}