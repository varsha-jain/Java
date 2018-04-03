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
public class Block {

    private Block nextBlock; //object reference
    private int blockSize;
    //private int blockType;

    public Block(int size) {
        this.blockSize = size;
    }

    public String toString() {
        return String.valueOf(blockSize);
    }

    public Block getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(Block nextBlock) {
        this.nextBlock = nextBlock;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }
}
