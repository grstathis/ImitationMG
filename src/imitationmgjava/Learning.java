package imitationmgjava;

import java.util.*;

/**
 * Implements Imitation as Learning for the Minority Game. 
 * The Agents imitate another Agent (Reference Agent) from their OWN Population 
 * (This holds for both Single and Multi Population Games). 
 * The class can be extended to create more learning methods (for example.
 * @author stathis
 * @version %I%
 */
 class Learning {
     
  private int seed;
  private  Random rand = new Random(seed);
    
    /**
     * Set Seed for selecting Agents to Imitate
     * @param seed 
     */
    public void setSeed(int seed){
     this.seed = seed;        
    }
    
    /**
     * Returns the Seed for selecting Agents to Imitate
     * @return seed 
     */
    public int getSeed(){
     return this.seed;        
    }
 
 
 
 /**
  * 
  * Sets the Reference AgentID inside the structure of the potential Imitator.
  * The <code>ImitatorList</code> is a general List for both Single and Multi Population Games.
  * Moreover, this function accepts both Population types (Single, Multi).
  * 
  * @param <PopulationClass>
  * @param ImitatorsList
  * @param GamePopulations 
  */
 public <PopulationClass extends Population>
 void setImitatorReferres 
 (ArrayList<Agent> ImitatorsList, ArrayList<PopulationClass> GamePopulations){
     
     
     
     int psize = GamePopulations.get(0).getPopulationSize();
     
     
     for(Agent Imitator: ImitatorsList){
        Imitator.setRefAgentID(rand.nextInt(psize));
     }
     
     
          
 }
 
 /**
  * In the Single Population case, the potential Imitating Agents 
  * hold the Strategy of the Reference Agent. Thus the Setter. 
  * 
  * @param ImitatorsList
  * @param GamePopulations 
  */
 
 public void setRefStragies(ArrayList<SinglePopulationAgent> ImitatorsList, 
                            ArrayList<SinglePopulation> GamePopulations){
     
     int i = 0;
     
     for(SinglePopulationAgent Imitator: ImitatorsList){
        Imitator.setRefStrategy(GamePopulations.get(0).AgentList.
                get(Imitator.getRefAgentID()).getStrategy());
        i++;
     }
 }
 
 
 /**
  * Generic Method to perform Imitation in the Minority Game. 
  * This method works for both Single and Multi Populations.<p>
  * Imitation:<br>
  * If the <code>TempScore</code> of the Reference Agent is higher than the Imitator, a <code>double ProbabilityChange</code>
  * is calculated, which is the probability that Imitation will take place. <code>ProbabilityChange</code> is
  * proportional to the <code>TempScore</code> difference of the Imitator Reference, multiplied by a dumpening factor 
  * <code>ProbabilityChangeFactor</code>.<br>
  * Single Population: The Strategy is imitated if successful Imitation occurs.<br>
  * Multi  Population: The Action is imitated if successful Imitation occurs.<br>
  * 
  * 
  * @param <PopulationClass>
  * @param <AgentClass>
  * @param ProbabilityChangeFactor
  * @param ImitationRounds
  * @param ImitatorsList
  * @param GamePopulations 
  */
 public <PopulationClass extends Population, AgentClass extends Agent> void PerformImitation 
         (double ProbabilityChangeFactor, 
          int ImitationRounds, 
          ArrayList<Agent> ImitatorsList, 
          ArrayList<PopulationClass> GamePopulations) {
     
      //ArrayList<PopulationClass> TempPopulation;
      Class GameClass = GamePopulations.get(0).getClass();
         if(GameClass.getName().equals("imitationmgjava.SinglePopulation")){
             //Single Population Case
             ArrayList<SinglePopulation> TempPopulation = (ArrayList<SinglePopulation>)GamePopulations;
             for(Agent Imitator: ImitatorsList){
                 
                 SinglePopulationAgent SImitator = (SinglePopulationAgent)Imitator;
                 //Imitator.getTempScore();
                 //TempPopulation.get(Imitator.getPopulationID()).AgentList.get(Imitator.getRefAgentID()).getTempScore();
                 //System.out.println(SImitator.getAgentID() + " " + SImitator.getTempScore() + " " + SImitator.getRefAgentID() + " " + 
                 //        TempPopulation.get(SImitator.getPopulationID()).AgentList.get(SImitator.getRefAgentID()).getTempScore());
                 
                 if(TempPopulation.get(SImitator.getPopulationID()).AgentList.get(SImitator.getRefAgentID()).getTempScore() 
                         > SImitator.getTempScore()){
                     double ProbabilityChange = ProbabilityChangeFactor*((double)(TempPopulation.get(SImitator.getPopulationID()).AgentList.get(SImitator.getRefAgentID()).getTempScore() 
                             - SImitator.getTempScore())) / (double)ImitationRounds;
                    // System.out.println(ProbabilityChange);
                     if(rand.nextDouble() <= ProbabilityChange ){
                     // System.out.println(SImitator.getAgentID() + " " + SImitator.getStrategy() + " " + SImitator.getRefAgentID() + " " + 
                       //  TempPopulation.get(SImitator.getPopulationID()).AgentList.get(SImitator.getRefAgentID()).getStrategy());
   
                                              
                         SImitator.setStrategy
                         (TempPopulation.get(SImitator.getPopulationID()).AgentList.
                                         get(SImitator.getRefAgentID()).getStrategy());
                         //System.out.println(SImitator.getStrategy());
                     }
                     //SImitator.setStrategy(Strategy);
                 }
             }

             
         }else{
             //Multi Population
             ArrayList<MultiPopulation> TempPopulation = (ArrayList<MultiPopulation>)GamePopulations;
             for(Agent Imitator: ImitatorsList){
                 MultiPopulationAgent SImitator = (MultiPopulationAgent)Imitator;
                 //Imitator.getTempScore();
                 //TempPopulation.get(Imitator.getPopulationID()).AgentList.get(Imitator.getRefAgentID()).getTempScore();
                 if(TempPopulation.get(SImitator.getPopulationID()).AgentList.get(SImitator.getRefAgentID()).getTempScore() 
                         > SImitator.getTempScore()){
                     double ProbabilityChange = ProbabilityChangeFactor*((double)(TempPopulation.get(SImitator.getPopulationID()).AgentList.get(SImitator.getRefAgentID()).getTempScore() 
                             - SImitator.getTempScore())) / (double)ImitationRounds;
                     if(rand.nextDouble() <= ProbabilityChange ){
                         SImitator.setAction
                         (TempPopulation.get(SImitator.getPopulationID()).AgentList.
                                         get(SImitator.getRefAgentID()).getAction());
                     }
                     //SImitator.setStrategy(Strategy);
                 }
                 
             }
            
             
         }  
     
          
          
     
 }
 
    
    
}
