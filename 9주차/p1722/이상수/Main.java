public class p1722 {
    public static int n;
    public static long arr[];
    public static void main() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(in.readLine());
        
        String line[] = in.readLine().split(" ");
        arr = new long[n];
        
        int i, len = line.length;
        for(i=1;i<len;i++) {
            arr[i - 1] = Long.parseLong(line[i]);
        }
        
        out.write(line[0].equals("1") ? getPermutation() : getOrder());
        out.close();
        in.close();
    }

    private static String getPermutation(){
        int i, j;
        long f, tmp, sum = 0, k = arr[0]-1;

        StringBuilder perm = new StringBuilder();
        LinkedList<Integer> order = new LinkedList<>();
        for(i=1;i<=n;i++) order.add(i);

        for(i=1;i<n;i++){
            for(f=fac(n-i), j=0;;j++){
                if((tmp = sum + j*f) >= k){
                    if(tmp > k){
                        tmp -= f; j--;
                    }
                    perm.append(order.remove(j)+" ");
                    sum = tmp;
                    break;
                }
            }
        }

        while(!order.isEmpty())
            perm.append(order.poll()+" ");

        return perm.toString().trim();
    }

    private static String getOrder(){
        int i, j;
        long f, sum = 0;

        LinkedList<Integer> order = new LinkedList<>();
        for(i=1;i<=n;i++) order.add(i);

        for(i=0;i<n;i++){
            f = fac(n-i-1);
            j = order.indexOf((int)arr[i]);
            order.remove(j);
            sum += j*f;
        }

        return (sum+1)+"";
    }

    private static long fac(int num){
        long f = 1;
        for(;num>1;f*=(num--));
        return f;
    }
}
