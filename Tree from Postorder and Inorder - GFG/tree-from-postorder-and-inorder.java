//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends



/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/

class GfG{
    int index;
    Node buildTree(int in[], int post[], int n) {
        index = n-1;
        return helper(in,post,0,n-1);
    }
    Node helper(int[]inorder,int[]postorder,int is,int ie){
        if(is>ie){
            return null;
        }
        Node root = new Node(postorder[index--]);
        int ind = 0;
        for(int i=is;i<=ie;i++){
            if(inorder[i]==root.data){
                ind = i;
                break;
            }
        }
        // go right
        root.right = helper(inorder,postorder,ind+1,ie);
        // go left
        root.left = helper(inorder,postorder,is,ind-1);
        return root;
    }
}