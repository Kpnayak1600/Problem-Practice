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



//User function Template for Java



//User function Template for Java



//User function Template for Java

class Solution {
    //Function to find minimum number of pages.
    static boolean isValid(int mid,int[] Arr,int M){
                 int student = 1;

        int sum =0;

        for(int i=0; i< Arr.length ; i++){
            if(Arr[i]>mid)return false;
            sum += Arr[i];
            if(sum>mid){
                student++;
                sum = Arr[i];
            }

        }

        if(student > M) return false;

        return true;
    }
    public static int findPages(int[]A,int N,int M){
        //Your code here
        if(M>N){
            return -1;
        }
        int j =10000000;
        int i =0;
        //int min = Integer.MAX_VALUE;
        // for(int k=0;k<N;k++){
        //     //min = Math.min(min,A[i]);
        //     j += A[k];
        // }
        int mid =0;
        int res = 0;
        while(i<=j){
            mid = i+(j-i)/2;
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