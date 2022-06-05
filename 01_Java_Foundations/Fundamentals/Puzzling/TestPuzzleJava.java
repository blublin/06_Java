import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println("\n|------- Gen Ten Rolls -------|");
		System.out.println(randomRolls);
		

        System.out.println("\n|------- Gen 5 Random Letter -------|");
        for (int i = 0; i < 5; i++) {
            char c = generator.genRandomLetter();
            System.out.printf("Letter #%s :: %s\n", i+1, c);
        }

        System.out.println("\n|------- Gen 5 Passwords -------|");
        for (int i = 0; i < 5; i++) {
            String pw = generator.generatePassword();
            System.out.printf("Password #%s :: %s\n", i+1, pw);
        }

        System.out.println("\n|------- Gen Password Set -------|");
        ArrayList<String> pwSet = generator.getNewPasswordSet(5);
        System.out.printf("ArrayList :: %s\n", pwSet.toString());
        for (int i = 0; i < pwSet.size(); i++) {
            String pw = pwSet.get(i);
            System.out.printf("Password #%s :: %s\n", i+1, pw);
        }

        // Sensei Bonus
        System.out.println("\n|------- Shuffle Password Set -------|");
        System.out.printf("ArrayList BEFORE :: %s\n", pwSet.toString());
        int shuffleCount = 30;
        System.out.println("Shuffle Count :: " + shuffleCount);
        generator.shuffleArray(pwSet, shuffleCount);
        System.out.printf("ArrayList AFTER :: %s\n", pwSet.toString());

	}
}
