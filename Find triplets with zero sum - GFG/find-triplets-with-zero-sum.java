//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n){
        //add code here.
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
           int sum = 0-arr[i];
           if(isPair(arr,i+1,n-1,sum)){
               return true;
           }
        }
        return false;
    }
    boolean isPair(int []arr,int i,int j,int sum){
        while(i<j){
            if(arr[i]+arr[j] == sum){
                return true;
            }else if(arr[i]+arr[j]>sum){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}