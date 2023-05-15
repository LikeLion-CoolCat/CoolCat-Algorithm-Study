import java.util.Scanner;
import java.util.Arrays;

class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] stones = new int[M];
		int count = 0;
		for(int i=0;i<size;i++){
			stones[i] = sc.nextInt();
			count += stones[i];
		}
		int pick = sc.nextInt();
		double total = 1;
		for(int i=0;i<pick;i++){
			total *= (count-i);
		}
		double sum = 0;

		for(int i=0;i<size;i++){
			if(stones[i]<pick) continue;
			double tmp=1;
			for(int j=0;j<total;j++) {
				tmp *= (stones[i]-j);
			}
			sum+= tmp;
		}
		System.out.println(sum/total);
	}
}
