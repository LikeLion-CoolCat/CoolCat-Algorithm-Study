class p1753 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] e = new ArrayList[V];
        int k = Integer.parseInt(br.readLine()) - 1;
        boolean[] visit = new boolean[V];
        int[] wei = new int[V];
        for (int i = 0; i < V; i++) { // 초기화
            wei[i] = Integer.MAX_VALUE;
            e[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            e[u].add(new Edge(v, w));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(k, 0));
        wei[k] = 0;

        while (!q.isEmpty()) {
            Edge now = q.poll();

            if(visit[now.v]) continue;
            visit[now.v] = true;
            for (int i = 0; i < e[now.v].size(); i++) {
                if(wei[e[now.v].get(i).v]>wei[now.v] + e[now.v].get(i).w) {
                    wei[e[now.v].get(i).v] = wei[now.v] + e[now.v].get(i).w;
                    q.offer(new Edge(e[now.v].get(i).v, wei[e[now.v].get(i).v]));
                }
            }
        }

        for(int i=0;i<V;i++) {
            if(wei[i]==Integer.MAX_VALUE) {
                sb.append("INF\n");
            }else {
                sb.append(wei[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static class Edge implements Comparable<Edge>{
        int v, w;

        public Edge(int v, int w) {
            super();
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w-o.w;
        }
    }
}
