import lombok.Data;

import java.util.LinkedList;

public class JsonTest {

    @Data
    private static class Node {
        private final String name;
        private final LinkedList<Node> childNodes = new LinkedList<>();

        private Node(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node("ddd");
        Node node2 = new Node("dddh");
        Node node3 = new Node("dddh");

        node2.childNodes.add(node3);

        node1.childNodes.add(new Node("dddh"));
        node1.childNodes.add(node2);


        System.out.println(JacksonTool.parseToJsonString(node1));
    }
}
