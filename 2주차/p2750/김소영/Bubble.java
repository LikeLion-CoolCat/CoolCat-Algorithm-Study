public class Bubble {
    void run() {
                Scanner sc = new Scanner(System.in);
                int queueIndex = 0;
                System.out.print("크기를 입력해주세요 : ");
                int max = sc.nextInt();
                int[] sort = new int[max];
                for(int i=0;i<max;i++){
                    sort[i] = sc.nextInt();
                }
                System.out.println("입력된 배열 : "+Arrays.toString(sort));
                int cnt=0;
                for(int i=0;i<max;i++){
                    for(int j=0;j<max-i-1;j++){
                       if(sort[j+1]<sort[j]){
                            int temp=sort[j];
                            sort[j]=sort[j+1];
                            sort[j+1]=temp;
                            cnt++;
                           System.out.println(cnt+"번째 정렬 결과 : "+Arrays.toString(sort));
                       }
                    }
                }

        System.out.println("최종 정렬 결과 : "+Arrays.toString(sort));

    }
}
