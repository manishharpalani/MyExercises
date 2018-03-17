package Nyansa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class ReportByDate {
    String fileName;
    Map<String, String> map = new TreeMap<>();

    ReportByDate(String inputFileName) {
        this.fileName = inputFileName;
    }

    public void process()
            throws FileNotFoundException, IOException {
        /*
         *  Don't modify this function
         */
        Scanner scanner = new Scanner(new File(fileName));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.length() > 0) {
                String reportDate = DateParser.getReportDate(line.split("\\|")[0]);
                map.put(reportDate, line.split("\\|")[1]);
            }

        }
        scanner.close();
    }

    public long getNumReportDays() {
        return map.size();
    }
}
