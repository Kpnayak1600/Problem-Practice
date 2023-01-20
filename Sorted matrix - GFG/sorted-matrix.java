//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            int v[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < N; j++) v[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            int ans[][] = ob.sortedMatrix(N, v);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int[][] sortedMatrix(int N, int Mat[][]) {
        // code here
        List<Integer> set = new ArrayList<>(N*N);
		
        
        for(int row=0;row<N;row++) {
            for(int col=0;col<N;col++) {
                set.add(Mat[row][col]);
            }
        }
        
        int[] re = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        int idx = 0;
        int[][] result = new int[N][N];
        
          for(int row=0;row<N;row++) {
            for(int col=0;col<N;col++) {
                result[row][col] = re[idx];
                idx++;
            }
        }
        
        return result;
    }
};