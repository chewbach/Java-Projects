package homework1;


public class TestClass1 {

	public static void main(String[] args) {
		
		Account gizemsungu = new Account(1,"gizemsungu","13.01.1993","Gebze"); 
		Account sibelgulmez = new Account(2,"sibelgulmez","10.03.1995","Istanbul");
		Account gokhankaya = new Account(3,"gokhankaya","25.04.1990","Istanbul");
		
		
		
		sibelgulmez.login("sibelgulmez");
		sibelgulmez.addPost("I like Java");
		sibelgulmez.addPost("Java the coffee...");
		sibelgulmez.follow(gizemsungu);
		sibelgulmez.follow(gokhankaya);
		sibelgulmez.logout();
		gokhankaya.login("gokhankaya");
		gokhankaya.viewProfile(sibelgulmez);
		gokhankaya.viewPosts(sibelgulmez);
		gokhankaya.like(sibelgulmez, 1);
		gokhankaya.comment(sibelgulmez,1,"me too!");
		gokhankaya.follow(sibelgulmez);
		gokhankaya.follow(gizemsungu);
		gokhankaya.sendMessage(gizemsungu,"This homework is too easy!");
		gokhankaya.logout();
		gizemsungu.login("gizemsungu");
		gizemsungu.checkOutbox();
		gizemsungu.checkInbox();
		gizemsungu.viewInbox();
		gizemsungu.viewProfile(sibelgulmez);
		gizemsungu.viewPosts(sibelgulmez);
		gizemsungu.viewInteractions(sibelgulmez);
		gizemsungu.like(sibelgulmez,1);
		gizemsungu.like(sibelgulmez, 2);
		gizemsungu.viewInteractions(sibelgulmez);
		
		
		
		
		
	}

}
