package redfin;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

//MobileFoodProcessor class for the data file
class MobileFoodProcessor {

    private static MobileFoodProcessor single_instance = null;
    private   List<MobileFood> data;
    private   Calendar c = Calendar.getInstance();

    private MobileFoodProcessor()
    {
        data = null;
    }

    public static MobileFoodProcessor getInstance()
    {
        if (single_instance == null)
            single_instance = new MobileFoodProcessor();
        return single_instance;
    }

    public MobileFoodProcessor Load(List<MobileFood> d) {
        getDayOfWeek();
        getTimeOfDay();
        data = d;
        return this;
    }

    public  ArrayList<MobileFood> RetrievedList() {

        SortedMap<String,MobileFood> r = new TreeMap<>();
        int day = getDayOfWeek();
        int time = getTimeOfDay();
        System.out.println("Today's day : [" + day + "] Current time : ["+time + "]");
        for (MobileFood m: data) {
            if (day == m.getDayOrder() && (m.getHourFromString(m.getStart24()) <= time && m.getHourFromString(m.getEnd24()) > time)){
               // System.out.println(m);
                r.put(m.getApplicant(),m);
            }
        }
        return new ArrayList<MobileFood>(r.values());
    }

    private int getDayOfWeek(){
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return  dayOfWeek;
    }

    private int getTimeOfDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String str = sdf.format(new Date());
        int h = Integer.parseInt(str);
        return h;
    }



}
