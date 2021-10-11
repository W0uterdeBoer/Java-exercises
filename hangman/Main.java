import java.util.*;


public class Main {
    
    /* Runs hangman */
    public static void main(String[] args) {		
        Word theWord = new Word();
        int n = theWord.correctWord.length();
        char[] playWord = new char[n];  /*strings are immutable char[] is not.*/
        int wrongGuesses = 0;
        ArrayList<Character> guessedLetters = new ArrayList<Character>(); /* I need variable length */
        
        /* Makes empty lines of length correctWord */
        for(int i = 0 ; i< n ; i++){
            playWord[i] = '-';
        }
         System.out.println(playWord);

        
        /* Gameloop */
        while(wrongGuesses < 10){
            /* Makes the player guess a letter */
            System.out.println("Guess a letter");
            Scanner userInput = new Scanner(System.in);
            char guessedChar = Character.toLowerCase(userInput.next().charAt(0));
            if(guessedLetters.contains(guessedChar)){
                System.out.println("You already guessed that");
            } else{
                guessedLetters.add(guessedChar);
            }
            
            /* Handles the Guess by invoking the Guess method */
            char[] newPlayWord = theWord.Guess(guessedChar, playWord);     
            
            /* Gives player output as a result of the guess */
            if(Arrays.equals(newPlayWord, playWord)){              
                wrongGuesses = wrongGuesses +1;
                System.out.println("There was no " + guessedChar + " in the word.");
                System.out.println(10-wrongGuesses + " guesses left" );
            } else{
                playWord = newPlayWord;
            }           
            System.out.println(playWord);
             
            /*Checks for game end*/
            boolean existsBlank = false ;
            for(int i = 0 ; i<playWord.length; i++){
                if(playWord[i] == '-'){
                    existsBlank = true;
                } 
            }
            if(!existsBlank){
                System.out.println("You win");
                System.exit(0);
            }    
            System.out.println("Guessed letters: " + guessedLetters);
        }
        System.out.println("You lose, the word was: " + theWord.correctWord); 
        System.exit(0);
    };
}