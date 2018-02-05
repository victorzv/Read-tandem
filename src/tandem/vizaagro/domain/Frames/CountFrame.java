package tandem.vizaagro.domain.Frames;

import tandem.vizaagro.domain.utils.CRCQuery;

public class CountFrame extends Frame{
    public CountFrame() throws Exception{
        super();
    }
    @Override
    public void createFrame() {
        // 0x01, 0x00, 0x00, 0x04, (byte)0x9A, (byte)0x9F, (byte)0x9F

        request = new byte[7];

        request[0] = 0x01;
        request[1] = 0x00;
        request[2] = 0x00;
        request[3] = 0x04;
        request[4] = (byte)0x9A;
        byte cs_add = CRCQuery.get_cs_add(request);
        byte cs_xor = CRCQuery.get_cs_xor(request);
        request[5] = cs_xor;
        request[6] = cs_add;
    }
}
