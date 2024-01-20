public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        System.out.println(capVowelsLowRest("Hello World")); // “hEllO wOrld”
        System.out.println(capVowelsLowRest("One two tHRee world")); // “OnE twO thrEE wOrld”
        System.out.println(capVowelsLowRest("vowels are fun")); // “vOwEls ArE fUn”
        System.out.println(capVowelsLowRest("intro")); // “IntrO”
        System.out.println(capVowelsLowRest("yellow")); // “yEllOw”
        System.out.println(camelCase("Hello World")); // “helloWorld”
        System.out.println(camelCase("HELLO world")); // “helloWorld”
        System.out.println(camelCase(" tWo wordS")); // “twoWords”
        System.out.println(camelCase("world")); // “world
        System.out.println(camelCase(" Intro to coMPUter sCIEncE ")); // “introToComputerScience”
        printTest(allIndexOf("Hello world",'l')); // output: {2, 3, 9}
        printTest(allIndexOf("Hello worLd",'l')); // output: {2, 3}
        printTest(allIndexOf("Hello world",'o')); // output: {4, 7}
        printTest(allIndexOf("Hello world",' ')); // output: {5}
        printTest(allIndexOf("Hello world",'d')); // output: {10}
        printTest(allIndexOf("MMMM",'M')); // output: {0, 1, 2, 3}
    }

    private static void printTest (int[] test)
    {
        for (int i = 0; i < test.length; i++)
        {
            System.out.print(test[i]+ " ");
        }
        System.out.println();
    }

    public static String capVowelsLowRest (String string) {
        String cappedVowelsString = "";
        String capitalVowels = "aeiou";
        for (int i = 0; i < string.length(); i++)
        {
            /*
                #feedback:
                Switch\case is not a good mechanism to such kind of questions.
                It should be used when you have multiple cases.
                Here you have only 2 which is classic to if-else.
            */
            char currentChar = string.charAt(i);
            if (isCapital(currentChar)) {
                char lowerCase = toLowerCase(currentChar);
                if (capitalVowels.indexOf(lowerCase) == -1) {
                    cappedVowelsString += lowerCase;
                } else {
                    cappedVowelsString += currentChar;
                }
            }
            else {
                if(capitalVowels.indexOf(currentChar) >= 0) {
                    const upperCase = toUpperCase(currentChar);
                    cappedVowelsString += upperCase;
                } else {
                    cappedVowelsString += currentChar;
                }
            }
        }
        return cappedVowelsString;
    }

    public static String camelCase (String string) {
        String camelCaseString = "";
        // #feedback: it's kinda ironic that in camelCase question you did not use camelCased variable names :)
        boolean newWord = false;
        boolean firstWord = true;
        for (int i = 0; i < string.length(); i++)
        {
            // #feedback: try to avoid multiple function calls when the expected value is the same - store it in a variable instead
            char currentChar = string.charAt(i);
            if (currentChar != ' ') {
                // #feedback: why did you wrap these both conditions than seperate their behavior inside?
                if (firstWord) {
                    camelCaseString += toLowerCase(currentChar);
                    firstWord = false;
                    newWord = false;
                } else if (newWord) {
                    camelCaseString += toUpperCase(currentChar);
                    newWord = false;
                } else {
                    camelCaseString += toLowerCase(currentChar);
                }
            }
            else {
                newWord = true;
            }
        }
        return camelCaseString;
    }

    public static int[] allIndexOf (String string, char chr) {
        // #feedback: camelCase
        int arraySize = 0;
        for (int i = 0; i < string.length(); i++)
        {
            if (string.charAt(i) == chr) {
                arraySize++;
            }
        }
        int indexes[] = new int[arraySize];
        int j = 0;
        for (int i = 0; i < string.length(); i++)
        {
            if (string.charAt(i) == chr) {
                indexes[j] = i;
                j++;
            }
        }
        return indexes;
    }

    public static boolean isCapital (char chr) {
        // #feedback: always scope the code in condition with {} - even when there's only one line of code
        if (chr < 90 && chr > 64) {
            return true;
        }
        
        return false;
    }

    public static char toUpperCase (char chr) {
        // #feedback: always scope the code in condition with {} - even when there's only one line of code
        if (isCapital(chr)) {
            return chr;
        }

        // #feedback: else not required then there is return inside the if
        return (char)(chr - 32);
    }

    public static char toLowerCase (char chr) {
        // #feedback: always scope the code in condition with {} - even when there's only one line of code
        if (!isCapital(chr)) {
            return chr;
        }

        // #feedback: else not required then there is return inside the if
        return (char)(chr + 32);
    }
}
