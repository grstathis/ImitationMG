package imitationmgjava;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stathis
 */
public class RunABSTest {
    
    public RunABSTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Run method, of class RunABS.
     */
    @Test
    public void testRun() {
        System.out.println("Run");
        int seed = 0;
        int NumberOfPopulations = 0;
        int NumberOfAgents = 0;
        int NumberOfAgentsInPlay = 0;
        int NumberOfImitators = 0;
        int ImitationRounds = 0;
        int NumberOfRounds = 0;
        double ProbabilityChangeFactor = 0.0;
        RunABS instance = new RunABS();
        instance.run(seed, NumberOfPopulations, NumberOfAgents, NumberOfAgentsInPlay, NumberOfImitators, ImitationRounds, NumberOfRounds, ProbabilityChangeFactor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
