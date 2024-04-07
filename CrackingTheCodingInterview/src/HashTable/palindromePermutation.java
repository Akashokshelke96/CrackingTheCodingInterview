package HashTable;

public class palindromePermutation {

    public static void main(String[] args) {

        System.out.println(isPermutationPalindrome("tactoac"));
    }

    static boolean isPermutationPalindrome(String phrase) {
        int[] table = buildCharacterFrequencyTable(phrase);
        return checkMaxOneOddValue(table);
    }

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


    private static int[] buildCharacterFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    private static int getCharNumber(Character c) {
        int a =  'a';
        int z =  'z';
        int val = (int) c;
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }
}
