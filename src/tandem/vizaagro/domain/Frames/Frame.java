package tandem.vizaagro.domain.Frames;

import tandem.vizaagro.Entity.IEntityData;
import tandem.vizaagro.domain.converters.IConvertable;
import tandem.vizaagro.domain.utils.CRCQuery;
import tandem.vizaagro.domain.utils.Comunication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Frame {

    Comunication comunication;
    List<byte[]> buffers = new ArrayList<>();

    byte[] request = new byte[1024];

    byte[] response = new byte[1024];
    int lengthOfResponse = 0;

    byte[] data = null;

    short indexBegin = 0;
    byte numbersOfEntityes = 1;
    byte typeArch = 0;

    public Frame() throws Exception{
        comunication = Comunication.getInstance();
    }

    public void setParametrs(byte typeArch, byte numbersOfEntityes, short indexBegin){
        setIndexBegin(indexBegin);
        setNumbersOfEntityes(numbersOfEntityes);
        setTypeArch(typeArch);
    }

    public void setIndexBegin(short indexBegin){
        this.indexBegin = indexBegin;
    }

    public void setNumbersOfEntityes(byte numbersOfEntityes){
        this.numbersOfEntityes = numbersOfEntityes;
    }

    public void setTypeArch(byte typeArch){
        this.typeArch = typeArch;
    }

    public abstract void createFrame();

    public void writeFrame(){
        try {
            comunication.writeBytesData(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFrame(){
        try {
            lengthOfResponse = comunication.waitFoData(5, 1000);
            if (lengthOfResponse == 0) {
                return;
            }
            response = new byte[lengthOfResponse];
            response = comunication.read(lengthOfResponse);

            if (checkFrame())
            {
                int count = response[1] & 0xFF;
                System.out.println("Kvo data bytes " + count);
                int lenEntity = count/numbersOfEntityes;
                System.out.println("Len of data entity " + lenEntity);

                for (int i = 0; i < numbersOfEntityes; i++)
                {
                    data = new byte[lenEntity];
                    System.arraycopy(response, 5 + i*lenEntity, data, 0, lenEntity);
                    buffers.add(data);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean doFrame(){
        createFrame();
        writeFrame();
        readFrame();
        return checkFrame();
    }

    public boolean checkFrame(){
        byte CS_ADD = CRCQuery.get_cs_add(response);
        byte CS_XOR = CRCQuery.get_cs_xor(response);
        if (CS_ADD == response[response.length-1] && CS_XOR == response[response.length-2])
            return true;
        return false;
    }

    public IEntityData getFrame(IConvertable convertable, int index){
        return convertable.convertToObject(buffers.get(index));
    }
}


