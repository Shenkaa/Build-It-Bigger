package eu.ramich.builditbigger.libjava;

import java.util.Arrays;
import java.util.List;


public class JokeTeller {

    /**
     * Source: https://www.boredpanda.com/funniest-two-line-jokes/
     * Last seen: 14.01.2018
     */
    private static final List<String> JOKE_LIST = Arrays.asList(
            "I told my wife she was drawing her eyebrows too high. \nShe looked surprised.",
            "And the Lord said unto John, 'Come forth and you will receive eternal life.' \nBut John came fifth, and won a toaster.",
            "I threw a boomerang a few years ago. \nI now live in constant fear.",
            "My wife accused me of being immature. \nI told her to get out of my fort.",
            "You don't need a parachute to go skydiving. \nYou need a parachute to go skydiving twice.",
            "Parallel lines have so much in common. \nIt's a shame they'll never meet.",
            "Someone stole my mood ring, I don't know how I feel about that.",
            "My grandfather has the heart of a lion and a lifetime ban at the zoo.",
            "Women only call me ugly until they find out how much money I make. \nThen they call me ugly and poor.",
            "How many Germans does it take to screw in a light bulb? \nOne, they're efficient and not very funny.",
            "You're not completely useless, you can always serve as a bad example.",
            "I broke my finger last week. On the other hand, I'm okay.",
            "Apparently, someone in London gets stabbed every 52 seconds. \nPoor bastard.",
            "A Roman legionnaire walks into a bar, holds up two fingers and says, 'Five beers, please.'",
            "Someone stole my Microsoft Office and they're gonna pay. \nYou have my Word.",
            "I tried to catch fog yesterday, Mist.",
            "Working in a mirror factory is something I can totally see myself doing.",
            "Just say NO to drugs! \nWell, if I'm talking to my drugs... I probably already said yes.",
            "How does Moses make his coffee? \nHebrews it.",
            "What would The Jetsons be called if they were black? \nThe Jetsons, you fucking racist."
    );


    public static String getJoke() {
        return JOKE_LIST.get((int) (Math.random() * JOKE_LIST.size()));
    }
}
