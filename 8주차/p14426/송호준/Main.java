import java.io.*;
import java.util.*;

public class Main {
    static class TrieNode {

        private Map<Character, TrieNode> childNodes = new HashMap<>();

        Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }
    }

    static class Trie {
        private TrieNode rootNode;

        public Trie() {
            rootNode = new TrieNode();
        }

        void insert(String word) {
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
        }

        boolean contains(String word) {
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                TrieNode node = thisNode.getChildNodes().get(character);
                if (node == null)
                    return false;
                thisNode = node;
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            trie.insert(input);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (trie.contains(input)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
