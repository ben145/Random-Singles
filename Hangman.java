import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public String generateWord() {

        String[] words = {"bulbasaur","ivysaur","venusaur","charmander","charmeleon","charizard","squirtle","wartortle",
        "blastoise","caterpie","metapod","butterfree","weedle","kakuna","beedrill","pidgey","pidgeotto","pidgeot","rattata",
        "raticate","spearow","fearow","ekans","arbok","pikachu","raichu","sandshrew","sandslash","nidoran","nidorina",
        "nidoqueen","nidorino","nidoking","clefairy","clefable","vulpix","ninetales","jigglypuff","wigglytuff","zubat",
        "golbat","oddish","gloom","vileplume","paras","parasect","venonat","venomoth","diglett","dugtrio","meowth","persian",
        "psyduck","golduck","mankey","primeape","growlithe","arcanine","poliwag","poliwhirl","poliwrath","abra","kadabra",
        "alakazam","machop","machoke","machamp","bellsprout","weepinbell","victreebel","tentacool","tentacruel","geodude",
        "graveler","golem","ponyta","rapidash","slowpoke","slowbro","magnemite","magenton","farfetchd","doduo","dodrio",
        "seel","dewgong","grimer","muk","shellder","cloyster","gastly","haunter","gengar","onix","drowzee","hypno","krabby",
        "kingler","voltorb","electrode","exeggcute","exeggutor","cubone","marowak","hitmonlee","hitmonchan","lickitung",
        "koffing","weezing","rhyhorn","rhydon","chansey","tangela","kangaskhan","horsea","seadra","goldeen","seaking",
        "staryu","starmie","mr mime","scyther","jynx","electabuzz","magmar","pinsir","tauros","magikarp","gyarados","lapras",
        "ditto","eevee","vaporeon","jolteon","flareon","porygon","omanyte","omastar","kabuto","kabutops","aerodactyle",
        "snorlax","articuno","zapdos","moltres","dratini","dragonair","dragonite","mewtwo","mew"};
        Random rand = new Random();
        int i = rand.nextInt(words.length);
        return words[i];
    }

    public String mask(String word) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i,i+1).equals(" "))
                s.append(" ");
            else
                s.append("*");
        }
        return s.toString();
    }

    public String toNow(String word, StringBuilder inProgress, List<String> guesses) {
        for (int i = 0; i < word.length(); i++) {
            String in = word.substring(i, i + 1);
            if (guesses.contains(in))
                inProgress.append(in);
            else
                inProgress.append("*");
        }
        return inProgress.toString();
    }

    public boolean game() {
        int lives = 5;
        int hint = 0;
        Scanner scan = new Scanner(System.in);
        ArrayList<String> guesses = new ArrayList();
        guesses.add(" ");
        String word = generateWord();
        String guess;
        System.out.println(mask(word));
        while (lives > 0) {
            StringBuilder inProgress = new StringBuilder();
            System.out.print("Guess a letter: ");
            guess = scan.next().substring(0, 1);
            if (guess.equals("!")) {
                if (hint < 1) {
                    lives--;
                    System.out.println("Hint now exchanged for 1 life (" + lives + " lives remaining)");
                    boolean keepLooking = true;
                    Random r = new Random();
                    while (keepLooking) {
                        int idx = r.nextInt(word.length());
                        if (!guesses.contains(word.substring(idx, idx + 1))) {
                            System.out.println("try " + word.substring(idx, idx + 1) + "\n");
                            keepLooking = false;
                        }
                    }
                    hint++;
                }
                else
                    System.out.println("You already used your hint\n");
            }
            else {
                if (!guesses.contains(guess)) {
                    guesses.add(guess);
                    if (!word.toLowerCase().contains(guess)) {
                        lives--;
                        System.out.print("That letter is not present -- " + lives + " lives remaining.");
                        if (lives == 2)
                            System.out.println(" (Use your hint now if you haven't yet!)");
                        System.out.println("\n");
                    } else
                        System.out.println("Letter present!\n");
                } else {
                    System.out.println("You've already guessed '" + guess + "' so try again.\n");
                }
            }
            String toCheck = toNow(word, inProgress, guesses);
            if (toCheck.equals(word)) {
                System.out.println("You win!");
                System.out.println("The word was '"+word+"'");
                return true;
            }
            System.out.print(toCheck + "\t## GUESSES: { ");
            for (int i = 0; i < guesses.size(); i++) {
                if (!guesses.get(i).equals(" "))
                    System.out.print(guesses.get(i)+" ");
            }
            System.out.println("} ##\n");
        }
        System.out.println("Ran out of lives. You LOSE");
        System.out.println("The word was '"+word+"'");
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Use '!' for a hint at the cost of 1 life one time only\n");
        Hangman h = new Hangman();
        h.game();
    }
}