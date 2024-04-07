package ArraysStrings;

public class IsUnique {

    public static boolean isUniqueCharString(String str){

        if(str.length()>128){
            //if the length is greater than 128, and since ASCII can only have 128 unique values, there definitely is duplicates.
            return false;
        }

        boolean[] charArr = new boolean[128];

        for(int i = 0 ; i < str.length() ; i++){
            int value = str.charAt(i);
            if(charArr[value]){
                return false;
            }
            charArr[value] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        //Determine whether a string has all unique characters & cannot use additional data structures.
        String str = "abbced";
        System.out.println(" String is " + isUniqueCharString(str));
    }
}
