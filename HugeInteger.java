import java.util.Random;

public class HugeInteger {
	 String integer;
	
	
	//Constructors
	public HugeInteger(String val) {
		
		if(val.length() == 0) { //checks if string is empty 
			throw new ArithmeticException("Invalid Expression. String is empty. Please input another input");
		}
		
		char initial = val.charAt(0);  //gets the ascii value of the string at position i
		int asciicode = initial;
		String array = ""; //initialize an array
		
		if((asciicode == 45) || ((asciicode >= 48) && (asciicode <= 57))) {  //checks if it starts with a negative or a number
			
			array += val.charAt(0);
			
			for(int i=1; i<val.length(); i++ ) { //loops through from second element till the end of the string 
				//char ascii = val.charAt(i);  //gets the ascii value of the string at position i
				//int character = ascii;
				
				if((val.charAt(i) >= 48) && (val.charAt(i) <= 57)) {
					array += val.charAt(i);
				 
				}
				
				else{ //anything else that isnt an integer or negative gets the error message 
					throw new ArithmeticException("Invalid Expression. Please input another input");
				}
					
			}
			
		}
		
		else{
			throw new ArithmeticException("Invalid Expression. String cannot start with something else other than - or an integer. Please input another input");
		}	
		
		this.integer = array; //sets integer to array string 
	}

	public HugeInteger(int n) {
		
		//creates a mutable sequence of characters
		if(n >= 1) {
			
			StringBuffer sb = new StringBuffer(n); //create stringbuffer of size n
			
			Random numb = new Random(); //creates a variable numb of type random
			int rannumb = numb.nextInt(9) + 1 ; //generates random number between 1 to 9
			sb.append(rannumb); //appends this value at the start of sb string
			
			for (int i = 1; i < n; i++) {  //repeats the number generation n times 
				  
	            // generate a random number between 0 to 9 
				
				Random ran = new Random(); 
				int nxt = ran.nextInt(10);
				
	            // add Character one by one in end of sb 
	            sb.append(nxt); //appends nxt number to the end of sb string each iteration
	        } 
			
			String fina = sb.toString();
			this.integer = fina;
			
		}
		
		else {
			throw new ArithmeticException("Please input n >=1 ");
		}
		
	}

	public HugeInteger add(HugeInteger h) {
		//returns a new HugeInteger representing the sum of this HugeInteger and h
		//omit leading 0's 
		//can't do negatives yet 
		
		//convert the hugeinteger class variable to string
		String s1 = h.toString();
		String s2 = this.integer;
		
		char initial = s1.charAt(0);  //gets the ascii value of the string at position i
		char initial2 = s2.charAt(0);
		int asciicode = initial;
		int asciicode2 = initial2;  
		
		if(((asciicode >= 48) && (asciicode <= 57)) && ( ((asciicode2 >= 48) && (asciicode2 <= 57)))) { //checks if both strings are positive 
			// Before proceeding further, make sure length of string 2 is larger.  
			if(compareTo(h) == -1) { //this integer is smaller than h
				//want s2 to be the longer one
					 String t = s1; 
				     s1 = s2; 
				     s2 = t;
				}
		  
		    // Make an empty String for storing result  
		    String empty = "";  
		  
		    // Calculate length of both String  
		    int l1 = s1.length();
		    int l2 = s2.length();  
		  
		    // Reverse the strings
		    s1 = new StringBuilder(s1).reverse().toString(); 
		    s2 = new StringBuilder(s2).reverse().toString(); 
		  
		    //initialise a carry
		    int carry = 0;  
		    
		    for (int i = 0; i < l1; i++)  
		    {  
		        //compute sum of current digits and carry  
		    	
		        int sum = ((int)(s1.charAt(i) - '0') +  (int)(s2.charAt(i) - '0') + carry);  //converts the character to integer and then converts it back to a string 
		        empty += (char)(sum % 10 + '0');  //adds the addition of the sum into the empty string but ommiting the carry 
		  
		        // Calculate carry for next step  
		        carry = sum / 10;  //calculates the carry and remembers it 
		    }  
		  
		    // Add remaining digits of larger number  
		    for (int i = l1; i < l2; i++)  
		    {  
		        int sum = ((int)(s2.charAt(i) - '0') + carry);  
		        empty += (char)(sum % 10 + '0');  
		        carry = sum / 10;  
		    }  
		  
		    // Add remaining carry if there is a carry 
		    if (carry > 0) {  
		        empty += (char)(carry + '0');  
		    }
		    
		    // reverse resultant String 
		    empty = new StringBuilder(empty).reverse().toString(); 
		    
		    HugeInteger finale = new HugeInteger(empty);
		    
		    return finale;
		}
		
		else if(((asciicode == 45) && ( ((asciicode2 >= 48) && (asciicode2 <= 57))))) { //checks if h string is negative and this integer is positive 
			StringBuilder sb = new StringBuilder(s1);
			sb.deleteCharAt(0); //deletes the negative value of h string 
			s1 = sb.toString(); //makes h into a string again after removing the negative value  
			
			//now h is a positive value, dont forget to add the negative sign after 
			HugeInteger S1 = new HugeInteger(s1);
			
				if(compareTo(S1) == 1) { //this integer is bigger than h
				//want s2 to be the longer one 
				     
					// Take an empty string for storing result 
					    String empty1 = ""; 
					  
					    // Calculate length of both string 
					    int n1 = s1.length(); 
					    int n2 = s2.length();  //length of the longer string 
					  
					    // Reverse both of strings 
					    s1 = new StringBuilder(s1).reverse().toString(); 
					    s2 = new StringBuilder(s2).reverse().toString(); 
					      
					    int carry = 0; 
					  
					    // Run loop till small string length 
					    // and subtract digit of str1 to str2 
					    for (int i = 0; i < n1; i++) 
					    { 
					        //Compute difference of current digits 
					    	//Convert the element of a string value to an integer value 
					        int sub = ((int)(s2.charAt(i) - '0') - (int)(s1.charAt(i) - '0') - carry); 
					          
					        // If subtraction is less then zero 
					        // we add then we add 10 into sub and take carry as 1 for calculating next step 
					        if (sub < 0) 
					        { 
					            sub = sub + 10; 
					            carry = 1; 
					        } 
					        else
					            carry = 0; 
					  
					        empty1 += (char)(sub + '0'); 
					    } 
					  
					    // subtract remaining digits of larger number 
					    for (int i = n1; i < n2; i++) 
					    { 
					        int sub = ((int)(s2.charAt(i) - '0') - carry); 
					          
					        // if the sub value is -ve, then make it positive 
					        if (sub < 0) 
					        { 
					            sub = sub + 10; 
					            carry = 1; 
					        } 
					        else
					            carry = 0; 
					              
					        empty1 += (char)(sub + '0'); 
					    } 
					  
					 // reverse resultant String 
					    empty1 = new StringBuilder(empty1).reverse().toString(); 
					    HugeInteger finale1 = new HugeInteger(empty1);
					    
					    return finale1;
				}
			    
				else if(compareTo(S1) == -1) { //this integer is smaller than h
					//want s2 to be the longer one
					//h becomes s2
						
						
						String t = s1; 
					    s1 = s2; 
					    s2 = t; //make s2 to h
					     
					     
						 
						 //now h is the bigger one 
					     
						// Take an empty string for storing result 
						    String empty1 = ""; 
						  
						    // Calculate length of both string 
						    int n1 = s1.length(); 
						    int n2 = s2.length();  //length of the longer string 
						  
						    // Reverse both of strings 
						    s1 = new StringBuilder(s1).reverse().toString(); 
						    s2 = new StringBuilder(s2).reverse().toString(); 
						      
						    int carry = 0; 
						  
						    // Run loop till small string length 
						    // and subtract digit of str1 to str2 
						    for (int i = 0; i < n1; i++) 
						    { 
						        //Compute difference of current digits 
						    	//Convert the element of a string value to an integer value 
						        int sub = ((int)(s2.charAt(i) - '0') - (int)(s1.charAt(i) - '0') - carry); 
						          
						        // If subtraction is less then zero 
						        // we add then we add 10 into sub and take carry as 1 for calculating next step 
						        if (sub < 0) 
						        { 
						            sub = sub + 10; 
						            carry = 1; 
						        } 
						        else
						            carry = 0; 
						  
						        empty1 += (char)(sub + '0'); 
						    } 
						  
						    // subtract remaining digits of larger number 
						    for (int i = n1; i < n2; i++) 
						    { 
						        int sub = ((int)(s2.charAt(i) - '0') - carry); 
						          
						        // if the sub value is -ve, then make it positive 
						        if (sub < 0) 
						        { 
						            sub = sub + 10; 
						            carry = 1; 
						        } 
						        else
						            carry = 0; 
						              
						        empty1 += (char)(sub + '0'); 
						    } 
						  
						 // reverse resultant String 
						    empty1 = new StringBuilder(empty1).reverse().toString(); 
						    empty1 = '-' + empty1;
						    HugeInteger finale1 = new HugeInteger(empty1);
						    
						    return finale1;
					}
				
					else{ //if h and this integer is the same
						HugeInteger zero = new HugeInteger("0");
						return zero;
						
					}
			}	     
						 
						
		else if(((asciicode2 == 45) && ( ((asciicode >= 48) && (asciicode <= 57))))) { //checks if this string is negative and h string is positive 
			
			StringBuilder sb = new StringBuilder(s2);
			 sb.deleteCharAt(0); //deletes the negative value of this int string 
			 s2 = sb.toString(); //makes this int into a string again after removing the negative value 
			 this.integer = s2;
			 
			if(compareTo(h) == -1) { //this integer is smaller than h
			//want s2 to be the longer one
				// Take an empty string for storing result 
				    String empty1 = ""; 
				  
				    String y = s1;
				    s1 = s2;
				    s2 = y;
				    //h is now s2
				    // Calculate length of both string 
				    int n1 = s1.length(); 
				    int n2 = s2.length();  //length of the longer string 
				  
				    // Reverse both of strings 
				    s1 = new StringBuilder(s1).reverse().toString(); 
				    s2 = new StringBuilder(s2).reverse().toString(); 
				      
				    int carry = 0; 
				  
				    // Run loop till small string length 
				    // and subtract digit of str1 to str2 
				    for (int i = 0; i < n1; i++) 
				    { 
				        //Compute difference of current digits 
				    	//Convert the element of a string value to an integer value 
				        int sub = ((int)(s2.charAt(i) - '0') - (int)(s1.charAt(i) - '0') - carry); 
				          
				        // If subtraction is less then zero 
				        // we add then we add 10 into sub and take carry as 1 for calculating next step 
				        if (sub < 0) 
				        { 
				            sub = sub + 10; 
				            carry = 1; 
				        } 
				        else
				            carry = 0; 
				  
				        empty1 += (char)(sub + '0'); 
				    } 
				  
				    // subtract remaining digits of larger number 
				    for (int i = n1; i < n2; i++) 
				    { 
				        int sub = ((int)(s2.charAt(i) - '0') - carry); 
				          
				        // if the sub value is -ve, then make it positive 
				        if (sub < 0) 
				        { 
				            sub = sub + 10; 
				            carry = 1; 
				        } 
				        else
				            carry = 0; 
				              
				        empty1 += (char)(sub + '0'); 
				    } 
				  
				 // reverse resultant String 
				    empty1 = new StringBuilder(empty1).reverse().toString(); 
				     
				    HugeInteger finale1 = new HugeInteger(empty1);
				    
				    return finale1;
			}
		    
			else if(compareTo(h) == 1) { //this integer is bigger than h
				//want s2 to be the longer one
					
					 //now h is the bigger one 
				     
					// Take an empty string for storing result 
					    String empty1 = ""; 
					  
					    // Calculate length of both string 
					    int n1 = s1.length(); 
					    int n2 = s2.length();  //length of the longer string 
					  
					    // Reverse both of strings 
					    s1 = new StringBuilder(s1).reverse().toString(); 
					    s2 = new StringBuilder(s2).reverse().toString(); 
					      
					    int carry = 0; 
					  
					    // Run loop till small string length 
					    // and subtract digit of str1 to str2 
					    for (int i = 0; i < n1; i++) 
					    { 
					        //Compute difference of current digits 
					    	//Convert the element of a string value to an integer value 
					        int sub = ((int)(s2.charAt(i) - '0') - (int)(s1.charAt(i) - '0') - carry); 
					          
					        // If subtraction is less then zero 
					        // we add then we add 10 into sub and take carry as 1 for calculating next step 
					        if (sub < 0) 
					        { 
					            sub = sub + 10; 
					            carry = 1; 
					        } 
					        else
					            carry = 0; 
					  
					        empty1 += (char)(sub + '0'); 
					    } 
					  
					    // subtract remaining digits of larger number 
					    for (int i = n1; i < n2; i++) 
					    { 
					        int sub = ((int)(s2.charAt(i) - '0') - carry); 
					          
					        // if the sub value is -ve, then make it positive 
					        if (sub < 0) 
					        { 
					            sub = sub + 10; 
					            carry = 1; 
					        } 
					        else
					            carry = 0; 
					              
					        empty1 += (char)(sub + '0'); 
					    } 
					  
					 // reverse resultant String 
					    empty1 = new StringBuilder(empty1).reverse().toString(); 
					    empty1 = '-' + empty1;
					    HugeInteger finale1 = new HugeInteger(empty1);
					    
					    return finale1;
				}
			
			else { //same numbers but different sign
				HugeInteger finale1 = new HugeInteger("0");
			    return finale1; 
				
				
			}
		
		}
		
		else if((asciicode2 == 45) && (asciicode == 45)){ //checks if this string and h string is negative
					
		     
			 if(s1.length()>s2.length()) { //checks if this integer is smaller than h
				//want s2 to be the longer one, make h bigger string
				 String y = s1; 
			     s1 = s2; 
			     s2 = y; //make h the longer string now
			}
			 
			 StringBuilder sb = new StringBuilder(s1);
			 sb.deleteCharAt(0); //deletes the negative value of h string 
			 s1 = sb.toString(); //makes h into a string again after removing the negative value 
			 
			 StringBuilder sb1 = new StringBuilder(s2);
			 sb1.deleteCharAt(0); //deletes the negative value of this integer
			 s2 = sb1.toString(); //makes this integer into a string again after removing the negative value
			 
			    // Make an empty String for storing result  
			    String empty = "";  
			  
			    // Calculate length of both String  
			    int l1 = s1.length();
			    int l2 = s2.length();  
			  
			    // Reverse the strings
			    s1 = new StringBuilder(s1).reverse().toString(); 
			    s2 = new StringBuilder(s2).reverse().toString(); 
			  
			    //initialise a carry
			    int carry = 0;  
			    
			    for (int i = 0; i < l1; i++)  
			    {  
			        //compute sum of current digits and carry  
			    	
			        int sum = ((int)(s1.charAt(i) - '0') +  (int)(s2.charAt(i) - '0') + carry);  //converts the character to integer and then converts it back to a string 
			        empty += (char)(sum % 10 + '0');  //adds the addition of the sum into the empty string but ommiting the carry 
			  
			        // Calculate carry for next step  
			        carry = sum / 10;  //calculates the carry and remembers it 
			    }  
			  
			    // Add remaining digits of larger number  
			    for (int i = l1; i < l2; i++)  
			    {  
			        int sum = ((int)(s2.charAt(i) - '0') + carry);  
			        empty += (char)(sum % 10 + '0');  
			        carry = sum / 10;  
			    }  
			  
			    // Add remaining carry if there is a carry 
			    if (carry > 0) {  
			        empty += (char)(carry + '0');  
			    }
			    
			    // reverse resultant String 
			    empty = new StringBuilder(empty).reverse().toString(); 
			    empty = '-' + empty;
			    HugeInteger finale = new HugeInteger(empty);
			    
			    return finale;
		}
		
		return null;
	}
			
				
		  
	
	public HugeInteger subtract(HugeInteger h) {
		// Before proceeding further, make sure str1 
	    // is not smaller 
		//convert the hugeinteger class variable to string
		//convert the hugeinteger class variable to string
		String s1 = h.toString();
		String s2 = this.integer;
		
		char initial = s1.charAt(0);  //gets the ascii value of the string at position i
		char initial2 = s2.charAt(0);
		int asciicode = initial;
		int asciicode2 = initial2;  

		if((asciicode >= 48) && (asciicode <= 57) && (asciicode2 >= 48) && (asciicode2 <= 57)) { //checks if both are non negative
			
			if(compareTo(h) == -1) { //this integer is smaller than h
				//want s2 to be the longer one
				//make h the bigger one
					 String t = s1; 
				     s1 = s2; 
				     s2 = t;
				
			    // Take an empty string for storing result 
			    String empty1 = ""; 
			  
			    // Calculate length of both string 
			    int n1 = s1.length(); 
			    int n2 = s2.length();  //length of the longer string 
			  
			    // Reverse both of strings 
			    s1 = new StringBuilder(s1).reverse().toString(); 
			    s2 = new StringBuilder(s2).reverse().toString(); 
			      
			    int carry = 0; 
			  
			    // Run loop till small string length 
			    // and subtract digit of str1 to str2 
			    for (int i = 0; i < n1; i++) 
			    { 
			        //Compute difference of current digits 
			    	//Convert the element of a string value to an integer value 
			        int sub = ((int)(s2.charAt(i) - '0') - (int)(s1.charAt(i) - '0') - carry); 
			          
			        // If subtraction is less then zero 
			        // we add then we add 10 into sub and take carry as 1 for calculating next step 
			        if (sub < 0) 
			        { 
			            sub = sub + 10; 
			            carry = 1; 
			        } 
			        else
			            carry = 0; 
			  
			        empty1 += (char)(sub + '0'); 
			    } 
			  
			    // subtract remaining digits of larger number 
			    for (int i = n1; i < n2; i++) 
			    { 
			        int sub = ((int)(s2.charAt(i) - '0') - carry); 
			          
			        // if the sub value is -ve, then make it positive 
			        if (sub < 0) 
			        { 
			            sub = sub + 10; 
			            carry = 1; 
			        } 
			        else
			            carry = 0; 
			              
			        empty1 += (char)(sub + '0'); 
			    } 
			  
			 // reverse resultant String 
			    empty1 = new StringBuilder(empty1).reverse().toString(); 
			    empty1 = '-' + empty1; 
			    HugeInteger finale1 = new HugeInteger(empty1);
			    
			    return finale1;
			}
			
			else if(compareTo(h) == 1) { //checks if this integer is bigger than h
				
					 
			    // Take an empty string for storing result 
			    String empty1 = ""; 
			  
			    // Calculate length of both string 
			    int n1 = s1.length(); 
			    int n2 = s2.length();  //length of the longer string 
			  
			    // Reverse both of strings 
			    s1 = new StringBuilder(s1).reverse().toString(); 
			    s2 = new StringBuilder(s2).reverse().toString(); 
			      
			    int carry = 0; 
			  
			    // Run loop till small string length 
			    // and subtract digit of str1 to str2 
			    for (int i = 0; i < n1; i++) 
			    { 
			        //Compute difference of current digits 
			    	//Convert the element of a string value to an integer value 
			        int sub = ((int)(s2.charAt(i) - '0') - (int)(s1.charAt(i) - '0') - carry); 
			          
			        // If subtraction is less then zero 
			        // we add then we add 10 into sub and take carry as 1 for calculating next step 
			        if (sub < 0) 
			        { 
			            sub = sub + 10; 
			            carry = 1; 
			        } 
			        else
			            carry = 0; 
			  
			        empty1 += (char)(sub + '0'); 
			    } 
			  
			    // subtract remaining digits of larger number 
			    for (int i = n1; i < n2; i++) 
			    { 
			        int sub = ((int)(s2.charAt(i) - '0') - carry); 
			          
			        // if the sub value is -ve, then make it positive 
			        if (sub < 0) 
			        { 
			            sub = sub + 10; 
			            carry = 1; 
			        } 
			        else
			            carry = 0; 
			              
			        empty1 += (char)(sub + '0'); 
			    } 
			  
			 // reverse resultant String 
			    empty1 = new StringBuilder(empty1).reverse().toString(); 
			    HugeInteger finale1 = new HugeInteger(empty1);
			    
			    return finale1;
			}
			
			else { //same number
				String zero = "0";
				HugeInteger none = new HugeInteger(zero);
				return none;
			}
		}
		
		
		else if((asciicode == '-') && (asciicode2 >= 48) && (asciicode2 <= 57)) { //checks if h is negative
			StringBuilder sb = new StringBuilder(s1);
			sb.deleteCharAt(0); //deletes the negative value of h string 
			s1 = sb.toString(); //makes h into a string again after removing the negative value  
			
			if(s1.length() > s2.length()) { //this integer is smaller than h
				//want s2 to be the longer one
				//makes h s2 if h is longer 
					 String t = s1; 
				     s1 = s2; 
				     s2 = t;
			}
		  
		    // Make an empty String for storing result  
		    String empty = "";  
		  
		    // Calculate length of both String  
		    int l1 = s1.length();
		    int l2 = s2.length();  
		  
		    // Reverse the strings
		    s1 = new StringBuilder(s1).reverse().toString(); 
		    s2 = new StringBuilder(s2).reverse().toString(); 
		  
		    //initialise a carry
		    int carry = 0;  
		    
		    for (int i = 0; i < l1; i++)  
		    {  
		        //compute sum of current digits and carry  
		    	
		        int sum = ((int)(s1.charAt(i) - '0') +  (int)(s2.charAt(i) - '0') + carry);  //converts the character to integer and then converts it back to a string 
		        empty += (char)(sum % 10 + '0');  //adds the addition of the sum into the empty string but ommiting the carry 
		  
		        // Calculate carry for next step  
		        carry = sum / 10;  //calculates the carry and remembers it 
		    }  
		  
		    // Add remaining digits of larger number  
		    for (int i = l1; i < l2; i++)  
		    {  
		        int sum = ((int)(s2.charAt(i) - '0') + carry);  
		        empty += (char)(sum % 10 + '0');  
		        carry = sum / 10;  
		    }  
		  
		    // Add remaining carry if there is a carry 
		    if (carry > 0) {  
		        empty += (char)(carry + '0');  
		    }
		    
		    // reverse resultant String 
		    empty = new StringBuilder(empty).reverse().toString(); 
		    HugeInteger finale = new HugeInteger(empty);
		    
		    return finale;
		}
		
		else if((asciicode2 == '-') && (asciicode >= 48) && (asciicode <= 57)) { //checks if this integer is negative 
			
			StringBuilder sb = new StringBuilder(s2);
			sb.deleteCharAt(0); //deletes the negative value of this string 
			s2 = sb.toString(); //makes this int into a string again after removing the negative value
			
			if(s1.length() > s2.length()) { //this integer is smaller than h
				//want s2 to be the longer one
					 String t = s1; 
				     s1 = s2; 
				     s2 = t;
				}
		  
		    // Make an empty String for storing result  
		    String empty = "";  
		  
		    // Calculate length of both String  
		    int l1 = s1.length();
		    int l2 = s2.length();  
		  
		    // Reverse the strings
		    s1 = new StringBuilder(s1).reverse().toString(); 
		    s2 = new StringBuilder(s2).reverse().toString(); 
		  
		    //initialise a carry
		    int carry = 0;  
		    
		    for (int i = 0; i < l1; i++)  
		    {  
		        //compute sum of current digits and carry  
		    	
		        int sum = ((int)(s1.charAt(i) - '0') +  (int)(s2.charAt(i) - '0') + carry);  //converts the character to integer and then converts it back to a string 
		        empty += (char)(sum % 10 + '0');  //adds the addition of the sum into the empty string but ommiting the carry 
		  
		        // Calculate carry for next step  
		        carry = sum / 10;  //calculates the carry and remembers it 
		    }  
		  
		    // Add remaining digits of larger number  
		    for (int i = l1; i < l2; i++)  
		    {  
		        int sum = ((int)(s2.charAt(i) - '0') + carry);  
		        empty += (char)(sum % 10 + '0');  
		        carry = sum / 10;  
		    }  
		  
		    // Add remaining carry if there is a carry 
		    if (carry > 0) {  
		        empty += (char)(carry + '0');  
		    }
		    
		    // reverse resultant String 
		    empty = new StringBuilder(empty).reverse().toString(); 
		    empty = '-' + empty;
		    HugeInteger finale = new HugeInteger(empty);
		    
		    return finale;
		}

		else if((asciicode2 == '-') && (asciicode == '-')) { //checks if this integer is negative 
			
			StringBuilder sb = new StringBuilder(s2);
			sb.deleteCharAt(0); //deletes the negative value of this string 
			s2 = sb.toString(); //makes this int into a string again after removing the negative value
			
			StringBuilder sb1 = new StringBuilder(s1);
			sb1.deleteCharAt(0); //deletes the negative value of h string 
			s1 = sb1.toString(); //makes h into a string again after removing the negative value
			
			this.integer = s2;
			HugeInteger S1 = new HugeInteger(s1); //makes the new h an hugeinteger type
			
			if(compareTo(S1) == -1) { //this integer is smaller than h
				//want s2 to be the longer one
				//make h the bigger one
					 String t = s1; 
				     s1 = s2; 
				     s2 = t;
				
			    // Take an empty string for storing result 
			    String empty1 = ""; 
			  
			    // Calculate length of both string 
			    int n1 = s1.length(); 
			    int n2 = s2.length();  //length of the longer string 
			  
			    // Reverse both of strings 
			    s1 = new StringBuilder(s1).reverse().toString(); 
			    s2 = new StringBuilder(s2).reverse().toString(); 
			      
			    int carry = 0; 
			  
			    // Run loop till small string length 
			    // and subtract digit of str1 to str2 
			    for (int i = 0; i < n1; i++) 
			    { 
			        //Compute difference of current digits 
			    	//Convert the element of a string value to an integer value 
			        int sub = ((int)(s2.charAt(i) - '0') - (int)(s1.charAt(i) - '0') - carry); 
			          
			        // If subtraction is less then zero 
			        // we add then we add 10 into sub and take carry as 1 for calculating next step 
			        if (sub < 0) 
			        { 
			            sub = sub + 10; 
			            carry = 1; 
			        } 
			        else
			            carry = 0; 
			  
			        empty1 += (char)(sub + '0'); 
			    } 
			  
			    // subtract remaining digits of larger number 
			    for (int i = n1; i < n2; i++) 
			    { 
			        int sub = ((int)(s2.charAt(i) - '0') - carry); 
			          
			        // if the sub value is -ve, then make it positive 
			        if (sub < 0) 
			        { 
			            sub = sub + 10; 
			            carry = 1; 
			        } 
			        else
			            carry = 0; 
			              
			        empty1 += (char)(sub + '0'); 
			    } 
			  
			 // reverse resultant String 
			    empty1 = new StringBuilder(empty1).reverse().toString(); 
			    HugeInteger finale1 = new HugeInteger(empty1);
			    
			    return finale1;
			}
			
			else if(compareTo(S1) == 1) { //checks if this integer is bigger than h
				
					 
			    // Take an empty string for storing result 
			    String empty1 = ""; 
			  
			    // Calculate length of both string 
			    int n1 = s1.length(); 
			    int n2 = s2.length();  //length of the longer string 
			  
			    // Reverse both of strings 
			    s1 = new StringBuilder(s1).reverse().toString(); 
			    s2 = new StringBuilder(s2).reverse().toString(); 
			      
			    int carry = 0; 
			  
			    // Run loop till small string length 
			    // and subtract digit of str1 to str2 
			    for (int i = 0; i < n1; i++) 
			    { 
			        //Compute difference of current digits 
			    	//Convert the element of a string value to an integer value 
			        int sub = ((int)(s2.charAt(i) - '0') - (int)(s1.charAt(i) - '0') - carry); 
			          
			        // If subtraction is less then zero 
			        // we add then we add 10 into sub and take carry as 1 for calculating next step 
			        if (sub < 0) 
			        { 
			            sub = sub + 10; 
			            carry = 1; 
			        } 
			        else
			            carry = 0; 
			  
			        empty1 += (char)(sub + '0'); 
			    } 
			  
			    // subtract remaining digits of larger number 
			    for (int i = n1; i < n2; i++) 
			    { 
			        int sub = ((int)(s2.charAt(i) - '0') - carry); 
			          
			        // if the sub value is -ve, then make it positive 
			        if (sub < 0) 
			        { 
			            sub = sub + 10; 
			            carry = 1; 
			        } 
			        else
			            carry = 0; 
			              
			        empty1 += (char)(sub + '0'); 
			    } 
			  
			 // reverse resultant String 
			    empty1 = new StringBuilder(empty1).reverse().toString(); 
			    empty1 = '-' + empty1;
			    HugeInteger finale1 = new HugeInteger(empty1);
			    
			    return finale1;
			}
			
			else { //same number
				String zero = "0";
				HugeInteger none = new HugeInteger(zero);
				return none;
			}
		}
		
		return null;
	}
	
	public HugeInteger multiply(HugeInteger h) {
		//convert the hugeinteger class variable to string
		//convert the hugeinteger class variable to string
		String s1 = h.toString();
		String s2 = this.integer;
		
		char initial = s1.charAt(0);  //gets the ascii value of the string at position i
		char initial2 = s2.charAt(0);
		int asciicode = initial;
		int asciicode2 = initial2;  
		
		if((asciicode != 45) && (asciicode2 == 45) || (asciicode == 45) && (asciicode2 != 45)) { //checks if one of the input is negative 
			
			if(asciicode == 45) { //removes negative sign on h string
				StringBuilder sb = new StringBuilder(s1);
				sb.deleteCharAt(0);
				s1 = sb.toString();
			}
			
			if(asciicode2 == 45) { //removes negative sign on this string
				StringBuilder sb2 = new StringBuilder(s2);
				sb2.deleteCharAt(0);
				s2 = sb2.toString();
			}
			
			
			int len1 = s1.length(); 
		    int len2 = s2.length(); 
		    
		    if (len1 == 0 || len2 == 0) {  //checks if string is empty 
		       HugeInteger zero = new HugeInteger("0");
		       return zero;
		    }
		    
		    // will keep the result number in vector 
		    // in reverse order 
		    int result[] = new int[len1 + len2]; 
		  
		    // Keep track of positions in result.  
		    int i_n1 = 0;  
		    int i_n2 = 0;  
		      
		    // Go from right to left in s1 
		    for (int i = len1 - 1; i >= 0; i--) 
		    { 
		        int carry = 0; 
		        int n1 = s1.charAt(i) - '0'; 
		  
		        // To shift position to left after every 
		        // multipliccharAtion of a digit in num2 
		        i_n2 = 0;  
		          
		        // Go from right to left in s2              
		        for (int j = len2 - 1; j >= 0; j--) 
		        { 
		            // Take current digit of second number 
		            int n2 = s2.charAt(j) - '0'; 
		  
		            // Multiply with current digit of first number 
		            // and add result to previously stored result 
		            // charAt current position.  
		            int sum = n1 * n2 + result[i_n1 + i_n2] + carry; 
		  
		            // Carry for next itercharAtion 
		            carry = sum / 10; 
		  
		            // Store result 
		            result[i_n1 + i_n2] = sum % 10; 
		  
		            i_n2++; 
		        } 
		  
		        // store carry in next cell 
		        if (carry > 0) { 
		            result[i_n1 + i_n2] += carry; 
		        }
		        // To shift position to left after every 
		        // multipliccharAtion of a digit in num1. 
		        
		        i_n1++; 
		    } 
		  
		    // ignore '0's from the right 
		    int i = result.length - 1; 
		    
		    while (i >= 0 && result[i] == 0) { 
			    i--; 
			  
			    // If all were '0's - means either both  
			    // or one of s1 or s2 were '0' 
			    
			    if (i == -1) {
			    	HugeInteger zero = new HugeInteger("0");
				    return zero;
			    } 
		    }
		    // generate the result String 
		    
		    String s = ""; 
		      
		    while (i >= 0) { 
		        s += (result[i--]); //This prints the results from the array in reverse
		    }
		    
		    s = '-' + s;
		    HugeInteger finale = new HugeInteger(s);
		    return finale; 
		}
		
		else if(((asciicode == 45) && (asciicode2 == 45)) || ((asciicode != 45) && (asciicode2 != 45))) { //checks if both are negative or both positive 
			
			if((asciicode == 45) && (asciicode2 == 45)) {
			//removes negative sign on h string
				StringBuilder sb = new StringBuilder(s1);
				sb.deleteCharAt(0);
				s1 = sb.toString();
		
			//removes negative sign on this string
				StringBuilder sb2 = new StringBuilder(s2);
				sb2.deleteCharAt(0);
				s2 = sb2.toString();
			}
			
			int len1 = s1.length(); 
		    int len2 = s2.length(); 
		    
		    if (len1 == 0 || len2 == 0) {  //checks if string is empty 
		       HugeInteger zero = new HugeInteger("0");
		       return zero;
		    }
		    
		    // will keep the result number in vector 
		    // in reverse order 
		    int result[] = new int[len1 + len2]; 
		  
		    // Below two indexes are used to  
		    // find positions in result.  
		    int i_n1 = 0;  
		    int i_n2 = 0;  
		      
		    // Go from right to left in num1 
		    for (int i = len1 - 1; i >= 0; i--) 
		    { 
		        int carry = 0; 
		        int n1 = s1.charAt(i) - '0'; 
		  
		        // To shift position to left after every 
		        // multipliccharAtion of a digit in num2 
		        i_n2 = 0;  
		          
		        // Go from right to left in num2              
		        for (int j = len2 - 1; j >= 0; j--) 
		        { 
		            // Take current digit of second number 
		            int n2 = s2.charAt(j) - '0'; 
		  
		            // Multiply with current digit of first number 
		            // and add result to previously stored result 
		            // charAt current position.  
		            int sum = n1 * n2 + result[i_n1 + i_n2] + carry; 
		  
		            // Carry for next itercharAtion 
		            carry = sum / 10; 
		  
		            // Store result 
		            result[i_n1 + i_n2] = sum % 10; 
		  
		            i_n2++; 
		        } 
		  
		        // store carry in next cell 
		        if (carry > 0) 
		            result[i_n1 + i_n2] += carry; 
		  
		        // To shift position to left after every 
		        // multipliccharAtion of a digit in num1. 
		        i_n1++; 
		    } 
		  
		    // ignore '0's from the right 
		    int i = result.length - 1; 
		    while (i >= 0 && result[i] == 0) { 
			    i--; 
			  
			    // If all were '0's - means either both  
			    // or one of s1 or s2 were '0' 
			    
			    if (i == -1) {
			    	HugeInteger zero = new HugeInteger("0");
				    return zero;
			    } 
		    }
		    // generate the result String 
		    
		    String s = ""; 
		      
		    while (i >= 0) { 
		        s += (result[i--]); //This prints the results from the array in reverse
		    }
		    
		    HugeInteger finale = new HugeInteger(s);
		    return finale;
		}
		return null;
	}
	
	public int compareTo(HugeInteger h) {
		//Returns -1 if this HugeInteger is less than h, 1 if this HugeInteger is larger than h, and 0 if this HugeInteger is equal to h
		String s1 = h.toString();
		String s2 = this.integer;
		
		if(s1.charAt(0) == '-' && s2.charAt(0) != '-' ) {
			
			return 1; //h is less than this HugeInteger
		   
		}
	    
		else if(s1.charAt(0) != '-' && s2.charAt(0) == '-' ) {
			
			return -1; //this integer is less than h
			
		}
		
		else if(s1.charAt(0) == '-' && s2.charAt(0) == '-' ){ //if they are both negative
			
			StringBuilder sb = new StringBuilder(s1);
			sb.deleteCharAt(0); //removes negative sign 
			s1 = sb.toString();
			
			StringBuilder sb2 = new StringBuilder(s2);
			sb2.deleteCharAt(0); //removes negative sign
			s2 = sb2.toString();
			
			if (s1.length() > s2.length()){  
		        return 1;
		    } 
			
		    else if(s1.length() < s2.length()) {
		    	return -1;
		    }
		    
		    else{ //if they are equal length 
		    	
		    	for(int i = 0; i < s2.length(); i++) { //iterate over the whole string
		    		if(s2.charAt(i) > s1.charAt(i)) {
		    			return -1; //bigger negative number 
		    		}
		    		
		    		else if(s2.charAt(i) < s1.charAt(i)) {
		    			return 1;
		    		}
		    		
		    	}
		    }
		}
		
		else if(s1.charAt(0) != '-' && s2.charAt(0) != '-') {//if they are both positive
			if (s1.length() > s2.length()){  
		        return -1;
		    } 
			
		    else if(s1.length() < s2.length()) {
		    	return 1;
		    }
		    
		    else{ //if they are equal length 
		    	for(int i = 0; i < s2.length(); i++) { //iterate over the whole string
		    		if(s2.charAt(i) > s1.charAt(i)) {
		    			return 1; //bigger positive number 
		    		}
		    		
		    		else if(s2.charAt(i) < s1.charAt(i)) {
		    			return -1;
		    		}
		    		
		    	}
		    }
		}
		
		return 0;
	}
	
	public static String removeZero(String g) 
    { 
		StringBuilder sb = new StringBuilder(g);
		 
		if(sb.charAt(0) == '-') { //checks for negative then skips over it in the while loop
			//stop the loop if there's only a single character left.
		    while (sb.length() > 1 && sb.charAt(1) == '0') { //checks if length is greater than 1 and the character is a 0
		        sb.deleteCharAt(1); //deletes the first element if its a 0
		    }
		}
		
		else {
			while (sb.length() > 1 && sb.charAt(0) == '0') { //checks if length is greater than 1 and the character is a 0
		    sb.deleteCharAt(0); //deletes the first element if its a 0
		    }
		}
		
	    return sb.toString(); //returns the new string 
    } 
	
	public String toString() {
		String newone = removeZero(integer); //calls the removeZero function on array string
		return newone;
	}

}
