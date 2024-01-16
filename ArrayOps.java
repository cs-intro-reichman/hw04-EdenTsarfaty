public class ArrayOps {
    public static void main(String[] args) {
//        System.out.println(findMissingInt(new int[] {3, 0, 1})); // 2
//        System.out.println(findMissingInt(new int[] {0, 1, 2, 3, 4, 6})); // 5
//        System.out.println(findMissingInt(new int[] {0})); // 1
//        System.out.println(secondMaxValue(new int[] {6, 9, 4, 7, 3, 4})); // 7
//        System.out.println(secondMaxValue(new int[] {1, 2, 3, 4, 5})); // 4
//        System.out.println(secondMaxValue(new int[] {2, 8, 3, 7, 8})); // 8
//        System.out.println(secondMaxValue(new int[] {1, -2, 3, -4, 5})); // 3
//        System.out.println(secondMaxValue(new int[] {-202, 48, 13, 7, 8})); // 13
//        System.out.println(containsTheSameElements(new int[] {1, 2, 1, 1, 2}, new int[] {2, 1})); // true
//        System.out.println(containsTheSameElements(new int[] {2, 2, 3, 7, 8, 3, 2}, new int[] {8, 2, 7, 7, 3})); // true
//        System.out.println(containsTheSameElements(new int[] {1, 2, 3}, new int[] {1, 2, 3})); // true
//        System.out.println(containsTheSameElements(new int[] {3, -4, 1, 2, 5}, new int[] {1, 3, -4, 5})); // false
//        System.out.println(isSorted(new int[] {7, 5, 4, 3, -12})); // true
//        System.out.println(isSorted(new int[] {1, 2, 3})); // true
//        System.out.println(isSorted(new int[] {1, -2, 3})); // false
//        System.out.println(isSorted(new int[] {1, 1, 500})); // true
//        System.out.println(isSorted(new int[] {1, 3, 2})); // false
    }
    
    public static int findMissingInt (int [] array) {
        int sum = 0;            //Sums up all the elements of array
        int expected = 0;       //Sums up the series 1+2+3+4...
        for (int i = 0; i < array.length; i++)
        {
            sum += array[i];
            expected += i + 1;
        }
        return expected-sum;
    }

    public static int secondMaxValue(int [] array) {
        int max = array[0];
        int maxindex = 0;
        for (int i = 1; i < array.length; i++)      //Determines the max value and index
        {
            if (array[i] > max) {
                max = array[i];
                maxindex = i;
            }
        }
        int secondmax = array[0];
        for (int i = 1; i < array.length; i++)
        {
            if (i != maxindex) {        //Skips the check for the max element index
                if (array[i] > secondmax) {
                    secondmax = array[i];
                }
            }
        }
        return secondmax;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        boolean exists = false;
        for (int i = 0; i < array1.length; i++) {
            exists = false;
            for (int j = 0; j < array2.length; j++)
            {
                if (array1[i] == array2[j]) {       //A match in array2 was found
                    exists = true;
                    break;
                }
            }
            if (exists == false) {                  //Finished a round without finding a match in array2
                return false;
            }
        }
        return exists;
    }

    public static boolean isSorted(int [] array) {
        boolean sorted = false;
        for (int i = 1; i < array.length; i++)      //Checks whether array is sorted up
        {
            if (array[i] >= array[i-1]) {
                sorted = true;
            }
            else {
                sorted = false;
                break;
            }
        }
        if (!sorted) {                              //If not sorted up checks whether array is sorted down
            for (int i = 1; i < array.length; i++) {
                if (array[i] <= array[i - 1]) {
                    sorted = true;
                } else {
                    sorted = false;
                    break;
                }
            }
        }
        return sorted;
    }

}
