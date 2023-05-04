package p14426;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p14426 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        String[] inputArr = new String[N];
        String[] toFindArr = new String[M];

        Trie trie = new Trie();

        int count = 0;
        
        sc.nextLine();

        for(int i=0; i<N; i++)
        {
            inputArr[i] = sc.nextLine().trim();
            trie.insert(inputArr[i]);
        }

        for(int i=0; i<M; i++)
        {
            toFindArr[i] = sc.nextLine().trim();

            if(trie.search(toFindArr[i]))
            {
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }
}

class TrieNode {

    char c;
    boolean isLeaf;     //해당 노드가 마지막 문자에 해당하는가? (True => 접두사 X)

    Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode() {}
    public TrieNode(char c) {
        this.c = c;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word)
    {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);

            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode(c));
            }

            node = node.children.get(c);
        }
        node.isLeaf = true;
    }

    public boolean search(String word)
    {
        TrieNode node = root;

        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);

            if(!node.children.containsKey(c))
            {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isLeaf;
    }

}
