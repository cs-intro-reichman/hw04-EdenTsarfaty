public class ArrayOps {
    public static void main(String[] args) {
        // #feedback: please dont keep historical code within comments
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
        // #feedback: you could use one loop to find the second (when new max found - second max is the old one)
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
