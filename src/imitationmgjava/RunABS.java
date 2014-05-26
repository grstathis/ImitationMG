package imitationmgjava;


import java.io.*;
import java.util.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 * Class to execute the Agent Based Simulation (ABS) of the Minority Game. 
 * Keep it inside the package, the implementation is specific to the Minority Game.
 * 
 * @author stathis
 */


class RunABS {
          /**
           * Run the Agent Based Simulation using:<br>
           * A random seed<br>
           * The number of Populations ( If one the game becomes a Single Population Game ) <br>
           * The number of Agents in each Population<br>
           * The number of Agents that play the game (Applicable only in the Single Population Game)<br>
           * The number of Imitator Agents from each Population<br>
           * The number of rounds where periodicly Imitation is performed<br>
           * The maximum number of rounds of the Simulation<br>
           * The probability change factor for the Imitation Process.
           * 
           * TODO, implement generic Population scheme.
           * 
           * @param seed
           * @param NumberOfPopulations
           * @param NumberOfAgents
           * @param NumberOfAgentsInPlay
           * @param NumberOfImitators
           * @param ImitationRounds
           * @param NumberOfRounds
           * @param ProbabilityChangeFactor 
           */
           
         
    
          
          public void run (     int seed, 
                                int NumberOfPopulations, 
                                int NumberOfAgents, 
                                int NumberOfAgentsInPlay,
                                int NumberOfImitators,
                                int ImitationRounds,
                                int NumberOfRounds,
                                double ProbabilityChangeFactor){
         
            
            
            Initialization NewGame = new Initialization();
            NewGame.setSeed(seed);
            GamePlay GamePlay = new GamePlay();
            Learning Imitation = new Learning();
            Imitation.setSeed(seed);
            ArrayList<Population> Game = NewGame.InitializePopulations(NumberOfPopulations, NumberOfAgents);
            ArrayList<ArrayList<Integer>> singleGamePlay = GamePlay.CreateGamePlayList
                                                           (seed, ( seed + 1 ), NumberOfAgentsInPlay, 1, Game);
            ArrayList<Agent> GameListAgent = GamePlay.getGamePlayList(singleGamePlay, Game);
            Class GameClass = GameListAgent.get(0).getClass();
            boolean CurrentMinority;
            
            
            for(int tick = 0; tick <= NumberOfRounds; tick++){
                 
                 CurrentMinority = 
                 GamePlay.PlayGameAndPublishMinority
                (GameListAgent.size(), GamePlay.getActionGamePlayList(GameListAgent));                 
                 GamePlay.UpdateScores(CurrentMinority, GameListAgent);
                 
                 if( tick %  ImitationRounds == 0){
                     
                    ArrayList<Agent> ImitationList = GamePlay.getGamePlayList
                    (GamePlay.CreateGamePlayList(seed, tick, NumberOfImitators, 1, Game),Game);
                    Imitation.setImitatorReferres(ImitationList, Game);
                    Imitation.PerformImitation(ProbabilityChangeFactor, ImitationRounds, ImitationList, Game);
                    Utils.ZeroTempScores(Game);
                   
                    if(GameClass.getName().equals("imitationmgjava.SinglePopulation")){
                      ((ArrayList<SinglePopulation>)(List)Game).get(0).setStrategyList();
                    }
                    
                 }
                  if(GameClass.getName().equals("imitationmgjava.SinglePopulation")){
                    ((ArrayList<SinglePopulation>)(List)Game).get(0).setActions();
                  }
                 
             }
            
            
   
    }
    
           
           
           
    /**
     * TODO, a generic function to process the attributes of different types of Populations. 
     * @param <PopulationClass>
     * @param GamePopulations 
     */       
    private <PopulationClass extends Population> 
       void setPopulationActions(ArrayList<PopulationClass> GamePopulations){
        
    }

    
    
    
}
