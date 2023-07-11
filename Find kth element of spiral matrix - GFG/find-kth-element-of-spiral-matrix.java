//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
        if(k > n*m){
            return -1;
        }
        
    // Your code here
   
    //to count for elements
    int count = 0;
    
    //rs - row start, cs - column start, re = row end, ce = column end
    int rs = 0, cs = 0, re = n-1, ce = m-1;
       
   //a loop to iterate over all the elements in the matrix in spiral format
    while(count<n*m){
        //iterating the first row
        for(int i = cs; i<=ce; i++){
            count++;
            if(count == k){
                return A[rs][i];
            }
        }
        rs++;
        
        //iterating the last column
        for(int i = rs; i<=re; i++){
            count++;
            if(count == k){
                return A[i][ce];
            }
        }
        ce--;
        
        //iterating the last row
        for(int i = ce; i>=cs; i--){
            count++;
            if(count == k){
                return A[re][i];
            }
        }
        re--;
           
       //iterating the first column
        for(int i = re; i>=rs; i--){
            count++;
            if(count == k){
                return A[i][cs];
            }
        }
        cs++;
    }
    
    return -1;
    }
}
 
   