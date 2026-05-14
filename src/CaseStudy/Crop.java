package CaseStudy;

class InvalidCropException extends Exception{
	InvalidCropException(String message) {
        super(message);
    }
}

class Crop {
    private String name; 
	private double water,pesticide,insects;
	private double water_req;
	private double health;
    
	Crop(String name,double water_req){
	  
	  try {
		  if(name.trim().isEmpty()) {
			throw new InvalidCropException("Crop name cannot be empty!");  
		  }
		  
		  if(water_req < 0 || water_req > 10) {
			  throw new InvalidCropException("Crop's Water Requirement must be above 0 and below 10");
		  }
		  
		  this.name=name;
	      this.water_req = water_req;
	  }
	  catch(InvalidCropException e) {
		     System.out.println("Custom Exception: " + e.getMessage());  
	  }
	  catch (Exception e) {
	         System.out.println("Unexpected Error: " + e.getMessage());
	  }
    }

	
	public void deployHelp(double water,double insects,double pesticide,double soil_Fertility){
          this.insects = insects;
		  changeConditionshelp(water, soil_Fertility, pesticide);
	}


	public void changeConditionshelp(double water,double fertilizer,double pesticide){
          this.water = water;
		  this.pesticide = pesticide;
		  calcHealth(fertilizer);
	}
	
	private void calcHealth(double soil_Fertility) {
		double water_Effect  = 10-Math.abs(water-water_req);
		double insect_Effect = (Math.max(0, (insects-pesticide)));
		health = Math.min(10, (water_Effect + soil_Fertility/2)*(10-insect_Effect)) / 10;
	}
	
	public double getWater() {
		return water;
	}
	
	public double getWaterReq() {
		return water_req;
	}
	
	public double getPesticide(){
		return pesticide;
	}

	public double getInsects(){
		return insects;
	}	

	public double getHealth(){
		return health;
	}
}