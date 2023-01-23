import java.util.Arrays;

public class GameCharGenModel 
{
	static public int NUM_CHARS_BLOCK = 500;
	final public int STRENGTH=0; 
	final public int INTELLIGENCE=1; 
	final public int WISDOM=2;
	
	private int gameCharCount=0;
	private GameCharacter[] randomGameChars = new GameCharacter[NUM_CHARS_BLOCK];
	
	/**
	 * Returns the number of randomly-generated characters so far. 
	 * @return Number of randomly-generated characters.
	 */
	public int getNumCharacters()
	{
		return gameCharCount;
	}
	
	/**
	 * Adds a character to the array of characters
	 * @param c character to be added
	 */
	public void addGameCharacter(GameCharacter c)
	{
		if (gameCharCount>=randomGameChars.length)
		{
			GameCharacter[] newRandomChars = Arrays.copyOf(randomGameChars,randomGameChars.length+GameCharGenModel.NUM_CHARS_BLOCK);
			randomGameChars = newRandomChars;
		}
			
		randomGameChars[gameCharCount] = c;
		gameCharCount++;
	}
	
	/**
	 * Returns a character at a given index
	 * @return Character at a given index
	 */
	public GameCharacter gameCharacterAt(int idx)
	{
		if (idx<0 || idx>=randomGameChars.length)
			throw new IndexOutOfBoundsException();
		
		return randomGameChars[idx];
	}
	
	/**
	 * Finds a character with either maximum strength, intelligence or wisdom based on the parameter passed.
	 * @return Index of the character with lowest HP in the character array.
	 * @throws NoGameCharacterFoundException
	 */
	public int getLowestHPGameCharacter() throws NoGameCharacterFoundException
	{   if(gameCharCount==0) throw new NoGameCharacterFoundException("No Character Found ");
		int min = randomGameChars[0].hitPoints;
		int index =0;
		for(int i =1; i < gameCharCount;i++) {
			if(randomGameChars[i].hitPoints < min) {
				min = randomGameChars[i].hitPoints;
				index = i;
			}
		}
		return index;
	}
	public void display() throws NoGameCharacterFoundException{
		if(gameCharCount==0) throw new NoGameCharacterFoundException("No Character Found ");
		else{
			for (int i = 0; i < gameCharCount; i++){
				System.out.println();
				randomGameChars[i].display();
			}
		}
	}
	
	
	public void sortGameCharacterWisdom(boolean ascending) throws NoGameCharacterFoundException
	{
		GameCharacter temp;
		if(ascending) {
			if(gameCharCount==0) throw new NoGameCharacterFoundException("No Character Found");
			for(int i=0; i < gameCharCount;i++) {
				for(int j =0; j < gameCharCount-1;j++) {
					if(randomGameChars[j].wisdom>randomGameChars[j+1].wisdom) {
						temp = randomGameChars[j];
						randomGameChars[j]= randomGameChars[j+1];
						randomGameChars[j+1] = temp;
						
					}
				}
			}
		}
		else {
			if(gameCharCount==0) throw new NoGameCharacterFoundException("No Character Found ");
			for(int i=0; i < gameCharCount;i++) {
				for(int j =0; j < gameCharCount-1;j++) {
					if(randomGameChars[j].wisdom<randomGameChars[j+1].wisdom) {
						temp = randomGameChars[j];
						randomGameChars[j]= randomGameChars[j+1];
						randomGameChars[j+1] = temp;
						
					}
				}
			}
		}
		
	}

}
