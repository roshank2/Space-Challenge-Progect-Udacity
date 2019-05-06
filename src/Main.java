public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        long phase1U1 = simulation.runSimulation(simulation.loadU1(simulation.loadItems("phase-1.txt")));
        System.out.println("Budget for Phase 1 (U1): $" + phase1U1);
        long phase2U1 = simulation.runSimulation(simulation.loadU1(simulation.loadItems("phase-2.txt")));
        System.out.println("Budget for Phase 2 (U1): $" + phase2U1);
        long totalBudgetU1 = phase1U1+phase2U1;
        System.out.println("Total Budget (U1) $" + totalBudgetU1);



        long phase1U2 = simulation.runSimulation(simulation.loadU1(simulation.loadItems("phase-1.txt")));
        System.out.println("Budget for Phase 1 (U2): $" + phase1U2);
        long phase2U2 = simulation.runSimulation(simulation.loadU1(simulation.loadItems("phase-2.txt")));
        System.out.println("Budget for Phase 2 (U2): $" + phase2U2);
        long totalBudgetU2 = phase1U2+phase2U2;
        System.out.println("Total Budget (U2) $" + totalBudgetU2);

        if(totalBudgetU1>totalBudgetU2){
            System.out.println("\n U2 is Cheaper");
        }else if(totalBudgetU1<totalBudgetU2) {
            System.out.println("\n U1 is Cheaper");
        }else {
            System.out.println("\nBoth will cost same");
        }
    }
}
