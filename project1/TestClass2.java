package homework1;

public class TestClass2 {

	public static void main(String[] args) {
		
		Account gizemsungu = new Account(1,"gizemsungu","13.01.1993","Gebze"); 
		Account sibelgulmez = new Account(2,"sibelgulmez","10.03.1995","Istanbul");
		Account gokhankaya = new Account(3,"gokhankaya","25.04.1990","Istanbul");
		
	
		gizemsungu.login("gizemsungu");
		gizemsungu.addPost("I like Java");
		gizemsungu.addPost("Java the coffee...");
		gizemsungu.logout();
		
		sibelgulmez.login("sibelgulmez");
		sibelgulmez.viewProfile(gizemsungu);
		sibelgulmez.like(gizemsungu, 1);
		sibelgulmez.logout();
		
		gokhankaya.login("gokhankaya");
		gokhankaya.viewProfile(gizemsungu);
		gokhankaya.comment(gizemsungu,2,"Nice!");
		gokhankaya.follow(gizemsungu);
		gokhankaya.sendMessage(gizemsungu, "Hello!");
		gokhankaya.logout();
		
		gizemsungu.login("gizemsungu");
		gizemsungu.viewProfile(gizemsungu);
		gizemsungu.readMessagesFrom(gokhankaya);
	
	}

}
