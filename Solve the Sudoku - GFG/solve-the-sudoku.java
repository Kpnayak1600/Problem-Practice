//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isValid(int grid[][],int row ,int col,int x){
        for(int i=0;i<grid.length;i++){
            if(grid[row][i]==x || grid[i][col]==x){
                return false;
            }
        }
        int sq = (int)Math.sqrt(grid.length);
        int rs = row - row%sq;
        int cs = col - col%sq;
        for(int r = 0;r<sq;r++){
            for(int c = 0;c<sq;c++){
                if(grid[r+rs][c+cs]==x){
                    return false;
                }
            }
        }
        return true;
    }
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][]){
        // add your code here
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    for(int k=1;k<=grid.length;k++){
                        if(isValid(grid,i,j,k)){
                            grid[i][j] = k;
                            if(SolveSudoku(grid)){
                                return true;
                            }
                            grid[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][]){
        // add your code here
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
        }
    }
}