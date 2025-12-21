import java.util.*;
/**
 * Q. Implement Preorder Traversal of a Binary Tree
 *
 * Approach:
 * 1. Build the binary tree using inorder input with -1 as null.
 * 2. Traverse the tree in preorder (Left -> Root  -> Right).
 */

public class Inorder {
    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Binary Tree construction
    static class BinaryTree {
        static int ind = -1;

        public static Node buildTree(int[] nodes) {
            ind++;
            if (nodes[ind] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[ind]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // Preorder traversal: Root -> Left -> Right
    static void preorderTraversal(Node root) {
        if (root == null) return;

        preorderTraversal(root.left);
        System.out.print(root.data + " ");
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] nodes =
            {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        Node root = BinaryTree.buildTree(nodes);
        preorderTraversal(root);
    }
}
