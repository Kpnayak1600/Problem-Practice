//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countTriplet(int arr[], int n) {
        // code here
        Arrays.sort(arr);
        int count =0;
        for(int i=n-1;i>=2;i--){
            count += find(arr,0,i-1,arr[i]);
        }
        return count;
    }
    int find(int arr[],int i,int j,int sum){
        int count=0;
        while(i<j){
            int s=arr[i]+arr[j];
            if(sum==s){
                count+=1;
                i++;
                j--;
            }else if(sum<s){
                j--;
            }else{
                i++;
            }
        }
        return count;
    }
}