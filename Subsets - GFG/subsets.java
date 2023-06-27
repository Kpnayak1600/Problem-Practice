//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    ArrayList<Integer> A = new ArrayList<Integer>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        A.add(arr[i]);
		        
		    }
		   
		   
		    
		    ArrayList <ArrayList<Integer>> res = new Solution().subsets(A);
		    for (int i = 0; i < res.size (); i++)
		    {
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		          System.out.print(res.get(i).get(j)+" ");
		        }
		        System.out.println();
		      
		    }
		    //System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A){
        //code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        subsetsHelper(A,res,temp,0);
        Collections.sort(res,new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer>a,ArrayList<Integer>b){
                for(int i=0;i<a.size()&&i<b.size();i++){
                    if(a.get(i)!=b.get(i)){
                        return a.get(i)-b.get(i);
                    }
                }
                return a.size()-b.size();
            }    
        });
        return res;
    }
    static void subsetsHelper(ArrayList<Integer>A,ArrayList<ArrayList<Integer>> res,ArrayList<Integer>temp,int i){
        if(i>A.size()-1){
            res.add(new ArrayList<>(temp));
            temp = new ArrayList<>();
            return;
        }
        // take 
        temp.add(A.get(i));
        subsetsHelper(A,res,temp,i+1);
        temp.remove(temp.size()-1);
        // not take
        subsetsHelper(A,res,temp,i+1);
    }
}