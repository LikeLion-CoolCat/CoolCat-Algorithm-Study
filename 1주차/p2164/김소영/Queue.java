class Queue {
    void run() {
                Scanner sc = new Scanner(System.in);
                int queueIndex = 0;
                System.out.print("크기를 입력해주세요 : ");
                int max = sc.nextInt();
                queueIndex=max-1;
                int[] queue = new int[max];
                int[] storage = new int[max];
                Arrays.fill(queue, 0);
                for(int i=1;i<=max;i++){
                    queue[i-1] = i;
                }

                int i=0;
                if(queueIndex!=0)
                    while(queue[1]!=0){
                        queue[0]=0;
                        if(queueIndex>1)
                            for(int j=0;j<queueIndex;j++){
                                int temp=queue[j+1];
                                if(temp==0) break;
                                queue[j]=queue[j+1];
                            }
                        else {
                            queue[0]=queue[1];
                            queue[1]=0;
                        }
                        if(queue[1]==0) break;

                        queueIndex--;
                        queue[queueIndex]=queue[0];

                        for(int j=0;j<queueIndex;j++){
                            int temp=queue[j+1];
                            if(temp==0) break;
                            queue[j]=queue[j+1];
                        }
                        if(queue[1]==0) break;
                    }

                System.out.println(queue[0]);

    }
}
