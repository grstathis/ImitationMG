package imitationmgjava;

/**
 *
 * The Agent implementation for the Single Population Game. Suitable Agents 
 * at the corresponding round, imitate the strategy of a better fellow Agent. 
 * 
 * @author stathis
 * @version %I% 
 * @since 1.0
 */
 class SinglePopulationAgent extends Agent  {
    
     private final int PopulationID = 0;//We have only one Population
     private double Strategy; //In the Single Population Game, the Strategy is
     private double RefStrategy; //Imitated

     
    /**
     * The default Constructor of the Single Population Agent. 
     * The AgentID is provided externally, along with a random Strategy.
     * All Scores are set to zero, the Reference Agent is the Agent itself 
     * and the Action is false. 
     * 
     * @param AgentID
     * @param Strategy 
     */
    SinglePopulationAgent(int AgentID, double Strategy){
        
        this.setAgentID(AgentID);
        this.setScore(0);
        this.setTempScore(0);
        this.setStrategy(Strategy);
        this.setRefAgentID(AgentID);
        this.setRefStrategy(Strategy);
        this.setAction(false);
    }
    
    @Override
    public final int getPopulationID(){ return this.PopulationID; }

    
    /**
     * Sets the Strategy of a Single Population Agent
     * @param Strategy 
     */
    public final void  setStrategy(double Strategy){ this.Strategy = Strategy; }
    
    /**
     * Returns the Strategy of a Single Population Agent
     * @return Strategy 
     */
    
    public final double getStrategy(){ return this.Strategy; }
    
    @Override
    public final void setRefStrategy(double Strategy){ this.RefStrategy = Strategy; }
    
    /**
     * Returns the Strategy of the Reference Agent in a Single Population Game.
     * ...Played by Single Population Agents
     * @return RefStrategy 
     */
    
    public final double getRefStrategy(){ return this.RefStrategy; }
    
}
