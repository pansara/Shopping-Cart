package assignment2;
/*
 * This is an abstract class having price and quantity as attributes and two abstract methods Displayed and Purchased and also implements serializable methods to serialize and deserialize the items in the file
 */
public abstract class item implements java.io.Serializable {
	//attributes of protected type so that all it's derived classes can have access to it
	
	protected int item_id;
	protected double price;
	protected int quantity;
	static int counter = 0;				//static counter to keep only one instance of it amongst all the classes and increment it as the item is added to the list
	
	//default constructor
	public item()
	{
		price = 0;
		quantity = 0;
	}
	
	//overloaded constructor that also invokes the default constructor and sets it's value to the entered values
	public item(double price, int quantity)
	{
		this();
		setPrice(price);
		setQuantity(quantity);
		item_id = ++counter;		//increments the id with the addition of the price in list
	}
	
	//access methods to set and get the values
	
	/*
	 * gives the condition of input and if the condition satisfies it sets the value of price to the entered value or it sets it value to default
	 */
	public void setPrice(double price)
	{
		//condition to check the validity
		if(price > 0)
		{
			this.price = price;
		}
	}
	
	/*
	 * gives the condition of input and if the condition satisfies it sets the value of price to the entered value or it sets it value to default
	 */
	public void setQuantity(int quantity)
	{
		//condition th check the validity
		if(quantity > 0)
		{
			this.quantity = quantity;
		}
	}
	
	/*
	 * get method of the author to do the method override in the book class
	 */
	public String getAuthor()
	{
		return "";
	}
	
	/*
	 * get method of the label to do the method override in the book class
	 */
	public String getLabel()
	{
		return "";
	}
	
	/*
	 * get method of the price to access the entered value of the price
	 */
	public double getPrice()
	{
		return price;
	}
	
	/*
	 * get method of the quantity to access the entered value of the quantity
	 */
	public int getQuantity()
	{
		return quantity;
	}
	
	//abstract methods to introduce it in the derived class
	protected abstract void Display();
	
	protected abstract void Purchased(int qty);
	

}
