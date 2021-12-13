//---------------------------------------------------------------------------
// LinkedCollection.java          by Dale/Joyce/Weems               Chapter 5
//
// Implements the CollectionInterface using a linked collection.
// Null elements are not allowed. Duplicate elements are allowed.
// One constructor is provided, one that creates an empty collection.
//
// Edited by: Nicholas Souder
// Updated methods - toString, count, removeAll, combine
//---------------------------------------------------------------------------

package ch05.collections;

import support.LLNode;

public class LinkedCollection<T> implements CollectionInterface<T>  
{
  protected LLNode<T> head;       // head of the linked list
  protected int numElements = 0;  // number of elements in this collection

  // set by find method
  protected boolean found;        // true if target found, else false
  protected LLNode<T> location;   // node containing target, if found
  protected LLNode<T> previous;   // node preceding location

  public LinkedCollection()
  {
    numElements = 0;
    head = null;
  }

  public boolean add(T element)
  // Adds element to this collection.
  {
    LLNode<T> newNode = new LLNode<T>(element);
    newNode.setLink(head);
    head = newNode;
    numElements++;
    return true;
  }

  protected void find(T target)
  // Searches the collection for an occurence of an element e such that
  // e.equals(target). If successful, sets instance variables
  // found to true, location to node containing e, and previous
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
        previous = location;
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
        previous.setLink(location.getLink());  // remove node at location

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
  
  /**
     Getter Method
     @param target The target element a user wants to find the amount of in the collection.
     @return How many times the target shows up in the collection.
  */
  public int count(T target)
  {
     LLNode<T> temp = head;
     
     int countElement = 0;
     
     while (temp != null)
     {
        if (temp.getInfo().equals(target))
           countElement++;
        temp = temp.getLink();
     }
     
     return countElement;
  }
  
  /**
     Transformer Method
     @param target The target element the user wants to remove from the collection.
  */
  public void removeAll(T target)
  {
     location = head;
     
     LLNode<T> temp = head;
     
     // Loop through however many times the target shows up.
     // Remove each target and reset the links.
     while (temp != null)
     {
        if (target == temp.getInfo())
        {
           previous.setLink(temp.getLink());
           numElements--;
           temp = temp.getLink();
        }
        else
        {
           previous = temp;
           temp = temp.getLink();
        }
     }
  }

  /**
     Transformer Method
     @param other Another LinkedCollection<T> to add to the current one.
     @return The new combined linked collection.
  */
  public LinkedCollection<T> combine(LinkedCollection<T> other)
  {
     if (other.head == null)
        return null;
     else
     {
        LinkedCollection<T> newLinkedCollection = this;
        LLNode<T> current = other.head;                  // Links to param's head location to carry over that collection.
        while (current != null)
        {
           add((T) current.getInfo());
           current = current.getLink();
        }
        return newLinkedCollection;
     }
  }
  
  public static void main(String[] args)
  {
     LinkedCollection<String> test = new LinkedCollection<String>();
     
     test.add("test");
     test.add("skulk");
     test.add("umpire");
     test.add("skulk");
     test.add("umpire");
     test.add("umpire");
     test.add("odin");
     
     System.out.println(test);
     
     System.out.println("------------");
     System.out.println("Count test");
     System.out.println("------------");
     System.out.println("skulk shows up " + test.count("skulk") + " times");
     System.out.println("umpire shows up " + test.count("umpire") + " times\n");
     
     System.out.println("------------");
     System.out.println("removeAll test (umpire)");
     System.out.println("------------");
     test.removeAll("umpire");
     
     System.out.println(test);
     
     System.out.println("-------------");
     System.out.println("New collection");
     System.out.println("-------------");
     
     LinkedCollection<String> test2 = new LinkedCollection<String>();
     
     test2.add("bright");
     test2.add("Titanic");
     test2.add("legos");
     
     System.out.println(test2);
     
     System.out.println("----------");
     System.out.println("Combine test");
     System.out.println("-----------");
     test.combine(test2);
     
     System.out.println(test);
     
  }
  
}
