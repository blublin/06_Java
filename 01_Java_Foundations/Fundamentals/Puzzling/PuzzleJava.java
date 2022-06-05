import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {
        Random randInt = new Random();
        ArrayList<Integer> retArr = new ArrayList<Integer>();
        
        for (int i = 0; i < 10; i++) {
            // nextInt is 0 - bound exclusive, add 1 to be 1 to bound inclusive
            retArr.add(randInt.nextInt(20) +1);
        }
        return retArr;
    }

    public char genRandomLetter() {
        Random randIndex = new Random();
        // https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        return alphabet[randIndex.nextInt(26)];
    }

    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += genRandomLetter();
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int len) {
        ArrayList<String> passwordSet = new ArrayList<String>();

        for (int i = 0; i < len; i++) {
            passwordSet.add(generatePassword());
        }
        return passwordSet;
    }

    // Sensei Bonus
    public void shuffleArray(ArrayList<String> inputArray, int shuffles) {
        Random idx = new Random();
        int arrSize = inputArray.size();
        for (int i = 0; i < shuffles; i++) {
            // Generate indexes based on max array size
            int idx1 = idx.nextInt(arrSize);
            int idx2 = idx.nextInt(arrSize);

            String idxVal1 = inputArray.get(idx1);
            inputArray.set(idx1, inputArray.get(idx2));
            inputArray.set(idx2, idxVal1);
        }
    }
    
}
