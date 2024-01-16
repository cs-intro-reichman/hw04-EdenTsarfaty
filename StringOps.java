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
        for (int i = 0; i < string.length(); i++)
        {
            if (isCapital(string.charAt(i))) {
            switch (string.charAt(i)) {
                case 'I':
                    cappedVowelsString += 'I';
                    break;
                case 'E':
                    cappedVowelsString += 'E';
                    break;
                case 'O':
                    cappedVowelsString += 'O';
                    break;
                case 'A':
                    cappedVowelsString += 'A';
                    break;
                case 'U':
                    cappedVowelsString += 'U';
                    break;
                default:
                    cappedVowelsString += toLowerCase(string.charAt(i));
            }
            }
            else {
                switch (string.charAt(i)) {
                    case 'i':
                        cappedVowelsString += 'I';
                        break;
                    case 'e':
                        cappedVowelsString += 'E';
                        break;
                    case 'o':
                        cappedVowelsString += 'O';
                        break;
                    case 'a':
                        cappedVowelsString += 'A';
                        break;
                    case 'u':
                        cappedVowelsString += 'U';
                        break;
                    default:
                        cappedVowelsString += string.charAt(i);
                }
            }
        }
        return cappedVowelsString;
    }

    public static String camelCase (String string) {
        String camelCaseString = "";
        boolean newword = false;
        boolean firstword = true;
        for (int i = 0; i < string.length(); i++)
        {
            if (string.charAt(i) != ' ') {
                if (newword || firstword) {
                    if (firstword) {
                        camelCaseString += toLowerCase(string.charAt(i));
                        firstword = false;
                        newword = false;
                    }
                    else {
                        camelCaseString += toUpperCase(string.charAt(i));
                        newword = false;
                    }
                }
                else {
                    camelCaseString += toLowerCase(string.charAt(i));
                }
            }
            else {
                newword = true;
            }
        }
        return camelCaseString;
    }

    public static int[] allIndexOf (String string, char chr) {
        int arraysize = 0;
        for (int i = 0; i < string.length(); i++)
        {
            if (string.charAt(i) == chr) {
                arraysize++;
            }
        }
        int indexes[] = new int[arraysize];
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
        if (chr < 90 && chr > 64) return true;
        return false;
    }

    public static char toUpperCase (char chr) {
        if (isCapital(chr)) return chr;
        else return (char)(chr - 32);
    }

    public static char toLowerCase (char chr) {
        if (!isCapital(chr)) return chr;
        else return (char)(chr + 32);
    }
}