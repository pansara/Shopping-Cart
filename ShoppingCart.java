package assignment2;

/**
 * SHIVANI PANSARA
 * STUDENT ID: 104874374
 */

//All the methods to import
import java.util.*;
import java.io.*;
import java.lang.Object;
import java.util.Arrays;

/***
 * 
 * @author SHIVANI PANSARA
 *This is the main Shopping Class cart in which there are several menu options and it maintains the cart
 */
public class ShoppingCart {
	
	//global variable so all methods can access for ease
	static item[] i = new item[100];	
	public static void main(String[] args)
	{
		//Scanner one to scan integer and another to scan string
		Scanner sc = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
		
		//counter to count the number of items
		int c = 0;
		
		//menu list that displays all the possible methods
		System.out.println("SHOPPING CART\nMenu:\n1.Add item (book or gift)\n2.Display all items\n3.Display only book sorted by authors name\n4.Display only gifts sorted by authors name\n5.Delete an item by item_id\n6.Purchase an item\n7.Save the inventory list in the file\n8.Load the inventory list from the file\nEnter your choice (0 to exit):");
		int a = sc.nextInt();
		
		//loop till the user wants to use it
		while (a!=0)
		{
			//switch case to access each case according to the choice entered
			switch(a)
			{
			//case to add items in the list i.e. a book or a gift
			case 1:
				//asks if it is a book or a gift and proceed accordingly
				System.out.println("book or gift?(Enter b or g):");
				String b = s.next();
				//calls the add method 
				c = Add(b, c);
				break;
			
			//case to display all the items in the inventory list whether it is a book or a gift
			case 2:
				
				//check if the item array is  not empty if it is not empty then display all the items else it will display the error message
				if(i[0] != null)
				{
					//display format
					System.out.printf("%-40s %-10s %-10s %-10s\n", "Name", "ID", "Quantity", "Price");
					//loop to display each item
					for(int j = 0; j < c; j++)
					{
						Display(j);
					}
				}
				else
				{
					System.out.println("Cart is empty!!");
				}
				break;
				
			//case to sort the books according to author and display	
			case 3:
				//create array of item with instance of book
				item[] d = new book[10];
				int l=0;
				for(int k = 0; k < c; k++)
				{
					//check if it is a book that stores in the created array
					if (i[k] instanceof book)
					{
						d[l++] = i[k];
					}
				}
				//sorts and displays the book
				Sort_Books(d, l);
				break;
			
			//create array of item with instance of gift	
			case 4:
				item[] g = new gift[10];
				int v=0;
				for(int k = 0; k < c; k++)
				{
					//check if it is a gift that stores in the created array
					if (i[k] instanceof gift)
					{
						g[v++] = i[k];
					}
				}
				//sorts and displays the gift
				Sort_Gifts(g, v);
				break;
				
			//case to delete the item by item id	
			case 5:
				//asks the user to enter the id of the item they want to delete
				System.out.println("Enter the item id you want to delete: ");
				int id = sc.nextInt(); 
				//deletes the item
				c = delete_Item(c, id);
				System.out.println("Item with item id "+id+" removed from the cart");
				break;
				
			//case to purchase the item with the item id	
			case 6:
				//asks the user to enter the id of the item they want to purchase
				System.out.println("Enter the id of the item you want to purchase");
				int id_ = sc.nextInt();
				//purchases the item
				c = purchase_Item(id_, c);
				break;
				
			//case to save the inventory in the file	
			case 7:
				//asks the user to enter the filename in which they want to store
				System.out.println("Enter the name of the file in which you want to save the data: ");
				String filename = s.next();
				//saves the items in the file
				save_Items(c, filename);
				System.out.println("Inventory saved in file");
				break;
				
			//load the data from the filename entered
			case 8:
				//asks the user to enter the filename from which they want to load the data
				System.out.println("Enter the name of the file from which you want to load the data: ");
				String file = s.next();
				//loads the file into the item array
				c = load_Items(file);
				System.out.println("Item list loaded from the file");
				break;
			case 0:
				break;
			}
			System.out.println("\nSHOPPING CART\nMenu:\n1.Add item (book or gift)\n2.Display all items\n3.Display only book sorted by authors name\n4.Display only gifts sorted by authors name\n5.Delete an item by item_id\n6.Purchase an item\n7.Save the inventory list in the file\n8.Load the inventory list from the file\nEnter your choice (0 to exit):");
			a = sc.nextInt();
		}
	}
	
	/**
	 * This method takes two parameters and return the number of items add or say the next index of the array when the nex item will be added
	 * @param b	tells whether it is a book or a gift b or g
	 * @param c	gives the index if the item i array
	 * @return next index of the array
	 */
	public static int Add(String b, int c)
	{
		//scanner to scan the entered details
		Scanner s = new Scanner(System.in);
		
		//condition if it is a book (b) or gift (g)
		if(b.equalsIgnoreCase("b"))
		{
			//asks the user to enter the needed details one after the other
			System.out.println("Enter the name of author, title, year, price and quantity one after the other:");
			
			//scans the details
			String a = s.nextLine();
			String t = s.nextLine();
			int y = s.nextInt();
			double p = s.nextDouble();
			int q = s.nextInt();
			//creates an instance of type book and stores it
			i[c++] = new book(p, q, a, t, y);
			return c;
		}
		else if (b.equalsIgnoreCase("g"))
		{
			//aks the user to enter the necessary details
			System.out.println("Enter the label, manufacturer, price and quantity one after the other:");
			
			//scans it
			String l = s.nextLine();
			String m = s.nextLine();
			double p = s.nextDouble();
			int q = s.nextInt();
			//creates an instance of type gift and stores it
			i[c++] = new gift(p, q, l, m);
			return c;
		}
		else
		{
			System.out.println("Invalid Input!!");
			return c;
		}
	}
	
	/**
	 * This method display all the items in the inventory list 
	 * @param j is the index of the item which is needed to be displayed
	 */
	public static void Display(int j)
	{
		//calls the Display method of the particular class and prints the output
		i[j].Display();
	}
	
	/**
	 * This is the overloaded method of the Display which also takes an array as a parameter
	 * @param i	item array to display
	 * @param j index of that array to display
	 */
	public static void Display(item[] i, int j)
	{
		//calls the Display method of the particular class and prints the output
		i[j].Display();
	}
	
	/**
	 * This method sorts the item books according to their author names and then displays it
	 * @param d item array to sort
	 * @param l number of items in that array
	 */
	public static void Sort_Books(item[] d, int l)
	{
		//temporary item to swap
		item temp;
		
		//sorts according to the insertion sort
		for(int j=0; j<l-1; j++)
		{
			for(int i=j+1; i < l; i++)
			{
				//condition to compare two strings
				if(d[j].getAuthor().compareToIgnoreCase(d[i].getAuthor()) > 0)
				{
					//if the condition succeeded than it swaps 
					temp = d[j];
					d[j] = d[i];
					d[i] = temp;
				}
			}
		}
		//displays the output
		System.out.printf("%-40s %-10s %-10s %-10s\n", "Name", "ID", "Quantity", "Price");
		for(int j = 0; j < l; j++)
		{
			Display(d, j);
		}
	}
	
	/**
	 * This method sorts the item gifts according to their labels and then displays it
	 * @param d item array to sort
	 * @param l number of items in that array
	 */
	public static void Sort_Gifts(item[] d, int l)
	{
		//temporary item to swap
		item temp;
		
		//sorts according to the insertion sort
		for(int j=0; j<l-1; j++)
		{
			for(int i=j+1; i < l; i++)
			{
				//condition to compare two strings
				if(d[j].getLabel().compareToIgnoreCase(d[i].getLabel()) > 0)
				{
					//if the condition succeeded than it swaps 
					temp = d[j];
					d[j] = d[i];
					d[i] = temp;
				}
			}
		}
		//displays the output
		System.out.printf("%-40s %-10s %-10s %-10s\n", "Name", "ID", "Quantity", "Price");
		for(int j = 0; j < l; j++)
		{
			Display(d, j);
		}
	}
	
	/**
	 * This method deletes the item according to the id of the item user entered to delete
	 * @param c number of items in an array
	 * @param id id of the item that wants to delete
	 * @return c returns the new number of items in array after deleting
	 */
	public static int delete_Item(int c, int id)
	{
		//initial index to -1
		int index = -1;
		//loops through to find the item with that id
		for(int j=0; j<c; j++)
		{
			//condition to compare and get that item
			if(i[j].item_id == id)
			{
				//index changes to that index with that id
				index = j;
			}
		}
		//condition to check if the has changed and of yes that it deletes that item 
		if(index >= 0)
		{
			//shifts all the items to fill the empty space created after deleting that item
			for(int k=index; k < c-1; k++)
			{
				i[k] = i[k+1];
			}
			//sets the item to be deleted to null
			i[c-1] = null;
			return c-1;
		}
		//by default condition if no such item found
		else
		{
			System.out.println("No such item id found!");
			return c;
		}
	}
	
	/**
	 * This method purchases the item according to the item id and the amount they want to purchase of that item
	 * @param id_ id of the item user want to purchase
	 * @param c the number of items user have in the inventory
	 * @return the number of items remaining in the inventory
	 */
	public static int purchase_Item(int id_, int c)
	{
		Scanner sc = new Scanner(System.in);
		int index = -1;
		//finds the item with that id
		for(int j=0; j<c; j++)
		{
			if(i[j].item_id == id_)
			{
				index = j;
			}
		}
		if(index >= 0)
		{
			//asks the user to enter the quantity they want to purchase of that item
			System.out.println("Enter the quantity you want to purchase");
			int qty;			
			qty = sc.nextInt();
			
			//if the entered quantity is equal to the quantity in the cart
			if(i[index].getQuantity() == qty)
			{
				//that otem will be deleted from the inventory
				c = delete_Item(c, id_);
				System.out.println("Item with ID "+id_+" purchased");
			}
			//if the quantity is greater that the available in the cart that show error message
			else if(i[index].getQuantity() < qty)
			{
				System.out.println("Quantity entered is not available in the shopping cart. Please enter again!!");
			}
			//if the quantity is smaller than that available in cart than subtract that much quantity 
			else if(i[index].getQuantity() > qty)
			{
				i[index].setQuantity(i[index].getQuantity() - qty);
				//calls the Purchased method to display the message
				i[index].Purchased(qty);
			}
		}
		else	//by default message
		{
			System.out.println("Item with ID " + id_ + " not found");
		}
		return c;
	}
	
	/**
	 * This method saves the items in the inventory into a file
	 * @param c total items in the list
	 * @param filename name of file in which to store
	 */
	public static void save_Items(int c, String filename)
	{
			try
	        {
				FileOutputStream file = new FileOutputStream(filename); 
	            ObjectOutputStream out = new ObjectOutputStream(file);  
	            //read the objects to the file
		        out.writeObject(i); 
	             
		        //closes the file
	            out.close(); 
	            file.close();
	        } 
			
			//throws IO exception
			catch(IOException ex)
			{
				 System.out.println("IOException is caught");
			}
			
	}
	
	/**
	 * This method loads the data from the file 
	 * @param filename	name of file from which to enter data
	 * @return return the number of elements loaded
	 */
	public static int load_Items( String filename)
	{
		int count = 0;
		try
        {
            FileInputStream fi = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fi);
            //read the objects from file
            i = (item[]) in.readObject();
            
            //closes file
            in.close(); 
            fi.close();
        } 
		//throws IO Exception
		catch(IOException ex)
		{
			 System.out.println("IOException is caught");
		}
		
		//throws the Class Not Found Exception
		catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
		
		//count the number of elements in the file
		 for(int j=0; j<i.length&&i[j]!=null; j++) {
			 count++;
	        }
		return count;
	}
}
