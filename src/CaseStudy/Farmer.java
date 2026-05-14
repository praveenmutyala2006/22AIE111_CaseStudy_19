package CaseStudy;
import java.util.*;

class InvalidFarmerException extends Exception {
    InvalidFarmerException(String message) {
        super(message);
    }
}

class Farmer {
   private static int farmer_counter = 1;
   private final int farmer_id;
   private String name, recommendation;
   private double yield;
   private double fertilizer;
   private Soil soil;
   private Crop crop;

   Farmer(String name, Soil soil, Crop crop) {

	      int tempId = 0;

	      try {
	    	  
	    	  if (name == null || name.trim().isEmpty()) {
	            throw new InvalidFarmerException("Farmer name cannot be empty!");
	         }

	         
	         if (soil == null) {
	            throw new InvalidFarmerException("Soil object cannot be null!");
	         }

	         if (soil.get_name().trim().isEmpty()) {
	            throw new InvalidFarmerException("Soil name cannot be empty!");
	         }

	         
	         if (soil.get_soil_fertility() <= 0 || soil.get_soil_fertility() > 10) {
	            throw new InvalidFarmerException("Soil fertility must be between 1 and 10!");
	         }

	         
	         if (crop == null) {
	            throw new InvalidFarmerException("Crop object cannot be null!");
	         }

	         
	         this.name = name;
	         this.soil = soil;
	         this.crop = crop;

	         tempId = farmer_counter++;

	         System.out.println("Farmer " + name + " is successfully registered!");

	      }

	      catch (InvalidFarmerException e) {
	         System.out.println("Custom Exception: " + e.getMessage());
	      }

	      catch (Exception e) {
	         System.out.println("Unexpected Error: " + e.getMessage());
	      }

	      farmer_id = tempId;
	   }
   
   
   public void deploy(double water,double insects,double pesticide) {
	   crop.deployHelp(water, insects, pesticide, soil.get_soil_fertility());
   }
   
   public void changeConditions(double water, double soil_Fertility, double pesticide) {
	   crop.changeConditionshelp(water, soil_Fertility, pesticide);
   }
   
   public void set_fertilizer(int fertilizer) {
	   this.fertilizer = fertilizer;
      soil.fertilize(this.fertilizer);
   }

  

   public double calc_Yield(){
      this.yield = crop.getHealth()*10;
      return yield;
   }
   

   public void receive_advice(Advice advice_sent){
	   this.recommendation = advice_sent.getRecommendation();
      double[] values = advice_sent.dispense();
      act_on_advice(values[0], values[1], values[2]);
   }
   
   public double get_fertilizer(){
      return fertilizer;
   }
   
   public void act_on_advice(double waterChange, double fertilizerChange, double pesticideChange){      
       soil.fertilize(fertilizerChange);
       crop.changeConditionshelp(crop.getWater()+waterChange, soil.get_soil_fertility(), crop.getPesticide()+pesticideChange);
       
   }

   public Crop getCrop(){
      return crop;   
   }
   

   public Soil getSoil(){
      return soil;
   }

   public int getId(){
      return farmer_id;
   }
   
   public String getName(){
      return name;
   }
}