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







class Solution {
    static int index;
    public static Node buildTree(int in [], int pre[], int n) {
      index = 0;
      Node root = sub(pre,in, 0, n - 1); 
      return root;
  }
  static Node sub(int pre[],int in[], int s, int e) {
      if(index == pre .length ||s > e) return null;
      Node root = new Node(pre[index++]);
      int ind = 0;
      for(int i=s;i<in.length;i++){
          if(in[i]==root.data){
              ind=i;
              break;
          }
      }
      root.left = sub(pre,in, s, ind- 1);
      root.right = sub(pre,in, ind+ 1, e);
      return root;
  }
}

