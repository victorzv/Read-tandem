package tandem.vizaagro.domain.converters;

import tandem.vizaagro.Entity.DataArch;
import tandem.vizaagro.Entity.IEntityData;

import java.nio.ByteBuffer;

public class ConverterDataArchImpl implements IConvertable {

    DataArch dataArch = new DataArch();
    ByteBuffer bbuf = ByteBuffer.allocate(50);

    byte[] buf_data = null;

    /*
    * Реверс байтов согласно структуры данных для последующей конвертации
    * */
    private void applyData(){
        int[] sizeData = {2, 2, 1, 1, 1, 1, 4, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 2};
        int start = 0;
        for (int i = 0; i < sizeData.length; i++){

            for (int j = 0; j < sizeData[i]/2; j++){
                byte temp = buf_data[start + j];
                buf_data[start + j] = buf_data[start + sizeData[i] - j - 1];
                buf_data[start + sizeData[i] - j - 1] = temp;
            }
            start+= sizeData[i];
        }
        bbuf = ByteBuffer.wrap(buf_data);
    }
    /*
    * сконвертировать данные в структуру
    * */
    private void putDataFromByte(){
        dataArch.setNumRec(bbuf.getShort(2));
        dataArch.setYear((int) bbuf.get(4));
        dataArch.setMounth((int) bbuf.get(5));
        dataArch.setDay((int) bbuf.get(6));
        dataArch.setHour((int) bbuf.get(7));
        dataArch.setTimeWork(((float)bbuf.getInt(8)/60/60));
        dataArch.setPress(((float)bbuf.getShort(12)/25));
        dataArch.setTemperatura(((float)bbuf.getShort(14))/100);
        dataArch.setvWork(((float)bbuf.getInt(16))/10);
        dataArch.setvStand(((float)bbuf.getInt(20))/10);
        dataArch.setkKorrection(bbuf.getFloat(24));
        dataArch.setvWorkSm(((float)bbuf.getInt(28))/10);
        dataArch.setvStandSm(((float)bbuf.getInt(32))/10);
        dataArch.setdVStandSm(((float)bbuf.getInt(36))/10);
        dataArch.setvWorkError(((float)bbuf.getInt(40))/10);
        dataArch.setTimeError(((float)bbuf.getInt(44))/10);
    }

    @Override
    public IEntityData convertToObject(byte[] buffer) {
        buf_data = buffer;
        applyData();
        putDataFromByte();
        return dataArch;
    }

}
