package OOP.L04_InterfacesAndAbstraction.P06_MilitaryElite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Soldier> army = new LinkedHashMap<>();

        String line = "";
        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            String type = tokens[0];
            int id = Integer.valueOf(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (type) {
                case "Private":
                    army.putIfAbsent(id, new PrivateImpl(id, firstName, lastName, Double.valueOf(tokens[4])));
                    break;
                case "LieutenantGeneral":
                    Collection<Private> somePrivates = new ArrayList<>();
                    Stream.of(tokens).skip(5)
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()).forEach(e -> {
                        somePrivates.add(Private.class.cast(army.get(e)));
                    });
                    army.putIfAbsent(id, new LieutenantGeneralImpl(id, firstName, lastName, Double.valueOf(tokens[4]),
                            somePrivates
                    ));
                    break;
                case "Engineer":
                    SpecialisedSoldier engineer = new EngineerImpl(id, firstName, lastName, Double.valueOf(tokens[4]), tokens[5], parseRepairs(tokens));
                    if (engineer.getCorps() != null)
                        army.putIfAbsent(id, engineer);
                    break;
                case "Commando":
                    SpecialisedSoldier soldier = new CommandoImpl(id, firstName, lastName, Double.valueOf(tokens[4]), tokens[5], parseMissions(tokens));
                    if (soldier.getCorps() != null)
                        army.putIfAbsent(id, soldier);
                    break;
                case "Spy":
                    army.putIfAbsent(id, new SpyImpl(id, firstName, lastName, Integer.valueOf(tokens[4])));
                    break;

            }
        }

        for (Soldier soldier : army.values()) {
            System.out.println(soldier.toString().trim());
        }
    }

    private static Collection<Repair> parseRepairs(String... args) {
        Collection<Repair> rp = new ArrayList<>();
        for (int i = 6; i < args.length; i += 2) {
            rp.add(new RepairImpl(args[i], Integer.valueOf(args[i + 1])));

        }
        return rp;
    }

    private static Collection<Mission> parseMissions(String... args) {
        Collection<Mission> rp = new ArrayList<>();
        for (int i = 6; i < args.length; i += 2) {
            Mission m = new MissionImpl(args[i], args[i + 1]);
            if (m.getState() != null)
                rp.add(m);


        }
        return rp;
    }
}
