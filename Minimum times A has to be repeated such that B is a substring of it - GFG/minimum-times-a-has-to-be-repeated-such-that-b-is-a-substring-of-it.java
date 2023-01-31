//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A,B));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        // code here
        int lenA = A.length();
        int lenB = B.length();
        //System.out.println(lenA+" "+lenB);
        boolean flag = true;
        for(int i=0;i<lenA;i++){
            if(A.charAt(i)!=B.charAt(i)){
                flag = false;
                break;
            }
        }
        int m = lenB/lenA;
        int rep =0;
        if(lenB%lenA == 0 && flag ){
            rep = m;
        }else if(m==0){
            rep = m+2;
        }else{
            rep = m+1;
        }
        String temp = "";
        for(int i=1;i<=rep;i++){
            temp+=A;
        }
        int count =0;
        if(temp.contains(B)){
            return rep;
        }
        return -1;
    }
};