//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution{
    static int index; 
    public static Node buildTree(int inorder[], int preorder[], int n){
        // code here 
        index=0;
        return helper(inorder,preorder,0,n-1);
    }
    static Node helper(int[]inorder,int[]preorder,int is,int ie){
        if(is>ie){
            return null;
        }
        Node root = new Node(preorder[index++]);
        int ind = 0;
        for(int i=is;i<=ie;i++){
            if(inorder[i]==root.data){
                ind = i;
                break;
            }
        }
        // go left
        root.left = helper(inorder,preorder,is,ind-1);
        // go right
        root.right = helper(inorder,preorder,ind+1,ie);
        return root;
    }
}
