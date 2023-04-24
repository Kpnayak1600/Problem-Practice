//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] nums ,int n) 
    {
        //Your code here
        long count=0;
        Map<Long,Integer> s = new HashMap<>();
        long presum=0;
        for(int i=0;i<nums.length;i++){
            presum+=nums[i];
            if(presum==0){
                count++;
            }
            if(s.containsKey(presum)){
                 count += s.get(presum-0);
            }
            s.put(presum,s.getOrDefault(presum,0)+1);
        }
        return count;
    }
}