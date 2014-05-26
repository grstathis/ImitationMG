package imitationmgjava;
import java.util.*;

/**
 *Initializes the Single or Multi Population Agents using generic methods 
 * depending of the type of Agents requested.
 * 
 * @author stathis
 */
class Initialization{
    
    
    //Initialize the RNG here, use it once as the class does not have 
    //a purporse except creating agents and population to begin the game
    private int seed;
    private  Random rand = new Random(seed);
    
    /**
     * Set Seed for Initialization of Agents and Populations
     * @param seed 
     */
    public void setSeed(int seed){
     this.seed = seed;        
    }
    
    /**
     * Returns the Initialization seed
     * @return seed 
     */
    public int getSeed(){
     return this.seed;        
    }
    
    
    /**
     * 
     * Method to initialize Populations requested from the user. Depending on the number requested, 
     * a Single Population Class is created (when one is set) or a Multi Population Class (over one population)  
     * To create the populations, we overload the same method.
     * 
     * 
     * @param NumberOfPopulations
     * @param NumberOfAgents
     * @return PopulationsList
     */
    
    public ArrayList<Population> InitializePopulations (int NumberOfPopulations, int NumberOfAgents){
        
        ArrayList<Population> PopulationsList = new ArrayList();
        
        if(NumberOfPopulations == 1){
            
          PopulationsList.add(InitSinglePopulation(NumberOfAgents));
            
        }else{
            
           for(int i = 0; i < NumberOfPopulations; i++){ 
                double temp = rand.nextDouble();
                PopulationsList.add(InitSinglePopulation(i, NumberOfAgents, temp));
           }
            
        }
        
        
        return PopulationsList;
    }
    
    
    
    /**
     * Method to create a Single Population.
     * 
     * @param NumberOfAgents
     * @return Single Population (TempPopulation)
     */
    
    public Population InitSinglePopulation(int NumberOfAgents) {
              
        SinglePopulation TempPopulation = new SinglePopulation();
        
        TempPopulation.setPopulationID(0);

        for(int j = 0; j < NumberOfAgents; j++){

           SinglePopulationAgent TempAgentS = new SinglePopulationAgent(j,rand.nextDouble());
           boolean InitAction = (rand.nextDouble() < TempAgentS.getStrategy()) ? true : false;
           TempAgentS.setAction(InitAction);
     
           TempPopulation.AgentList.add(TempAgentS);
        }
        
        TempPopulation.setStrategyList();
        TempPopulation.setActionList();
        return TempPopulation;
    }
    
    
    
    /**
     * Method overloaded to create Multi Population.
     * 
     * @param PopulationID
     * @param NumberOfAgents
     * @param MixedStrategy
     * @return Multi Population (TempPopulation)
     */
    
    public Population InitSinglePopulation
                 (int PopulationID, int NumberOfAgents, double MixedStrategy){
                
        MultiPopulation TempPopulation = new MultiPopulation();

        TempPopulation.setPopulationID(PopulationID);
        TempPopulation.setInitMixedStrategy(MixedStrategy);

        for(int j = 0; j < NumberOfAgents; j++){

           double TempDraw = rand.nextDouble();
           boolean TempAction = (TempDraw < MixedStrategy) ? true : false;
           MultiPopulationAgent TempAgentM = 
                   new MultiPopulationAgent(j,PopulationID,TempAction);
           
          TempPopulation.AgentList.add(TempAgentM);
          
         }
        
        TempPopulation.setActionList();
        return TempPopulation;
    } 
    
}
