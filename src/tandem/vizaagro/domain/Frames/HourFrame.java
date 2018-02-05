package tandem.vizaagro.domain.Frames;

import tandem.vizaagro.domain.utils.CRCQuery;

import java.nio.ByteBuffer;

/**
 * Created by User on 07.12.2016.
 */
public class HourFrame extends Frame {

    public HourFrame() throws Exception{
        super();
    }

    @Override
    public void createFrame() {
        //byte[] command_read_day = {0x01, 0x04, 0x00, 0x04, (byte) 0xa5, 0x01, 0x05, (byte) 0xC8, 0x00, (byte) 0x62, (byte) 0x76};
        request = new byte[11];
        request[0] = 0x01;
        request[1] = 0x04;
        request[2] = 0x00;
        request[3] = 0x04;
        request[4] = (byte)0xA4;
        request[5] = (byte)typeArch;
        request[6] = (byte)numbersOfEntityes;

        byte[] buf_index = ByteBuffer.allocate(2).putShort(indexBegin).array();

        request[7] = buf_index[1];
        request[8] = buf_index[0];

        byte cs_xor = CRCQuery.get_cs_xor(request);
        byte cs_add = CRCQuery.get_cs_add(request);

        request[9] = cs_xor;
        request[10] = cs_add;
    }
}
