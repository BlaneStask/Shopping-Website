package shopc;

public class item{
	int number;
	String name;
	String category;
	double price;
	int quantity;
	public item(int nu, String na, String ca, double pr, int qu) {
		number = nu;
		name = na;
		category = ca;
		price = pr;
		quantity = qu;
	}
	/** This method returns value of item
	 * 
	 * @return		values to for item in cart
	 */
	public String toString(){
		return("Number:   " + number + "\n" +
		"Name:   " + name + "\n" +
		"Category:   " + category + "\n" +
		"Price:   " + price + "\n" +
		"Quantity:   " + quantity + "\n"
		);
	}
	
	public void stringtoFlat(){
		System.out.println(number + "	" + name + "			 $" + price);
	}
	/** This method returns number
	 * 
	 * @return	number
	 */
	public int getnumber(){
		return number;
	}
	/** This method returns name
	 * 
	 * @return	name
	 */
	public String getname(){
		return name;
	}
	/** This method returns category
	 * 
	 * @return	category
	 */
	public String getcategory(){
		return category;
	}
	/** This method returns price
	 * 
	 * @return	price
	 */
	public double getprice(){
		return price;
	}
	/** This method returns quantity
	 * 
	 * @return	quantity	
	 */
	public int getquantity(){
		return quantity;
	}
	/** This method sets number
	 */
	public void setnumber(int number){
		this.number = number;
	}
	/** This method sets name
	 */
	public void setname(String name){
		this.name = name;
	}
	/** This method sets category
	 */
	public void setcategory(String category){
		this.category = category;
	}
	/** This method sets price
	 */
	public void setprice(double price){
		this.price = price;
	}
	/** This method sets quantity
	 */
	public void setquantity(int quantity){
		this.quantity = quantity;
	}
}

