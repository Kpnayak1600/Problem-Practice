//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMin(int arr[], int n){
        //complete the function here
        int i=0;
        int j=n-1;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]<arr[(mid+1)%n] && arr[mid]<arr[(mid+n-1)%n]){
                return arr[mid];
            }else if(arr[mid]<arr[n-1]){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return 0;
    }
}
