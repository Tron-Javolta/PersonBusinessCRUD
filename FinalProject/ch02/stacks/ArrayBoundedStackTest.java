package ch02.stacks;

/**
   Programmer: Nicholas Souder
   Date: 9/18/2018
*/

public class ArrayBoundedStackTest
{
   public static void main(String[] args)
   {
      ArrayBoundedStack<Integer> arrayTest = new ArrayBoundedStack<Integer>();
      
      // Create and display array full of numbers.
      for (int i = 0; i < 100; i++)
      {
         arrayTest.push(i+1);
      }
      System.out.print(arrayTest);
      
      // size() method test
      System.out.println("Size of array: " + arrayTest.size());
      
      // UNSUCCESSFUL POP, COUNT TOO HIGH
      arrayTest.popSome(123);
      System.out.println("Size of array after unsuccessful pop: " + arrayTest.size());
      
      // SUCCESSFUL POP
      arrayTest.popSome(7);
      System.out.println("Size of array after successful pop (7): " + arrayTest.size());
      System.out.println(arrayTest);
      
      // SWAPSTART TEST
      if (arrayTest.swapStart())
      {
         System.out.println(arrayTest);
         System.out.println("Index 90 and index 91 have been switched.\n");
         System.out.println("--------------------");
      }
      
      // POPTOP TEST
      System.out.println("POP TEST");
      System.out.println("--------------------");
      arrayTest.popTop();
      System.out.println(arrayTest+"\n");
      
      // Shrink stack for further testing
      System.out.println("popSome");
      System.out.println("--------------------");
      arrayTest.popSome(89);
      System.out.println(arrayTest+"\n");
      System.out.println("--------------------");
      
      // popTop test
      System.out.println("popTop");
      System.out.println("--------------------");
      arrayTest.popTop();
      System.out.println(arrayTest);
      arrayTest.popTop();
      System.out.println(arrayTest+"\n");
      System.out.println("--------------------");
      
      // False returning swapstart test 
      System.out.println("Final swap test");
      System.out.println("--------------------");
      if (!arrayTest.swapStart())
      {
         System.out.println("Elements in stack cannot be swapped because there are none to swap.");
      }
      
      System.out.println("\n\n\n" + arrayTest.getIndex(10));
      arrayTest.pop();
      System.out.println(arrayTest.top());
      System.out.println(arrayTest.getIndex(10));
   }
   
}