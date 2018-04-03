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
public class BSTNode {

    BSTNode left, right;
    int data;
    int size;
    boolean isMemoryOccupied;
    int nodeStartAddress;

    
    public BSTNode() {
        left = null;
        right = null;

        data = 0;
    }

    
    public BSTNode(int n,int startAddress) {
        left = null;
        right = null;
        data = n;
        nodeStartAddress=startAddress;
        size=n;
        
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

    public boolean isIsMemoryOccupied() {
        return isMemoryOccupied;
    }

    public void setIsMemoryOccupied(boolean isMemoryOccupied) {
        this.isMemoryOccupied = isMemoryOccupied;
    }

    public int getNodeStartAddress() {
        return nodeStartAddress;
    }

    public void setNodeStartAddress(int nodeStartAddress) {
        this.nodeStartAddress = nodeStartAddress;
    }

    

}
