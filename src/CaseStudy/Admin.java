package CaseStudy;
import java.util.*;
public class Admin {
    private ArrayList<Advice> record_of_advice;
    
    Admin(){
        record_of_advice = new ArrayList<>();
    }

    public void storeAdvice(Advice adviceSent){
        if(!adviceSent.getRecommendation().isEmpty()){
            record_of_advice.add(adviceSent);
        }
    }

    public void displayRecords(){
       System.out.println("Records:");
       
       for(Advice advice : record_of_advice){
          System.out.println(advice.getRecommendation());
       }
    }

}