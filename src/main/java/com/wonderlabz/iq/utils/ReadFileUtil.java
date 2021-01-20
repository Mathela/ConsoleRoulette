
package com.wonderlabz.iq.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Nkosinathi Mathela
 * Reads list of player names from text file 
 */
public class ReadFileUtil {
         List <String> readPlayerNames(String fileName) throws FileNotFoundException, IOException{
        List<String> lines = Collections.emptyList(); 
       //each line in text file contains a playerName

      lines = 
       Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
    
    return lines; 
  } 
    
}
