package binarysearch;

import java.util.Scanner;

public class BinarySearch {

    int step = 1;

    final Scanner sc = new Scanner(System.in);

    public int checkInt() {
        int number = Integer.parseInt(sc.nextLine());

        return number;
    }

    public int inputSizeRandomArray() {
        System.out.println("Enter number of array: ");
        int size = checkInt();

        return size;
    }

    public int inputSearchValue() {
        System.out.println("Enter search value: ");
        int searchNumber = checkInt();

        return searchNumber;
    }

    public int randomNumber() {
        int number = (int) (Math.random() * (10 - 0));

        return number;
    }

    public int[] getRandomNumberArray(int size) {
        int[] arrayRandomNumber = new int[size];

        for (int i = 0; i < arrayRandomNumber.length; i++) {
            arrayRandomNumber[i] = randomNumber();
        }

        return arrayRandomNumber;
    }

    public int[] sortArrayAndPrint(int[] arrayNumber) {
        for (int i = 0; i < arrayNumber.length; i++) {
            for (int j = i + 1; j < arrayNumber.length; j++) {
                int tmp = 0;
                if (arrayNumber[i] > arrayNumber[j]) {
                    tmp = arrayNumber[i];
                    arrayNumber[i] = arrayNumber[j];
                    arrayNumber[j] = tmp;
                }
            }
        }
        
        System.out.print("Sorted array: ");

        for (int i = 0; i < arrayNumber.length; i++) {
            if (i == 0) {
                System.out.print("[" + arrayNumber[i] + ", ");
            } else if (i == arrayNumber.length - 1) {
                System.out.println(arrayNumber[i] + "]");
            } else {
                System.out.print(arrayNumber[i] + ", ");
            }
        }

        return arrayNumber;
    }

//    public int binarySearch(int[] arraySorted, int value, int left, int right) {
//        if (left > right) {
//            return -1;
//        }
//        int middle = (left + right) / 2;
//
//        if (arraySorted[middle] == value) {
//            return middle;
//        } else if (arraySorted[middle] > value) {
//            return binarySearch(arraySorted, value, left, middle - 1);
//        } else {
//            return binarySearch(arraySorted, value, middle + 1, right);
//        }
//    }
    
    public int binarySearch(int[] arraySorted, int value, int left, int right, boolean test) {
        if (left > right) {
            if (test) {
                System.out.println("Step " + step + " (searched value is absent): ");
            }
            return -1;
        }
        int middle = (left + right) / 2;

        if (arraySorted[middle] == value) {
            if (test) {
                System.out.print("Step " + step + " (middle element is " + arraySorted[middle] + " == " + value + "): ");

                for (int i = left; i <= right; i++) {
                    if (arraySorted[i] != arraySorted[middle]) {
                        System.out.print(arraySorted[i] + " ");
                    }

                    if (arraySorted[i] == arraySorted[middle]) {
                        System.out.print("{" + arraySorted[i] + "} ");
                    }
                }
                            System.out.println("");
            }
            return middle;
        } else if (arraySorted[middle] > value) {
            if (test) {
                System.out.print("Step " + step + " (middle element is " + arraySorted[middle] + " > " + value + "): ");

                for (int i = left; i <= right; i++) {
                    if (arraySorted[i] != arraySorted[middle]) {
                        System.out.print(arraySorted[i] + " ");
                    }

                    if (arraySorted[i] == arraySorted[middle]) {
                        System.out.print("{" + arraySorted[i] + "} ");
                    }
                }
                System.out.println("");
                step++;
            }
            return binarySearch(arraySorted, value, left, middle - 1, test);
        } else {
            if (test) {
                System.out.print("Step " + step + " (middle element is " + arraySorted[middle] + " < " + value + "): ");

                for (int i = left; i <= right; i++) {
                    if (arraySorted[i] != arraySorted[middle]) {
                        System.out.print(arraySorted[i] + " ");
                    }

                    if (arraySorted[i] == arraySorted[middle]) {
                        System.out.print("{" + arraySorted[i] + "} ");
                    }
                }
                System.out.println("");
                step++;
            }
            return binarySearch(arraySorted, value, middle + 1, right, test);
        }
    }

    public void displayBinarySearch(int value, int index) {
        if (index != -1) {
            System.out.println("Found " + value + " at index: " + index);
        } else {
            System.out.println("The value is not found!");
        }
    }
}
