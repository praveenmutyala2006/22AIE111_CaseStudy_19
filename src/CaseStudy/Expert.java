package CaseStudy;
public class Expert{
    private Advice advice;
    
    public void generate_advice(double waterChange, double fertilizerChange, double pesticideChange, int farmer_id, String name){
       this.advice = new Advice(waterChange,fertilizerChange,pesticideChange);
       advice.setRecommendation(generate_recommendation(farmer_id, name));
    } 

    public Advice getAdvice(){
        return advice;
    }
    
    private String generate_recommendation(int farmer_id, String name) {
        double[] changes = advice.dispense();
        double waterChange = changes[0];
        double fertilizerChange = changes[1];
        double pesticideChange = changes[2];
        
        
        StringBuilder recommendationBuilder = new StringBuilder();

        recommendationBuilder.append("Farmer ID: " + farmer_id + ", Name: " + name + ", ");

        int initialLength = recommendationBuilder.length();
       
        if (waterChange < 0) {
            recommendationBuilder.append("Increase water by " + String.format("%.2f", waterChange*-1) + " units, ");
        } 
        else if (waterChange > 0) {
            recommendationBuilder.append("Reduce water by " + String.format("%.2f", waterChange) + " units, ");
        }

        if (fertilizerChange > 0) {
            recommendationBuilder.append("Add " + String.format("%.2f", fertilizerChange) + " units of fertilizer, ");
        }
        

        if (pesticideChange < 0) {
            recommendationBuilder.append("Increase pesticide by " + String.format("%.2f", pesticideChange*-1) + " units, ");
        } 
        else if (pesticideChange > 0) {
            recommendationBuilder.append("Reduce pesticide by " + String.format("%.2f", pesticideChange) + " units, ");
        }

        if (recommendationBuilder.length() == initialLength) {
            return "Farmer ID: " + farmer_id + ", Name: " + name + ": No requirement of any changes!";
        }

        if (recommendationBuilder.substring(recommendationBuilder.length() - 2).equals(", ")) {
            recommendationBuilder.delete(recommendationBuilder.length() - 2, recommendationBuilder.length());
        }

      return recommendationBuilder.toString();
    }

}