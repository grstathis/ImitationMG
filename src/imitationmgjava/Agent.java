package imitationmgjava;
import java.io.Serializable;
/**
 *
 *The Abstract Class of an Agent playing the Minority Game and 
 * adapt through Evolutionary Learning. An Agent implementation holds 
 * the following private variables:
 * PopulationID (Only MultiPopulation Games)<br>
 * AgentID<br>
 * Overall Score<br>
 * Temporary Score<br>
 * An Action<br>
 * Reference Agent <p>
 * 
 * Abstract Class Agent describes the common implementation of an Agent for 
 * the Single Population case and the MultiPopulation one. 
 * 
 * @author stathis
 * @version     %I%, %G%
 *
 */
  abstract class Agent implements AgentInterface, Serializable {
    
    //private int PopulationID;  
    private int AgentID;
    private int Score;
    private int TempScore;
    private boolean Action;
    private int RefAgentID;
    
    //@Override
    //public int getPopulationID(){ return this.PopulationID; }
    
    
    @Override
    public void setAgentID(int AgentID)
    { this.AgentID = AgentID; }
   
     
    @Override
    public int getAgentID(){ return this.AgentID; }
    
    @Override
    public void setScore(int Score){ this.Score = Score; }
    
    @Override
    public int getScore(){ return this.Score;}
    
    @Override
    public void setTempScore(int TempScore){ this.TempScore = TempScore; }
    
    @Override
    public int getTempScore(){ return this.TempScore;}
    
    @Override
    public void setAction(boolean Action){ this.Action = Action; }
    
    @Override
    public boolean getAction(){ return this.Action; }
    
    @Override
    public void setRefAgentID(int RefAgentID){ this.RefAgentID = RefAgentID; }
    
    @Override
    public int getRefAgentID(){ return this.RefAgentID; }
    
    
    /**
     * Imitates the Strategy of the Reference Agent. 
     * Used in the Single Population Case
     * @param RefStrategy 
     */
    public void setRefStrategy(double RefStrategy){};
 
}
