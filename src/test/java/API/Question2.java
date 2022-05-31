package API;

public class Question2 {
    public static void checkIsNot(String sentence){
        int counterIs=0;
        int counterNot=0;
        boolean result;

        for(int i=0; i<sentence.length()-1;i++){
            String word=sentence.substring(i,i+2);
            if (word.equals("is")){
                counterIs++;
            }
        }

        for(int i=0; i<sentence.length()-2;i++){
            String word=sentence.substring(i,i+3);
            if(word.equals("not")){
                counterNot++;
            }
        }

        if(counterIs==counterNot){
            result=true;
        }else {
            result=false;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

        checkIsNot("noisxxnotyynotxisi");

    }
}
