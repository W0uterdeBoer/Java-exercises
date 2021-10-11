
public class Edge {
    String origin;
    String destination; 
    boolean answer;
    
    public Edge(String origin, String destination, boolean answer){
        this.origin = origin;
        this.destination = destination.trim();
        this.answer = answer;
    }
    
    public String getDestination(){
        return destination;
    }
}

