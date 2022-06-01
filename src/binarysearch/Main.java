package binarysearch;

public class Main {

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        boolean test = false;

        //Step 1: user enter a number of array 
        int size = b.inputSizeRandomArray();

        //Step 2: user enter a search number
        int searchNumber = b.inputSearchValue();

        //Step 3: genarate random integer in number range for each array element
//        int[] randomNumberArray = b.getRandomNumberArray(size);
//        int[] randomNumberArray = {1, 1, 1, 1, 3, 4, 6, 8, 9, 9};
        test = true;
        int[] randomNumberArray = {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114};

        //Step 4: sort array
        b.sortArrayAndPrint(randomNumberArray);

        //Step 5: display the index of search number in array
        int index = b.binarySearch(randomNumberArray, searchNumber, 0, randomNumberArray.length - 1, test);
        b.displayBinarySearch(searchNumber, index);
    }

}
