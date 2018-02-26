import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println(encrypt("This is a test!",1));
        System.out.println(decrypt("hsi  etTi sats!",1));


    }


    public static String encrypt(final String text, final int n) {
        ArrayList<Character> holder = new ArrayList<>();
        String left = "", right = "", result;
        int count = 0;



        if (n <= 0) return text;
        if (text == null || text == "") return text; //Validate data

            //Put characters into an ArrayList
            for (int i = 0; i < text.length(); i++) {
                holder.add(text.charAt(i));
            }
            //Split the characters, if they're even they're a 2nd character, else they're a 1st
            for (char c : holder) {
                if (count % 2 == 0) {
                    right += c;
                    count++;
                } else {
                    left += c;
                    count++;
                }
            }
            //Form result
            result = left + right;
            //Recursion to do n number of times
            if(n == 0){
                return result;
            }else{
                return encrypt(result,n-1);
            }

    }

        public static String decrypt ( final String encryptedText, final int n){
        int count = 0,max = 0;
        int leftCnt = 0, rightCnt = 0;

        if (n <= 0) return encryptedText;
        if (encryptedText == null || encryptedText == "") return encryptedText; //Validate data

        String right, left, result;
        StringBuilder sb = new StringBuilder(encryptedText.length());

        right = encryptedText.substring(encryptedText.length()/2,encryptedText.length());
        left = encryptedText.substring(0,encryptedText.length()/2);
        max = Math.max(left.length(),right.length());

        while(count < max)
        {
            if(rightCnt < right.length())
            sb.append(right.charAt(rightCnt));
            if (leftCnt < left.length())
            sb.append(left.charAt(leftCnt));

            count++;
            leftCnt++;
            rightCnt++;
        }
        result = sb.toString();

            if(n == 0){
                return result;
            }else{
                return decrypt(result,n-1);
            }


        }


    }