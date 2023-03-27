public class Main{ //중간 피벗 퀵정렬
    //11004 https://www.acmicpc.net/problem/11004
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        //구현부

        qSort sort = new qSort();
        qSort.middleQuickSort(a, 0, a.length - 1);

        System.out.println(a[k-1]);

    }

}

class qSort{

    static void middleQuickSort(int[] a, int left, int right){
        if(left >= right){
            return ;
        }

        int pivotIndex = partition(a, left, right);

        middleQuickSort(a, left, pivotIndex - 1);
        middleQuickSort(a, pivotIndex, right);
    }

    static int partition(int[] a, int left, int right){
        int pivot = a[(left+right) / 2];
        while(left <= right){
            while(a[left] < pivot){
                left++;
            }
            while(a[right] > pivot){
                right--;
            }
            if(left <= right){
                swap(a, left, right);
                left++;
                right--;
            }
        }
        return left;

    }

    static void swap(int[] a, int b, int c){
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }
}


//public class Main{ // 이건 시간초과로 안됨 좌측피벗정렬임.
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        //Scanner sc = new Scanner(System.in);
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//
//        int[] a = new int[n];
//
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < n; i++){
//            a[i] = Integer.parseInt(st.nextToken());
//        }
//
//        //구현부
//        quickSort sort = new quickSort();
//        sort.sort(a, 0, a.length-1);
//
//        System.out.println(a[k-1]);
////        for (int num:a) {
////            System.out.println(num);
////        }
//    }
//}
//
//class quickSort{
//
//    void sort(int[] a, int left, int right){
//
//        if(left >= right){ // 스택오버플로우방지
//            return ;
//        }
//
//        int pivot = partition(a, left, right);
//
//        sort(a, left, pivot - 1);
//        sort(a, pivot + 1, right);
//
//    }
//
//    int partition(int[] a, int left, int right){
//        int pivot = a[left];
//        int pivotIndex = left;
//        while(left < right) {
//
//            while (a[right] > pivot && left < right) {
//                right--;
//            }
//            while (a[left] <= pivot && left < right) {
//                left++;
//            }
//
//            swap(a, left, right);
//
//        }
//
//        swap(a, pivotIndex, left);
//
//
//
//        return left;
//    }
//
//    void swap(int[] a, int i, int j){
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }
//}
