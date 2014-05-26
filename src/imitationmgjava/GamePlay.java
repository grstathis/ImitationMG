package imitationmgjava;

import static ch.lambdaj.Lambda.*;
import java.util.*;
import static org.hamcrest.Matchers.*;

/**
 *
 * Class contains methods to create Agent List to play the Minority Game, Imitation Lists.
 * Library lamdaj is used to select data in a functional style.
 * 
 * @author stathis
 * @version %I%
 * 
 */

 class GamePlay {
    
    
    /**
     * 
     * Select AgentIDs at random to play the Minority Game or create list of Imitators (see Go Class). 
     * The selected Agents are put in a list. In the Single Population case, 
     * the parameter <code>NumOfAgents</code> is 
     * used to determine the number of Agents to play the game in a particular round.
     * <p>
     * In the Multi Population case, the parameter <code>NumOfAgents</code>
     * determines the number of Agents to play the game from each Population. 
     * <p>
     * This method is also used to select Agents to imitate Reference Agents at a suitable round.
     * The <code>seed, seed2</code> parameters are used to control the random process.
     * @param seed
     * @param seed2
     * @param NumberOfAgentsinPlay
     * @param ImitatorsPerPopulation
     * @param GamePopulations
     * @return GamePlayList
     * 
     */ 
    public ArrayList<ArrayList<Integer>> CreateGamePlayList
           (int seed, int seed2, int NumOfAgents, int NumOfMultiPopulationAgents, 
            ArrayList<Population> GamePopulations){
       
       Random rand = new Random(seed); 
        
       ArrayList<ArrayList<Integer>> GamePlayList = new ArrayList();
       if(GamePopulations.size() == 1){
           //Single Population Case
           SinglePopulation TempPopulation =  (SinglePopulation)GamePopulations.get(0);
           
            ArrayList<Integer>  FullAgentIDList = Utils.Range(0,TempPopulation.AgentList.size());
            rand.setSeed(seed2);
            Collections.shuffle(FullAgentIDList, rand);
           
            GamePlayList.add(new ArrayList<>(FullAgentIDList.subList(0, NumOfAgents)));

                 
       }else{
           //Multi Population Case, we only need one population to pick AgentIDs 
           //as all populations have the same number of Agents
           MultiPopulation TempPopulation =  (MultiPopulation)GamePopulations.get(0);
           
           for(int i = 0; i < GamePopulations.size(); i++){
               ArrayList<Integer> TempAgent = new ArrayList();
               for(int j = 0; j < NumOfAgents; j++){
                 TempAgent.add(rand.nextInt(TempPopulation.AgentList.size()));
               }
               GamePlayList.add(TempAgent);
           }
           
       } 
        
        return GamePlayList;
    } 
    
    
    /**
     * Generic Method to return the Game Play list of Agents for each round,
     * using a GamePlayList of AgentIDs. 
     * 
     * @param <PopulationClass>
     * @param <AgentClass>
     * @param AgentIDList
     * @param GamePopulations
     * @return 
     */
    
    public <PopulationClass extends Population, AgentClass extends Agent> ArrayList<AgentClass> 
             getGamePlayList(ArrayList<ArrayList<Integer>> AgentIDList, ArrayList<PopulationClass> GamePopulations ){
         
         ArrayList<Agent> AgentGamePlayList = new ArrayList<>();
         Class GameClass = GamePopulations.get(0).getClass();
         if(GameClass.getName().equals("imitationmgjava.SinglePopulation")){
            //TODO <<<<<< Ask StackOverflow here for the equalTo(AgentID) 
           for(ArrayList<Integer> PopulationID: AgentIDList ){ 
             for (Integer AgentID: PopulationID){

             AgentGamePlayList.add(((List<SinglePopulationAgent>)(select(((ArrayList<SinglePopulation>)(GamePopulations))
                     .get(0).AgentList, 
                      having(on(SinglePopulationAgent.class).getAgentID(), equalTo(AgentID))))).get(0));  

           }
           }
         }else{
           //Multi Population Case
          for(ArrayList<Integer> PopulationID: AgentIDList ){ 
              //AgentIDList.indexOf(PopulationID)
           for (Integer AgentID: PopulationID){

      //       AgentGamePlayList.add(((List<MultiPopulationAgent>)(select(((ArrayList<MultiPopulation>)(GamePopulations))
      //               .get(0).AgentList, 
      //                having(on(MultiPopulationAgent.class).getAgentID(), equalTo(AgentID))))).get(0));
               AgentGamePlayList.add(((List<MultiPopulationAgent>)(select(((ArrayList<MultiPopulation>)(GamePopulations))
                     .get(AgentIDList.indexOf(PopulationID)).AgentList, 
                      having(on(MultiPopulationAgent.class).getAgentID(), equalTo(AgentID))))).get(0)); 
                    
           }  
         }
         } 
         return (ArrayList<AgentClass>)AgentGamePlayList;
     }
     
    /**
     * 
     * Method to return the Actions of the Agents that will play 
     * the Minority Game in the corresponding round. Generic method that holds both for 
     * Single and Multi Population Agents. Library lamdbaj is used.
     * 
     * @param <AgentClass>
     * @param AgentGamePlayList
     * @return ActionGamePlay
     */ 
    public  <AgentClass extends Agent> BitSet 
            getActionGamePlayList(ArrayList<Agent> AgentGamePlayList ){
       
       
       BitSet ActionGamePlay = new BitSet();
       List<Boolean> ActionList = extract(AgentGamePlayList, on(Agent.class).getAction());
       
       
       int i=0;
       for (Boolean Action: ActionList){
         ActionGamePlay.set(i,Action);
         i++;
       }
          
         /*ActionGamePlay.set(i,(extract(select(SingleGamePopulation.get(0).AgentList,
                   having(on(SinglePopulationAgent.class).getAgentID(),equalTo(AgentID))), 
                  on(SinglePopulationAgent.class).getAction()).get(0).booleanValue()));
         
          i++;
        }*/
       
       
       
        return ActionGamePlay;
        
    }
    
    /**
     * Play the Minority Game and return the boolean Minority result. 
     * @param GameListSize
     * @param ActionGamePlay
     * @return Minority
     * 
     */
    public boolean PlayGameAndPublishMinority(int GameListSize, BitSet ActionGamePlay){
        //int test  = ActionGamePlay.length();     
        boolean Minority;
        if(ActionGamePlay.cardinality() <= (int)((GameListSize - 1) / 2)){
                   Minority = true;   
        }else{
                   Minority = false;
        }
        
        return Minority;
    }
    
    
   /**
    * Update Agent Scores, 
    * give one point to the winners ( the Agents in the Minority).
    * 
    * @param Minority
    * @param AgentGameList 
    */ 
   public void UpdateScores(boolean Minority, ArrayList<Agent> AgentGameList ){
       
       for (Agent Agent: AgentGameList){
         
         if(Agent.getAction() == Minority){
            Agent.setScore(Agent.getScore() + 1);
            Agent.setTempScore(Agent.getTempScore() + 1);
         }  
           
       }
       
   } 
    
    
}
