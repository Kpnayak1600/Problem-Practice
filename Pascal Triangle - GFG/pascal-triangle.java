//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        // List<ArrayList<Long>>a =new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     ArrayList<Long> r = new ArrayList<>();
        //     for(int j=0;j<=i;j++){
        //         if(i<2 || j==i || j==0){
        //             r.add((long)1);
        //             continue;
        //         }
        //         r.add((a.get(i-1).get(j-1)+a.get(i-1).get(j))%1000000007);
        //     }
        //     a.add(new ArrayList<Long>(r));
            
        List<ArrayList<Long>>a =new ArrayList<>();
        ArrayList<Long> prev = null;
        for(int i=0;i<n;i++){
            ArrayList<Long> curr = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(i<2 || j==i || j==0){
                    curr.add((long)1);
                    continue;
                }
                curr.add((prev.get(j-1)+prev.get(j))%1000000007);
            }
            a.add(new ArrayList<Long>(curr));
            prev = curr;
            //System.out.println(prev);
        }
        //System.out.println(a);
        return a.get(n-1);
    }
}