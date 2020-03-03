/*
Author: Blane Staskiewicz
E-mail: bas6248@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 3
Due date: 3/03/2020
File: shopping_cart.java, item.java, shoppingC_list.txt
Purpose: Java application that is a shopping cart, uses Arraylists to
  enter new items into the cart and checkout with card.
Compiler/IDE: Java SE Development Kit 13.0.2/Eclipse Foundation
  IDE 2019-12
Operating system: macOS Catalina Version 10.15.2
Reference(s): Java 10 API - Oracle Documentation
  (https://docs.oracle.com/javase/10/docs/api/)
  Chapters 9, 10, 14 Lecture Slides
*/ 

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
	public String toString() {
		return ("Number:   " + number + "\n" +
		"Name:   " + name + "\n" +
		"Category:   " + category + "\n" +
		"Price:   " + price + "\n" +
		"Quantity:   " + quantity + "\n"
		);
	}
	
	public void stringtoFlat() {
		System.out.println(number + "	" + name + "			 $" + price);
	}
	/** This method returns number
	 * 
	 * @return	number
	 */
	public int getnumber() {
		return number;
	}
	/** This method returns name
	 * 
	 * @return	name
	 */
	public String getname() {
		return name;
	}
	/** This method returns category
	 * 
	 * @return	category
	 */
	public String getcategory() {
		return category;
	}
	/** This method returns price
	 * 
	 * @return	price
	 */
	public double getprice() {
		return price;
	}
	/** This method returns quantity
	 * 
	 * @return	quantity	
	 */
	public int getquantity() {
		return quantity;
	}
	/** This method sets number
	 */
	public void setnumber(int number) {
		this.number = number;
	}
	/** This method sets name
	 */
	public void setname(String name) {
		this.name = name;
	}
	/** This method sets category
	 */
	public void setcategory(String category) {
		this.category = category;
	}
	/** This method sets price
	 */
	public void setprice(double price) {
		this.price = price;
	}
	/** This method sets quantity
	 */
	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
}

