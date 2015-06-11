package pp.s1299212.q2_2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Set;

import pp.homework.q2_2.Graph;
import pp.homework.q2_2.Node;
import pp.iloc.Assembler;
import pp.iloc.model.Instr;
import pp.iloc.model.Label;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

public class ILOC2CFG {
	/** The singleton instance of this class. */
	private static final ILOC2CFG instance = new ILOC2CFG();

	/** Returns the singleton instance of this class. */
	public static ILOC2CFG instance() {
		return instance;
	}

	/** Converts an ILOC file given as parameter and prints out the
	 * resulting CFG. 
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: filename");
		}
		try {
			Program prog = Assembler.instance().assemble(new File(args[0]));
			System.out.println(instance().convert(prog));
		} catch (FormatException | IOException exc) {
			exc.printStackTrace();
		}
	}

	/** Private constructor for the singleton instance. */
	private ILOC2CFG() {
		// empty by design
	}

    public Graph convert(Program prog) {
        Graph g = new Graph();
        
        Node startNode = null;
        Node previousNode = null;
        Node currentNode = null;
        //Map of edges to be made
        Map<Node, List<Label>> controlFlow = new HashMap<Node, List<Label>>();
        //Map that stores incoming edges per Node
        Map<Node, List<Node>> incomingEdges = new HashMap<Node, List<Node>>();
        

        boolean cont = true;
        // Build nodes, store edges
        for (Instr instr : prog.getInstr()) {
            Iterator<Op> it = instr.iterator();
            while (it.hasNext()) {
                Op op = it.next();
                if (op.hasLabel()) {
                    previousNode = currentNode;
                    currentNode = g.addNode(op.getLabel().getValue());
                    if (previousNode != null) {
                        if (cont) {
                            previousNode.addEdge(currentNode);
                        }
                    } else {
                        startNode = currentNode;
                    }
                }

                List<Label> list;
                switch (op.getOpCode()) {
                case jumpI:
                    list = new ArrayList();
                    list.add(op.label(0));
                    controlFlow.put(currentNode, list);
                    cont = false;
                    break;
                case cbr:
                    list = new ArrayList();
                    list.add(op.label(1));
                    list.add(op.label(2));
                    controlFlow.put(currentNode, list);
                    cont = false;
                    break;
                default:
                    cont = true;
                    break;
                }
            }
        }
        
        //Build edges
        for (Entry<Node, List<Label>> entry: controlFlow.entrySet()) {
            for (Label l : entry.getValue()) {
                Node from = entry.getKey();
                Node to = getNode(g,l);
                from.addEdge(to);
                
                List<Node> list = incomingEdges.get(to);
                if(list == null) {
                    list = new ArrayList<Node>();
                }
                list.add(from);
            }
        }
        
        System.out.println("Basic graph:\n"+g);
        g = optimize(startNode, incomingEdges);
        
        return g;
    }
    
    private Graph optimize(Node start, Map<Node, List<Node>> incomingEdges) {
        //Due to there not being a graph remove / adapt method, the entire graph gets rebuild.
        //The initial graph building still is not useless, the Node and Edge information is used,
        //along with gathering an incomingEdges Map
        
        Graph newG = new Graph();
        Set<Node> toVisit = new HashSet<Node>();
        Set<Node> visited = new HashSet<Node>();
        Set<Node> block = new HashSet<Node>();
        
        Map<Node,List<String>> newEdges = new HashMap<Node, List<String>>();
        Map<String, Node> belongsToBlock = new HashMap<String, Node>();
        
        toVisit.add(start);
        block.clear();
        while (!toVisit.isEmpty()) {
            Node current = toVisit.iterator().next();
            visited.add(current);
            toVisit.remove(current);
            
            while (current != null) {
                block.add(current);
                Node nextNode = current.getEdges().toArray(new Node[1])[0];
                boolean loopToSelf = visited.contains(nextNode);
                boolean noIncomingBranches = incomingEdges.get(current) == null || incomingEdges.get(current).size() == 1;
                boolean noOutgoingBranches = current.getEdges().size() == 1;
                if (noOutgoingBranches && !loopToSelf && noIncomingBranches) {
                    // Continue block;
                    current = nextNode;
                } else {
                    // Finish block
                    Node newNode = newG.addNode(block.toArray(new Node[1])[0].getId());
                    for (Node node : block) {
                        belongsToBlock.put(node.getId(),newNode);
                    }
                    List<String> outgoingEdges = current.getEdges().stream().map(n -> n.getId()).collect(Collectors.toCollection(ArrayList<String>::new));
                    newEdges.put(newNode, outgoingEdges);
                    
                    for (Node edge : current.getEdges()) {
                        if (!visited.contains(edge)) {
                            toVisit.add(edge);
                        }
                    }
                    block.clear();
                    current = null;
                }
            }
        }
        
        // Build edges
        for (Entry<Node, List<String>> entry : newEdges.entrySet()) {
            for (String id : entry.getValue()) {
                Node from = entry.getKey();
                Node to = belongsToBlock.get(id);
                from.addEdge(to);
            }
        }

        return newG;
    }
    
    
    private Node getNode(Graph g, Label l) {
        for (Node n : g.getNodes()) {
            if (n.getId().equals(l.getValue())) {
                return n;
            }
        }
        
        return null;
    }
}
