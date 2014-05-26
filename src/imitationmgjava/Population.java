package imitationmgjava;
import java.io.Serializable;
import java.util.*;
/**
 *
 * The bare implementation of the PopulationInterface Class. 
 * 
 * @author stathis
 * @version %I%
 * @since 1.0
 */
abstract class Population implements PopulationInterface, Serializable {
    
    private int PopulationID;
    BitSet Actions = new BitSet();//We declare a default BitSet to hold the 
                                  //Actions of all the Agents in the Population
       
    
    @Override 
    public int getPopulationSize(){ int psize = 0; return psize;}
    
    @Override
    public int getPopulationID(){ return this.PopulationID; }
 
    @Override
    public void setPopulationID(int PopulationID){ this.PopulationID = PopulationID; }
         
         
    
}
