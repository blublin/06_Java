import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;  

public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

    // Sensei Version :: no parameters
    public String guestGreeting() {
        // Create date formatter to output current hour in 0-23 format
        SimpleDateFormat sdFormatter = new SimpleDateFormat("H");
        // Simple Date Format returns string
        // Convert to primitive int
        // https://stackoverflow.com/a/5585876/19170401
        int currentHour = Integer.parseInt(sdFormatter.format(new Date()));
        
        // Test validity and type
        // System.out.println("Current Hour: " + currentHour);
        // System.out.println(sdFormatter.format(new Date()));
        // System.out.println(sdFormatter.format(new Date()).getClass().getSimpleName());

        String dayPeriod;
        if (currentHour > 20){
            dayPeriod = "night";
        }
        else if (currentHour > 17) {
            dayPeriod = "evening";
        }
        else if (currentHour > 12) {
            dayPeriod = "afternoon";
        }
        else {
            dayPeriod = "morning";
        }

        String[] possibleGreetings = {
            String.format("Good %s. Lovely to see you.", dayPeriod),
            String.format("Good %s. Good to see you.", dayPeriod),
            String.format("Good %s. How have you been?", dayPeriod)
        };

        return possibleGreetings[getRandom(possibleGreetings)];
    }
    
    // Default version :: name parameter
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

    // Ninja version :: name, dayPeriod parameters
    public String guestGreeting(String name, String dayPeriod) {
        String[] possibleGreetings = {
            String.format("Good %s, %s. Lovely to see you.", dayPeriod, name),
            String.format("Good %s, %s. Good to see you.", dayPeriod, name),
            String.format("Good %s, %s. How have you been?", dayPeriod, name)
        };

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
        // Check for "Alexis, Alfred, neither"
        if (conversation.indexOf("Alexis") > -1) {
            return "I'm not quite sure why we bother with her at all.";
        }
        else if (conversation.indexOf("Alfred") > -1) {
            return "Of course. Right away.";
        }
        else {
            return "Indeed. Then I shall take my leave.";
        }
    }

    // https://stackoverflow.com/a/8065554/19170401
    // Returns a random integer representing an index of array passed in
    // Private as only usable from within this class
    private int getRandom(String[] array) {
        // getRandom(String[]) :: signature
        // array is the parameter

        // requires Random java.util
        int rnd = new Random().nextInt(array.length);
        return rnd;
    }
    
    // Sensei/Ninja bonus method
    public String angryAlfred() {
        String[] youWontLikeMeWhenImMad = {
            "This is utter nonsense!",
            "You, sir, are an imbecile!",
            "I will not be treated this way!"
        };

        return youWontLikeMeWhenImMad[getRandom(youWontLikeMeWhenImMad)].toUpperCase();
    }
}

