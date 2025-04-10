import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AdventureGame {

    static Clip currentMusicClip; // To store the currently playing music

    static void playMusic(String musicFilePath, boolean loop) {
        try {
            File musicFile = new File(musicFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the music
            } else {
                clip.start(); // Play once
            }
            stopCurrentMusic(); // Stop any music that was playing before
            currentMusicClip = clip; // Store the current clip
        } catch (UnsupportedAudioFileException e) {
            System.err.println("Unsupported audio file: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error playing music file: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Audio line unavailable: " + e.getMessage());
        }
    }

    static void stopCurrentMusic() {
        if (currentMusicClip != null && currentMusicClip.isRunning()) {
            currentMusicClip.stop();
            currentMusicClip.close();
        }
    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        // Loop for replaying the game
        boolean playAgain = true;
        while (playAgain) {
            boolean hasKey = false;
            System.out.println("You're a student. AT WECIB. You wish your life was less... boring.");
            playMusic("src\\DokiDoki.wav", true); // Looping background music for school
            System.out.println("As you pass room 255...");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            System.out.println("\n");
            System.out.println("...you see a note.");
            System.out.println("What do you do?");
            System.out.println("(A) Open the note");
            System.out.println("(B) Keep walking");

            String firstChoice = inputReader.nextLine().toUpperCase();
            stopCurrentMusic(); // Stop the decision music after the choice

            if (firstChoice.equals("A")) {
                System.out.println("\nThe note says: 'Are you ready to play, some sort of calamari game? Find a squid then a door.'");
                System.out.println("What do you do now?");
                playMusic("src\\funnySquidGameMusic.wav", true); // Music for the second decision
                System.out.println("(C) What... brina fried from class... uhhh Self combust");
                System.out.println("(D) Some game? Like... a squid, game?");

                String secondChoice = inputReader.nextLine().toUpperCase();

                if (secondChoice.equals("C")) {
                    stopCurrentMusic();
                    playMusic("src\\The Skull Gang (Alpha Mix) - Kirby Mass Attack.wav", false); // One-time lose music
                    System.out.println("\nYou just explode, the explosion causing America to think they got hit by a nuclear blast. Kesha proceeded to hack the news and play her songs. ");
                    System.out.println("**LOSE ENDING: Ignored the call to adventure, thus sending the earth into WW3 and Kesha showing up to play her songs.**");
                } else if (secondChoice.equals("D")) {
                    System.out.println("\nYou remember the squid at the library near RTP 1 and a windy alley nearby.");
                    //2 second wait
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("What do you do next?");
                    System.out.println("(E) Go to the library");
                    System.out.println("(F) Check the windy alley first");

                    String thirdChoice = inputReader.nextLine().toUpperCase();
                    stopCurrentMusic();

                    if (thirdChoice.equals("E")) {
                        System.out.println("\nYou walk to the library. You find the squid but no obvious door. You search around.");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                        System.out.println("You notice a loose stone. Do you:");
                        playMusic("src\\Okay, Everyone! (Natsuki) (Act 2) - Doki Doki Literature Club!.wav", true); // Music for the fourth decision (library)
                        System.out.println("(G) Push the stone, maybe its a squid game reference?");
                        System.out.println("(H) Call for help. Like Undertale?!?!?!?");

                        String fourthChoiceLibrary = inputReader.nextLine().toUpperCase();
                        stopCurrentMusic();

                        if (fourthChoiceLibrary.equals("G")) {
                            System.out.println("\nThe stone clicks! WOAW! A hidden door opens.");
                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                Thread.currentThread().interrupt();
                            }
                            System.out.println("Inside, you find a dusty old key on a pedestal.");
                            System.out.println("You take the key.");
                            hasKey = true;
                            System.out.println("You step back outside.");
                            System.out.println("What now?");
                            playMusic("src\\funnySquidGameMusic.wav", true); // Music for the fifth decision (after key)
                            System.out.println("(I) Go home with your discovery");
                            System.out.println("(J) Try to find where the key goes");

                            String fifthChoiceLibrary = inputReader.nextLine().toUpperCase();
                            stopCurrentMusic();

                            if (fifthChoiceLibrary.equals("I")) {
                                System.out.println("\nYou call for help... Wait.... Waiting....");
                                try {
                                    Thread.sleep(6000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    Thread.currentThread().interrupt();
                                }
                                System.out.println("\nBut nobody came.");
                                playMusic("src\\Game Over Yeah!.wav", false); // One-time neutral music
                                System.out.println("**NEUTRAL ENDING: Is... is that an undertale reference?!?!?!?.**");
                            } else if (fifthChoiceLibrary.equals("J")) {
                                System.out.println("\nYou wander around the library, looking for a lock that fits the key.");

                                System.out.println("Behind a bookshelf in a quiet corner, you find a small, ornate door.");
                                if (hasKey) {
                                    playMusic("src\\Hooray! Sound Effect.wav", false); // One-time win music
                                    System.out.println("\nYou insert the key. It fits perfectly! The door creaks open, revealing a hidden chamber filled with a bajillion dollar");
                                    System.out.println("**WIN ENDING: Solved the mystery and found a treasure! MONEY YIPEEEEEE**");
                                } else {
                                    playMusic("src\\Game Over Yeah!.wav", false); // One-time lose music
                                    System.out.println("\nYou try to open the ornate door, but it's locked.");
                                    System.out.println("**LOSE ENDING: Found a secret door but lacked the squid game key. How you gonna open a door you cant cause ...locked???**");
                                }
                            } else {
                                System.out.println("Invalid choice. The End.");
                            }

                        } else if (fourthChoiceLibrary.equals("H")) {
                            playMusic("src\\Game Over Yeah!.wav", false); // One-time lose music
                            System.out.println("\nYou give up and head home, wondering what lay behind the stone.");
                            System.out.println("**LOSE ENDING: Gave up too easily. What a quitter.**");
                        } else {
                            System.out.println("Invalid choice. The End.");
                        }

                    } else if (thirdChoice.equals("F")) {
                        System.out.println("\nYou check the windy alley. Amidst the swirling leaves, you find a small, shiny key hidden beneath a loose brick.");
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                        System.out.println("You pocket the key.");
                        hasKey = true;
                        System.out.println("You decide to head to the library now, remembering the squid, pet they have.");
                        System.out.println("You find the squid but no obvious door. You search around.");
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                        System.out.println("You notice a loose stone. Do you:");
                        playMusic("src\\Bendy-Boing Wonder (Alternate Mix) - Super Mario Bros. Wonder.wav", true); // Music for the fourth decision (alley path)
                        System.out.println("(K) Push the stone");
                        System.out.println("(L) Go home, thinking you've found all there is to find like a LOSER.");

                        String fourthChoiceAlley = inputReader.nextLine().toUpperCase();
                        stopCurrentMusic();

                        if (fourthChoiceAlley.equals("K")) {
                            System.out.println("\nThe stone clicks! A hidden door opens.");
                            System.out.println("Inside, you see a small, ornate door.");
                            if (hasKey) {
                                playMusic("src\\Hooray! Sound Effect.wav", false); // One-time win music
                                System.out.println("\nYou insert the key. It fits perfectly! The door creaks open, revealing a hidden chamber filled with ancient scrolls.");
                                System.out.println("**WIN ENDING: Found the key in an unexpected place and solved the mystery! Youve squidded the game!!!**");
                            } else {
                                playMusic("src\\Game Over Yeah!.wav", false); // One-time lose music
                                System.out.println("\nYou try to open the ornate door, but it's locked.");
                                System.out.println("**LOSE ENDING: Found a secret door but lacked the key. Bro tryna open a door with no key LMAOOOO (insert skull emoji here)**");
                            }
                        } else if (fourthChoiceAlley.equals("L")) {
                            playMusic("src\\The Skull Gang (Alpha Mix) - Kirby Mass Attack.wav", false); // One-time secret ending music
                            System.out.println("\nYou go home, satisfied with finding the key but unaware of the hidden door, thus finding Kesha and she blasts her music at you, the decibles of music destoying your ears.");
                            System.out.println("**SECRET ENDING: Found a piece of the puzzle but missed the bigger picture, so Kesha punished your ignorance.**");
                        } else {
                            System.out.println("Invalid choice. Next time, choose what I give you. The End.");
                        }

                    } else {
                        System.out.println("Invalid choice. Next time, choose what I give you. The End.");
                    }

                } else {
                    System.out.println("Invalid choice.Except this is a super super secret ending and uhhhh, you get blown up into a bagillionmillion pixels uh oh good job lol");
                }
            } else if (firstChoice.equals("B")) {
                playMusic("src\\The Monkeys' Maze (OST Mix) - EarthBound.wav", false); // One-time lose music
                System.out.println("\nYou keep walking home, oblivious to the mystery unfolding nearby.Then, you meet the principal at a Wendys, and get suspended for skipping class..");
                System.out.println("**LOSE ENDING: Missed the opportunity entirely, and proceeded to have the worst luck possible.**");
            } else {
                System.out.println("Invalid choice. The End. Next time, youll choose the options I give you. ");
            }

            // Ask if the player wants to play again
            System.out.println("\nDo you want to play again? (Y/N)");
            String replayChoice = inputReader.nextLine().toUpperCase();
            if (replayChoice.equals("N")) {
                playAgain = false;
            } else if (!replayChoice.equals("Y")) {
                System.out.println("Invalid input. Exiting game.");
                playAgain = false;
            }

            stopCurrentMusic(); // Ensure music stops when the game ends
        }
    }
}
