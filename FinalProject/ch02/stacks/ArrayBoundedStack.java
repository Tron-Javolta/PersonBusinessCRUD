//----------------------------------------------------------------
// ArrayBoundedStack.java    by Dale/Joyce/Weems         Chapter 2
//
// Implements StackInterface using an array to hold the 
// stack elements.
//
// Two constructors are provided: one that creates an array of a 
// default size and one that allows the calling program to 
// specify the size.
//
// UPDATED BY: Nicholas Souder
// Date: 9/17/2018
//----------------------------------------------------------------

package ch02.stacks;

public class ArrayBoundedStack<T> implements StackInterface<T> 
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // holds stack elements
  protected int topIndex = -1;      // index of top element in stack

  public ArrayBoundedStack() 
  {
    elements = (T[]) new Object[DEFCAP];
  }

  public ArrayBoundedStack(int maxSize) 
  {
    elements = (T[]) new Object[maxSize];
  }

  public void push(T element)
  // Throws StackOverflowException if this stack is full,
  // otherwise places element at the top of this stack.
  {      
    if (isFull())
      throw new StackOverflowException("Push attempted on a full stack.");
    else
    {
      topIndex++;
      elements[topIndex] = element;
    }
  }

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
    {
      elements[topIndex] = null;
      topIndex--;
    }
  }

  public T top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {                 
    T topOfStack = null;
    if (isEmpty())
      throw new StackUnderflowException("Top attempted on an empty stack.");
    else
      topOfStack = elements[topIndex];
    return topOfStack;
  }

  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    return (topIndex == -1); 
  }

  public boolean isFull()
  // Returns true if this stack is full, otherwise returns false.
  {              
    return (topIndex == (elements.length - 1));
  }
  
  // PART A
  /**
     toString method modified to display the whole stack.
     @return The whole stack for the user to view.
  */
  public String toString()
  {
     String displayString = "";
     
     if (topIndex <= 0)
        displayString = "The stack is empty.";
     else
     {
        for (int i = 0; i < topIndex; i++)
        {
           displayString += "Index " + i + " in stack: " + elements[i].toString() + "\n";
        }
     }
     
     return displayString;
  }
  
  // PART B
  /**
     Method to return the size of the array.
     @return The size of the array.
  */
  public int size()
  {
     return topIndex;
  }
  
  // PART C
  /**
     Transformer method to pop a given amount of elements that the
     user has inputted out of the stack.
     @param count The number of elements the user wants to pop from the stack.
  */
  void popSome(int count)
  {
     // If the user inputs an amount to pop than there are elements.
     if (count > topIndex)
     {
        System.out.println("Not enough elements in the stack to pop.");
     }
     // Pop the amount inputted.
     else
     {
        elements[topIndex] = null;
        topIndex = topIndex - count;
     }
  }
  
  // PART D
  /**
     Transformer method to swap two elements.
     @return Whether the swap was successful or unsuccessful.
  */
  boolean swapStart()
  {
     // Element holders
     T temp1;
     T temp2;
     
     // Stack cannot be under two to swap elements.
     if (topIndex < 2)
        return false;
     // Swap the top two elements.
     else
     {
        temp1 = elements[topIndex-2];
        temp2 = elements[topIndex-1];
        elements[topIndex-1] = temp1;
        elements[topIndex-2] = temp2;
        return true;
     }
  }
  
  // PART E
  /**
     Transformer method to pop the top of the stack.
     @return The stack object at the given index.
  */
  T popTop() throws StackUnderflowException
  {
     // Stack must have something in it to pop or else an exception is thrown.
     if (topIndex <= 0)
     {
        throw new StackUnderflowException("Stack underflow");
     }
     else
     {
        T stackObject;
        stackObject = elements[topIndex];
        elements[topIndex] = null;
        topIndex--;
        return stackObject;
     }
  }
  
  T getIndex(int where)
  {
   topIndex = where;
   return elements[topIndex];
   }
}