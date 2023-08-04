//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    public static int smallestSubWithSum(int arr[], int n, int s) {
        // Your code goes here 
        int i=0;
        int j=0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(j<n){
            if(arr[j]>s){
                return 1;
            }
            sum+= arr[j];
            while(i<j && sum>s){
                res = Math.min(res,j-i+1);
                //System.out.println(res+" "+sum);
                sum-=arr[i++];
            }
            j++;
        }
        return res!=Integer.MAX_VALUE?res:0;
    }
}

