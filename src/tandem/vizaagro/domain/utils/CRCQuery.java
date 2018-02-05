package tandem.vizaagro.domain.utils;

/**
 * Created by ADM on 29.11.2016.
 */
public class CRCQuery {
    public static byte get_cs_add(byte[] buffer){
        byte sh_cs_add = 0;
        for (int i = 0; i < buffer.length - 2; i++){
            sh_cs_add += buffer[i];
        }
        return sh_cs_add;
    }
    public static byte get_cs_xor(byte[] buffer){
        byte cs_xor = 0;
        for (int i = 0; i < buffer.length - 2; i++){
            cs_xor ^= buffer[i];
        }
        return cs_xor;
    }
    public static byte[] reverse(byte[] validData) {

        for (int i = 0; i < validData.length / 2; i++) {
            byte temp = validData[i];
            validData[i] = validData[validData.length - i - 1];
            validData[validData.length - i - 1] = temp;
        }
        return validData;
    }
}
