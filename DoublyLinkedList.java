
package com.mycompany.dllists_stacks_queues;

/**
 *
 * @author MoaathAlrajab
 */
class Node {
   public int data;
   public Node next;
   public Node previous;

   public Node(int initialData) {
      data = initialData;
      next = null;
      previous = null;
   }
}

public class DoublyLinkedList {
   private Node head;
   private Node tail;
    
   public DoublyLinkedList() {
      head = null;
      tail = null;
   }
    
   public void append(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         tail.next = newNode;
         newNode.previous = tail;
         tail = newNode;
      }
   }
   
   public void prepend(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         newNode.next = head;
         head.previous = newNode;
         head = newNode;
      }
   }
   
   public void printList() {
      Node node = head;
      while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
      }
      System.out.println();
   }
   
   public void insertAfter(Node currentNode, Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else if (currentNode == tail) {
         tail.next = newNode;
         newNode.previous = tail;
         tail = newNode;
      }
      else {
         Node successor = currentNode.next;
         newNode.next = successor;
         newNode.previous = currentNode;
         currentNode.next = newNode;
         successor.previous = newNode;
      }
   }
   
   public void remove(Node currentNode) {
      Node successor = currentNode.next;
      Node predecessor = currentNode.previous;
      
      if (successor != null)
         successor.previous = predecessor;
         
      if (predecessor != null)
         predecessor.next = successor;
         
      if (currentNode == head)
         head = successor;
         
      if (currentNode == tail)
         tail = predecessor;
   }
   
   public  int getSize() {
       return linkedList.getSize();
   }
   public int [] toArray() {
  int [] arr = new int [size]; 
  int index = 0;
  Node current = head; 
  while (current != null) {
      arr[index++] = current.data; 
      current = current.next;
  }
  return arr;
  //space and time is O(n)
} 
   public int indexOf (int i) {
       int index = 0; 
       Node current = head;
       while (current != null) {
       if (current.data == i) 
           return index; 
       current = current.next;
       index++;
   }
       return -1; 
   } 
   //space is O(1) and time is O(n)
   public int getSum(int m) {
       //use code from reverse list, start at tail and create a counter to keep track of < m
      Node current = head;
      while (current != null) { //reverses list 
      Node temp = current.next;
      current.next=current.previous;
      current.previous=temp;
      current = current.previous;
}
      int sum = 0;
    while (current != null) {
        for (int i = 0; i <= m; i++)
        sum += current.data;
         current = current.next;
    }
    return sum;
}
   }
