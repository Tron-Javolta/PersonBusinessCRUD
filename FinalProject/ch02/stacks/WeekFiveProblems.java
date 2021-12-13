package ch02.stacks;

/**
   WEEK FIVE PROBLEMS 16, 17, AND 18
   Some methods reused from LinkedStack.java
   
   Test driver at the bottom
   
   Programmer: Nicholas Souder
   Date: 10/1/2018
*/

import support.LLNode;

public class WeekFiveProblems<T>
{
   protected LLNode<Integer> top;
   
   protected static int count = 0;
   
   public WeekFiveProblems()
  {
    top = null;
  }
  
  public void push(T element)
  // Places element at the top of this stack.
  { 
    LLNode newNode = new LLNode(element);
    newNode.setLink(top);
    top = newNode;
  }     

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
    {
      top = top.getLink();
    }
  }
  
  public Integer top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {                 
    if (isEmpty())
      throw new StackUnderflowException("Top attempted on an empty stack.");
    else
      return top.getInfo();
  }


  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    return (top == null); 
  }

  public boolean isFull()
  // Returns false - a linked stack is never full
  {              
      return false;
  }
  
  /**
     PROBLEM 16
     Getter method
     @param list Node.
     @return count The number of even numbers in the list.
  */
  public static int numEvens(LLNode<Integer> list)
  {
     LLNode<Integer> temp = list;
        
     if (temp == null)
        return count;
     else
     {
        // Find even number
        if (temp.getInfo()%2 == 0)
        {
           count++;
        }
        
        // Assign the next element to the temp.
        temp = temp.getLink();
        return numEvens(temp);
     }
  }
  
  /**
     PROBLEM 17
     Getter method
     @param target The user's input they're looking for.
     @param list Node.
     @return True if the number is found, false if not.
  */
  public static boolean contains(int target, LLNode<Integer> list)
  {
     LLNode<Integer> temp = list;
     
     if (temp == null)
        return false;
     
     if (target == temp.getInfo())
     {
        return true;
     }
     else
     {  // Assign the next element to the temp.
        temp = temp.getLink();
        return contains(target, temp);
     }
  }
  
  /**
     PROBLEM 18 EXTRA CREDIT
     Transformer method
     @param target The user's input that they want removed from the list.
     @param list The list that will be used to removed the element from.
     @return The new node referencing a list with the removed element.
  */
  public static LLNode<Integer> remove(int target, LLNode<Integer> list)
  {
     LLNode<Integer> temp = list;
     
     if (temp == null)
        return null;
     
     // Check for a match and recursively call remove to update the temp node.
     if (temp.getInfo() == target)
     {
        temp = remove(target, temp.getLink());
     }
     
     // Recursive loop if there's no match, advance the node to the next node.
     else if (temp.getInfo() != target)
     {
        temp.setLink(remove(target, temp.getLink()));
     }
     
     return temp;
  }
  
  public int example (int n)
  {
     if (n==0)
      return 0;
     else
        return example(n-1) + n*n*n;
  }
  
  /**
     TEST DRIVER
  */
  public static void main(String[] args)
  {
     WeekFiveProblems<Integer> list = new WeekFiveProblems<Integer>();
     
     list.push(3);
     list.push(6);
     list.push(6);
     list.push(9);
     list.push(12);
     list.push(15);
     list.push(18);
     list.push(19);
     list.push(19);
     list.push(20);
     
     LLNode<Integer> values = list.top;

     System.out.println("------------------");
     System.out.println("numEvens Test");
     System.out.println("------------------");
     System.out.println(numEvens(values));
     System.out.println();
     
     System.out.println("-------------------");
     System.out.println("contains Test");
     System.out.println("-------------------");
     System.out.println("Is -1 in the list: " + contains(-1,values));
     System.out.println("Is 3 in the list: " + contains(3,values));
     System.out.println();
     
     System.out.println("-------------------");
     System.out.println("remove Test (19)");
     System.out.println("-------------------");
     System.out.println("Before");
     System.out.println(values.getInfo());
     System.out.println(values.getLink().getInfo() + "\n");
     System.out.println("After");
     
     values = remove(19, values);
     
     System.out.println(values.getInfo());
     System.out.println(values.getLink().getInfo());
     
     
     System.out.println();
     WeekFiveProblems testThing = new WeekFiveProblems();
     System.out.println(testThing.example(3));
     
     
  }
   
}