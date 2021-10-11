import java.util.*;

import java.util.function.Consumer;

enum AllowedFacings{            
        NORTH,
        EAST,
        SOUTH,
        WEST
    }


public class Robot{
    
    ArrayList<Runnable> commands = new ArrayList<>();  /* This will contain commands and only be executed in execution */ 
    int[] position = new int[2]; /*No longer an ArrayList, Glen cannot add coordinates and sort them.*/
    AllowedFacings facing;
    
    
    public Robot(int x, int y, String facing){       
        this.position[0] = x;
        this.position[1] = y;     
        this.facing= AllowedFacings.valueOf(facing.toUpperCase()); 
    }
   
    
    public void printState(){           /*We can now print attributes without changing their access*/
        System.out.println("position: " + Arrays.toString(position) + " facing: "+ facing.name());
    } 
    
    public void turnRight(){       
        Runnable turnRight = () -> {
            switch(facing){
                case NORTH: 
                    facing = AllowedFacings.EAST;
                    break;
                case EAST:
                    facing = AllowedFacings.SOUTH;
                    break;
                case SOUTH:
                    facing = AllowedFacings.WEST;
                    break;
                case WEST:
                    facing = AllowedFacings.NORTH;       
                    break;
            }
            
        };
        commands.add(turnRight);
    }
    
    public void turnLeft(){
        Runnable turnLeft = () -> {
             switch(facing){
                case NORTH: 
                    facing = AllowedFacings.WEST;
                    break;
                case EAST:
                    facing = AllowedFacings.NORTH;
                    break;
                case SOUTH:
                    facing = AllowedFacings.EAST;
                    break;
                case WEST:
                    facing = AllowedFacings.SOUTH;       
                    break;
                }
        };
        commands.add(turnLeft);
    }
    
    
    /*method overloading on forward*/
    public void forward(int speed){
        if(0 < speed & speed <4){
            Runnable forward = () -> {     
                switch (facing) {
                    case NORTH:
                        position[1] = position[1]+speed;
                        break;
                    case EAST:
                        position[0] = position[0]+speed;
                        break;
                    case SOUTH:
                        position[1] = position[1]-speed;
                        break;
                    case WEST:
                        position[0] = position[0]-speed;
                        break;
                }
            };
            
            commands.add(forward);
        } else{
            System.out.println("Speed should be 1, 2, or 3, ignoring the command");
        }
    }  
       
    public void forward(){
        Runnable forward = () ->{
            switch (facing) {
                case NORTH:
                    position[1] = position[1]+1;
                    break;
                case EAST:
                    position[0] = position[0]+1;
                    break;
                case SOUTH:
                    position[1] = position[1]-1;
                    break;
                case WEST:
                    position[0] = position[0]-1;
                    break;
            }
        };
        
        commands.add(forward);
    }  
        
    public void backward(){
        Runnable backward = () ->{
            switch (facing) {
                case NORTH:
                    position[1] = position[1]-1;
                    break;
                case EAST:
                    position[0] = position[0]-1;
                    break;
                case SOUTH:
                    position[1] = position[1]+1;
                    break;
                case WEST:
                    position[0] = position[0]+1;
                    break;
            }
        };
        
        commands.add(backward);
    }
       
    public void execute(){
       
        commands.forEach(command -> command.run()); 
        commands.clear();/* Empty Commands after execution */
        printState();
    }
}