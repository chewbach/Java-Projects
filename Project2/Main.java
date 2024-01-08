package hw04;

public class Main {

	public static void main(String[] args) {
		SecuritySystem officer1 = new SecuritySystem();
		
		
		officer1.setDenomination(new int[]{4,17,29});
		
		
		officer1.login("sibelgulmez","[rac()ecar]",74);
		officer1.login("","[rac()ecar]",74);
		officer1.login("sibel1","[rac()ecar]", 74);
		officer1.login("sibel","pass[]",75);
		officer1.login("sibel", "abcdabcd",74);
		officer1.login("sibel","[[[[]]]]",74 );
		officer1.login("sibel","[no](no)",74);
		officer1.login("sibel", "[rac()ecar]]", 74);
		officer1.login("sibel","[rac()ecars]",74);
		officer1.login("sibel","[rac()ecar]",8);
		officer1.login("sibel", "[rac()ecar]", 35);
		
	}

}
