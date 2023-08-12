//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int ans=0;
        for(int i:a){
            Integer ceil = map.ceilingKey(i);
            if(ceil==null) map.put(i, map.size()+1 );
            // if(ceil==i)    //eat 5 star do nothing
            else if(i<ceil){
                //bcz merko ceil ki value chote se chote rkne h
                //ceil choti kr de
                map.put(i,map.get(ceil));
                map.remove(ceil);
            }
            // System.out.println(ceil+" "+map);
            ans=Math.max(map.get(i),ans);
        }
        return ans;
    }
} 