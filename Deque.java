
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
/*
Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator.
*/
public class Deque<Item> implements Iterable<Item> {

    /**
     * @param args the command line arguments
     */
   private Node first;
   private Node last;
   private int n;
   
    private class Node {
       Item item; 
       Node next; 
       Node previous;
    } 
    
   public Deque(){
       // construct an empty deque
        first = null;
        last = null;
         n = 0;
   }
   
   public boolean isEmpty(){
       // is the deque empty?
       return n == 0;
   }
   public int size(){
       // return the number of items on the deque
       return n;
   }
   public void addFirst(Item item){
       if(item == null)
           throw new java.lang.IllegalArgumentException("");
       Node newNode = new Node();
               newNode.item = item;
               newNode.next = first;
               first = newNode;
               n++;
       // add the item to the front
   }
   public void addLast(Item item){
       if(item == null)
           throw new java.lang.IllegalArgumentException("");
              Node newLast = new Node();
               newLast.item = item;
               newLast.next = null;
               last.next = newLast;
               last = newLast;
               n++;
       // add the item to the end
   }
   public Item removeFirst(){
       if(n==0)
           throw new java.util.NoSuchElementException("");
       Node removedNode = first; 
        first = first.next;
        n--;
        return removedNode.item;
       // remove and return the item from the front
   }
   public Item removeLast(){
       if(n==0)
           throw new java.util.NoSuchElementException("");
       Node removedNode = new Node();
       removedNode = last.previous;
       last = last.previous;
       return removedNode.item;
       // remove and return the item from the end
   }
   
    @Override
   public Iterator<Item> iterator(){

        Iterator<Item> it = new Iterator<Item>() {

            private Node currentIndex = first;

            @Override
            public boolean hasNext() {
                return currentIndex.next != null;
            }

            @Override
            public Item next() {
                if(currentIndex == null)
                    throw new java.util.NoSuchElementException("");
                Item item = currentIndex.item;
                currentIndex = currentIndex.next;
                return item;
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
