package p1991;

import java.util.Arrays;
import java.util.Scanner;

public class p1991 {

    public static void main(String[] args) {

        //전위 순회(preorder traversal) : root -> left -> right
        //중위 순회(inorder traversal) : left -> root -> right
        //후위 순회(postorder traversal) : left -> right -> root

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[][] tree = new String[N][3];

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<3; j++)
            {
                String node = sc.next();

                tree[i][j] = node;
            }
        }

        preorderPrint(tree);
        inorderPrint(tree);
        postorderPrint(tree);
    }

    static void preorderPrint(String[][] tree)
    {
        System.out.print(tree[0][0]);

        leftTraversal(tree);

        rightTraversal(tree);

        System.out.println();
    }

    static void inorderPrint(String[][] tree)
    {
        leftTraversal(tree);

        System.out.print(tree[0][0]);

        rightTraversal(tree);

        System.out.println();
    }

    static void postorderPrint(String[][] tree)
    {

        leftTraversal(tree);

        rightTraversal(tree);

        System.out.print(tree[0][0]);

        System.out.println();
    }

    static void leftTraversal(String[][] tree)
    {
        for(int i=0; i<tree.length; i++)
        {
            if(tree[i][0].equals(tree[0][1]))
            {
                inorderPrint(Arrays.copyOfRange(tree, i, tree.length));
                break;
            }
//            else if(i == tree.length-1)
//            {
//                System.out.print(tree[0][0]);
//            }
        }
    }

    static void rightTraversal(String[][] tree)
    {
        for(int i=0; i<tree.length; i++)
        {
            if(tree[i][0].equals(tree[0][2]))
            {
                inorderPrint(Arrays.copyOfRange(tree, i, tree.length));
                break;
            }
//            else if(i == tree.length-1)
//            {
//                System.out.print(tree[0][0]);
//            }
        }
    }
}
