/**
   SortedLinkedCollection.java
   
   Programmer: Nicholas Souder
   Date: 10/16/2018
   
   Method updated - add
      Now sorts the linked list as each node is placed.
*/

package ch05.collections;

import support.LLNode;

public class SortedLinkedCollection<T extends Comparable<T>> implements CollectionInterface<T>
{
  protected LLNode<T> head;       // head of the linked list
  protected int numElements = 0;  // number of elements in this collection

  // set by find method
  protected boolean found;        // true if target found, else false
  protected LLNode<T> location;   // node containing target, if found
  protected LLNode<T> previousNodeious;   // node preceding location

  public SortedLinkedCollection()
  {
    numElements = 0;
    head = null;
  }

 public boolean add(T element)
  // Adds element to this collection.
  {
    LLNode<T> newNode = new LLNode<T>(element);
    
    
    if (head == null)
       head = newNode;
    
    // If the param element is less than the head's element, reset the head as the param element.
    else if (newNode.getInfo().compareTo(head.getInfo()) < 0)
    {
       newNode.setLink(head);
       head = newNode;
    }
    
    else
    {
       LLNode<T> temp;
       LLNode<T> previousNode;        // previous node to temp
       temp = head.getLink();
       previousNode = head;
       
       // param element greater than current(previous) node's element
       while (previousNode.getLink() != null && newNode.getInfo().compareTo(previousNode.getLink().getInfo()) > 0)
       {
          previousNode = temp;
          temp = temp.getLink();
       }
       
       // insert new node in between where location is found from above while loop
       newNode.setLink(temp);
       previousNode.setLink(newNode);
    }
    numElements++;
    return true;
  }
 
 
  protected void find(T target)
  // Searches the collection for an occurence of an element e such that
  // e.equals(target). If successful, sets instance variables
  // found to true, location to node containing e, and previousNodeious
  // to the node that links to location. If not successful, sets 
  // found to false.
  {
    location = head;
    found = false;

    while (location != null) 
    {
      if (location.getInfo().equals(target))  // if they match
      {
       found = true;
       return;
      }
      else
      {
        previousNodeious = location;
        location = location.getLink();
      }
    }
  }

  public int size()
  // Returns the number of elements on this collection. 
  {
    return numElements;
  }

  public boolean contains (T target)
  // Returns true if this collection contains an element e such that 
  // e.equals(target); otherwise, returns false.
  {
    find(target);
    return found;
  }

  public boolean remove (T target)
  // Removes an element e from this collection such that e.equals(target)
  // and returns true; if no such element exists, returns false.
  {
    find(target);
    if (found)
    {
      if (head == location)     
        head = head.getLink();    // remove first node
      else
        previousNodeious.setLink(location.getLink());  // remove node at location

      numElements--;
    }
    return found;
  }

  public T get(T target)
  // Returns an element e from this collection such that e.equals(target);
  // if no such element exists, returns null.
  {
    find(target);    
    if (found)
      return location.getInfo();
    else
      return null;
  }
    
  public boolean isEmpty()
  // Returns true if this collection is empty; otherwise, returns false.
  {
    return (numElements == 0);  
  }

  public boolean isFull()
  // Returns true if this collection is full; otherwise, returns false.
  {
    return false;  // Linked implementation is never full
  }
  
  /**
     toString method
     @return Information about the collection.
  */
  public String toString()
  {
     LLNode<T> temp = head;
     
     String displayString = "";
     
     for (int i = 0; i < numElements; i++)
     {
        displayString += i+1 + ". " + temp.getInfo() + "\n";
        temp = temp.getLink();
     }
     return displayString;
  }
  
  public static void main(String[] args)
  {
     SortedLinkedCollection<String> test = new SortedLinkedCollection<String>();
     
     test.add("candy");
     test.add("camaro");
     test.add("sweet");
     test.add("brigade");
     test.add("cat");
     test.add("art");
     test.add("add");
     test.add("tango");
     test.add("casa");
     
     System.out.println(test);
     
  }


}
