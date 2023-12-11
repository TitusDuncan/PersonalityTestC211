// Titus Duncan, Jack Ventura, Matt Molewyk / C211 Project, Fall 2023

package application;

//subclass of personality. Used to create a Fighter personality object
public class Fighter extends Personality {
	
	// Return Fighter personality type
    @Override
    String getType() {
        return "Fighter";
    }
    
    // Return a description of Fighter personality type
    @Override
    String getDescription() {
        return "Likes to fight their way through battles. Skilled in hand-to-hand combat and loves"
        		+ " to use weapons.";
    }
}

