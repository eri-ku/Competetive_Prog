import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int n = sc.nextInt(); n > 0; n--) {
            LinkedHashMap<String, LinkedHashMap<String, String>> teams = new LinkedHashMap<String, LinkedHashMap<String, String>>();
            String[] poradie = new String[4];
            for (int i = 0; i < 4; i++) {
                String shortcut = sc.next();
                String name = sc.nextLine().strip();
                teams.put(name, new LinkedHashMap<String, String>());
                teams.get(name).put(shortcut, " X ");
                poradie[i]=shortcut;
            }
            sc.nextLine();
            for (int i = 0; i < 12; i++) {
                sc.useDelimiter("[0-9]");
                String[] teamsNames = sc.next().strip().split(" - ");
                sc.useDelimiter( "\\p{javaWhitespace}+");
                String goals = sc.next();
                for (var shortcut : teams.get(teamsNames[1]).keySet()) {
                    teams.get(teamsNames[0]).put(shortcut, goals);
                    break;
                }

            }
            String s = "+---+---+---+---+---+";
            System.out.println(s);
            System.out.print("|   |");
            for (var shortcut : poradie) {
                System.out.print(shortcut + "|");
            }

            System.out.println();
            System.out.println(s);
            for (var team : teams.values()) {
                System.out.print("|" + team.keySet().iterator().next() + "|");
                for (var element : poradie) {
                    System.out.print(team.get(element) + "|");
                }
                System.out.println();
                System.out.println(s);
            }
        }
        System.out.println();

    }

}