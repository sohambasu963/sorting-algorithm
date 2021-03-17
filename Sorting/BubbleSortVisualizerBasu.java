import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class BubbleSortVisualizerBasu here.
 * 
 * @author Soham Basu 
 * @version 1.0
 */
public class BubbleSortVisualizerBasu extends Actor
{
    List blockList;
    int size;
    int i;
    int j ;
    boolean debug = false; //turn on to print debugging statements
    
    public BubbleSortVisualizerBasu() {
        size = -1;
        j = 0;
        i = 0;
    }
    /**
     * Act - do whatever the BubbleSortVisualizerBasu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (size < 0) {
           blockList = ((SortingVisualization)getWorld()).getBlockList();
           size = blockList.size();
           j = size - 1;
        } 
        
        else if (size == 1) {
            System.out.println("There is only one block. Therefore, there is nothing to sort.");
        }
            
        else if(size > 1) {
           // once j reaches index 0, it resets to the value of j-1 and the sort tracker (i) increases by 1
           if (j == 0) {
               j = size-1;
               i += 1;
            }
           //once the program has sorted all the blocks, it stops 
           if (i == size) {
               Greenfoot.stop();
               System.out.println("The blocks have been sorted from top to down in ascending order");
            }
           //gets the last two blocks and their values
           Block block1 = (Block)blockList.get(j);
           Block block2 = (Block)blockList.get(j-1);
           int value1 = block1.getValue();
           int value2 = block2.getValue();
           if (debug) {
               System.out.println("The value of block 1 is "+value1);
               System.out.println("The value of block 2 is "+value2); }
           //if the blocks are in the wrong order
           if (value2 > value1) {
               //this code sets them in the right order
               Object temp = blockList.get(j);
               blockList.set(j, blockList.get(j-1));
               blockList.set(j-1, temp);

               SortingVisualization tempWorld = (SortingVisualization)this.getWorld();
               tempWorld.displayList();
               if (debug) System.out.println("Block 1 and 2 were swapped");
               j -= 1; //changes the j-value so the program can look at the next 2 blocks
            }
           //if the blocks are in the right order
           else if (value2 <= value1) {
               if (debug) System.out.println("Block 2 was not greater than Block 1");
               j -= 1; //changes the j-value so the program can look at the next 2 blocks
            }
        }
    }  
}
