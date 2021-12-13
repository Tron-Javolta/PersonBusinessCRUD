/**
   BusinessPersonApplication.java
   
   Programmer: Nicholas Souder
   
   App that stores, views, and manipulates contacts
*/

import java.util.*;
import java.io.*;

import support.BSTNode;


public class BusinessPersonContactsApplication
{
   public static void main(String[] args)
   {
      boolean running = true; // continues program
      
      Scanner keyboard = new Scanner(System.in);
      
      int numberInput; // used for deciding the route of options
      
      // Separate trees for contact data
      BinarySearchTree<Business> businessTree = new BinarySearchTree<Business>();
      BinarySearchTree<Person> personTree = new BinarySearchTree<Person>();
      
      // Contact information variables
      String wordInput, fName, lName, business, address, email, website, phoneNumber;
      
      System.out.println("Welcome to the Business/Person contact application.");
      System.out.println("--------------------------------------------------");
      
      System.out.println("Loading current contacts...");
      
      // ArrayLists for file data
      ArrayList<Person> persons = new ArrayList<Person>();
      ArrayList<Business> businesses = new ArrayList<Business>();
      
      // Read person file to arraylist
      try
      {
         BufferedReader buf = new BufferedReader(new FileReader("MOCK_DATA_P.txt"));
         String lineJustFetched = null;
         String[] wordsArray; // holds line of data separated by tabs
         Person creationPerson;
         
         // Read each line and create a Person object
         while (true)
         {
            lineJustFetched = buf.readLine();
            if (lineJustFetched == null)
               break;
            
            else
            {
               wordsArray = lineJustFetched.split("\t");

               // with the wordsArray, put each index as the person object's item and add it to the arraylist
               creationPerson = new Person(wordsArray[0], wordsArray[1], wordsArray[2], wordsArray[3], wordsArray[4]);
               persons.add(creationPerson);
            }
         }
         
         buf.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

      // Sorts ascending, sorted for balance method to add arraylist to tree
      Collections.sort(persons);
      
      // Method creates a balanced tree using the persons ArrayList
      personTree.balance(persons, persons.size()-1);
      
      // Read business file to arraylist
      try
      {
         BufferedReader buf = new BufferedReader(new FileReader("MOCK_DATA_B.txt"));
         String lineJustFetched = null;
         String[] wordsArray; // holds line of data separated by tabs
         Business creationBusiness;
         
         // Read each line and create a Business object
         while (true)
         {
            lineJustFetched = buf.readLine();
            if (lineJustFetched == null)
               break;
               
            else
            {
               wordsArray = lineJustFetched.split("\t");
               
               // with the wordsArray, put each index as the business object's item and add it to the arraylist
               creationBusiness = new Business(wordsArray[0], wordsArray[1], wordsArray[2], wordsArray[3], wordsArray[4]);
               businesses.add(creationBusiness);
            }
         }
         
         buf.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      
      // Sorts businesses arraylist ascending, needed for binary search tree balance method
      Collections.sort(businesses);
      
      // Method creates a balanced tree using the businesses arraylist
      businessTree.balance(businesses, businesses.size()-1);
      
      
      System.out.println("\n\nLoading complete.");
      System.out.println("-----------------------");
      
      
      while (running)
      {
         System.out.println("What would you like to do?\n");
         System.out.println("1. Create new contact\n" +
                            "2. View current contacts\n" +
                            "3. Update a contact\n" + 
                            "4. Delete a contact\n");
         
         System.out.print("Choose option: ");
         
         while (!keyboard.hasNextInt())
         {
            System.out.println("Incorrent input, please try again.");
            System.out.println("What would you like to do?\n");
            System.out.println("1. Create new contact\n" +
                            "2. View current contacts\n" +
                            "3. Update a contact\n" + 
                            "4. Delete a contact\n");
           
            System.out.print("Choose option: ");
           
            keyboard.next();
         } 

         numberInput = keyboard.nextInt();
         keyboard.nextLine();
         
         // Create new contact
         if (numberInput == 1)
         {
            System.out.println("\nCreating new contact");
            System.out.println("-----------------------");
            System.out.println("1. Person\n2. Business");
            System.out.print("\nChoose option: ");
               
            while (!keyboard.hasNextInt())
            {
               System.out.println("\nIncorrect input, please try again.");
               System.out.println("1. Person\n2. Business");
               System.out.print("\nChoose option: ");
                  
               keyboard.next();
            }
               
            numberInput = keyboard.nextInt();
            keyboard.nextLine();
               
            // adding new person
            if (numberInput == 1)
            {
               System.out.println("\nCreating new person contact.");
               System.out.println("----------------------------");
                     
               System.out.print("\nFirst Name: ");
               fName = keyboard.nextLine();
                     
               System.out.print("\nLast Name: ");
               lName = keyboard.nextLine();
                     
               System.out.print("\nAddress: ");
               address = keyboard.nextLine();
                     
               System.out.print("\nEmail: ");
               email = keyboard.nextLine();
                     
               System.out.print("\nPhone Number: ");
               phoneNumber = keyboard.nextLine();
                     
               // Create a new Person object with given information and add to the BST
               Person newPerson = new Person(fName, lName, address, email, phoneNumber);
               personTree.add(newPerson);
               
               System.out.println("\nPerson successfully added.");
               System.out.println("----------------------------");
            }
            
            // adding new business
            else if (numberInput == 2)
            {
               System.out.println("\nCreating new business contact.");
               System.out.println("------------------------------");
                     
               System.out.print("Business Name: ");
               business = keyboard.nextLine();
                     
               System.out.print("Address: ");
               address = keyboard.nextLine();
                     
               System.out.print("Email: ");
               email = keyboard.nextLine();
                     
               System.out.print("Website: ");
               website = keyboard.nextLine();
                     
               System.out.print("Phone Number: ");
               phoneNumber = keyboard.nextLine();
                     
               // make new business object for BST
               Business newBusiness = new Business(business, address, email, website, phoneNumber);
               businessTree.add(newBusiness);
               
               System.out.println("\nBusiness successfully added.");
               System.out.println("------------------------------");
            }
               
            else
            {
               System.out.println("\nInvalid choice.");
               System.out.println("-----------------");
            }
         }
         
         // view current contacts
         else if(numberInput == 2)
         {
            System.out.println("\nViewing current contacts.");
            System.out.println("-------------------------");
               
            System.out.println("\n1. Person contacts");
            System.out.println("2. Business contacts");
            System.out.print("\nChoose option: ");
               
            while (!keyboard.hasNextInt())
            {
               System.out.println("\nIncorrect input, please try again.");
               System.out.println("1. Person\n2. Business");
               System.out.print("\nChoose option: ");
                  
               keyboard.next();
            }
               
            numberInput = keyboard.nextInt();
            keyboard.nextLine();
               
            // Person viewing
            if (numberInput == 1)
            {
               System.out.println("\nViewing contacts");
               System.out.println("-----------------");
               System.out.println("\n1. Ascending order");
               System.out.println("2. Descending order");
               System.out.print("\nChoose option: ");
                  
               while (!keyboard.hasNextInt())
               {
                  System.out.println("\nIncorrect input, please try again.");
                  System.out.println("1. Ascending order\n2. Descending order");
                  System.out.print("\nChoose option: ");
                  
                  keyboard.next();
               }
                  
               numberInput = keyboard.nextInt();
               keyboard.nextLine();
                  
               // ASCENDING
               if (numberInput == 1)
               {
                  // ascending order sort of persons arraylist
                  Collections.sort(persons);
                     
                  // ask for filter term to compare to persons in tree
                  // put them in array to be printed
                  System.out.print("\nEnter search term: ");
                  String searchTerm = keyboard.nextLine();
                  searchTerm = searchTerm.toLowerCase();
                  System.out.println("--------------------------");
                     
                  ArrayList<Person> filterPeople = new ArrayList<Person>();
                     
                  // search tree for those terms
                  for (int i = 0; i < persons.size(); i++)
                  {
                     if (persons.get(i).getLastName().toLowerCase().substring(0,searchTerm.length()).equals(searchTerm))
                        filterPeople.add(persons.get(i));
                  }
                     
                  // Display in ascending order
                  for (int i = 0; i < filterPeople.size(); i++)
                  {
                     System.out.println();
                     System.out.println("Name: " + filterPeople.get(i).getFormalName());
                     System.out.println("Address: " + filterPeople.get(i).getAddress());
                     System.out.println("Email: " + filterPeople.get(i).getEmail());
                     System.out.println("Phone Number: " + filterPeople.get(i).getPhone());
                     System.out.println("--------------------------");
                  }
               }
                  
               // DESCENDING
               else if (numberInput == 2)
               {
                  // descending order sort of persons arraylist
                  Collections.sort(persons, Collections.reverseOrder());
                     
                  // ask for filter term to compare to persons in tree
                  // put them in array to be printed
                  System.out.print("\nEnter search term: ");
                  String searchTerm = keyboard.nextLine();
                  System.out.println("--------------------------");
                     
                  ArrayList<Person> filterPeople = new ArrayList<Person>();
                     
                  // search tree for those terms
                  for (int i = 0; i < persons.size(); i++)
                  {
                     if (persons.get(i).getLastName().substring(0,searchTerm.length()).equals(searchTerm))
                           filterPeople.add(persons.get(i));
                  }
                     
                  // Display in ascending order
                  for (int i = 0; i < filterPeople.size(); i++)
                  {
                     System.out.println();
                     System.out.println("Name: " + filterPeople.get(i).getFormalName());
                     System.out.println("Address: " + filterPeople.get(i).getAddress());
                     System.out.println("Email: " + filterPeople.get(i).getEmail());
                     System.out.println("Phone Number: " + filterPeople.get(i).getPhone());
                     System.out.println("--------------------------");
                  }
                     
               }
               else
                  System.out.println("\nInvalid choice.");
            }
               
            // Business viewing
            else if (numberInput == 2)
            {
               System.out.println("1. Ascending order");
               System.out.println("2. Descending order");
               System.out.print("\nChoose option: ");
                  
               while (!keyboard.hasNextInt())
               {
                  System.out.println("\nIncorrect input, please try again.");
                  System.out.println("1. Ascending order\n2. Descending order");
                  System.out.print("\nChoose option: ");
                  
                  keyboard.next();
               }
                  
               numberInput = keyboard.nextInt();
               keyboard.nextLine();
                  
               // ASCENDING
               if (numberInput == 1)
               {
                  // ascending sort of businesses arraylist
                  Collections.sort(businesses);
                     
                  // ask for filter
                  System.out.print("\nEnter search term: ");
                  String searchTerm = keyboard.nextLine();
                  System.out.println("--------------------------");
                     
                  ArrayList<Business> filterBusiness = new ArrayList<Business>();
                     
                  // search tree for those terms
                  for (int i = 0; i < businesses.size(); i++)
                  {
                     if (businesses.get(i).getBusiness().substring(0,searchTerm.length()).equals(searchTerm))
                        filterBusiness.add(businesses.get(i));
                  }
                  // print each business's information
                  for (int i = 0; i < filterBusiness.size(); i++)
                  {
                     System.out.println();
                     System.out.println("Business: " + filterBusiness.get(i).getBusiness());
                     System.out.println("Address: " + filterBusiness.get(i).getAddress());
                     System.out.println("Email: " + filterBusiness.get(i).getEmail());
                     System.out.println("Website: " + filterBusiness.get(i).getWeb());
                     System.out.println("Phone Number: " + filterBusiness.get(i).getPhoneNumber());
                     System.out.println("--------------------------");
                  }

               }
                  
               // DESCENDING
               else if (numberInput == 2)
               {
                  // descending order sort of businesses arraylist
                  Collections.sort(businesses, Collections.reverseOrder());
                     
                  // ask for filter
                  System.out.print("\nEnter search term: ");
                  String searchTerm = keyboard.nextLine();
                  System.out.println("--------------------------");
                     
                  ArrayList<Business> filterBusiness = new ArrayList<Business>();
                     
                  // search tree for those terms
                  for (int i = 0; i < businesses.size(); i++)
                  {
                     if (businesses.get(i).getBusiness().substring(0,searchTerm.length()).equals(searchTerm))
                        filterBusiness.add(businesses.get(i));
                  }
                  
                  // print each business's information
                  for (int i = 0; i < filterBusiness.size(); i++)
                  {
                     System.out.println();
                     System.out.println("Business: " + filterBusiness.get(i).getBusiness());
                     System.out.println("Address: " + filterBusiness.get(i).getAddress());
                     System.out.println("Email: " + filterBusiness.get(i).getEmail());
                     System.out.println("Website: " + filterBusiness.get(i).getWeb());
                     System.out.println("Phone Number: " + filterBusiness.get(i).getPhoneNumber());
                     System.out.println("--------------------------");
                  }
               }
               // Invalid choice for order
               else
                  System.out.println("\nInvalid choice.");
            }
               
            // Invalid viewing choice (Person or business)
            else
               System.out.println("\nInvalid choice.");
         }
            
         // update contact
         else if (numberInput == 3)
         {
            System.out.println("\nUpdating contact");
            System.out.println("-----------------");
               
            System.out.println("\n1. Update person contact");
            System.out.println("2. Update business contact");
            System.out.print("\nChoose option: ");
               
            while (!keyboard.hasNextInt())
            {
               System.out.println("\nIncorrect input, please try again.");
               System.out.println("1. Update person contact\n2. Update business contact");
               System.out.print("\nChoose option: ");
                  
               keyboard.next();
            }
                  
            numberInput = keyboard.nextInt();
            keyboard.nextLine();
               
            // update person contact
            if (numberInput == 1)
            {
               System.out.println();
                  
               // Search for contact to update in BST
               System.out.print("Enter last name of person you would like to update: ");
               String searchTerm = keyboard.nextLine();
                  
                  
               // traverse binary search tree to find this person
               try
               {
                  // Grab said person and hold it for updating its information
                  Person updatePerson = personTree.getPerson(searchTerm).getInfo();
                  System.out.println("\nPerson found.");
                  System.out.println("-------------");
                  System.out.println();
                  personTree.remove(updatePerson);
                     
                  System.out.print("Updated First Name: ");
                  updatePerson.changeFirst(keyboard.nextLine());
                  
                  System.out.print("Updated Last Name: ");
                  updatePerson.changeLast(keyboard.nextLine());
                  
                  System.out.print("Updated Address: ");
                  updatePerson.changeAddress(keyboard.nextLine());
                  
                  System.out.print("Updated Email: ");
                  updatePerson.changeEmail(keyboard.nextLine());
                     
                  System.out.print("Updated Phone Number: ");
                  updatePerson.changePhone(keyboard.nextLine());
                  
                  personTree.add(updatePerson);
                  
                  System.out.println("Person successfully updated.");
                  System.out.println("----------------------------");
               }
                  
               catch (Exception e)
               {
                  System.out.println("\nPerson not found.");
               }
                  
            }
               
            // update business contact
            else if (numberInput == 2)
            {
               System.out.println();
                  
               
               System.out.print("Enter the name of the business you would like to update: ");
               String searchTerm = keyboard.nextLine();
               
               // Grab business from BST for updating information   
               try
               {
                  Business updateBusiness = businessTree.getBusiness(searchTerm).getInfo();
                  System.out.println("\nBusiness found.");
                  businessTree.remove(updateBusiness);
                     
                  System.out.print("Updated Business Name: ");
                  updateBusiness.changeBusiness(keyboard.nextLine());
                  
                  System.out.print("Updated Address: ");
                  updateBusiness.changeAddress(keyboard.nextLine());
                  
                  System.out.print("Updated Email: ");
                  updateBusiness.changeEmail(keyboard.nextLine());
                  
                  System.out.print("Updated Website: ");
                  updateBusiness.changeWeb(keyboard.nextLine());
                     
                  System.out.print("Updated Phone Number: ");
                  updateBusiness.changeNumber(keyboard.nextLine());
                  
                  businessTree.add(updateBusiness);
                  System.out.println("Business succesfully updated.");
                  System.out.println("-----------------------------");
               }
               catch (Exception e)
               {
                  System.out.println("\nBusiness not found.");
               }
            }
               
            else
                System.out.println("\nInvalid choice.");
         }
            
         // Delete contact
         else if (numberInput == 4)
         {
            System.out.println("\nContact deletion");
            System.out.println("-----------------");
            System.out.println();
            System.out.println("1. Person\n2. Business");
            System.out.print("\nChoose option: ");
               
            while (!keyboard.hasNextInt())
            {
               System.out.println("\nIncorrect input, please try again.");
               System.out.println("1. Person\n2. Business");
               System.out.print("\nChoose option: ");
                  
               keyboard.next();
            }
                  
            numberInput = keyboard.nextInt();
            keyboard.nextLine();
               
            // Person delete
            if (numberInput == 1)
            {
               System.out.print("\nEnter last name of the contact you wish to delete: ");
                  
               wordInput = keyboard.nextLine();
               
               // Find node of person to delete, save to variable and remove from BST
               try
               {
                  Person deletePerson = personTree.getPerson(wordInput).getInfo();
                  personTree.remove(deletePerson);
                  System.out.println("Successfully deleted contact.");
                  System.out.println("-----------------------------");
               }
               catch (Exception e)
               {
                  System.out.println("\nContact not found.");
               }
                  
            }
               
            // Business delete
            else if (numberInput == 2)
            {
               System.out.print("\nEnter the business name you wish to delete: ");
                  
               wordInput = keyboard.nextLine();
                  
               // Find node of business to delete, save to variable and remove from BST
               try
               {
                  Business deleteBusiness = businessTree.getBusiness(wordInput).getInfo();
                  businessTree.remove(deleteBusiness);
                  System.out.println("\nSuccessfully deleted contact.");
                  System.out.println("-------------------------------");
               }
               catch (Exception e)
               {
                  System.out.println("\nContact not found.");
               }
            }
               
            else
               System.out.println("\nInvalid choice.");
         }
            
         // Invalid choice of what to do from main menu
         else
         {
             System.out.println("\nInvalid choice.");
         }

         // clear numberInput at the end
         numberInput = 0;
         
         // ask user if they'd like to continue
         System.out.print("\nContinue? (Y/N) ");
         wordInput = keyboard.nextLine();
         
         char answer = wordInput.charAt(0);
         
         if (answer == 'Y' || answer == 'y')
         {
            System.out.println("------------------\n");
            running = true;
         }
         
         else
         {
            running = false;
            System.out.println("\nApplication will now update information to file.");
         }
      }
      
      // Person file update
      try
      {
         // rewrite the text file of information
         FileWriter fw = new FileWriter("MOCK_DATA_P.txt", false);
         
         // traverse binary search tree
         Iterator<Person> iter = personTree.getIterator(BSTInterface.Traversal.Inorder);
         Person hold;
         while (iter.hasNext())
         {
            hold = iter.next();
            
            // Separate information by new line to keep from stacking information in file
            fw.write(hold.displayWrite()+System.getProperty("line.separator"));
         }
         fw.close();
      }
      catch (Exception e)
      {
         System.out.println("\nPerson file could not be written.");
      }
      
      // Business file update
      try
      {
         FileWriter fw = new FileWriter("MOCK_DATA_B.txt", false);
         
         // traverse binary search tree
         Iterator<Business> iter2 = businessTree.getIterator(BSTInterface.Traversal.Inorder);
         Business hold;
         while (iter2.hasNext())
         {
            hold = iter2.next();
            
            // Separate information by new line to keep from stacking information in file
            fw.write(hold.displayWrite() + System.getProperty("line.separator"));
         }
         fw.close();
      }
      catch (Exception e)
      {
         System.out.println("\nBusiness file could not be written.");
      }
      System.out.println("-------------------------");
      System.out.println("Files updated, goodbye.");
   }
}