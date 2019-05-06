import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Simulation {
    public ArrayList<Item> loadItems(String fName){
        ArrayList<Item>  arrayList = new ArrayList<>();
        File file = new File(fName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String[] line = scanner.nextLine().split("=");
                Item item = new Item(line[0],Integer.parseInt(line[1]));
                arrayList.add(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> arrayList){
        ArrayList arrayListOfU1 = new ArrayList<>();
        Rocket u1 = new U1();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Item item = (Item) iterator.next();
            if(u1.canCarry(item)){
                u1.carry(item);
            }
            else {
                arrayListOfU1.add(u1);
                u1 = new U1();
                u1.carry(item);
            }
            if(!iterator.hasNext()){
                arrayListOfU1.add(u1);
            }
        }
        return arrayListOfU1;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> arrayList){
        ArrayList<Rocket> arrayListOfU2 = new ArrayList<>();
        Rocket u2 = new U2();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Item item = (Item) iterator.next();
            if(u2.canCarry(item)){
                u2.carry(item);
            }
            else {
                arrayListOfU2.add(u2);
                u2 = new U1();
                u2.carry(item);
            }
            if(!iterator.hasNext()){
                arrayListOfU2.add(u2);
            }
        }
        return arrayListOfU2;
    }

    public long runSimulation(ArrayList<Rocket> rocket){
        long totalBudget = 0;

        for(Rocket rocket1: rocket){
            while (!rocket1.launch()){
                totalBudget+=rocket1.getCost();
            }
            while (!rocket1.land()){
                while (!rocket1.launch()){
                    totalBudget+=rocket1.getCost();
                }
                totalBudget+=rocket1.getCost();
            }
            totalBudget+=rocket1.getCost();
        }
        return totalBudget;
    }

}
