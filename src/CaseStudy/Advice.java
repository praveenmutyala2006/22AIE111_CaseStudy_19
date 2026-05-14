package CaseStudy;
import java.util.*;
class Advice{
    private double waterChange;
    private double pesticideChange;
    private double fertilizerChange;
    private String recommendation;

    Advice(double waterChange, double fertilizerChange, double pesticideChange){
      this.waterChange = waterChange;
      this.pesticideChange = pesticideChange;
      this.fertilizerChange = fertilizerChange;
    }
 
    public void setRecommendation(String recommendation) {
    	this.recommendation = recommendation;
    }
    
    public double[] dispense(){
      double[] values = {waterChange,fertilizerChange,pesticideChange};
      return values;
    }

    public String getRecommendation(){
      return recommendation;
    }
}