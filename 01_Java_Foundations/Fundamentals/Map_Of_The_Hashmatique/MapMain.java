import java.util.HashMap;
import java.util.Set;

public class MapMain {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String,String>();

        trackList.put(
            "Party Party Party",
            "Well, Party, Party, Party\n" +
            "I wanna have a Party\n" +
            "I need to have a Party\n" +
            "You better have a Party"
        );
        trackList.putIfAbsent(
            "Friday",
            "Seven a.m., waking up in the morning\n" +
            "Gotta be fresh, gotta go downstairs\n" +
            "Gotta have my bowl, gotta have cereal\n" +
            "Seein' everything, the time is goin'\n" +
            "Tickin' on and on, everybody's rushin'\n" +
            "Gotta get down to the bus stop\n" +
            "Gotta catch my bus, I see my friends (My friends)"
        );
        trackList.put(
            "Photograph",
            "Look at this photograph\n" +
            "Every time I do, it makes me laugh\n" +
            "How did our eyes get so red?\n" +
            "And what the hell is on Joey's head?\n" +
            "And this is where I grew up"
        );
        trackList.put(
            "All Star",
            "Somebody once told me the world is gonna roll me\n" +
            "I ain't the sharpest tool in the shed\n" +
            "She was looking kind of dumb with her finger and her thumb\n" +
            "In the shape of an 'L' on her forehead\n"
        );
            
        String partyLyrics = trackList.get("Party Party Party");
        System.out.printf("Single Song\nTitle: %s\nLyrics: %40s\n\n", "Party Party Party", partyLyrics);

        Set<String> trackTitles = trackList.keySet();
        for (String track : trackTitles) {
            System.out.println("Song Title: " + track);
            System.out.printf("Some Lyrics:\n%80s\n\n", trackList.get(track));
        }
    }
}
