//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        // code here
        int j=0;
        while(j<s.length()-1){
            if(s.charAt(j)==s.charAt(j+1)){
                String l = s.substring(0,j);
                String r = s.substring(j+2);
                s = l+r;
                //System.out.println(s);
                if(s.equals("")){
                    return "-1";
                }
                j=-1;
            }
            j++;
        }
        return s;
    }
}
        
