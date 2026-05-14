package CaseStudy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Systems system = new Systems();
        Soil soil = null;
        Crop crop = null;
        Farmer farmer = null;
        int choice;
        System.out.println("SMART AGRICULTURE MANAGEMENT SYSTEM ");

        do {
        	System.out.println();
            System.out.println("1.Add Soil");
            System.out.println("2.Add Crop");
            System.out.println("3.Add Farmer");
            System.out.println("4.Deploy Crop");
            System.out.println("5.Change Conditions");
            System.out.println("6.Process Data");
            System.out.println("7.Display Recommendation Records");
            System.out.println("8.Display Crop Health");
            System.out.println("9.Display Crop Yield");
            System.out.println("10.Exit");
            System.out.print("Enter Choice:");
            choice = scanner.nextInt();

            switch (choice) {

                case 1: scanner.nextLine();
                
                        System.out.print("Enter Soil Name:");
                        String soilName = scanner.nextLine();
                        System.out.print("Enter Soil Fertility (1-10):");
                        double soilFertility = scanner.nextDouble();
                        soil = new Soil(soilName, soilFertility);
                        System.out.println("Soil Added Successfully!");
                        break;

                case 2: scanner.nextLine();
                        System.out.print("Enter Crop Name:");
                        String cropName = scanner.nextLine();
                        System.out.print("Enter Crop Water Requirement (1-10):");
                        double waterReq = scanner.nextDouble();
                        crop = new Crop(cropName, waterReq);
                        System.out.println("Crop Added Successfully!");
                        break;

                case 3: if (soil == null || crop == null) {
                            System.out.println("Please Add Soil and Crop First!");
                            break;
                        }
                        scanner.nextLine();
                        System.out.print("Enter Farmer Name:");
                        String farmerName = scanner.nextLine();
                        farmer = new Farmer(farmerName, soil, crop);
                        System.out.println("Farmer Added Successfully!");
                        break;

                case 4: if (farmer == null) {
                            System.out.println("Please Add Farmer First!");
                            break;
                        }
                        System.out.print("Enter Water Supply:");
                        double water = scanner.nextDouble();
                        System.out.print("Enter Insect Level:");
                        double insects = scanner.nextDouble();
                        System.out.print("Enter Pesticide Level:");
                        double pesticide = scanner.nextDouble();
                        farmer.deploy(water, insects, pesticide);
                        System.out.println("Crop Deployed Successfully!");
                        break;

                case 5: if (farmer == null) {
                            System.out.println("Please Add Farmer First!");
                            break;
                        }
                        System.out.print("Enter New Water Supply:");
                        double newWater = scanner.nextDouble();
                        System.out.print("Enter New Soil Fertilizer:");
                        double newFertility = scanner.nextDouble();
                        System.out.print("Enter New Pesticide Level:");
                        double newPesticide = scanner.nextDouble();
                        farmer.changeConditions(newWater, newFertility, newPesticide);
                        System.out.println("Conditions Updated Successfully!");
                        break;

                case 6: if (farmer == null) {
                            System.out.println("Please Add Farmer First!");
                            break;
                        }
                        system.process_data(farmer);
                        System.out.println("Data Processed Successfully!");
                        break;

                case 7: system.Admin().displayRecords();
                        break;

                case 8: if (farmer == null) {
                            System.out.println("Please Add Farmer First!");
                            break;
                        }
                        System.out.println("Crop Health: " + String.format("%.2f", farmer.getCrop().getHealth()));
                        break;

                case 9: if (farmer == null) {
                            System.out.println("Please Add Farmer First!");
                            break;
                        }
                        System.out.println("Crop Yield: " + String.format("%.2f", farmer.calc_Yield()) + "%");
                        break;

                case 10: System.out.println("Exiting Program...");
                         break;

                default: System.out.println("Invalid Choice!");
            }

        } while (choice != 10);

        scanner.close();
    }
}