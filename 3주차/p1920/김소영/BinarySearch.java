public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("크기와 크기만큼의 값을 입력하세요. : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("검색할 배열의 크기와 크기만큼의 값을 입력하세요. : ");
        int sizeT = sc.nextInt();
        int[] tempArr = new int[sizeT];
        for(int i=0;i<sizeT;i++){
            tempArr[i]=sc.nextInt();
        }

        Arrays.sort(arr); // 정렬
        System.out.print("검색 결과 : ");
        for(int i=0;i<sizeT;i++){
            System.out.print(binarySearch(arr, tempArr[i], 0, size-1)+" ");
        }

    }

    public static int binarySearch(int[] arr, int temp, int low, int high){
        if(low>high) return 0;
        int mid = (low+high)/2;
        if(arr[mid]<temp) return binarySearch(arr, temp, mid+1,high);
        else if (arr[mid]>temp) return binarySearch(arr, temp, low, temp-1);
        else return 1;
    }

}
