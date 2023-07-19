//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int findSubArraySum(int nums[], int n, int k){
        // code here
        Map<Integer,Integer> mp = new HashMap<>();
        int presum = 0;
        int res = 0;
        for(int i=0;i<n;i++){
            presum+=nums[i];
            if(presum==k){
                res++;
            }
            if(mp.containsKey(presum-k)){
                res+=mp.get(presum-k);
            }
            mp.put(presum,mp.getOrDefault(presum,0)+1);
        }
        return res;
    }
}