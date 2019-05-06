public class U2 extends Rocket {
    private double chanceLaunched;
    private double chanceLanded;
    U2(){
        setCost(120000000);
        setRocketWeight(18000);
        setTotalWeight(29000);
        setMaxCargo(getTotalWeight()-getRocketWeight());
    }

    @Override
    public boolean launch(){
        double rand = Math.random();
        chanceLaunched=0.04*((double)getCargoCarried()/(double)getMaxCargo());
        if(chanceLaunched>=rand){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean land(){
        double rand = Math.random();
        chanceLanded=0.08*((double)getCargoCarried()/(double)getMaxCargo());
        if(chanceLanded>=rand){
            return false;
        }
        else {
            return true;
        }
    }
}
