//-----------------------------------------------------------------------------
// LinkedQueue.java**            by Dale/Joyce/Weems                  Chapter 4
//
// Implements QueueInterface using a linked list.
// 
// **UPDATED TO CircularLinkedQueue.java
// Programmer: Nicholas Souder
// Date: 10/8/2018
//------------------------------------------------------------------------------

package ch04.queues;

import support.LLNode;

public class CircularLinkedQueue<T> implements QueueInterface<T>
{
  protected LLNode<T> front;     // reference to the front of this queue
  protected LLNode<T> rear;      // reference to the rear of this queue
  protected int numElements = 0; // number of elements in this queue

  public CircularLinkedQueue()
  {
    front = null;
    rear = null;
  }

  public void enqueue(T element)
  { 
    LLNode<T> newNode = new LLNode<T>(element);
    if (rear == null)
      front = newNode;
    else
    {
      rear.setLink(newNode);
      rear.getLink().setLink(front);
    }
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
      if (front.getLink() == front)
      {
         front = null;
         rear = null;
      }
      else
      {
         front = front.getLink();
         rear.setLink(front);
      
      if (front == null)
        rear = null;

      numElements--;
      }
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

  public int size()
  // Returns the number of elements in this queue.
  {
    return numElements;
  }
  
  /**
     toString method
     @return Contents of the queue.
  */
  public String toString()
  {
     LLNode<T> temp = front;  // Holds reference to the first link.
     
     String displayString = "";
     
     for (int i = 0; i < numElements; i++)
     {
        displayString += i+1 + ". " + temp.getInfo() + "\n";
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
        for (int i = 0; i < count; i++)
        {
           // Move up one through the queue and reset rear's link to new front.
           front = front.getLink();
           rear.setLink(front);
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
        LLNode<T> temp = front;
        
        T element;   // Holds front's information
        T element2;  // Holds link after front's information
        
        element = temp.getInfo();
        element2 = temp.getLink().getInfo();
        
        // Swap the two
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
       LLNode<T> temp = front;
       
       T element;  // Holds the second last link's information.
       T element2; // Holds the last link's information.
       
       // Loop through temp to get to second last and last link.
       while (temp != rear && temp.getLink() != rear.getLink())
       {
          // Find the rear link and swap the last two links.
          if (temp.getLink().getLink() == rear)
          {
             element = temp.getLink().getInfo();
             element2 = temp.getLink().getLink().getInfo();
             
             temp.getLink().setInfo(element2);
             temp.getLink().getLink().setInfo(element);
          }
          temp = temp.getLink();
       }
     }
     return true;
  }
  
  /**
     Test main method
  */
  public static void main(String[] args)
  {
     CircularLinkedQueue test = new CircularLinkedQueue();
     
     System.out.println("Enqueue test");
     System.out.println("-------------");
     test.enqueue("Vancouver");
     test.enqueue("Tennis");
     test.enqueue("Darts");
     test.enqueue("Valhalla");
     test.enqueue("Abraham");
     test.enqueue("West Chester");
     System.out.print(test+"\n");
     
     System.out.println("Dequeue test");
     System.out.println("------------");
     test.dequeue();
     test.dequeue();
     System.out.println(test);
     
     
     System.out.println("swapEnds test");
     System.out.println("-------------");
     test.swapEnds();
     System.out.println(test);
     
     System.out.println("swapStart test");
     System.out.println("--------------");
     test.swapStart();
     System.out.println(test);
     
     System.out.println("Remove test");
     System.out.println("-----------");
     test.remove(2);
     System.out.println(test);
     
     System.out.println("Size test");
     System.out.println("---------");
     System.out.println(test.size());
    


  }

}

