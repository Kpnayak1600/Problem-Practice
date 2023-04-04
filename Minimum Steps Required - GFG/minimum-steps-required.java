//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String str = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.minSteps(str));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    int minSteps(String str) {
        //Write your code here
        int count=0;
        int c2=0;
        boolean ele=false;
        boolean tmp=false;
        for(int i=0;i<str.length();i++){
            if(ele==false&&str.charAt(i)=='a'){
            count++;
            ele=true;
            tmp=false;
            }
            else if(tmp==false&&str.charAt(i)=='b'){
            c2++;
            ele=false;
            tmp=true;
            }
        }
            return (Math.min(count,c2)+1);
    
        }
    
}