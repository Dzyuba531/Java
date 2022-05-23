package com.max.idea;
import java.util.Scanner;

public class task2 {

    public static int[] Zero_arr(int[] arr){
    int zer=0;
    for (int i : arr){
        if(i == 0){
            zer++;
        }
    }
    System.out.println("Кількість нульових елементів масиву: "+zer);
    return arr;
}

    public static int Sum_After_Max(int[] arr)throws Exception{
        int max=0;
        int x=0;
        int sum=0;

        for (int i = 0; i < arr.length; i++) {
            int a=arr[arr.length-1];
            if (max < Math.abs(arr[i])) {
                x = i;
                max = Math.abs(arr[i]);

            }
            if(a==max){
                throw new Exception("Максимальний за модулем елемент є останнім.");
            }
        }
        for (int i = x+1; i < arr.length; i++) {
            sum += arr[i];

        }

        System.out.println("Добуток елементів масиву розташованих після максимального за модулем елемента: " + sum);
        return x;
    }

    public static void Start() {
        Scanner in = new Scanner(System.in);
        int[] arr = createArray.ArrayCreate();
        char num;
        do
        {
            System.out.println("Оберіть метод заповнення масиву:");
            System.out.println("1 — ввід елементів з клавіатури");
            System.out.println("2 — рандомайзер.");
            System.out.print("метод: ");
            num = in.next().charAt(0);

            switch (num)
            {
                case '1':
                    createArray.ArrayInput(arr);
                    break;
                case '2':
                    createArray.ArrayRandom(arr);
                    createArray.ArrayOutput(arr);
                    break;
                default:
                    System.out.println("Дані введено некорректно!");
                    break;
            }
            System.out.println();
        } while (num != '1' && num != '2');
        task2.Zero_arr(arr);
        try{
            System.out.println(Sum_After_Max(arr));
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}