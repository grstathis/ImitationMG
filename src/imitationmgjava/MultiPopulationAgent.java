package imitationmgjava;

/**
 * The class represents a Multi Population Agent. 
 * These Agents do not posses Strategy only an Action. 
 * @author stathis
 * @version %I%
 * @since 1.0
 */
 class MultiPopulationAgent extends Agent {
    
    private int PopulationID;//PopulationID has a meaning here
    private boolean RefAction;//We addionally need the Action of the Reference Agent
    
    
    /**
     * The Default Constructor for the Multi Population Agent. 
     * We require the AgentID only, PopulationID gets a zero.
     * Scores are set to zero, Action to false and initial Reference Agent his serf. 
     * 
     * @param AgentID 
     */
    MultiPopulationAgent(int AgentID){
        
        this.setPopulationID(0);
        this.setAgentID(AgentID);
        this.setScore(0);
        this.setTempScore(0);
        this.setRefAgentID(AgentID);
        this.setAction(false);
        
    }
    
    /**
     * A more advanced constructor, we require AgentID, PopulationID and Action.
     * 
     * @param AgentID
     * @param PopulationID
     * @param Action 
     */
    
    MultiPopulationAgent(int AgentID, int PopulationID, boolean Action){
        
        this.setPopulationID(PopulationID);
        this.setAgentID(AgentID);
        this.setScore(0);
        this.setTempScore(0);
        this.setRefAgentID(AgentID);
        this.setAction(Action);
        
    }
    
    
    /**
     * In the Multi Population case, we return the PopulationID of an Agent
     * @return PopulationID
     */
    @Override
    public final  int getPopulationID(){ return this.PopulationID; }
    
    /**
     * Set the PopulationID of an Agent. 
     * Should only be used when creating an Agent.
     * @param PopulationID 
     */
    
    public final void setPopulationID(int PopulationID){ this.PopulationID = PopulationID; }
    
    /**
     * Sets the Action of the Reference Agent to be imitated.
     * In the Multi Population case the Action is imitated, 
     * as the agents do not posses Strategy.
     * @param RefAction 
     */
    
    public final void setRefAction(boolean RefAction){ this.RefAction = RefAction; }
    
    /**
     * Returns the Action of the Reference Agent in the Multi Population case.
     * @return 
     */
    
    public final boolean getRefAction(){ return this.RefAction; }

   
}
