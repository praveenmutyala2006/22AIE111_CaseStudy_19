package CaseStudy;

class InvalidSoilException extends Exception{
	InvalidSoilException(String message) {
        super(message);
    }
}

public class Soil {
    private String soil_name;
    private double soil_fertility;
    
    Soil(String name, double soil_fertility){
        try {
  		  if(name.trim().isEmpty()) {
  			throw new InvalidSoilException("Soil name cannot be empty!");  
  		  }
  		  
  		  if(soil_fertility < 0 || soil_fertility > 10) {
  			  throw new InvalidSoilException("Soil's Fertility must be above 0 and below 10");
  		  }
  		  
  		  this.soil_name=name;
  	      this.soil_fertility = soil_fertility;
  	  }
  	  catch(InvalidSoilException e) {
  		     System.out.println("Custom Exception: " + e.getMessage());  
  	  }
  	  catch (Exception e) {
  	         System.out.println("Unexpected Error: " + e.getMessage());
  	  }
    }
    


    public double get_soil_fertility() {
    	return soil_fertility;
    }
    

    public void fertilize(double fertilizer){
          if(fertilizer > 0 && fertilizer <= 10){
            soil_fertility = Math.min(10, soil_fertility+fertilizer);
            return;
          }
    }
    
    public String get_name() {
    	return soil_name;
    }
}