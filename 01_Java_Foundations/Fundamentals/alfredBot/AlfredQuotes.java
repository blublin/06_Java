import java.util.Date;
import java.util.Random;

public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // Static array of greetings
        String[] possibleGreetings = {
            String.format("Hello, %s. Lovely to see you.", name),
            String.format("Hello %s. Good to see you.", name),
            String.format("Hello %s. How have you been?", name)
        };

        // Return a random greeting from possibleGreetings
        return possibleGreetings[getRandom(possibleGreetings)];
    }
    
    public String dateAnnouncement() {
        Date currentDate = new Date();
        // Why is this rendered as a string, not Date object??
        String politeDate = String.format(
            "I would like to inform the guests that it is currently %s",
            currentDate
        );
        return politeDate;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        return "for snarky response return string";
    }

    // https://stackoverflow.com/a/8065554/19170401
    // Returns a random integer representing an index of array passed in
    public static int getRandom(String[] array) {
        // getRandom(String[]) :: signature
        // array is the parameter

        // requires Random java.util
        int rnd = new Random().nextInt(array.length);
        return rnd;
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

