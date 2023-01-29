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
    static class Mycomparator implements Comparator<ArrayList<Integer>>{
        public int compare(ArrayList<Integer> p,ArrayList<Integer> q){   
            int oneSize = p.size();
            int twoSize = q.size();
            for(int i = 0; i < Math.min(oneSize,twoSize); i++){
                if(i == oneSize || i == twoSize)
                    return oneSize - twoSize;
                int elementOne = p.get(i);
                int elementTwo = q.get(i);
                if(elementOne == elementTwo)
                   continue;
                return Integer.compare(elementOne, elementTwo);
            }
            return p.size()-q.size();
        }
    }
    static void solve(ArrayList<Integer> A,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> ds,int i){
        if(i==A.size()){
            res.add(new ArrayList<>(ds));
            return;
        }
        //take
        ds.add(A.get(i));
        solve(A,res,ds,i+1);
        ds.remove(ds.size()-1);
        //not take
        solve(A,res,ds,i+1);
        return;
    }
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A){
        //code here
        ArrayList<ArrayList<Integer>>res = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        solve(A,res,ds,0);
        Collections.sort(res,new Mycomparator());
        return res;
    }
}