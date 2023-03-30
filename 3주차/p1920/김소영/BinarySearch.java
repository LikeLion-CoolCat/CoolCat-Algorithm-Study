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

        System.out.print("검색 결과 : ");
        binarySearch(arr, tempArr);

    }

    public static void binarySearch(int[] arr, int[] temp){
        Arrays.sort(arr); // 정렬
        for(int i=0;i<temp.length;i++){
            //구현 필요. . .
        }

    }

}
