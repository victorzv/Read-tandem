package tandem.vizaagro;

import tandem.vizaagro.Entity.CountOfData;
import tandem.vizaagro.Entity.DataArch;
import tandem.vizaagro.domain.Frames.CountFrame;
import tandem.vizaagro.domain.Frames.DayFrame;
import tandem.vizaagro.domain.converters.ConverterCountImpl;
import tandem.vizaagro.domain.converters.ConverterDataArchImpl;
import tandem.vizaagro.domain.utils.OperationPhone;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        try {
            CountOfData countOfData;
            List<DataArch> dataArch = new ArrayList<>();

            OperationPhone phone = new OperationPhone();
            phone.callToPhone();

            CountFrame countFrame = new CountFrame();

            if (countFrame.doFrame()) {
                countOfData = (CountOfData) countFrame.getFrame(new ConverterCountImpl(), 0);
            } else {
                System.out.println("ZHOPA COUNT");
                return;
            }

            System.out.println(countOfData.getIndexLastInDaysArchive());

            int curentIndex = countOfData.getIndexLastInDaysArchive();

            DayFrame dayFrame = new DayFrame();

            dayFrame.setParametrs((byte) 0, (byte) 5, (short) (curentIndex - 10));

            if (dayFrame.doFrame()) {
                for (int i = 0; i < 5; i++) {
                    dataArch.add((DataArch) dayFrame.getFrame(new ConverterDataArchImpl(), i));
                }
            } else {
                System.out.println("DAY FRAME ZHOPA");
                return;
            }

            for (DataArch d : dataArch) {
                System.out.println("**************************************\r\n");
                System.out.print(d.getNumRec() + "\t");
                System.out.print(d.getDay() + "." + d.getMounth() + "." + d.getYear() + "\t");
                System.out.print(d.getPress() + "\t");
                System.out.println(d.getTemperatura());
            }
            System.out.println("**************************************\r\n");

            phone.turnOfPhone();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
