/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memorymanagement;

import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class BST {

    private BSTNode root;

    public BST() {
        root = null;

    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insertNew(BSTNode root, ArrayList<Integer> al, int start, int size, ArrayList<Integer> startAddress) {
        int left = 2 * start + 1;
        int right = 2 * start + 2;

        if (left > size || right > size) {
            return;
        }

        if (root == null) {
            BSTNode node = new BSTNode(al.get(start), startAddress.get(start));
            root = node;
        }

        if (root.left == null && root.right == null) {
            if (left < size) {
                root.left = new BSTNode(al.get(left), startAddress.get(left));
            }

            if (right < size) {
                root.right = new BSTNode(al.get(right), startAddress.get(right));
            }
        }
        insertNew(root.left, al, left, size, startAddress);
        insertNew(root.right, al, right, size, startAddress);

    }

    /* Function for inorder traversal */
    public void inorder(BSTNode r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    public BSTNode search(int memoryDemanded, BSTNode root) {

        BSTNode tempRoot = null;

        if (memoryDemanded == root.data) {
            root.isMemoryOccupied = true;
            System.out.println("Memory allocated : " + root.data + " at location: " + root.nodeStartAddress);
            root.data -= memoryDemanded;
            setChildUnavailable(root);
            return root;

            // check to set flag of parent when both children are busy
        } else if (root.left != null && root.left.isMemoryOccupied == false && root.left.data >= memoryDemanded) {
            tempRoot = root;
            //System.out.println("Traversing the node : " + tempRoot.data); //printing to test
            root = search(memoryDemanded, root.left);
            tempRoot.data -= memoryDemanded;
            //System.out.println("After subtraction : " + tempRoot.data);
            return tempRoot;
        } else if (root.right != null && root.right.isMemoryOccupied == false && root.right.data >= memoryDemanded) {
            tempRoot = root;
            //System.out.println("Traversing the node : " + tempRoot.data);
            root = search(memoryDemanded, root.right);
            tempRoot.data -= memoryDemanded;
           // System.out.println("After subtraction : " + tempRoot.data);
            return tempRoot;
        }

        return root;
    }

    public void setChildUnavailable(BSTNode startingNode) {

        if (startingNode == null) {
            return;
        } else if (startingNode.left != null) {
            setChildUnavailable(startingNode.left);

        }

        startingNode.data = 0;
        startingNode.isMemoryOccupied = true;

        if (startingNode.right != null) {
            setChildUnavailable(startingNode.right);
        }

    }

    public void resetNodeData(BSTNode parentNode) {

        //System.out.println("After deallocation data in root is: " + parentNode.data);
        if (parentNode.left != null) {
            //parentNode.data += memoryDemanded;
            resetNodeData(parentNode.left);
        }
        parentNode.data = parentNode.size;
        parentNode.isMemoryOccupied = false;
        if (parentNode.right != null) {
            //parentNode.data += memoryDemanded;
            resetNodeData(parentNode.right);
        }

    }
}
