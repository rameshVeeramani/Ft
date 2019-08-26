package redfin;
import java.io.*;
import java.util.*;
import com.opencsv.bean.*;
//Main Class that would execute
public class MobileFoodController {

    // main method
    public static void main(String[] args) {
        try {
            List<MobileFood> myEntries = new CsvToBeanBuilder(new FileReader("data/data.csv"))
                    .withType(MobileFood.class)
                    .build()
                    .parse();

            ArrayList<MobileFood> sampleList = MobileFoodProcessor.getInstance().Load(myEntries).RetrievedList();

            if (sampleList.size() == 0)
                System.out.println("No restaurants available..");

            int updateBatchSize = 10;
            int start = 0;
            int end = sampleList.size() < updateBatchSize ? sampleList.size() : updateBatchSize;
            int size = sampleList.size();
            List<MobileFood> finalList = null;
            try {
                while (end <= sampleList.size()) {
                    System.out.println(String.format("Showing record [%d] to [%d] of Total :[%d]", start, end, size));
                    finalList = sampleList.subList(Math.max(0, start), Math.min(sampleList.size(), end));
                    System.out.println(new MobileFood().printHeader());
                    for (MobileFood v : finalList) {
                        System.out.println(v);
                    }
                    if (end == sampleList.size()) {
                        break;
                    }
                    System.out.print("Press any character for more and press enter :");
                    String input;
                    Scanner in = new Scanner(System.in);
                    input = in.nextLine();
                    if (input == "" || input != "") {
                        start = Math.max(0, start + updateBatchSize);
                        end = Math.min(sampleList.size(), end + updateBatchSize);
                    }
                }
            } catch (Exception ee) {
                System.out.println(ee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

