import java.util.*;

public class Node {
    /*
     * Given the Input data, all of this is fixed. If you consider changing this,
     * consider changing the inputdata Instead
    */
    final List<ArrayList<String>> nodesData;
    final String text;
    final String name;
    final Edge[] isOriginOf = new Edge[2]; /* Has either 2 or 0 elements */
    final List<Edge> Edges;

    public Node(ArrayList<String> nodeData, List<Edge> Edges, List<ArrayList<String>> nodesData) {
        this.text = nodeData.get(1);
        this.name = nodeData.get(0);

        int i = 0;
        for (Edge edge : Edges) {
            if (edge.origin.equals(name)) {
                isOriginOf[i] = edge;
                i++;
            }
        }

        this.Edges = Collections.unmodifiableList(Edges);
        this.nodesData = Collections.unmodifiableList(nodesData);

    };

    public Node nextNode() {
        Node newNode = null;
        boolean Answer = handleText(text);
        String newName = new String();

        for (Edge edge : isOriginOf) {
            if (edge.answer == Answer) {
                newName = edge.destination;
            }
        }

        for (ArrayList<String> nodeData : nodesData) {
            if (nodeData.get(0).equals(newName)) {
                String newText = nodeData.get(1);
                newNode = new Node(nodeData, Edges, nodesData);
            }
        }

        return newNode;
    }

    private static boolean handleText(String text) {
        boolean Answer = false; /* initialize to avoid "Might not have been initialized error */

        if (text.contains("?")) { /* We may assume all questions contain a question mark */
            System.out.println(text);
            Scanner myScanner = new Scanner(System.in);
            boolean invalidinput = true;

            while (invalidinput) {
                String UserAnswer = myScanner.nextLine();
                if (UserAnswer.equals("Ja")) {
                    Answer = true;
                    invalidinput = false;
                } else if (UserAnswer.equals("Nee")) {
                    Answer = false;
                    invalidinput = false;
                } else {
                    System.out.println("Input moet \"Ja\" of \"Nee\" zijn");
                }
            }
            
        } else {
            System.out.println("Het is een " + text);
            System.exit(0);
        }
        return Answer;
    };
}
