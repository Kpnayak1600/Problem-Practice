//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean isPalindrome(String s ,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;        
    }
    static void solve(ArrayList<ArrayList<String>>res,Deque<String>dq,String s,int i,int j){
        if(i>=j){
            res.add(new ArrayList<>(dq));
            return ;
        }
        for(int k=i;k<j;k++){
            if(isPalindrome(s,i,k)){
                dq.addLast(s.substring(i,k+1));
                solve(res,dq,s,k+1,j);
                dq.removeLast();
            }
        }
        return ;
    }
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        Deque<String> dq = new LinkedList<>();
        solve(res,dq,S,0,S.length());
        return res;
    }
};