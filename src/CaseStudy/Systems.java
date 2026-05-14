package CaseStudy;

public class Systems {
    private Admin admin;
    private Expert expert;

    Systems(){
        admin = new Admin();
        expert = new Expert();
    }

    public void process_data(Farmer f){
        double waterChange = 0, fertilizerChange = 0, pesticideChange = 0;

        if(f.calc_Yield()  < 100.00){
            waterChange = f.getCrop().getWater() - f.getCrop().getWaterReq();
            fertilizerChange = 10 - f.getSoil().get_soil_fertility();
            pesticideChange = f.getCrop().getPesticide() - f.getCrop().getInsects();
        }
        
        
        expert.generate_advice(waterChange, fertilizerChange, pesticideChange,f.getId(), f.getName());

        admin.storeAdvice(expert.getAdvice());
        f.receive_advice(expert.getAdvice());
    }
    
    public Admin Admin() {
    	return admin;
    }
}