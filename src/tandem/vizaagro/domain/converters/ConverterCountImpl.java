package tandem.vizaagro.domain.converters;

import tandem.vizaagro.Entity.CountOfData;
import tandem.vizaagro.Entity.IEntityData;

import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by User on 06.12.2016.
 */
public class ConverterCountImpl implements IConvertable {

    byte[] bufferOfData = null;

    @Override
    public IEntityData convertToObject(byte[] buffer) {
        bufferOfData = buffer;
        for (int i = 0; i < 12; i+=2){
            byte tmp = bufferOfData[i+1];
            bufferOfData[i+1] = bufferOfData[i];
            bufferOfData[i] = tmp;
        }
        for (int i = 36; i < 39; i+=2){
            byte tmp = bufferOfData[i+1];
            bufferOfData[i+1] = bufferOfData[i];
            bufferOfData[i] = tmp;
        }

        ByteBuffer bb = ByteBuffer.wrap(bufferOfData);
        CountOfData countOfData = new CountOfData();
        countOfData.setCurrentCountInEventsArchive(bb.getShort(0));
        countOfData.setIndexLastInEventsArchive(bb.getShort(2));
        countOfData.setCurrentCountInHourArchive(bb.getShort(4));
        countOfData.setIndexLastInHourArchive(bb.getShort(6));
        countOfData.setCurrentCountInDaysArchive(bb.getShort(8));
        countOfData.setIndexLastInDaysArchive(bb.getShort(10));

        DateFormat formatter = new SimpleDateFormat("yy.mm.dd hh:mm");
        try {

            countOfData.setFirstInHourArchive(formatter.parse((int) bb.get(20) + "." + (int) bb.get(21) + "." + (int) bb.get(22) + " " + (int) bb.get(23) + ":00"));
            countOfData.setLastInHourArchive(formatter.parse((int) bb.get(24) + "." + (int) bb.get(25) + "." + (int) bb.get(26) + " " + (int) bb.get(27) + ":00"));
            countOfData.setFirstInDaysArchive(formatter.parse((int) bb.get(28) + "." + (int) bb.get(29) + "." + (int) bb.get(30) + " " + (int) bb.get(31) + ":00"));
            countOfData.setLastInDaysArchive(formatter.parse((int) bb.get(32) + "." + (int) bb.get(33) + "." + (int) bb.get(34) + " " + (int) bb.get(35) + ":00"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        countOfData.setCurrentCountInAvarArchive(bb.getShort(36));
        countOfData.setIndexLastInAvarArchive(bb.getShort(38));

        return countOfData;
    }
}
