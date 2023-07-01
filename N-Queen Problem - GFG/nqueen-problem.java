//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        Set<ArrayList<Integer>> res = new TreeSet<>(new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer>a,ArrayList<Integer>b){
                for(int i=0;i<a.size();i++){
                    if(a.get(i)!=b.get(i)){
                        return a.get(i)-b.get(i);
                    }
                }
                return 0;
            }
        });
        int[][] grid = new int[n][n];
        nQueenHelper(res,grid,0);
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        for(ArrayList<Integer>i:res){
            ans.add(new ArrayList<>(i));
        }
        return ans;
    }
    static void nQueenHelper(Set<ArrayList<Integer>>res,int[][] grid,int col){
        if(col==grid[0].length){
            res.add(possibleSolution(grid));
            return ;
        }
        for(int row=0;row<grid.length;row++){
            if(isValid(row,col,grid)){
                grid[row][col] = 1;
                nQueenHelper(res,grid,col+1);
                grid[row][col] = 0;
            }
        }
    }
    static boolean isValid(int row,int col,int grid[][]){
        int i=row;
        int j=col;
        while(i>=0&&j>=0){
            if(grid[i--][j--]==1){
                return false;
            }
        }
        j=col;
        while(j>=0){
            if(grid[row][j--]==1){
                return false;
            }
        }
        i=row;
        j=col;
        while(i<grid.length && j>=0){
            if(grid[i++][j--]==1){
                return false;
            }
        }
         return true;
    }
    static ArrayList<Integer> possibleSolution(int[][]grid){
        ArrayList<Integer> rs = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    rs.add(j+1);
                }
            }
        }
        return rs;
    }
}