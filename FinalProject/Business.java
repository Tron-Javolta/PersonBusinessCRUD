import java.util.Comparator;

/**
   Business.java
   
   Programmer: Nicholas Souder
   
*/

public class Business implements Comparable<Business>
{
   protected String businessName, address, email, website, phoneNumber;
   
   /**
      Constructor method
      @param business Business name
      @param address Address of business
      @param email Email address of business
      @param web Website name of business
      @param phone Phone number of business
   */
   public Business(String business, String address, String email, String web, String phone)
   {
      businessName = business;
      this.address = address;
      this.email = email;
      website = web;
      phoneNumber = phone;
   }
   
   /**
      Getter method
      @return Name of the business
   */
   public String getBusiness()
   {
      return businessName;
   }
   
   /**
      Getter method
      @return Address of the business
   */
   public String getAddress()
   {
      return address;
   }
   
   /**
      Getter method
      @return Email address of the business
   */
   public String getEmail()
   {
      return email;
   }
   
   /**
      Getter method
      @return Website of the business
   */
   public String getWeb()
   {
      return website;
   }
   
   /**
      Getter method
      @return Phone number of the business
   */
   public String getPhoneNumber()
   {
      return phoneNumber;
   }
   
   /**
      Transformer method, modifies the current business name
      @param term The new name for the business
      
   */
   public void changeBusiness(String term)
   {
      businessName = term;
   }
   
   /**
      Transformer method, modifies the current address of the business
      @param term The new address of the business
   */
   public void changeAddress(String term)
   {
      address = term;
   }
   
   /**
      Transformer method, modifies the current email of the business
      @param term The new email of the business
   */
   public void changeEmail(String term)
   {
      email = term;
   }
   
   /**
      Transformer method, modifies the current website of the business
      @param term The new website of the business
   */
   public void changeWeb(String term)
   {
      website = term;
   }
   
   /**
      Transformer method, modifies the current phone number of the business
      @param term The new phone number of the business
   */
   public void changeNumber(String term)
   {
      phoneNumber = term;
   }
   
   /**
      Getter method, used for writing lines to a file for storage
      @return A string of information about the business
   */
   public String displayWrite()
   {
      String returnString = this.getBusiness();
      returnString += "\t" + this.getAddress();
      returnString += "\t" + this.getEmail();
      returnString += "\t" + this.getWeb();
      returnString += "\t" + this.getPhoneNumber();
      
      return returnString;
   }      
      
   /**
      Getter method, compares objects for equality
      @param obj The object being compared to
      @return True or false if the object is equal
   */
   @Override
   public boolean equals(Object obj)
   {
      if (obj == this)
         return true;
      else 
      if (obj == null || obj.getClass() != this.getClass())
         return false;
      else
      {
         Business bsns = (Business) obj; 
         return (this.businessName.equals(bsns.businessName)); 
      }
   }
   
   // Compare the business names
   public int compareTo(Business other)
   // Precondition: 'other' is not null
   //
   // Compares this Business with 'other' for order. Returns a 
   // negative integer, zero, or a positive integer as this object 
   // is less than, equal to, or greater than 'other'.
   {
     if (!this.businessName.equals(other.businessName))
       return this.businessName.compareTo(other.businessName);
     else
       return this.businessName.compareTo(other.businessName);
   }
}