//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.fingerCount(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int fingerCount(int N){
        // code here
        if(N% 8 == 1){ 
            return 1; 
        }else if(N%8 == 2){ 
            return 2; 
            
        }else if(N%8 == 3 || N%8 == 7){ 
            return 3; 
            
        }else if(N%8 == 4 || N%8 == 6){ 
            return 4; 
            
        }else if(N%8 == 5){ 
            return 5; 
            
        }else {
            return 2; 
            
        }
    }
}