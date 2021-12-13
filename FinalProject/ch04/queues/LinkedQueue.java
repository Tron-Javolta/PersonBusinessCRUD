//---------------------------------------------------------------------------
// LinkedQueue.java            by Dale/Joyce/Weems                  Chapter 4
//
// Implements QueueInterface using a linked list.
//
// Updated by: Nicholas Souder
// Date: 10/8/2018
//---------------------------------------------------------------------------

package ch04.queues;

import support.LLNode;

public class LinkedQueue<T> implements QueueInterface<T>
{
  protected LLNode<T> front;     // reference to the front of this queue
  protected LLNode<T> rear;      // reference to the rear of this queue
  protected int numElements = 0; // number of elements in this queue

  public LinkedQueue()
  {
    front = null;
    rear = null;
  }

  public void enqueue(T element)
  // Adds element to the rear of this queue.
  { 
    LLNode<T> newNode = new LLNode<T>(element);
    if (rear == null)
      front = newNode;
    else
      rear.setLink(newNode);
    rear = newNode;
    numElements++;
  }     

  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {
    if (isEmpty())
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T element;
      element = front.getInfo();
      front = front.getLink();
      if (front == null)
        rear = null;
      numElements--;
      return element;
    }
  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              
    return (front == null);
  }
  
  public boolean isFull()
  // Returns false - a linked queue is never full.
  {              
    return false;
  }

  /**
     Getter method
     @return Size of the queue.
  */
  public int size()
  {
    return numElements;
  }
  
  /**
     toString method
     @return Contents of the queue.
  */
  public String toString()
  {
     LLNode<T> temp = front;  // Holds the reference to the first link.
     
     String displayString = "";
     
     for (int i = 0; i < numElements; i++)
     {
        displayString +=i+1 + ". " + temp.getInfo() + "\n";
        temp = temp.getLink();
     }

     return displayString;
  }
  
  /**
     Transformer method
     Removes a set amount of links from the queue.
     @param count The number of links the user wants to remove.
     
  */
  public void remove(int count)
  {
     
     if (isEmpty())
        throw new QueueUnderflowException("Remove method attempted on an empty queue.");
     
     else if (count > numElements)
        throw new QueueUnderflowException("Amount attemped to remove is higher than the amount of elements in the queue.");
        
     else
     {
        T element;
        for (int i = 0; i < count; i++)
        {
           // Move up one through the queue to get new front.
           element = front.getInfo();
           front = front.getLink();
           if (front == null)
              rear = null;
        }
        numElements -= count;
     }
  }
  
  /**
     Transformer method
     Swaps the first two links in the queue.
     @return True or false whether the swap was successful.
  */
  public boolean swapStart()
  {
     if (numElements < 2)
     {
        System.out.println("Unable to complete swap.");
        return false;
     }
     else
     {
        LLNode<T> temp = front; // Reference for the front of the queue.
        
        T element;  // For the first link's info.
        T element2; // For the second link's info.
        
        element = temp.getInfo();
        element2 = temp.getLink().getInfo();
        
        temp.setInfo(element2);
        temp.getLink().setInfo(element);

        if (rear == front)
        {
           rear = front.getLink();
        }
     }
     return true;
  }
  
  /**
     Transformer method
     Swaps the last two links in the queue.
     @return True or false whether the swap was successful.
  */
  public boolean swapEnds()
  {
     if (numElements < 2)
     {
        System.out.println("Unable to swap ends.");
        return false;
     }
     else
     {
       LLNode<T> temp = front;  // Front link reference.
       
       T element;  // For second last link.
       T element2; // For last link.
       
       // Loop to the second last/last link.
       while (temp != null && temp.getLink() != null)
       {
          // Determine if the reference is the third last link to grab the second last and last link.
          if (temp.getLink().getLink() == rear)
          {
             element = temp.getLink().getInfo();
             element2 = temp.getLink().getLink().getInfo();
             
             // Swap information
             temp.getLink().setInfo(element2);
             temp.getLink().getLink().setInfo(element);
          }
          temp = temp.getLink();
       }
     }
     return true;
  }

}

