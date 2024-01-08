package hw04;
import java.util.EmptyStackException;
import java.util.Stack;

public class SecuritySystem {
	private String username;
	private String password1;
	private int password2;
	private int[] denominations;
	
	
	public void setDenomination(int[] denominations) {
		
		this.denominations = denominations;
	}
	public void login(String username,String password1,int password2) {
		this.username = username;
		this.password1 = password1;
		this.password2 = password2;

		if (checkIfValidUsername(username) && checkPassword(password1) && checkHasTwoBrackets(password1) && checkContainsCharacter(username, password1) ) {
			
			if(!isBalancedPassword(password1)) {
				System.out.println("The password1 is invalid. It should be balanced.");
				return;
			}
			if(!isPalindromePossible(password1)) {
				System.out.println("The password1 is invalid. It should be possible to obtain a palindrome from the password1.");
				return;
			}
			if(!isExactDivision(password2,denominations)) {
				System.out.println("The password2 is invalid. It is not compatible with the denominations.");
				return;
			}
			if(!checkPassword2(password2)) {
				System.out.println("The password2 is invalid. It should be between 10 and 10,000.");
				return;
			}
			System.out.println("The username and passwords are valid. The door is opening, please wait..");
		}
		else {
			return;
		}
	}

	
	public boolean checkPassword2(int password2) {
		
		if(!(password2>=10 && password2<=10000)) {
			return false;
		}
		

		return true;
	}
	
	public boolean checkBalanced(String password1) {
		try {
		if(! isBalancedPassword(password1)) {
			throw new Exception ("The password1 is invalid. It should be balanced.");
		}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
	        return false;
		}
		return true;
	}
	
	public boolean checkContainsCharacter(String username,String password) {
		try {
			if(!containsUserNameSpirit(username,password1)) {
				throw new Exception("The password1 is invalid. It should have at least 1 character from the username.");
			}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
		        return false;
			}
		return true;
	}
	
	public  boolean checkPassword(String str) {
		try {
	        if (password1.length() < 8) {
	            throw new IllegalArgumentException("The password1 is invalid. It should have at least 8 characters.");
	        }
		}
	        catch (IllegalArgumentException e) {
		        System.out.println(e.getMessage());
		        return false;
		    }
	        return true;
	}
	
	

	
	public boolean checkIfValidUsername(String username) {
		try {
		if (username.length() == 0) {
		throw new IllegalArgumentException("The username is invalid. It should have at least 1 character.");
		} else if (username.length() == 1) {
			if(!Character.isLetter(username.charAt(0))) {
				throw new IllegalArgumentException("The username is invalid. It should have letters only.");
			}
		return Character.isLetter(username.charAt(0)); // single character must be a letter
		} else {
		char firstChar = username.charAt(0);
		if (!Character.isLetter(firstChar)) {
		throw new IllegalArgumentException("The username is invalid. It should have letters only.");
		} else {
		String restOfString = username.substring(1);
		return checkIfValidUsername(restOfString); // recursive call on the rest of the string
		}
		}
		} catch (IllegalArgumentException e) {
		System.out.println(e.getMessage());
		return false;
		}
		}

	
	public boolean containsUserNameSpirit(String username, String password1) {
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < password1.length(); i++) {
            stack.push(password1.charAt(i));
        }
		
	

        for (int i = 0; i < password1.length(); i++) {
            char top = stack.pop();
            for(int j = 0;j < username.length();j++) {
            	if(username.charAt(j) == top) {
            		return true;
            	}
            }
        }

        
        return false;
	}
	
	public boolean checkHasTwoBrackets(String password1) {
		 Stack<Character> stack = new Stack<Character>();
		 try {
		 int bracketCount = 0;
	        boolean hasLetter = false; // new variable to track if password1 has any letters
	        for (int i = 0; i < password1.length(); i++) {
	            char ch = password1.charAt(i);
	            if (ch == '(' || ch == ')' || ch == '{' || ch == '}' || ch == '[' || ch == ']') {
	                bracketCount++;
	            } else if (Character.isLetter(ch)) { // check if character is a letter
	                hasLetter = true;
	            }
	        }

	        if (bracketCount < 2) {
	            throw new IllegalArgumentException("The password1 is invalid. It should contain at least 2 brackets.");
	        } else if (!hasLetter) { // throw new exception if password1 has no letters
	            throw new IllegalArgumentException("The password1 is invalid. It should have letters too.");
	        }
		 }
		 catch (IllegalArgumentException e) {
	    	 System.out.println(e.getMessage());
	    	return false;
	    }
		 return true;
	}
	
	public boolean isBalancedPassword(String password1) {
	    boolean balanced = true;
	    Stack<Character> stack = new Stack<Character>();

	    try {
	       

	        
	        int index = 0;
	        while (balanced && index < password1.length()) {
	            char nextch = password1.charAt(index);
	            if (password1.charAt(index) == '(' || password1.charAt(index) == '{' || password1.charAt(index) == '[') {
	                stack.push(password1.charAt(index));
	            } else if (password1.charAt(index) == ')' || password1.charAt(index) == '}' || password1.charAt(index) == ']') {
	                char topch = stack.pop();
	                balanced = (topch == '(' && nextch == ')') || (topch == '{' && nextch == '}') || (topch == '[' && nextch == ']');
	            }

	            index++;
	        }
	    } catch (EmptyStackException ex) {
	        //System.out.println(ex.getMessage());
	        balanced = false;
	    }
	    

	    return balanced && stack.empty();
	}

	
	public boolean isExactDivision(int password2, int[] denominations) {
	    int[] result = new int[denominations.length];
	    return exactDivisionHelper(password2, denominations, 0 , result);
	}

	private boolean exactDivisionHelper(int password2, int[] denominations, int index, int[] result) {
	    if (password2 == 0) {
	       /* System.out.print("Explanation: ");
	        for(int i = 0; i < denominations.length; i++) {
	            for(int j = 0; j < result[i]; j++) {
	                System.out.print(denominations[i]);
	                if(i != denominations.length - 1 || j != result[i] - 1) {
	                    System.out.print("+");
	                }
	            }
	        }
	        
	        int total = 0;
	        for(int i = 0; i<denominations.length;i++) {
	        	total += denominations[i]*result[i]; 
	        }
	        System.out.print("="+total);
	        System.out.print(". The coefficients are respectively ");
	        for (int i = 0; i < result.length; i++) {
	            System.out.print(result[i] + ", ");
	        }*/
	        return true;
	    }
	    if (password2 < 0 || index == denominations.length) {
	        return false;
	    }
	    int currentDenomination = denominations[index];
	    for (int i = 0; i <= password2 / currentDenomination; i++) {
	        result[index] = i;
	        if (exactDivisionHelper(password2 - i * currentDenomination, denominations, index + 1, result)) {
	            return true;
	        }
	    }
	    return false;
	}




	public boolean isPalindromePossible(String str) {
	    int[] count = new int[26];
	    str = str.replaceAll("[{}\\[\\]()]", "");
	    return isPalindromePossibleRecursiveHelper(str, count);
	}

	private boolean isPalindromePossibleRecursiveHelper(String str, int[] count) {
	    if (str.length() == 0) {
	        int oddCount = 0;
	        for (int i = 0; i < count.length; i++) {
	            if (count[i] % 2 == 1) {
	                oddCount++;
	            }
	        }
	        return oddCount <= 1;
	    }
	    count[str.charAt(0) - 'a']++;
	    return isPalindromePossibleRecursiveHelper(str.substring(1), count);
	}






	





	
	
	
}
