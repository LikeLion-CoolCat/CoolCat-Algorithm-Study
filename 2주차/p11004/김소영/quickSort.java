public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("크기를 입력해주세요 : ");
        int max = sc.nextInt();
        System.out.print("몇 번째로 큰 수? : ");
        int rank = sc.nextInt();
        int low = 0, high=max-1;
        int[] array = new int[max];
        System.out.print("크기만큼의 배열을 입력해주세요 : ");
        for(int i=0;i<max;i++){
            array[i] = sc.nextInt();
        }
        System.out.println("입력된 배열 : "+Arrays.toString(array));
        quick(low, high, array);
        System.out.println("최종 정렬 결과 : "+Arrays.toString(array));
        System.out.println(rank+ "번째로 큰 수 : "+array[rank-1]);

    }

    public static int partition(int low, int high, int[] arr){

        int pivot = (low+high)/2;

        while(low < high){
            //피벗보다 작은 값을 찾을때까지 증가
            while(low<=high && arr[low] <= arr[pivot])
                low++;

            //피벗보다 큰 값을 찾을때까지 감소
            while(low<=high && arr[high]>arr[pivot] )
                high--;

            if(high>=low){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                if(high == pivot) return low;
            }
        }

        if(high != pivot){
            int temp = arr[high];
            arr[high] = arr[pivot];
            arr[pivot] = temp;
        }
        return high;
    }

    public static void quick(int low, int high, int[] arr){
        if(low<high){
            int pivot = partition(low, high, arr);
            quick(low, pivot-1, arr);
            quick(pivot+1, high, arr);
        }
    }
}
