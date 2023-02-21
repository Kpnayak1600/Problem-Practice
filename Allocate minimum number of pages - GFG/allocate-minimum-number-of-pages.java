//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    //Function to find minimum number of pages.
    static boolean isValid(int mid,int[] A,int M){
        // int st=1;
        // int sum =A[0];
        // for(int i=1;i<A.length;i++){
        //     if(sum>mid){
        //         st++;
        //         sum=A[i];
        //     }else{
        //         sum+=A[i];
        //     }
        // }
        int req =1;
        int sum =0;
        for(int i=0;i<A.length;i++){
            if(sum+A[i]>mid){
                req++;
                sum=A[i];
            }else{
                sum+=A[i];
            }
        }
        return req<=M;
    }
    public static int findPages(int[]A,int N,int M){
        //Your code here
        if(M>N){
            return -1;
        }
        int sum =0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            max = Math.max(max,A[i]);
            sum += A[i];
        }
        int i=max;
        int j=sum;
        int res = -1;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(isValid(mid,A,M)){
                res = mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return res;
    }
};