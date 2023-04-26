public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("크기, 간선, 시작할 노드의 번호를 입력해주세요 : ");
        int size = sc.nextInt();
        int max = sc.nextInt();
        int start = sc.nextInt();
        Graph g1 = new Graph(size);
        Graph g2 = new Graph(size);
        System.out.print("연결점을 입력해주세요 : ");
        for(int i=0;i<max;i++){
            int a, b;
            a=sc.nextInt();
            b=sc.nextInt();
            g1.addEdge(a-1,b-1);
            g2.addEdge(a-1,b-1);
        }
        System.out.print("DFS 결과 : ");
        g1.dfs(start-1);
        System.out.print("BFS 결과 : ");
        g2.bfs(start-1);

    }

}

class Queue<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void enqueue(T item){
        Node<T> t = new Node<T>(item);
        if(last != null) {
            last.next=t;
        }
        last=t;
        if(first==null){
            first=last;
        }
    }

    public T dequeue(){
        if(first==null){
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;
        if(first==null){
            last=null;
        }
        return data;
    }

    public T peek(){
        if(first==null){
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty(){
        return first==null;
    }
}

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;
        Node (int data){
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }
    Node[] nodes;
    Graph(int size){
        nodes = new Node[size];
        for(int i=0;i<size;i++){
            nodes[i] = new Node(i);
        }
    }
    void addEdge(int i1, int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }
    void dfs() {
        dfs(0);
    }

    void dfs(int index){
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()){
            Node r = stack.pop();
            for(Node n : r.adjacent) {
                if(n.marked == false){
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    void bfs(){
        bfs(0);
    }
    void bfs(int index){
        Node root = nodes[index];
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        root.marked = true;
        while(!queue.isEmpty()){
            Node r = queue.dequeue();
            for(Node n : r.adjacent){
                if(n.marked == false) {
                    n.marked = true;
                    queue.enqueue(n);
                }
            }
            visit(r);
        }
    }

    void dfsR(Node r){
        if(r==null) return;
        r.marked = true;
        visit(r);
    }
    
    void visit(Node n){
        System.out.println(n.data+1+" ");
    }
}
