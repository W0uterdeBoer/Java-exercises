 import java.lang.String;
 import java.io.*;
 import java.util.*;

public class Word{
    public String correctWord;
    public Word(){
        System.out.println(System.getProperty("user.dir") + "/Wordlist.txt");
        String fileLocation = System.getProperty("user.dir") + "/Wordlist.txt";
        try{
            File inputFile = new File(fileLocation);
            Scanner reader = new Scanner(inputFile);
            int lineNumber = (int) (Math.random()* 490);       
            for(int i = 0 ; i < lineNumber ; i++){
                correctWord = reader.nextLine();
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("File not Found, choose your own word.");
            Scanner reader = new Scanner(System.in);
            correctWord = reader.nextLine();
        }       
    };
    
    /* Adds correctly guessed characters to playWord */
    public char[] Guess(char k, char[] playWord){                               
        char[] changedWord;
        changedWord = playWord.clone();      /* I need two distinct versions to compare them later*/
        for(int i=0; i<this.correctWord.length(); i++){
            if(k == this.correctWord.charAt(i)){
                /*strings are immutable*/
                changedWord[i] = k;                      
            }            
        }       
        return changedWord;
    };
};
