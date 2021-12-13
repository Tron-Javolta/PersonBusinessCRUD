package ch02.stacks;

/**
   Programmer: Nicholas Souder
   Date: 9/25/2018
   
   LINK TEST CLASS
*/

public class TestLink
{
   public static void main(String[] args)
   {
      // Creates new empty stack
      LinkedStack<String> node = new LinkedStack<String>();
      
      // Push test
      node.push("element");
      node.push("1");
      node.push("teller");
      node.push("stamps");
      node.push("tampa");
      
      // toString
      System.out.println("--------------");
      System.out.println("toString test");
      System.out.println("--------------");
      System.out.println(node);
      System.out.println();
      
      // size test
      System.out.println("--------------");
      System.out.println("size test");
      System.out.println("--------------");
      System.out.println(node.size());
      System.out.println();
      
      // swapStart
      System.out.println("--------------");
      System.out.println("swapStart test");
      System.out.print("--------------");
      node.swapStart();
      System.out.println(node);
      System.out.println("--------------");
      System.out.println("Swap back");
      System.out.print("--------------");
      node.swapStart();
      System.out.println(node);
      System.out.println();
      
      // pop 
      node.pop();
      node.pop();
      
      // popTop
      System.out.println("--------------");
      System.out.println("popTop test");
      System.out.println("--------------");
      System.out.println(node.popTop() + " has been popped.");
      System.out.println();
      System.out.println(node);
      node.pop();
      node.pop();
      
      // popSome
      System.out.println("-------------");
      System.out.println("popSome test");
      System.out.println("-------------");
      
      node.push("new");
      node.push("test");
      node.push("elephant");
      node.push("skittles");
      System.out.println("Before popSome");
      System.out.println(node);
      
      System.out.println();
      System.out.println("After popSome(3)");
      node.popSome(3);
      System.out.println(node);
      
      node.pop();
      
      node.push("washington");
      node.push("adams");
      node.push("jefferson");
      
      LinkedStack<String>temp = node;
      System.out.println(node.getLink());
     }
}