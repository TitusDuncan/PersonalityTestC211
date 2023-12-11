package application;

//subclass of personality. Used to create a Rogue personality object
public class Rogue extends Personality {
	
	// Return Fighter personality type
    @Override
    String getType() {
        return "Rogue";
    }
    
    // Return description of Rogue personality type
    @Override
    String getDescription() {
        return "Smart and stealthy. If a mission requires someone to be sneaky, you're the person in mind.";
    }
}
