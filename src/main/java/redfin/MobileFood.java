package redfin;

import com.opencsv.bean.CsvBindByName;


// Mobile Food Domain Object
public class MobileFood{
    @CsvBindByName(column = "DayOrder")
    private int DayOrder;
    @CsvBindByName(column = "DayOfWeekStr")
    private String DayOfWeekStr;
    @CsvBindByName(column = "start24")
    private String start24;
    @CsvBindByName(column = "end24")
    private String end24;
    @CsvBindByName(column = "PermitLocation")
    private String PermitLocation;
    @CsvBindByName(column = "Applicant")
    private String Applicant;

    public void setDayOrder(int d){
        DayOrder = d;
    }
    public int getDayOrder(){
        return DayOrder;
    }
    public void setDayOfWeekStr(String dayOfWeekStr){
        DayOfWeekStr = dayOfWeekStr;
    }
    public String getDayOfWeekStr(){
       return DayOfWeekStr;
    }
    public String getStart24() {
        return start24;
    }
    public void setStart24(String start24) {
        this.start24 = start24;
    }
    public String getEnd24() {
        return end24;
    }
    public void setEnd24(String end24) {
        this.end24 = end24;
    }
    public String getPermitLocation() {
        return PermitLocation;
    }
    public void setPermitLocation(String permitLocation) {
        PermitLocation = permitLocation;
    }
    public String getApplicant() {
        return Applicant;
    }
    public void setApplicant(String applicant) {
        Applicant = applicant;
    }
    public int getHourFromString(String h){
        try {
            if (h == "" | h == null) return 0;
            if (h.contains(":")) {
                String[] s = h.split(":");
                String sh = s[0];
                int result = Integer.parseInt(sh);
                return result;
            }
            return -1;
        }
        catch (Exception e){
            return 0;
        }

    }
    public String toString() {
        //return String.format("%2d | %75s |  %25s  | %5s | %5s ", DayOrder, Applicant, PermitLocation, getStart24(), getEnd24());
        return String.format("%75s |  %25s  |",   Applicant, PermitLocation);
    }
    public String printHeader(){
        return String.format("%75s |  %25s  | %n",   "Name", "Location");
    }
}
