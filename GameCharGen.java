import java.util.Scanner;


public class GameCharGen 
{
	
	public static void main(String[] args)  throws NoGameCharacterFoundException
	{   Scanner menuInput = new Scanner(System.in);
		int numGameCharacters=0;
		GameCharGenModel myCharGen = new GameCharGenModel();
		Wizard wizard = new Wizard();
		Fighter fighter = new Fighter();
		Cleric cleric = new Cleric();
		String string="";
		do{ System.out.println();
		    System.out.println("*** WoK gameCharGen menu ***");
		    System.out.println(" Create Wizard         WZ");
		    System.out.println(" Create Fighter        FG");
		    System.out.println(" Create Cleric         CL");
		    System.out.println(" Lowest HP Character   LHC");
		    System.out.println(" Sort Characters Asc.  SCA");
		    System.out.println(" Sort Characters Desc. SCD");
		    System.out.println(" Display Characters    DC");
		    System.out.println(" Exit Program          EX");
		    System.out.print(" Enter Selection:");
			string = menuInput.next();
			if(string.equalsIgnoreCase("WZ")) {//using equalsIgnoreCase to make it case insensitive 
				System.out.println();
				wizard.randGen(true);
				wizard.display();
				myCharGen.addGameCharacter(wizard);
				numGameCharacters++;
				System.out.println();
			}
			else if(string.equalsIgnoreCase("FG")) {
				System.out.println();
				fighter.randGen(false);
				fighter.display();
				myCharGen.addGameCharacter(fighter);
				numGameCharacters++;
				System.out.println();
			}
			else if(string.equalsIgnoreCase("CL")) {
				System.out.println();
				cleric.randGen(true);
				cleric.display();
				myCharGen.addGameCharacter(cleric);
				numGameCharacters++;
				System.out.println();
			}
			else if(string.equalsIgnoreCase("LHC")) {
				try{//using try and catch method to handle exception
					System.out.println("Game Character at index "+ myCharGen.getLowestHPGameCharacter()+" had lowest HP");
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
			else if(string.equalsIgnoreCase("SCA")) {
				try{
					myCharGen.sortGameCharacterWisdom(true);
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
			else if(string.equalsIgnoreCase("SCD")) {
				try{
					myCharGen.sortGameCharacterWisdom(false);
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
			else if(string.equalsIgnoreCase("DC")){
				System.out.println("number of creations: "+numGameCharacters);
				try{
					myCharGen.display();
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
			else if (string.equalsIgnoreCase("EX")) {
				menuInput.close();
				System.out.println("***************");
				System.out.println("Quitting now...");
				System.out.println("***************");
				System.exit(0);
			}
			else {
				System.out.println("Unrecognised command");	
			}
			}while(string.charAt(0)!='E'||string.charAt(0)!='e');
			
		
	}

}