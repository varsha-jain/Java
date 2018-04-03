package memorymanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package memorymanagement;

/**
 *
 * @author Soham
 */
public class LinkedList {

    private Block head;
    private Block rear;

    public void insertAtRear(int size) {
        Block newBlock = new Block(size);

        if (this.head == null) {
            this.head = newBlock;
            this.rear = head;
            this.rear.setNextBlock(null);
        }

        if (rear != null) {
            this.rear.setNextBlock(newBlock);
        }
        this.rear = newBlock;
        this.rear.setNextBlock(null);
    }

    public void display(int i) {
        if (this.head == null || this.rear == null) {
            System.out.println("No memory available at location " + i);
        } else {
            Block ptr = this.head;
            //ptr = head.getNext();
            while (ptr != null) {
                System.out.print(ptr.getBlockSize() + "-->");
                ptr = ptr.getNextBlock();
            }
            System.out.println("null");

        }
    }

    public int lengthOfList() {
        int length = 0;
        Block current = this.head;

        while (current != null) {
            length++;
            current = current.getNextBlock();
        }
        return length;
    }

    public void removeFromRear() {

        Block current = null;
        Block prev = null;
        current = this.head;

        if (this.head == this.rear) {
            this.head = null;
            return;
        }
        if (current != null) {
            if (current.getNextBlock() != null) {
                while (current.getNextBlock() != null) {
                    prev = current;
                    current = current.getNextBlock();

                }
                this.rear = prev;
                prev.setNextBlock(null);
            }
        }
    }

    public Block getHead() {
        return head;
    }

    public Block getRear() {
        return rear;
    }

}
