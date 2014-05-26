/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imitationmgjava;
import java.util.*;


/**
 *
 * @author stathis
 */
public class MGTests {
    
    public static void main(String[] args) {
        
    SinglePopulationAgent TempAgent = new SinglePopulationAgent(0,(double)0.5);
    MultiPopulationAgent TempAgentM = new MultiPopulationAgent(0);
    Class cls =  TempAgent.getClass(); 
    System.out.println("The type of the object is: " + cls.getName());
    
    Utils Utils = new Utils();
    
    SinglePopulationAgent newAgent = Utils.AgentCopy(TempAgent);
    MultiPopulationAgent newAgentM = Utils.AgentCopy(TempAgentM);
    
    
    TempAgentM.setAction(true);
    
    
    TempAgent.setAgentID(1);
    TempAgent.setStrategy(0.2);
        System.out.println("Copied  Agent Attr " + newAgent.getStrategy());
        System.out.println("Initial Agent Attr " + TempAgent.getStrategy());
    
        System.out.println("Initial Agent PopID " + TempAgent.getPopulationID());

        System.out.println("Copied Agent PopID " + newAgent.getPopulationID());
        
        System.out.println("Copied  MAgent Attr " + newAgentM.getAction());
        System.out.println("Initial MAgent Attr " + TempAgentM.getAction());
        
        MultiPopulation AgentPopulation = new MultiPopulation();
        
        AgentPopulation.AgentList.add(TempAgentM);
        AgentPopulation.setActionList();
        System.out.println("Pop Mixed Str " + AgentPopulation.getEmpMixedStrategy());
        
         Initialization NewGame = new Initialization();
         
         ArrayList<Population> Game1 = NewGame.InitializePopulations(3, 5);
         ArrayList<Population> Game2 = NewGame.InitializePopulations(1, 10);
         
         //int t1 = Game1.get(0).getPopulationSize();
         //int t2 = Game2.get(0).getPopulationSize();
         
         GamePlay GameList = new GamePlay();
         
         ArrayList<ArrayList<Integer>> singleGamePlay = GameList.CreateGamePlayList(1,1,5, 1, Game2);
         ArrayList<ArrayList<Integer>> singleGamePlay2 = GameList.CreateGamePlayList(1,1,3, 1, Game1);
         //singleGamePlay = GameList.CreateSingleGamePlayList(5, Game1);
         
         
         ArrayList<Agent> GameListAgent = GameList.getGamePlayList(singleGamePlay, Game2);
         ArrayList<Agent> GameListAgent2 = GameList.getGamePlayList(singleGamePlay2, Game1);
         BitSet ActionGamePlay = GameList.getActionGamePlayList(GameListAgent2);
         //int test = ActionGamePlay.length();
         for(int i = 0; i < GameListAgent2.size(); i++){
          System.out.println("Actions " + ActionGamePlay.get(i));
         }
         
         boolean Minority  = GameList.PlayGameAndPublishMinority(GameListAgent2.size(), ActionGamePlay);
         
         GameList.UpdateScores(Minority, GameListAgent2);
         boolean CurrentMinority;
         for(int tick = 0; tick <= 10; tick++){
             //for(int tick = 0; tick <= 10; tick++){}
             //GameList.CreateSingleGamePlayList(5, 1, Game2);
             //ArrayList<Agent> GameList = SingleGamePlay.getGamePlayList(singleGamePlay, Game2);
             //BitSet ActionSingleGamePlay = 
             //        SingleGamePlay.getActionGamePlayList
             //        (SingleGamePlay.getGamePlayList(singleGamePlay, Game2));
             
             CurrentMinority = GameList.PlayGameAndPublishMinority
            (GameListAgent.size(), GameList.getActionGamePlayList
            (GameList.getGamePlayList
            (GameList.CreateGamePlayList(1,1,3, 1, Game1), Game1)));
             
             System.out.println("Minority " + CurrentMinority);
             
             Learning Imitation = new Learning();
             ArrayList<Agent> ImitationList = GameList.getGamePlayList(GameList.CreateGamePlayList(1,1,3, 2, Game1),Game1);
             Imitation.setImitatorReferres(ImitationList, Game1);
             Imitation.PerformImitation(0.8, 1, ImitationList, Game1);
             Utils.ZeroTempScores(Game1);
             //Game2.get(0).
    
         }
         
         
         
         
    }
    
}
