package homework1;

public class TestClass3 {

	public static void main(String[] args) {
		
		Account gizemsungu = new Account(1,"gizemsungu","13.01.1993","Gebze"); 
		Account sibelgulmez = new Account(2,"sibelgulmez","10.03.1995","Istanbul");
		Account gokhankaya = new Account(3,"gokhankaya","25.04.1990","Istanbul");
		
		
		gizemsungu.login("gizemsungu");
		gizemsungu.block(sibelgulmez);
		gizemsungu.logout();
		
		sibelgulmez.login("sibelgulmez");
		sibelgulmez.follow(gokhankaya);
		sibelgulmez.follow(gizemsungu);
		sibelgulmez.sendMessage(gokhankaya, "hi");
		sibelgulmez.sendMessage(gizemsungu, "hi");
	}

}
