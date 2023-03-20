package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Stack{
  
    void run() {
        Scanner sc = new Scanner(System.in);
        int max = false;
        int stackIndex = 0;
        int storageIndex = 0;
        boolean isDuplication = false;
        System.out.print("크기를 입력해주세요 : ");
        int max = sc.nextInt();
        int[] stack = new int[max];
        int[] storage = new int[max];
        Arrays.fill(storage, 0);

        int i;
        for(i = 0; i < max; ++i) {
            System.out.print(i + 1 + "번째 입력 : ");
            int input = sc.nextInt();

            for(int j = 0; j < max; ++j) {
                if (storage[j] == input) {
                    isDuplication = true;
                }
            }

            if (isDuplication) {
                System.out.println("중복값이 있습니다. 다시 입력하세요.");
                --i;
            } else {
                storage[i] = input;
            }
        }

        i = 1;

        while(true) {
            if (stack[stackIndex] == 0 && storageIndex == 0) {
                stack[stackIndex] = 1;
                ++i;
                System.out.println("+ <" + stack[stackIndex] + "> pushed");
            } else if (stack[stackIndex] != storage[storageIndex]) {
                ++stackIndex;
                stack[stackIndex] = i++;
                System.out.println("+ <" + stack[stackIndex] + "> pushed");
            } else {
                System.out.println("- <" + stack[stackIndex] + "> popped");
                stack[stackIndex] = 0;
                if (stackIndex != 0) {
                    --stackIndex;
                }

                ++storageIndex;
            }

            if (storageIndex >= max) {
                System.out.println("END");
                break;
            }

            if (stack[stackIndex] > storage[storageIndex]) {
                System.out.println("NO");
                System.out.println("현재 스택의 최대값 : " + stack[stackIndex] + " / 수열 만들기에 필요한 값 : " + storage[storageIndex]);
                break;
            }
        }

    }
}
