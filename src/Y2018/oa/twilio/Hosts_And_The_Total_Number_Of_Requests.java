package Y2018.oa.twilio;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hosts_And_The_Total_Number_Of_Requests {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        filename = scan.nextLine();

        File file = new File(filename);
        Scanner sc = new Scanner(file);
        Map<String, Integer> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int idx = line.indexOf(" ");
            String host = line.substring(0, idx);
            map.put(host, map.getOrDefault(host, 0) + 1);
        }

        String output = "records_" + filename;
        PrintWriter writer = new PrintWriter(new FileWriter(output, true));
        for (String host : map.keySet()) {
            writer.printf("%s %d\n", host, map.get(host));
        }
        writer.flush();
    }

}
