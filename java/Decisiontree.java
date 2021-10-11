
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Decisiontree {

    
    public static void main(String[] args) { 

        /*Different data types because I want to use the class Node after I made the Edges*/
        ArrayList<Edge> Edges = new ArrayList<>(); 
        ArrayList<ArrayList<String>> nodesData = new ArrayList<>();
            
        readFile(nodesData, Edges);            
        Node firstNode = findFirstNode(nodesData, Edges);
        
        while(true){
            firstNode = firstNode.nextNode();
        }       
    }
    
   
    private static void readFile(ArrayList<ArrayList<String>> nodesData, ArrayList<Edge> Edges){
          Scanner myScanner = null;
          
        try{
            File decisionTreeData = new File("decision-tree-data.txt"); 
            myScanner = new Scanner(decisionTreeData);                        
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          System.exit(-1);
        }   
        
        while (myScanner.hasNextLine()) {  
            String lineOfData = myScanner.nextLine();
            ArrayList<String> dataLineAsArrayList = toArray(lineOfData);
            
            if(dataLineAsArrayList.size() == 2){
                nodesData.add(dataLineAsArrayList);
            }
            if(dataLineAsArrayList.size()==3){
                Edge myEdge = makeEdge(dataLineAsArrayList);
                Edges.add(myEdge);
            }    
        }
        
        myScanner.close(); 
    }
    
    /*This must be an ArrayList, length can be 2 or 3, I don't know yet*/
    private static ArrayList<String> toArray(String lineOfData){ 
        ArrayList<String> dataLineAsArrayList = new ArrayList<>();
        
        while(lineOfData.indexOf(',')!= -1){     /*indexOf returns -1 if ther is no such char */
           int commaPosition = lineOfData.indexOf(',');
           dataLineAsArrayList.add(lineOfData.substring(0, commaPosition).trim());
           lineOfData = lineOfData.substring(commaPosition+1);
        }
        dataLineAsArrayList.add(lineOfData.trim());
        
        return dataLineAsArrayList;      
    }
    
    private static Edge makeEdge(ArrayList<String> dataLineAsArrayList){
        boolean Answer;
        
        if("Ja".equals(dataLineAsArrayList.get(2))){
            Answer = true;
        } else  if("Nee".equals(dataLineAsArrayList.get(2))){
            Answer = false;
        } else{
            throw new ArrayIndexOutOfBoundsException( "Vraag moet beantwoord worden met \" Ja \" of \" Nee \" ");
        }
        
        Edge myEdge= new Edge(dataLineAsArrayList.get(0), dataLineAsArrayList.get(1), Answer);
        return myEdge;     
    }
           
    private static Node findFirstNode(ArrayList<ArrayList<String>> nodes, ArrayList<Edge> Edges ){
        for(ArrayList<String> node: nodes){
            boolean wrongNode = false;
            for(Edge edge: Edges){
                if(edge.getDestination().equals(node.get(0))){                   
                    wrongNode = true;              
                }
            }
            
            if(!wrongNode){
                ArrayList<String> firstNode = node;
                Node myNode= new Node( firstNode, Edges, nodes);
                return myNode;  /*there should be exactly one firstnode*/
            }
        }
        throw new ArrayIndexOutOfBoundsException("Starting Node not found");
    } 
}

