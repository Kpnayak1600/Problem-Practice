//{ Driver Code Starts
//Initial Template for Java



//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution{
    long countTriplets(long arr[], int n,int sum){
        long count =0;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            count += find(i+1,n,arr,sum-arr[i]);
        }
        return count;
    }
    long find(int i,int j,long []arr,long x){
        j=j-1;
        int res = 0;
        while(i<j){
            long sum = arr[i]+arr[j];
            if(sum<x){
                res+=j-i; // if arr[i]+arr[j] is less then x => arr[i] + sum of each 
                          // number from i to j will be less then x
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int k =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
//            String line2 = br.readLine();
//            String[] a2 = line2.trim().split("\\s+");
//            long b[] = new long[m];
//            for (int i = 0; i < m; i++) {
//                b[i] = Long.parseLong(a2[i]);
//            }
            Solution ob = new Solution();
            long ans=ob.countTriplets(a,n,k);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends