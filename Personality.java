// DnD Personalities, Jack Ventura, 11/13/2023
// Program to determine a user's DnD class based on personality questions
public abstract class Personality {
	
	// declare variables for DnD classes
	public String fightingStyle;
	public String weapon;
	public String armor;
	public String health;
	
	// constructor for DnD class
	public Personality(String fightingStyle, String weapon, String armor, String health)
	{
		this.fightingStyle = fightingStyle;
		this.weapon = weapon;
		this.armor = armor;
		this.health = health;
	}
	
}
