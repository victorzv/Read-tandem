package tandem.vizaagro.Entity;

import java.util.Date;

public class CountOfData implements IEntityData {
    int currentCountInEventsArchive;
    int indexLastInEventsArchive;
    int currentCountInHourArchive;
    int indexLastInHourArchive;
    int currentCountInDaysArchive;
    int indexLastInDaysArchive;
    Date firstInHourArchive;
    Date lastInHourArchive;
    Date firstInDaysArchive;
    Date lastInDaysArchive;
    int currentCountInAvarArchive;
    int indexLastInAvarArchive;

    public int getCurrentCountInEventsArchive() {
        return currentCountInEventsArchive;
    }
    public void setCurrentCountInEventsArchive(int currentCountInEventsArchive) {
        this.currentCountInEventsArchive = currentCountInEventsArchive;
    }
    public int getIndexLastInEventsArchive() {
        return indexLastInEventsArchive;
    }
    public void setIndexLastInEventsArchive(int indexLastInEventsArchive) {
        this.indexLastInEventsArchive = indexLastInEventsArchive;
    }
    public int getCurrentCountInHourArchive() {
        return currentCountInHourArchive;
    }
    public void setCurrentCountInHourArchive(int currentCountInHourArchive) {
        this.currentCountInHourArchive = currentCountInHourArchive;
    }
    public int getIndexLastInHourArchive() {
        return indexLastInHourArchive;
    }
    public void setIndexLastInHourArchive(int indexLastInHourArchive) {
        this.indexLastInHourArchive = indexLastInHourArchive;
    }
    public int getCurrentCountInDaysArchive() {
        return currentCountInDaysArchive;
    }
    public void setCurrentCountInDaysArchive(int currentCountInDaysArchive) {
        this.currentCountInDaysArchive = currentCountInDaysArchive;
    }
    public int getIndexLastInDaysArchive() {
        return indexLastInDaysArchive;
    }
    public void setIndexLastInDaysArchive(int indexLastInDaysArchive) {
        this.indexLastInDaysArchive = indexLastInDaysArchive;
    }
    public Date getFirstInHourArchive() {
        return firstInHourArchive;
    }
    public void setFirstInHourArchive(Date firstInHourArchive) {
        this.firstInHourArchive = firstInHourArchive;
    }
    public Date getLastInHourArchive() {
        return lastInHourArchive;
    }
    public void setLastInHourArchive(Date lastInHourArchive) {
        this.lastInHourArchive = lastInHourArchive;
    }
    public Date getFirstInDaysArchive() {
        return firstInDaysArchive;
    }
    public void setFirstInDaysArchive(Date firstInDaysArchive) {
        this.firstInDaysArchive = firstInDaysArchive;
    }
    public Date getLastInDaysArchive() {
        return lastInDaysArchive;
    }
    public void setLastInDaysArchive(Date lastInDaysArchive) {
        this.lastInDaysArchive = lastInDaysArchive;
    }
    public int getCurrentCountInAvarArchive() {
        return currentCountInAvarArchive;
    }
    public void setCurrentCountInAvarArchive(int currentCountInAvarArchive) {
        this.currentCountInAvarArchive = currentCountInAvarArchive;
    }
    public int getIndexLastInAvarArchive() {
        return indexLastInAvarArchive;
    }
    public void setIndexLastInAvarArchive(int indexLastInAvarArchive) {
        this.indexLastInAvarArchive = indexLastInAvarArchive;
    }

    @Override
    public void printEntity() {
        System.out.println("CountOfData");
    }
}
