package assignment2;
/*
 * this is book class having author, title and year as the attributes and also Displayed and Purchased as the methods from the abstract class also this class implements the interface serializable
 */
public class book extends item implements java.io.Serializable {
	//attributes that are set to the default values
	protected String author = "";
	protected String title = "";
	protected int year = 2018;
	
	//overloaded constructor that invokes the overloaded constructor of the super class to derive it's values
	public book(double price, int quantity, String author, String title, int year)
	{
		super(price, quantity);
		setAuthor(author);
		setTitle(title);
		setYear(year);
	}
	
	//access methods to set and get the values 
	
	/*
	 * gives the condition of input and if the condition satisfies it sets the name of the author to the entered value or it sets its name to default
	 */
	public void setAuthor(String author)
	{
		//check condition
		if(author.length() > 0)
		{
			this.author = author;
		}
	}
	
	/*
	 * gives the condition of input and if the condition satisfies it sets the name of title to the entered value or it sets its name to default
	 */
	public void setTitle(String title)
	{
		//check condition
		if(title.length() > 0)
		{
			this.title = title;
		}
	}
	
	/*
	 * gives the condition of input and if the condition satisfies it sets the value of year to the entered value or it sets it value to default
	 */
	public void setYear(int year)
	{
		//check condition
		if (year <= 2018 && year >=1800)
		{
			this.year = year;
		}
		else
		{
			this.year = 2018;
		}
	}
	
	/*
	 * get method of the author to access the entered name of the author(non-Javadoc)
	 * @	Override
	 */
	public String getAuthor()
	{
		return author;
	}
	
	/*
	 * get method of the title to access the entered name of the title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/*
	 * get method of the year to access the entered value of the year
	 */
	public int getYear()
	{
		return year;
	}
	
	/*
	 * Displays the output (non-Javadoc)
	 * @see assignment2.item#Display()
	 */
	protected void Display()
	{
		//System.out.println("author: "+author + " title: "+ title + " year: " + year + " id: " + item_id + " price: " + price + " quantity: " + quantity);
		System.out.printf("book:author:%-30s%-10s%-10s %-10s\n", author, item_id, quantity, price);
		System.out.printf("     title:%s\n     year publlished:%s\n", title, year);
	}
	
	/*
	 * Displays the purchased items according to the item id and the amount of quantity remaining in it as well(non-Javadoc)
	 * @see assignment2.item#Purchased(int)
	 */
	protected void Purchased(int qty)
	{
		System.out.println(qty+" quantity purchased of item with id "+item_id+" from the inventory");
		System.out.println("Now "+quantity+" remaining");
	}
	
	//toString a by default output string
	public String toString()
	{
		return "author: "+author + " title: "+ title + " year: " + year + " id: " + item_id + " price: " + price + " quantity: " + quantity + "\n";
	}
}
