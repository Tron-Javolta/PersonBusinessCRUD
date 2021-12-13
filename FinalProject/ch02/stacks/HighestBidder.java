package ch02.stacks;

import java.util.*;  // Need Scanner for user input

public class HighestBidder
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in); // user input object.
      
      
      int userBid;      // User's input bid
      int highBid = 0;  // Current high bid 
      int maxBid = 0;   // Maximum set bid
      
      
      String currentBidder;
      String highBidder;      // Bidder with the maximum bid
      
      // Creates new empty stack
      LinkedStack<Bid> bidders = new LinkedStack<Bid>();
      
      // For continuing do/while loop
      boolean continueRunning = true;
      
      do
      {
         
         System.out.println("Current Max Bid: " + maxBid);
         System.out.println("Current High Bid: " + highBid);
      
         System.out.print("Enter bidder name (X to end auction): ");
         currentBidder = keyboard.nextLine();
         
         // Ends auction
         if (currentBidder.equals("X"))
            continueRunning = false;
         
         // Receive user's bid 
         else
         {
            System.out.print("Enter bid: ");
            userBid = keyboard.nextInt();
            keyboard.nextLine();
         
            // Discard bid if it's less than the maximum, but set as the high bid
            // if it's higher than high bid.
            if (userBid > highBid && userBid < maxBid)
            {
               highBid = userBid;
               userBid = 0;
            }
            
            /**
               If the user's bid is higher than the maximum, set the new high bid
               as the last maximum bid plus one and make the user's bid the new 
               maximum bid. Set the high bidder to the current user and store their
               information/push onto stack.
            */
            else if (userBid > maxBid)
            {
               highBid = maxBid+1;
               maxBid = userBid;
               highBidder = currentBidder;
               Bid bidder = new Bid(highBidder, highBid, maxBid);
               bidders.push(bidder);
            }
            
         }
      }
      while (continueRunning);
      
      // Display the high bidders
      System.out.println(bidders);
   }
}