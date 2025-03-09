package HashTable;

public class palindromePermutation {

    public static void main(String[] args) {

        System.out.println(isPermutationPalindrome("tactoac"));
        //Solution: Use a hash-table to count how many times each character appears. then we iterate through the hash table
        // and ensure that no more than one character has an odd count.
    }

    static boolean isPermutationPalindrome(String phrase) {
        int[] table = buildCharacterFrequencyTable(phrase);
        return checkMaxOneOddValue(table);
    }

    //Check the whole table for a value which has odd number, only one odd number can be allowed in the table.
    private static boolean checkMaxOneOddValue(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    // count how many times each character appears.
    private static int[] buildCharacterFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        //Unicode conversion -> z=35 and a = 10;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);//Returns the position of character in the array, based on unicode conversion.
            if (x != -1) {
                table[x]++; //Increase the count of the position in the array.
            }
        }
        return table;
    }

    //Map each character to a number a->0, b->2 like that. and non character should be -1.

    private static int getCharNumber(Character c) {
        int a =  'a';
        int z =  'z';
        int val = c;
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }


    //Same O(n) time complexity
    //Another way would be that instead of checking the number of odd counts at the end , we can check as we go along.
    boolean isPermutationOfPalindrome(String phrase){
        int countOdd = 0 ;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for(char c : phrase.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
                if(table[x] % 2 == 1){
                    countOdd++;
                }else{
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }
}
