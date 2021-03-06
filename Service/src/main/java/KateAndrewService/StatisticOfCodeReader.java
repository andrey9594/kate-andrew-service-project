package KateAndrewService;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import matchstatistic.MatchType;
import matchstatistic.sportstatistictypes.Basketball;
import matchstatistic.sportstatistictypes.Football;
import matchstatistic.sportstatistictypes.Handball;
import matchstatistic.sportstatistictypes.Icehockey;
import matchstatistic.sportstatistictypes.StatisticType;
import matchstatistic.sportstatistictypes.Volleyball;


/**
 * 
 * @author Andrey Class for reading information about what exactly statistic means code of event
 */
public class StatisticOfCodeReader
{
    private Scanner scanner;


    /**
     * Main constructor
     * 
     * @param pathToFile Path to .csv file
     * @throws FileNotFoundException
     */
    public StatisticOfCodeReader(String pathToFile) throws FileNotFoundException
    {
        scanner = new Scanner(new File(pathToFile));
    }


    public Map<MatchType, Map<Integer, StatisticType>> getStatisticForCodeMap()
    {
        Map<MatchType, Map<Integer, StatisticType>> statisticForCodeMap = new HashMap<>();

        while (scanner.hasNext())
        {
            String line = scanner.nextLine();

            String[] strings = line.split(",");
            String sportName = strings[0];
            int code = Integer.parseInt(strings[1]);
            String statisticTypeString = strings[2];

            MatchType sportType = null;
            Map<Integer, StatisticType> tempMap = null;
            switch (sportName)
            {
                case "Soccer":
                    sportType = MatchType.FOOTBALL;
                    tempMap = statisticForCodeMap.get(sportType);
                    if (tempMap == null)
                    {
                        tempMap = new HashMap<Integer, StatisticType>();
                    }
                    tempMap.put(code, Football.valueOf(statisticTypeString));
                    statisticForCodeMap.put(sportType, tempMap);
                    break;
                case "Basketball":
                    sportType = MatchType.BASKETBALL;
                    tempMap = statisticForCodeMap.get(sportType);
                    if (tempMap == null)
                    {
                        tempMap = new HashMap<Integer, StatisticType>();
                    }
                    tempMap.put(code, Basketball.valueOf(statisticTypeString));
                    statisticForCodeMap.put(sportType, tempMap);
                    break;
                case "Icehockey":
                    sportType = MatchType.ICE_HOCKEY;
                    tempMap = statisticForCodeMap.get(sportType);
                    if (tempMap == null)
                    {
                        tempMap = new HashMap<Integer, StatisticType>();
                    }
                    tempMap.put(code, Icehockey.valueOf(statisticTypeString));
                    statisticForCodeMap.put(sportType, tempMap);
                    break;
                case "Volleyball":
                    sportType = MatchType.VOLLEYBALL;
                    tempMap = statisticForCodeMap.get(sportType);
                    if (tempMap == null)
                    {
                        tempMap = new HashMap<Integer, StatisticType>();
                    }
                    tempMap.put(code, Volleyball.valueOf(statisticTypeString));
                    statisticForCodeMap.put(sportType, tempMap);
                    break;
                case "Handball":
                    sportType = MatchType.HANDBALL;
                    tempMap = statisticForCodeMap.get(sportType);
                    if (tempMap == null)
                    {
                        tempMap = new HashMap<Integer, StatisticType>();
                    }
                    tempMap.put(code, Handball.valueOf(statisticTypeString));
                    statisticForCodeMap.put(sportType, tempMap);
                    break;
            }

            // System.out.println(sportName + ": code = " + code + " = " + statisticTypeString);
        }

        return statisticForCodeMap;
    }
}
