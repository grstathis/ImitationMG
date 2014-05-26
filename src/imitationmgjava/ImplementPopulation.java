package imitationmgjava;
import java.util.*;
/**
 *The implementation of the Single Population. Includes an ArrayList of Single Population Agents 
 * and an ArrayList of their Strategies.
 * 
 * @author stathis
 * @version %I%
 * 
 */
class SinglePopulation extends Population implements PopulationInterface {
  
 ArrayList<Double> StrategyList = new ArrayList();     
 ArrayList<SinglePopulationAgent> AgentList = new ArrayList();


@Override 
public int getPopulationSize(){
    
    return this.AgentList.size();
    
}


/**
 * We assign actions to the Agents of the Single Population 
 * according to their Strategy.
 * 
 */

public void setActions(){
    Random rand = new Random();
    //int i = 0;
    for (SinglePopulationAgent Agent: AgentList){
        
        if(rand.nextDouble() <= Agent.getStrategy()){
            Agent.setAction(true);
        }else{
            Agent.setAction(false);
        }
    }
    
}


/**
 * Create the List to contain the Actions of the Single Population Agents.
 * 
 */

public void setActionList(){
    
    int i = 0;
    for (SinglePopulationAgent Agent: AgentList){
        Actions.set(i, Agent.getAction());
        i++;
    }
 
    
}

/**
 * Create the List to contain the Strategies of the Single Population Agents.
 * 
 */

public void setStrategyList(){
    StrategyList.clear();
    int i = 0;
    for (SinglePopulationAgent Agent: AgentList){
        StrategyList.add(Agent.getStrategy());
        i++;
    }
    
}




}

/**
 *The implementation of the Multi Population. Includes an ArrayList of Multi Population Agents 
 * and a double to denote the (Mixed) Strategy of the Multi Population.
 * 
 * @author stathis
 * @version %I%
 * 
 */

class MultiPopulation extends Population {
 
 private double MixedStrategy;   
 ArrayList<MultiPopulationAgent> AgentList = new ArrayList();

@Override 
public int getPopulationSize(){
    
    return this.AgentList.size();
    
} 


/**
 * Sets the Initial MixedStrategy variable.
 * @param MixedStrategy 
 */
public void setInitMixedStrategy(double MixedStrategy){
    this.MixedStrategy = MixedStrategy;
} 

/**
 * Returns the Initial Mixed Strategy of the Population.
 * @return MixedStrategy
 */
public double getInitMixedStrategy(){
    return MixedStrategy;
}

/**
 * Returns the Mixed Strategy of the Population during the Game.
 * @return MixedStrategy
 */
public double getEmpMixedStrategy(){
    return ( (double)Actions.cardinality() / (double)AgentList.size()) ;
}
 

/**
 * Create the List to contain the Actions of the Multi Population Agents.
 * 
 */
 public void setActionList(){
    
    int i = 0;
    for (MultiPopulationAgent Agent: AgentList){
        Actions.set(i, Agent.getAction());
        i++;
    }
 
    
}
 
 
 
 
    
}