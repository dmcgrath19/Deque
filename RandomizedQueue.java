/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;
import java.util.Iterator;
/**
 *
 * @author dmcgrath19
 */

  public class RandomizedQueue<Item> implements Iterable<Item> {
        
   private Object [] array;
   private int index = 0;
    
        
   public RandomizedQueue(){
       int index = 0;
       array = null;//
       //(Item[]) new Object [0];
       // construct an empty randomized queue
   }
   public boolean isEmpty(){
       return index == 0;
       // is the randomized queue empty?
   }
   public int size(){
       return index;
       // return the number of items on the randomized queue
   }
   public void enqueue(Item item){
       if (item == null)
           throw new java.lang.IllegalArgumentException("");
       if(array.length < index+1){
           Object[] newarray = (Item[]) new Object[array.length*2];
           for(int i = 0; i < index; i++)
               newarray[i] = array[i];
           array = newarray;
       }
       int x = (int) (Math.random()*array.length);
        array[index++] = array[x];
        array[x] = item;
       // add the item
   }
   
   
   public Item dequeue(){
       if(index==0)
           throw new java.util.NoSuchElementException("");
       int x = (int)(Math. random() * index ); 
        Item item = (Item) array[index-1];
        array[index--] = null;
       index--;
        if(array.length >= index *4){
           Object[] newarray = (Item[]) new Object[array.length / 4];
           for(int i = 0; i < index; i++)
               newarray[i] = array[i];
           array = newarray;
       }
               return item; 
       // remove and return a random item
   }
   public Item sample(){
       if(index==0)
           throw new java.util.NoSuchElementException("");
       int x = (int)(Math. random() * index );
       return (Item) array[x];
       
       // return a random item (but do not remove it)
   }    
   

    @Override
   public Iterator<Item> iterator(){
         Iterator<Item> it = new Iterator<Item>() {
            private  int n  = index ;
            private  int [] nums = new int [index];
         
            @Override
            public Item next() {
             if(index-1 == 0)
                    throw new java.util.NoSuchElementException("");
             for(int i = 0; i <index; i++){
                 for(int j = index; j > -1; j--){
                    Math.random()*index
            
                 }
 }
             //Item item = currentIndex.item;
              //  currentIndex = currentIndex.next;
              //  return item;

              
            }
            
            @Override
            public boolean hasNext() {
                return currentIndex.next != null;
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

   public static void main(String[] args){
       // unit testing (optional)
}
    
}
