/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imitationmgjava;

//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.io.UnsupportedEncodingException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author stathis
 */
public class RunSimulation {
 
   public static void main(String[] args) {
       
       int seed = 0;
       int NumberOfPopulations = 1; 
       int NumberOfAgents = 99; 
       int NumberOfAgentsInPlay = 99;
       int NumberOfImitators = 3;
       int ImitationRounds = 3;
       int NumberOfRounds = 10000;
       double ProbabilityChangeFactor = 0.7;
       int NumberOfRuns = 10;
       
        if (args.length == 9) {
           try {
            seed = Integer.parseInt(args[0]);
            } 
            catch (NumberFormatException e) {
                System.err.println("Argument" + args[0] + " must be an integer.");
            }
           
           try {
            NumberOfPopulations = Integer.parseInt(args[1]);
            if(NumberOfPopulations != 0 && (NumberOfPopulations % 2 != 0) ){
               //NumberOfPopulations = args[1];
             }else{
                System.err.println("Argument" + args[1] + " must be an ODD integer greater of equal to one. "
                        + "Reverting to default value one");
            }
            
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[1] + " must be an integer.");
            }
            
            try {
               NumberOfAgents =  Integer.parseInt(args[2]);
               if(NumberOfAgents != 0 && (NumberOfAgents % 2 != 0) ){
                  //NumberOfAgents = args[2];
               }else{
                System.err.println("Argument" + args[2] + " must be an ODD integer greater of equal to one. "
                        + "Reverting to default value 99");
                //System.exit(1);
               }
               
            }catch (NumberFormatException e) {
               System.err.println("Argument" + args[2] + " must be an integer."); 
            }
            
            try {
               NumberOfAgentsInPlay =  Integer.parseInt(args[3]);
               if(NumberOfAgentsInPlay != 0 && (NumberOfAgentsInPlay % 2 != 0) ){
                  //NumberOfAgents = args[2];
               }else{
                System.err.println("Argument" + args[3] + " must be an ODD integer greater of equal to one. "
                        + "Reverting to default value 99");
                //System.exit(1);
               }
               
            }catch (NumberFormatException e) {
               System.err.println("Argument" + args[3] + " must be an integer."); 
            } 
             
             try {
               NumberOfImitators =  Integer.parseInt(args[4]);
               if(NumberOfAgentsInPlay != 0 ){
                  //NumberOfAgents = args[2];
               }else{
                System.err.println("Argument" + args[4] + " must be an integer greater of equal to one. "
                        + "Reverting to default value 3");
                //System.exit(1);
               }
               
            }catch (NumberFormatException e) {
               System.err.println("Argument" + args[4] + " must be an integer."); 
            } 
            
            try {
               ImitationRounds =  Integer.parseInt(args[5]);
               if(ImitationRounds != 0 ){
                  //NumberOfAgents = args[2];
               }else{
                System.err.println("Argument" + args[5] + " must be an integer greater to zero and less than the total rounds of the Game. "
                        + "Reverting to default value 3");
                //System.exit(1);
               }
               
            }catch (NumberFormatException e) {
               System.err.println("Argument" + args[5] + " must be an integer."); 
            } 
            
            try {
               NumberOfRounds =  Integer.parseInt(args[6]);
               if(NumberOfRounds != 0 ){
                  //NumberOfAgents = args[2];
               }else{
                System.err.println("Argument" + args[6] + " must be an integer greater than zero"
                        + "Reverting to default value 10000");
                //System.exit(1);
               }
               
            }catch (NumberFormatException e) {
               System.err.println("Argument" + args[6] + " must be an integer."); 
            } 
            
            try {
               ProbabilityChangeFactor =  Double.parseDouble(args[7]);
               if(ProbabilityChangeFactor != 0 && ProbabilityChangeFactor <= 1 ){
                  //NumberOfAgents = args[2];
               }else{
                System.err.println("Argument" + args[7] + " must be an double greater than zero and less than one"
                        + "Reverting to default value 0.7");
                //System.exit(1);
               }
               
            }catch (NumberFormatException e) {
               System.err.println("Argument" + args[7] + " must be an double."); 
            } 
            
            try {
               NumberOfRuns =  Integer.parseInt(args[8]);
               if(NumberOfRuns != 0 ){
                  //NumberOfAgents = args[2];
               }else{
                System.err.println("Argument" + args[8] + " must be an integer greater than zero"
                        + "Reverting to default value 10");
                //System.exit(1);
               }
               
            }catch (NumberFormatException e) {
               System.err.println("Argument" + args[8] + " must be an integer."); 
            } 
            
            
        }else{
            System.out.println("Some Input is missing. Reverting to Default Values");
            
        }
       
       
       
       // PrintWriter writersum = null;
        //try {
            RunABS go = new RunABS();
          //  writersum = new PrintWriter("StrategiesSum.txt", "UTF-8");
            for(int iter = 0; iter < NumberOfRuns; iter++){ 
                   
                     go.run(iter + seed,
                            NumberOfPopulations,
                            NumberOfAgents,
                            NumberOfAgentsInPlay,
                            NumberOfImitators,
                            ImitationRounds,
                            NumberOfRounds, 
                            ProbabilityChangeFactor);
                 
           }
        //} catch (FileNotFoundException ex) {
        //    Logger.getLogger(RunSimulation.class.getName()).log(Level.SEVERE, null, ex);
        //} catch (UnsupportedEncodingException ex) {
        //    Logger.getLogger(RunSimulation.class.getName()).log(Level.SEVERE, null, ex);
        //} finally {
        //    writersum.close();
        //}
   }
}
