//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int test = Integer.parseInt(in.readLine().trim());
        while(test-- > 0){
            int n = Integer.parseInt(in.readLine().trim());
            int m = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int [] seats = new int[m];
            for(int i = 0; i < m; i++){
                seats[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            boolean res = obj.is_possible_to_get_seats(n, m, seats);
            
            String _result_val = (res) ? "Yes" : "No";
            out.println(_result_val);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        // code here
        if(m==1&&n==1&&seats[0]==0){
            return true;
        }
        int count=0;
        if(m>1&&seats[0]==0&&seats[1]!=1){
            count++;
            seats[0]=1;
        }
        if( m>2&&seats[m-1]==0&&seats[m-2]!=1){
            count++;
            seats[m-1]=1;
        }
        for(int i=1;i<m-1;i++){
            if(seats[i]==0&&seats[i-1]!=1&&seats[i+1]!=1){
                seats[i]=1;
                count++;
            }
        }
        return count>=n;
    }
}
        
