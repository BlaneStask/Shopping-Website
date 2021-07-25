package shopc;
import java.util.*;
import java.io.*;

/**
* <h1>Shopping Cart</h1>
*
* @author  Blane Staskiewicz
*/
public class shopping_cart{
	
	/** 
	* This method is the main/driver method
	* 
	* @throws Exception e   FileNotFoundException
	* @param  args          Unused
	*/
	public static void main(String[] args) throws Exception{
		// scan file
		ArrayList <item> storage = new ArrayList<item>();
		Scanner s = null;
		try{
			s = new Scanner(new FileInputStream("shoppingC_list.txt"));
		} 
		catch(FileNotFoundException e){
			System.out.println("Problem opening files.");
		    System.exit(0);
		}
		
		// loop for values
		while(s.hasNextLine()){
			int number = Integer.parseInt(s.nextLine());
			String name = s.nextLine();
			String category = s.nextLine();
			double price = Double.parseDouble(s.nextLine());
			int quantity = Integer.parseInt(s.nextLine());
			storage.add(new item(number, name, category, price, quantity));
		}

		s = new Scanner(System.in);
		int count = 0;
		int input = welcome(s);
		ArrayList<item> cart = new ArrayList<item>();

		// loops until checkout value is returned
		while(input != 4){
		    input = welcome(s);
			
		    // return to menu
		    if(input == 0){
			input = welcome(s);
		    }
		    if(input == 2 && count == 0 || input == 3 && count == 0 || input == 4 && count == 0){
			System.out.println();
			System.out.println("A shopping cart has not been created.");
			System.out.println();
		    }
		    // first time making a shopping cart
		    else if(input == 1 && count == 0){
				System.out.println();
			System.out.println("Shopping Cart Created!");
				System.out.println();
			count++;
		    }
		    // trying to make a cart again
		    else if(input == 1 && count > 0){
				System.out.println();
			System.out.println("You already have a Shopping Cart Created!");
				System.out.println();
				return;
		    }
		    // adding to cart
		    else if(input == 2){
        		System.out.println("Choose a Category.");
        		System.out.println("1) Books");
        		System.out.println("2) Home & Gifts");
        		System.out.println("3) Tech");
        		
        		String input3 = s.nextLine();
        		int user_input = Integer.parseInt(input3);
        		
        		System.out.print("Your choice?: ");
        		System.out.println(user_input);
        		System.out.println();
        		
        		// invalid choice
        		if(user_input != 1 && user_input != 2 && user_input != 3){
        			// loop until valid choice
        			while(user_input != 1 && user_input != 2 && user_input != 3){
        				System.out.print(user_input);
        				System.out.println(" is not a valid choice! Please enter a number from 1 to 3.");
        				
        				String input1 = s.nextLine();
        				user_input = Integer.parseInt(input1);
        				
        			}
        			System.out.print("Your choice?: ");
        			System.out.println(user_input);
            			System.out.println();
        		}
        		// prints attributes of items, based on input value
        		if(user_input == 1){
				for(int i = 0; i < storage.size(); i++){
					if((storage.get(i)).getcategory().equals("Books")){
						(storage.get(i)).stringtoFlat();
					}
				}
        		}
        		else if(user_input == 2){
				for(int i = 0; i < storage.size(); i++){
					if((storage.get(i)).getcategory().equals("Home & Gifts")){
						(storage.get(i)).stringtoFlat();
					}
				}
        		}
        		else if(user_input == 3){
				for(int i = 0; i < storage.size(); i++){
					if((storage.get(i)).getcategory().equals("Tech")){
						(storage.get(i)).stringtoFlat();
					}
				}
        		}
        		
        		System.out.println();
        		System.out.println("Enter the number of the item you wish to add.");
        		String input4 = s.nextLine();
        		int user_input1 = Integer.parseInt(input4);
        		
        		try{
				// breaks if a valid number of the items
				for(int i = 0; i < storage.size(); i++){
					if(user_input1 == ((storage.get(i)).getnumber())){
						add(storage, cart, i);
						System.out.print("Your choice?: ");
						System.out.println(user_input1);
						System.out.println();
						System.out.print("Your choice ");
						System.out.print('"');
						System.out.print((storage.get(user_input1)).getnumber());
						System.out.print("   ");
						System.out.print((storage.get(user_input1)).getname());
						System.out.print('"');
						System.out.println(" has been added to the shopping cart.");
						System.out.println();
						break;
					}
					// no value is equal to input value
					else if(i == 14 && user_input1 != (storage.get(i)).getnumber()){
						System.out.print("Item #");
						System.out.print(user_input1);
						System.out.println(" was not found in storage.");
						throw new Exception();
					}
				}
        		}
        		catch(Exception e){
    				return;
        		}
			    
        		// print cart
        		for(int i = 0; i < cart.size(); i++){
        			cart.get(i).toString();
        			System.out.println();
        		}
            }
            // remove from cart
            else if(input == 3){
            	System.out.print("Displaying the current contents of the shopping cart ... ");
            	System.out.println();
            	
        		for(int i = 0; i < cart.size(); i++){
        			cart.toString();
        			System.out.println();
        		}
        		
            	System.out.print("Enter the number of the item you wish to remove: ");
        		String input3 = s.nextLine();
        		int user_input = Integer.parseInt(input3);
        		
        		System.out.print("Your choice?: ");
        		System.out.println(user_input);
        		
        		try{
				// breaks if a valid number of the items
				for(int i = 0; i < storage.size(); i++){
					if(user_input == (storage.get(i)).getnumber()){
						break;
					}
					// no value is equal to input value, return
					else if(i == 14 && user_input != (storage.get(i)).getnumber()){
						System.out.print("Item #");
						System.out.print(user_input);
						System.out.println(" was not found in your cart.");
						throw new Exception();
					}
				}
        		}
        		catch(Exception e) {
    				return;
        		}
        		
			remove(user_input, cart);
			System.out.println();
			System.out.print("Item #");
			System.out.print(user_input);
			System.out.println(" has been removed from the cart.");
			System.out.println();
			System.out.print("Displaying the current contents of the shopping cart ... ");
			System.out.println();
            	
        		for(int i = 0; i < cart.size(); i++){
        			cart.toString();
        			System.out.println();
        		}
		    }
		}

		// checkout
		System.out.println("ORDER SUMMARY: ");
		System.out.println();

		for(int i = 0; i < cart.size(); i++){
			(cart.get(i)).toString();
			System.out.println();
		}

		System.out.print("Order Total: $  ");

		double total = 0;

		// total price of the cart
		for(int i = 0; i < cart.size(); i++){
			total += (cart.get(i)).getprice();
		}
		System.out.print(total);
		System.out.println("  (6.0% tax included)");
		System.out.println();
		System.out.println("/************************************************************************************************/");
		System.out.println();

		// cart.checkout(cartItem);

		System.out.println("How do you wish to pay for your order?");
		System.out.println("(Enter 1 to charge to credit card on file or 2 to charge to a new credit card.): ");
		String input3 = s.nextLine();
		int user_input = Integer.parseInt(input3);

		// if invalid
		if(user_input != 1 && user_input != 2){
			// loop until valid option
			while(user_input != 1 && user_input != 2){
				System.out.println();
				System.out.print(user_input);
				System.out.println(" is not a valid option.");
				System.out.println("Please enter 1 to charge to card on file or 2 to charge to new card.");
				System.out.println();
				System.out.println("How do you wish to pay for your order?");
				System.out.println("(Enter 1 to charge to credit card on file or 2 to charge to a new credit card.): ");
				String input4 = s.nextLine();
				user_input = Integer.parseInt(input4);
				System.out.println();
			}
		}
		// new credit card
		if(user_input == 2){
			System.out.println();
			System.out.println("Please enter your payment information: ");
			System.out.println();
			System.out.println("Card holder name: ");
			String input4 = s.nextLine();
			System.out.println("Credit Card type (e.g., MasterCard): ");
			String input5 = s.nextLine();

			System.out.println("Credit Card Number (e.g., 5201345098756420): ");
			String input6 = s.nextLine();

			try{	
				if(input6.length() != 16){
					throw new Exception();
				}
			}
			catch(Exception e) {
				System.out.println("Credit Card Number does not have 16 digits. Please try again. ");
				System.out.println("Credit Card Number (e.g., 5201345098756420): ");
			    input6 = s.nextLine();

			    if(input6.length() != 16){
				throw new Exception();
			    }
			}

			System.out.println("Expiration Date (e.g., 10/2021): ");
			String input7 = s.nextLine();
			System.out.println();
			System.out.println("/************************************************************************************************/");
			System.out.println();
			System.out.println("Credit payment summary:");
			System.out.println();
			System.out.print(String.format("%-5s", "Customer name:   "));
			System.out.println(input4);
			System.out.print(String.format("%-5s", "Payment amount:   "));
			System.out.print("$");
			System.out.println(String.format("%-3.2f", total));
			System.out.print(String.format("%5s", "Card type:   "));
			System.out.println(input5);
			System.out.print(String.format("%5s", "Card number:  ************"));
			System.out.println(input6.substring(13, 16));
			System.out.print(String.format("%5s", "Exp date:   "));
			System.out.println(input7);
		}
		// charges card on file
		else{
			System.out.println("Payment Summary: ");
			System.out.println();
			System.out.print("Payment amount: $");
			System.out.print(String.format("%-3.2f", total));
			System.out.println("  charged to card on file");
		}

		// end output
			System.out.println();
			System.out.println("/************************************************************************************************/");
			System.out.println();
			System.out.println("Thanks for visiting Barnes & Noble Online!");
			System.out.println("Please come back soon");
			System.out.println();
			System.out.println("/************************************************************************************************/");
			System.out.println();
	}
	
	/** 
	* This method welcomes the user and gets user input for option chosen
	* 
	* @param  s     scanner for user input
	* @return val 	returns input value from welcome
	*/
	public static int welcome(Scanner s){
		System.out.println();
		System.out.println("/************************************************************************************************/");
		System.out.println();
		System.out.println("Welcome to Barnes & Noble Online!");
		System.out.println("Choose an option.");
		System.out.println("1) Create empty shopping cart");
		System.out.println("2) Add item to shopping cart");
		System.out.println("3) Remove item from shopping cart");
		System.out.println("4) Check out");
		
		String input = s.nextLine();
		int val = Integer.parseInt(input);
		
		// if value is not an option
		if(val != 1 && val != 2 && val != 3 && val != 4){
			// loop until value is an option
			while(val != 1 && val != 2 && val != 3 && val != 4){
				System.out.print(val);
				System.out.println(" is not a valid choice! Please enter a number from 1 to 4.");
				System.out.println("Enter 0 to return to the main menu.");
				
				String input1 = s.nextLine();
				val = Integer.parseInt(input1);
				
				// invalid, now 0 (main menu)
				if(val == 0){
					System.out.println();
					System.out.println("/************************************************************************************************/");
					System.out.println();
					System.out.println("Welcome to Barnes & Noble Online!");
					System.out.println("Choose an option.");
					System.out.println("1) Create empty shopping cart");
					System.out.println("2) Add item to shopping cart");
					System.out.println("3) Remove item from shopping cart");
					System.out.println("4) Check out");
					
					String input2 = s.nextLine();
					val = Integer.parseInt(input2);
					
					if(val == 1 || val == 2 || val == 3 || val == 4) {
						System.out.print("Your choice?: ");
						System.out.println(val);
						
						System.out.println();
						System.out.println("/************************************************************************************************/");
						System.out.println();
						
						return val;
					}
				}
			}
			// invalid, now valid
			System.out.print("Your choice?: ");
			System.out.println(val);
			
			System.out.println();
			System.out.println("/************************************************************************************************/");
			System.out.println();
			
			return val;
			
		}
		// valid the first time
		System.out.print("Your choice?: ");
		System.out.println(val);
		
		System.out.println();
		System.out.println("/************************************************************************************************/");
		System.out.println();
		
		return val;
	}
	
	/** 
	* This method removes items to the shopping cart
	* 
	* @param  user_input  users chosen option to remove
	* @param  cart 	      current cart
	*/
	public static void remove(int user_input, ArrayList<item> cart){
		for(int i = 0; i < cart.size(); i++){
			if((cart.get(i)).getnumber() == user_input){
				cart.remove((cart.get(i)));
			}
		}
	}
	
	/** 
	* This method add items to the shopping cart
	* 
	* @param  storage  current storage
	* @param  cart	   current cart
	* @param  i 	   users chosen option to add
	*/
	public static void add(ArrayList<item> storage, ArrayList<item> cart, int i){
		cart.add(storage.get(i));
	}
}
