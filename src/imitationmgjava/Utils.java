package imitationmgjava;
import java.util.*;
/**
 *
 * @author stathis
 */
class Utils {
     
    public static <AgentClass extends Agent> AgentClass AgentCopy(AgentClass AgentToCopy){
      
     AgentClass newAgent;
     newAgent = org.apache.commons.lang3.SerializationUtils.clone(AgentToCopy);
        
     return newAgent;
}
   
    
    public static ArrayList<Integer> Range(int min, int max) {
        
        ArrayList<Integer> list = new ArrayList();
        for (int i = min; i < max; i++) {
            list.add(i);
        }

        return list;
    }
    
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
