package imitationmgjava;
import java.util.*;
/**
 *Utilities Class with some helpful functions.
 * @author stathis
 */
class Utils {
    
    
    /**
     * Copy an Agent.
     * 
     * @param <AgentClass>
     * @param AgentToCopy
     * @return 
     */
    public static <AgentClass extends Agent> AgentClass AgentCopy(AgentClass AgentToCopy){
      
     AgentClass newAgent;
     newAgent = org.apache.commons.lang3.SerializationUtils.clone(AgentToCopy);
        
     return newAgent;
}
   
    /**
     * Take a subset of integer List.
     * @param min
     * @param max
     * @return 
     */
    public static ArrayList<Integer> Range(int min, int max) {
        
        ArrayList<Integer> list = new ArrayList();
        for (int i = min; i < max; i++) {
            list.add(i);
        }

        return list;
    }
    
    /**
     * 
     * Zero the Temporary scores of the Agents to restart the imitation process.
     * 
     * @param <PopulationClass>
     * @param GamePopulations 
     */
    public static <PopulationClass extends Population> void ZeroTempScores(ArrayList<PopulationClass> GamePopulations){
         
         Class GameClass = GamePopulations.get(0).getClass();
         if(GameClass.getName().equals("imitationmgjava.SinglePopulation")){
           ArrayList<SinglePopulation> TempGamePop = (ArrayList<SinglePopulation>)(List)GamePopulations;
           
           for(SinglePopulation TempGameSPop :TempGamePop){
             for(SinglePopulationAgent Agent: TempGameSPop.AgentList){
                 Agent.setTempScore(0);
             }
           }
           
         }else{
           ArrayList<MultiPopulation>  TempGamePop = (ArrayList<MultiPopulation>)(List)GamePopulations;
           for(MultiPopulation TempGameSPop :TempGamePop){
             for(MultiPopulationAgent Agent: TempGameSPop.AgentList){
                 Agent.setTempScore(0);
             }
           }
         }
         
         
         
         
    }
    
}
