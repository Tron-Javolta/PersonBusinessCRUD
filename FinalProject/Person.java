import java.util.Comparator;

/**
   Person.java
   
   Programmer: Nicholas Souder
*/

public class Person implements Comparable<Person>
{
   protected String firstName, lastName, address, email, phoneNumber;
   
   /**
      Constructor method
      @param first First name of person
      @param last Last name of person
      @param address Address of person
      @param email Email of person
      @param phone Phone number of person
   */
   public Person(String first, String last, String address, String email, String phone)
   {
      firstName = first;
      lastName = last;
      this.address = address;
      this.email = email;
      phoneNumber = phone;
   }
   
   
   /**
      Getter method
      @return Person's last name, comma, first name
   */
   public String getFormalName()
   {
      return lastName + ", " + firstName;
   }
   
   /**
      Getter method
      @return Person's first name
   */
   public String getFirstName()
   {
      return firstName;
   }
   
   /**
      Getter method
      @return Person's last name
   */
   public String getLastName()
   {
      return lastName;
   }
   
   /**
      Getter method
      @return Person's address
   */
   public String getAddress()
   {
      return address;
   }
   
   /**
      Getter method
      @return Person's email
   */
   public String getEmail()
   {
      return email;
   }
   
   /**
      Getter method
      @return Person's phone number
   */
   public String getPhone()
   {
      return phoneNumber;
   }
   
   /**
      Transformer method
      @param first Person's new first name
      @param last Person's new last name
   */
   public void changeName(String first, String last)
   {
      if (first != null && last != null)
      {
         firstName = first;
         lastName = last;
      }
      else
         System.out.println("Name cannot be blank.");
   }
   
   /**
      Transformer method
      @param first Person's new first name
   */
   public void changeFirst(String first)
   {
      if (first != null)
         firstName = first;
      
      else
         System.out.println("Name cannot be blank.");
   }
   
   /**
      Transformer method
      @param last Person's new last name
   */
   public void changeLast(String last)
   {
      if (last != null)
         lastName = last;
      
      else
         System.out.println("Name cannot be blank.");
   }
   
   /**
      Transformer method
      @param addr Person's new address
   */
   public void changeAddress(String addr)
   {
      address = addr;
   }
   
   /**
      Transformer method
      @param email Person's new email
   */
   public void changeEmail(String email)
   {
      this.email = email;
   }
   
   /**
      Transformer method
      @param phone Person's new phone number
   */
   public void changePhone(String phone)
   {
      phoneNumber = phone;
   }

   /**
      Getter method
      @return String of information on person, separated by tabs for placement in a file
   */ 
   public String displayWrite()
   {
      String returnString = this.getFirstName();
      returnString += "\t" + this.getLastName();
      returnString += "\t" + this.getAddress();
      returnString += "\t" + this.getEmail();
      returnString += "\t" + this.getPhone();
      return returnString;
   }
   
   /**
      Getter method, compares names
      @param obj Object being compared
      @return True or false if the objects are equal
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
         Person person = (Person) obj; 
         return (this.firstName.equals(person.firstName) &&
                 this.lastName.equals(person.lastName)); 
      }
   }
   
   public int compareTo(Person other)
   // Precondition: 'other' is not null
   //
   // Compares this Person with 'other' for order. Returns a 
   // negative integer, zero, or a positive integer as this object 
   // is less than, equal to, or greater than 'other'.
   {
     if (!this.lastName.equals(other.lastName))
       return this.lastName.compareToIgnoreCase(other.lastName);
     else
       return this.firstName.compareToIgnoreCase(other.firstName);
   }
   
   
   public static Comparator<Person> lastNameComparator()
   {
      return new Comparator<Person>()
      {
         public int compare(Person element1, Person element2)
         {
           return (element1.lastName.compareTo(element2.lastName));
         }
      };
   }

}