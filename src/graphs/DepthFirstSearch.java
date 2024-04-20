package graphs;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node i = new Node("I");
        Node j = new Node("J");
        Node g = new Node("G");
        Node h = new Node("H");
        Node k = new Node("K");

        a.addChild("B");
        a.addChild("C");
        a.addChild("D");

        b.addChild("E");
        b.addChild("F");

        d.addChild("G");
        d.addChild("H");

        f.addChild("I");
        f.addChild("J");

        g.addChild("K");

        List<String> inputArray = new ArrayList<>();
        List<String> output = a.depthFirstSearch(inputArray);
        for(String str : output) {
            System.out.println(str);
        }
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        // O(v + e) time | O(v) space
        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for (Node child : children) {
                child.depthFirstSearch(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
