package imitationmgjava;

/**
 *
 * The Population Interface is the required parts to create 
 * a Population of Agents. The interface is designed to hold generally two cases.
 * A Population of Single Population Agents and 
 * 
 * @author stathis
 * @version %I%
 * @since  1.0
 */
public interface PopulationInterface {
    
    
     /**
      * Returns the PopulationID
      * 
      * @return PopulationID 
      */
     int getPopulationID();
     
     /**
      * Sets the PopulationID
      * @param PopulationID 
      */
    
     void setPopulationID(int PopulationID);
     
     /**
      * Returns the size of the Population
      * @return PopulationSize
      */
     int getPopulationSize();
    
}
