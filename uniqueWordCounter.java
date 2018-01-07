import java.util.Scanner;

public class uniqueWordCounter {
    public static void main (String[] args) {
        System.out.println("Enter a sentence to find the number of unique words in it.");
        Scanner input = new Scanner(System.in);
        
        String sentence = input.nextLine();
        System.out.println(wordCounter(sentence));
    }

    public static int wordCounter(String sentence) {
        int uniqueWord = 0;
        String[] sentenceArray = sentence.split(" ");
        for(int i=0; i<sentenceArray.length; i++) {
            for(int k=0; k<sentenceArray.length; k++) {
                if(i!=k && sentenceArray[i].equals(sentenceArray[k])) {
                    break;
                }
                
                else if(k==sentenceArray.length-1){
                    uniqueWord++;
                }
            }
        }
        return uniqueWord;
    }

}