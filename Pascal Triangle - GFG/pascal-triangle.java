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



// User function Template for Java

class Solution {
    ArrayList<Long> newCol(List<ArrayList<Long>>a,int i,int j,ArrayList<Long>c){
        if(j==i){
            c.add((long)1);
            return c;
        }
        if(j==0){
            c.add((long)1);
        }else{
            c.add((a.get(i-1).get(j-1)+a.get(i-1).get(j))%1000000007);
        }
        newCol(a,i,j+1,c);
        return c;
    }
    List<ArrayList<Long>> reqRow(int n,List<ArrayList<Long>>a,int i){
        if(i==0){
            ArrayList<Long> r = new ArrayList<>();
            r.add((long)1);
            a.add(r);
            i=i+1;
        }
        if(i==n ){
            return a;
        }
        ArrayList<Long> c = new ArrayList<>();
        a.add(newCol(a,i,0,c));
        reqRow(n,a,i+1);
        return a;
    }
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        List<ArrayList<Long>> a = new ArrayList<>();
        ArrayList<Long> curr=null;
        a = reqRow(n,a,0);
        //System.out.println(a);
        return a.get(n-1);
    }
}