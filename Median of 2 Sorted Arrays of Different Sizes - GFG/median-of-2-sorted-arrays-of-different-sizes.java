//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int nums1[], int nums2[]) 
    {
        // Your Code Here
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        n1 = nums1.length;
        n2 = nums2.length;
        int medPos = (n1+n2+1)/2;
        int start = 0;
        int end = n1;
        while(start<=end){
            int l1 = start+(end-start)/2;
            int l2 = medPos - l1;
            int max1 = l1==0?Integer.MIN_VALUE:nums1[l1-1];
            int min1 = l1==n1?Integer.MAX_VALUE:nums1[l1];
            int max2 = l2==0?Integer.MIN_VALUE:nums2[l2-1];
            int min2 = l2==n2?Integer.MAX_VALUE:nums2[l2];
            if(max1<=min2 && max2<=min1){
                if((n1+n2)%2==0){
                    return (Math.max(max1,max2)+Math.min(min1,min2))/2.0;
                }else{
                    return Math.max(max1,max2);
                }
            }else if(max1>min2){
                end = l1-1;
            }else {
                start = l1+1;
            }
        }
        return -1;
    }
}