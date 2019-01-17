package assignment2;
/*
 * this is item class having label and manufacturer as the attributes and also Displayed and Purchased as the methods from the abstract class also this class implements the interface serializable
 */
public class gift extends item implements java.io.Serializable {
	//attributes
	protected String label = "";
	protected String manufacturer = "";
	
	//overloaded constructor that invokes the overloaded constructor of the super class to derive it's values
	public gift(double price, int quantity, String label, String manufacturer)
	{
		super(price, quantity);
		setLabel(label);
		setManufacturer(manufacturer);
	}
	
	//access methods to set and get the values
	
	/*
	 *  gives the condition of input and if the condition satisfies it sets the label of the gift to the entered value or it sets its label to default
	 */
	public void setLabel(String label)
	{
		//check condition
		if(label.length() > 0)
		{
			this.label = label;
		}
	}

	/*
	 *  gives the condition of input and if the condition satisfies it sets the name of the manufacturer to the entered value or it sets its name to default
	 */
	public void setManufacturer(String manufacturer)
	{
		//check condition
		if(manufacturer.length() > 0)
		{
			this.manufacturer = manufacturer;
		}
	}
	
	/*
	 *  get method of the label to access the entered label of the gift(non-Javadoc)
	 * @see assignment2.item#getLabel()
	 */
	public String getLabel()
	{
		return label;
	}
	
	/*
	 *  get method of the manufacturer to access the entered name of the manufacturer
	 */
	public String getManufacturer()
	{
		return manufacturer;
	}
	
	/*
	 * Displays the output(non-Javadoc)
	 * @see assignment2.item#Display()
	 */
	protected void Display()
	{
		//System.out.println("label: "+ label + " manufacturer: "+ manufacturer + " id: " + item_id + " price: " + price + " quantity: " + quantity);
		System.out.printf("gift:label:%-31s%-10s%-10s %-10s\n", label, item_id, quantity, price);
		System.out.printf("     manufacturer:%s\n", manufacturer);
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
		return "label: "+ label + " manufacturer: "+ manufacturer + " id: " + item_id + " price: " + price + " quantity: " + quantity + "\n";
	}
}
