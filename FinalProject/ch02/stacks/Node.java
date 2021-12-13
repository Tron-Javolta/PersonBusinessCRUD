package ch02.stacks;

public class Node<T>
{
   public T item;
   
   public Node next;
   
   public Node(T item)
   {
      this.item = item;
      next = null;
   }
}