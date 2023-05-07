//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String stringMirror(String str) {
        // code here
        int j=0;
        char ch = str.charAt(0),ch1;
        String rev= ""+ch;
        
        int len = str.length();
        for( int i = 1; i<len ; i++)
        {
            ch = str.charAt(i);
            ch1 = rev.charAt(j);
            
            if(ch > ch1)
             break;
             
            if(ch == ch1 && ch == str.charAt(0))
            break;
             
            else
            {
                rev = rev + ch;
                j++;
            }
            
        }
        String rev1 = rev;
        StringBuilder sb = new StringBuilder(rev1);
        sb.reverse();  
        sb.toString(); 
        
        return rev = rev + sb;

    }
}


        
