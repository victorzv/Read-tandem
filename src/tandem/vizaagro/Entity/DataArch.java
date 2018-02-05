package tandem.vizaagro.Entity;

public class DataArch implements IEntityData {
    int numRec;
    int year;
    int mounth;
    int day;
    int hour;
    float timeWork;
    float press;
    float temperatura;
    float vWork;
    float vStand;
    float kKorrection;
    float vWorkSm;
    float vStandSm;
    float dVStandSm;
    float vWorkError;
    float timeError;

    public int getNumRec() {
        return numRec;
    }
    public void setNumRec(int numRec) {
        this.numRec = numRec;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMounth() {
        return mounth;
    }
    public void setMounth(int mounth) {
        this.mounth = mounth;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public float getTimeWork() {
        return timeWork;
    }
    public void setTimeWork(float timeWork) {
        this.timeWork = timeWork;
    }
    public float getPress() {
        return press;
    }
    public void setPress(float press) {
        this.press = press;
    }
    public float getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }
    public float getvWork() {
        return vWork;
    }
    public void setvWork(float vWork) {
        this.vWork = vWork;
    }
    public float getvStand() {
        return vStand;
    }
    public void setvStand(float vStand) {
        this.vStand = vStand;
    }
    public float getkKorrection() {
        return kKorrection;
    }
    public void setkKorrection(float kKorrection) {
        this.kKorrection = kKorrection;
    }
    public float getvWorkSm() {
        return vWorkSm;
    }
    public void setvWorkSm(float vWorkSm) {
        this.vWorkSm = vWorkSm;
    }
    public float getvStandSm() {
        return vStandSm;
    }
    public void setvStandSm(float vStandSm) {
        this.vStandSm = vStandSm;
    }
    public float getdVStandSm() {
        return dVStandSm;
    }
    public void setdVStandSm(float dVStandSm) {
        this.dVStandSm = dVStandSm;
    }
    public float getvWorkError() {
        return vWorkError;
    }
    public void setvWorkError(float vWorkError) {
        this.vWorkError = vWorkError;
    }
    public float getTimeError() {
        return timeError;
    }
    public void setTimeError(float timeError) {
        this.timeError = timeError;
    }

    @Override
    public void printEntity() {
        System.out.println("DataArch");
    }
}
