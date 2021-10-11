import java.util.*;
import java.util.function.Consumer;
        
public class Roborally {
    public static void main(String[] args){
        Robot myFirstRobot = new Robot(0, 1,"East");
        Robot mySecondRobot = new Robot(1, 0, "West");
    

        myFirstRobot.turnLeft();
        myFirstRobot.forward();
        myFirstRobot.backward();
        
        myFirstRobot.printState(); /*to Check if robot did not move before execute*/
        myFirstRobot.execute();

        mySecondRobot.turnRight();
        mySecondRobot.forward(5); /*This should return a print, but does nothing*/
        mySecondRobot.forward(3);
        mySecondRobot.forward(1);
        mySecondRobot.execute();

        
    }
}