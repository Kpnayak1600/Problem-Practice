//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int isPossible(int w,int l,int W,int L){
        int fold =0;
        while(w>W){
            fold++;
            w/=2;
        }
        while(l>L){
            fold++;
            l/=2;
        }
      //  System.out.println(fold);
        return fold;
    }
    int carpetBox(int a, int b, int c, int d) { 
        //code here
        return Math.min(isPossible(a,b,c,d),isPossible(a,b,d,c));           
    }
}
