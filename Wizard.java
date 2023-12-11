// Titus Duncan, Jack Ventura, Matt Molewyk / C211 Project, Fall 2023

package application;

//subclass of personality. Used to create a Wizard personality object
public class Wizard extends Personality {
	
	// Return Wizard personality type
    @Override
    String getType() {
        return "Wizard";
    }
    
    //Return a description of Wizard personality type
    @Override
    String getDescription() {
        return "Casts spells and uses sorcery to get the job done. Very powerful.";
    }
}

