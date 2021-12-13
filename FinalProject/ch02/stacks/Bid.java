package ch02.stacks;

/**
   Programmer: Nicholas Souder
   Date: 9/25/2018
*/
public class Bid
{
   String bidderName;
   int currentBid;      // High bid
   int maxBid;          // Current maximum bid
   
   /**
      Constructor method
      @param name Bidder's name.
      @param currentBid Bidder's current bid.
      @param maxBid Maximum set bid.
   */
   public Bid(String name, int currentBid, int maxBid)
   {
      bidderName = name;
      this.currentBid = currentBid;
      this.maxBid = maxBid;
   }
   
   /**
      toString method
      @return The top bidders' names, high bids, and maximum bids as a string throughout the auction.
   */
   @Override
   public String toString()
   {
      return "Name: " + bidderName + "\t\t" + "High Bid: " + currentBid + "\t\tMaximum Bid Entered: " + maxBid;
   }
}