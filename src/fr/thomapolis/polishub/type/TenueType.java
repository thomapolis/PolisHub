package fr.thomapolis.polishub.type;

import java.util.ArrayList;
import java.util.List;

import fr.thomapolis.polishub.tenues.Tenue;
import fr.thomapolis.polishub.tenues.TenueNovice;

public class TenueType {

public List<Tenue> tenues = new ArrayList<>();
	
	public TenueType() {
		
		register();
		
	}
	
	public void register() {
		
		this.tenues.add(new TenueNovice());
		
	}
	
}
