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
    int count(int[] arr, int n, int x) {
        int f=firstOccur(arr,n,x);
        int l=lastOccur(arr,n,x);
        return f==-1?0:l-f+1;
    }
    int firstOccur(int[]arr,int n,int x){
        int res = -1;
        int i=0;int j=n-1;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]==x){
                res = mid;
                j=mid-1;
            }else if(arr[mid]>x){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return res;
    }
    int lastOccur(int[]arr,int n,int x){
        int res = -1;
        int i=0;int j=n-1;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]==x){
                res = mid;
                i=mid+1;
            }else if(arr[mid]>x){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return res;
    }
}