public class AlfredTest {
    /*
    * This main method will always be the launch point for a Java application
    * For now, we are using the main to test all our 
    * AlfredQuotes methods.
    */
    public static void main(String[] args) {
        // Make an instance of AlfredQuotes to access all its methods.
        AlfredQuotes alfredBot = new AlfredQuotes();
        
        // Make some test greetings, providing any necessary data
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        
        String alexisTest = alfredBot.respondBeforeAlexis(
                            "Alexis! Play some low-fi beats."
                            );
        String alfredTest = alfredBot.respondBeforeAlexis(
            "I can't find my yo-yo. Maybe Alfred will know where it is.");
        String notRelevantTest = alfredBot.respondBeforeAlexis(
            "Maybe that's what Batman is about. Not winning. But failing.."
        );
        
        // Ninja greetings
        String ninjagreeting1 = alfredBot.guestGreeting("Bobby Hill", "morning");
        String ninjagreeting2 = alfredBot.guestGreeting("Brave Sir Robin", "afternoon");
        String ninjagreeting3 = alfredBot.guestGreeting("Jenny Craig", "evening");

        // Sensei greetings
        String senseiGreeting1 = alfredBot.guestGreeting();
        String senseiGreeting2 = alfredBot.guestGreeting();
        String senseiGreeting3 = alfredBot.guestGreeting();

        // Print the greetings to test.
        System.out.println(testGreeting);
        
        // Uncomment these one at a time as you implement each method.
        System.out.println(testGuestGreeting);
        System.out.println(testDateAnnouncement);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(notRelevantTest);
        System.out.println(ninjagreeting1);
        System.out.println(ninjagreeting2);
        System.out.println(ninjagreeting3);
        System.out.println(senseiGreeting1);
        System.out.println(senseiGreeting2);
        System.out.println(senseiGreeting3);
    }
}
