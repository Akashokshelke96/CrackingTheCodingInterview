package ArraysStrings;

public class identicalStrings {

    public static void main(String[] args) {
        String str1 = "abba";
        String str2 = "bbaa";
        System.out.println("The above given strings are identical?, Ans-> " + isIdentical( str1, str2));
    }

    private static boolean isIdentical(String str1, String str2) {
        if(str1.length() != str2.length()){
            return false;
        }
        return sort(str1).equals(sort(str2));
    }


    private static String sort(String str) {
      char[] arr = str.toCharArray();
      java.util.Arrays.sort(arr);
      return new String(arr);
    }
}
