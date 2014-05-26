package imitationmgjava;

/**
 *The Interface Class of an Agent playing the Minority Game and 
 * adapt through Evolutionary Learning. An Agent implementation should hold 
 * the following private variables:
 * PopulationID (for MultiPopulation Games)<br>
 * AgentID<br>
 * Overall Score<br>
 * Temporary Score<br>
 * An Action<br>
 * Reference Agent <p>
 * 
 * AgentInterface describes the basic methods to be used by 
 * an Agent implementation. The interface is designed to hold A Single Population 
 * of Agents and Multiple Populations of Agents
 * 
 * @author stathis
 * @version     %I%, %G%
 *
 */
public interface AgentInterface {
         
    
    /** Returns the PopulationID of an Agent
     * @param none
     * @return <code>PopulationID</code> 
     */
    int getPopulationID();
    
    
    /**
     * Sets the AgentID of an Agent. 
     * Should only be used when creating an Agent.
     * @param AgentID 
     */
    
    void setAgentID(int AgentID);
   
    /**
     * Returns the AgentID of an Agent
     * @return <code> AgentID </code>
     */
    
    int getAgentID();
    
    
    /**
     * Sets the Overall Score of the Agent.
     * @param Score 
     */
    
    void setScore(int Score);
    
    
    /**
     * Returns the Score of an Agent
     * @return <code>Score</code> 
     */
    
    int getScore();
    
    /**
     * Sets the Temporary Score of the Agent. When the Learning phase is done, 
     * TempScore is reset to zero (Unlike Overall Score).
     * @param Score 
     */
    
    void setTempScore(int TempScore);
    
    /**
     * Returns the Temporary Score of an Agent
     * @return <code>TempScore</code> 
     */
    
    int getTempScore();
    
    /**
     * Sets the Action of the Agent to play at each round. 
     * The Action is represented by a boolean 
     * @param Action 
     */
   
    void setAction(boolean Action);
    
    /**
     * Returns the current Action of an Agent 
     * @return <code>Action</code> 
     */
    
    boolean getAction();
    
    /**
     * Sets the AgentID of the Reference Agent. 
     * That is, the Agent to be imitated by an Agent.
     * @param RefAgentID 
     */

    void setRefAgentID(int RefAgentID);
    
    /**
     * Returns the AgentID of the Reference Agent. 
     * That is, the Agent to be imitated by an Agent.
     * @param RefAgentID 
     */
    
    int getRefAgentID();
        
            
}
