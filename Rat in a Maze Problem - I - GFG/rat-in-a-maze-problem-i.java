// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends

class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        findPathHelper(m,n,res,"",0,0);
        return res;
    }
    static void findPathHelper(int[][] m, int N ,ArrayList<String> res, String temp, int i,int j){
        if(i==N || j==N || i<0 || j<0){
            return;
        }
        if(m[i][j]==0){
            return;
        }
        if(i==N-1&&j==N-1){
            res.add(temp);
            return;
        }
        m[i][j] =0; // visited path can be traversed once
        // go up
        findPathHelper(m,N,res,temp+"U",i-1,j);
        // go down
        findPathHelper(m,N,res,temp+"D",i+1,j);
        // go left
        findPathHelper(m,N,res,temp+"L",i,j-1);
        // go right
        findPathHelper(m,N,res,temp+"R",i,j+1);
        m[i][j]=1; 
    }
}