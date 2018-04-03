/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorymanagement;

/**
 *
 * @author varsha
 */
import static com.memorymanagement.Utilities.queryMemory;
import java.util.ArrayList;
import java.util.Scanner;


/* Class BSTNode */
class BSTNode {

    BSTNode left, right;
    int data;
    boolean isMemoryOccupied;
    int nodeAddress;

    /* Constructor */
    public BSTNode() {
        left = null;
        right = null;

        data = 0;
    }

    /* Constructor */
    public BSTNode(int n) {
        left = null;
        right = null;
        data = n;
        //isMemoryOccupied = true;
    }

    /* Function to set left node */
    public void setLeft(BSTNode n) {
        left = n;
    }

    /* Function to set right node */
    public void setRight(BSTNode n) {
        right = n;
    }

    /* Function to get left node */
    public BSTNode getLeft() {
        return left;
    }

    /* Function to get right node */
    public BSTNode getRight() {
        return right;
    }

    /* Function to set data to node */
    public void setData(int d) {
        data = d;
    }

    /* Function to get data from node */
    public int getData() {
        return data;
    }
}

/* Class BST */
class BST {

    private BSTNode root;

    /* Constructor */
    public BST() {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    /* Functions to insert data */
 /* public void insert(int data) {
        root = insert(root, data);
    }

    /* Function to insert data recursively 
    private BSTNode insert(BSTNode node, int data) {
        if (node == null) {
            node = new BSTNode(data);
        } else {

            node.left = insert(node.left, data / 2);
            node.right = insert(node.right, data / 2);
        }
        return node;
    }*/
    public void insertNew(BSTNode root, ArrayList<Integer> al, int start, int size) {
        int left = 2 * start + 1;
        int right = 2 * start + 2;

        if (left > size || right > size) {
            return;
        }

        if (root == null) {
            BSTNode node = new BSTNode(al.get(start));
            root = node;
        }

        if (root.left == null && root.right == null) {
            if (left < size) {
                root.left = new BSTNode(al.get(left));
            }

            if (right < size) {
                root.right = new BSTNode(al.get(right));
            }
        }
        insertNew(root.left, al, left, size);
        insertNew(root.right, al, right, size);

    }

    /* Functions to delete data */
 /* public void delete(int k) {
        if (isEmpty()) {
            System.out.println("Tree Empty");
        } else if (search(k) == false) {
            System.out.println("Sorry " + k + " is not present");
        } else {
            root = delete(root, k);
            System.out.println(k + " deleted from the tree");
        }
    }

    private BSTNode delete(BSTNode root, int k) {
        BSTNode p, p2, n;
        if (root.getData() == k) {
            BSTNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null) {
                return null;
            } else if (lt == null) {
                p = rt;
                return p;
            } else if (rt == null) {
                p = lt;
                return p;
            } else {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null) {
                    p = p.getLeft();
                }
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData()) {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        } else {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }*/

 /* Functions to count number of nodes */
 /* public int countNodes() {
        return countNodes(root);
    }

    /* Function to count number of nodes recursively 
    private int countNodes(BSTNode r) {
        if (r == null) {
            return 0;
        } else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }*/

 /* Functions to search for an element */
 /*  public boolean search(int val) {
        return search(root, val);
    }

    /* Function to search for an element recursively 
    private boolean search(BSTNode r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rval = r.getData();
            if (val < rval) {
                r = r.getLeft();
            } else if (val > rval) {
                r = r.getRight();
            } else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }*/

 /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }

    public void inorder(BSTNode r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    /* Function for preorder traversal */
    public void preorder() {
        preorder(root);
    }

    public void preorder(BSTNode r) {
        if (r != null) {
            System.out.print(r.getData() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    /* Function for postorder traversal */
    public void postorder() {
        postorder(root);
    }

    private void postorder(BSTNode r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() + " ");
        }
    }

    public void afterAllocationInOrder(BSTNode r) {
        if (r != null && r.isMemoryOccupied == false) {
            afterAllocationInOrder(r.getLeft());
            System.out.print(r.getData() + " ");
            afterAllocationInOrder(r.getRight());
        }
    }
}

/* Class BinarySearchTree */
public class BTMemoryManagement {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of BST */
        BST bst = new BST();

        System.out.println("Binary Search Tree Test\n");

        ArrayList<Integer> al = new ArrayList<>();

        int t = 0;
        int loc = 1;
        for (int i = 5; i >= 0; i--) {
            for (int j = 1; j <= Math.pow(2, t); j++) {

                al.add((int) Math.pow(2, i));
                loc++;
            }
            t++;
            if (t == 6) {
                break;
            }
        }
        BSTNode Newroot = new BSTNode(al.get(0));
        bst.insertNew(Newroot, al, 0, al.size());

        System.out.print("\nIn order : ");
        bst.inorder(Newroot);
        //for looop to call search
        for (int i = 0; i < 5; i++) {
            int memoryNeeded = queryMemory();
            int memoryAsked = (int) Math.pow(2, memoryNeeded);

            System.out.println("Memory asked is ------" + memoryAsked);
            BSTNode resultNode = search(memoryAsked, Newroot);
        }
        //bst.afterAllocationInOrder(Newroot);
    }

    public static BSTNode search(int memoryDemanded, BSTNode root) {

        //int memoryAsked = (int)Math.pow(2,memoryDemanded);
        BSTNode tempRoot = null;
        if (memoryDemanded == root.data) {
            root.isMemoryOccupied = true;
            root.data -= memoryDemanded;
            //System.out.println("found at location " + root);
            System.out.println("Memory is being allocated");
            return root;
//            if(root.left.isMemoryAvaiable == false && root.right.isMemoryAvaiable==false)
//            {
//                root.isMemoryAvaiable = false;
//            }
            // check to set flag of parent when both children are busy
        } else if (root.left != null && root.left.isMemoryOccupied == false && root.left.data >= memoryDemanded) {
            tempRoot = root;
            System.out.println(tempRoot.data);
            root = search(memoryDemanded, root.left);
            tempRoot.data -= memoryDemanded;
            System.out.println("After sub " + tempRoot.data);
            return tempRoot;
        } else if (root.right != null && root.right.isMemoryOccupied == false && root.right.data >= memoryDemanded) {
            tempRoot = root;
            root = search(memoryDemanded, root.right);
            tempRoot.data -= memoryDemanded;
            System.out.println("After sub " + tempRoot.data);
            return tempRoot;
        }
        return root;
    }

}

// tree done
// level order entry done
//inorder print done
//memory generated done
// random generation done

//-----
//search--
/*1. basic search done
2.calculation of remaining memoryy partially done---- test
3. set child node as isOccupied or not if parent is occupied---(PENDING)
4. deallocate memory after sometime ( thread)---(PENDING)
*/