//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java



//User function Template for Java



//User function Template for Java

class Solution{
    static int count =0;
    static long merge(long arr[],int l,int r,int mid ){
        long c =0;
        long []left = Arrays.copyOfRange(arr,l,mid+1);
        long []right = Arrays.copyOfRange(arr,mid+1,r+1);
        int i=0;
        int j=0;
        int k = l;
        //System.out.println(Arrays.toString(left)+" "+Arrays.toString(right));
        while(i<left.length&&j<right.length){
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
                c+= mid+1 - (l+i);
            }
        }
        while(i<left.length){
            arr[k++] = left[i++];
        }
        while(j<right.length){
            arr[k++] = right[j++];
        } 
        //System.out.println(count);
        return c;
    }
    static long mergeSort(long arr[],int l,int r){
        long c =0;
        if(l>=r){
           return 0;
        }
        int mid = (r+l)/2;
        c+=mergeSort(arr,l,mid);
        c+=mergeSort(arr,mid+1,r);
        c+=merge(arr,l,r,mid);
        return c;
    }
    static long inversionCount(long arr[], long N){
        // Your Code Here
        long c = mergeSort(arr,0,(int)(N-1));
        //System.out.println(Arrays.toString(arr));
        return c;
    }
}