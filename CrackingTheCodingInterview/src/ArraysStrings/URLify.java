package ArraysStrings;

public class URLify {
    public static void main(String[] args) {
        //If there is space in the string, replace it with a '%02', the input string already has some empty spaces in the end, to accomodate the change/
        String str = "I am the danger. Walter        ";
        replaceSpaces(str.toCharArray(),23);
    }
    public static void replaceSpaces(char[] arr,int trueLength){
        int spaceCount = 0;
        int i = 0 ;
        int index = 0;
        // In first run we are counting the number of spaces in the string
        for(i = 0 ; i< trueLength ;i++){
            if(arr[i] == ' '){
                spaceCount++;
            }
        }

        index = trueLength + spaceCount*2;
        for(i = trueLength-1 ; i>= 0 ; i--){
            if(arr[i] == ' '){
                arr[index - 1] = '0';
                arr[index - 2] = '2';
                arr[index - 3] = '%';
                index = index-3;
            }else{
                arr[index-1] = arr[i];
                index--;
            }
        }
        System.out.println(arr);

    }
}
