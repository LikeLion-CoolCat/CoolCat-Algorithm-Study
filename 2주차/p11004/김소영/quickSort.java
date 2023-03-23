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
        array=quick(low, high, array);
        System.out.println("최종 정렬 결과 : "+Arrays.toString(array));

    }

    public static int[] quick(int low, int high, int[] arr){
        if(low>=high) return arr;
        int pivot = arr[0];
        int i=low+1, j=high;

        while(i <= j){
            //피벗보다 작은 값을 찾을때까지 증가
            while(i<high && arr[i] < arr[pivot])
                i++;

            //피벗보다 큰 값을 찾을때까지 감소
            while(j>low && arr[j]>arr[pivot] )
                j--;

            if(i>j){
                int temp = arr[j];
                arr[j] = arr[pivot];
                arr[pivot] = temp;
            }else {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}
