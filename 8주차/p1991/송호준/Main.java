import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        char value;
        char leftChild;
        char rightChild;

        public Node(char value, char leftChild, char rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    private static int N;
    private static Node[] graph;
    private static StringBuilder sb = new StringBuilder();
    private static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new Node[N + 1];
        map.put('.', 0);
        graph[0] = new Node('.', '.', '.');
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char v = st.nextToken().charAt(0);
            char lc = st.nextToken().charAt(0);
            char rc = st.nextToken().charAt(0);
            graph[i] = new Node(v, lc, rc);
            map.put(v, i);
        }

        preOrder(1);
        sb.append("\n");
        inOrder(1);
        sb.append("\n");
        postOrder(1);

        System.out.println(sb);
    }

    private static void preOrder(int k) {
        Node node = graph[k];
        if (node.value == '.') {
            return;
        }
        sb.append(node.value);
        preOrder(map.get(node.leftChild));
        preOrder(map.get(node.rightChild));
    }

    private static void inOrder(int k) {
        Node node = graph[k];
        if (node.value == '.') {
            return;
        }
        inOrder(map.get(node.leftChild));
        sb.append(node.value);
        inOrder(map.get(node.rightChild));
    }

    private static void postOrder(int k) {
        Node node = graph[k];
        if (node.value == '.') {
            return;
        }
        postOrder(map.get(node.leftChild));
        postOrder(map.get(node.rightChild));
        sb.append(node.value);
    }
}
