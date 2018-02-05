package tandem.vizaagro.domain.utils;

import gnu.io.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by User on 12.12.2016.
 */
public class Comunication {

    private SerialPort serialPort = null;
    private InputStream in = null;
    private OutputStream out = null;
    public static String NAMECOMPORT = "COM6";

    private static Comunication instance;

    public static synchronized Comunication getInstance() throws Exception {
            if (instance == null){
                instance = new Comunication();
                instance.IinitPort();
            }
        return instance;
    }

    private void IinitPort() throws Exception {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(NAMECOMPORT);
            CommPort commPort = portIdentifier.open(Comunication.class.getName(), 10000);

            instance.serialPort = (SerialPort)commPort;
            instance.serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            instance.serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN);

            instance.in = serialPort.getInputStream();
            instance.out = serialPort.getOutputStream();
    }

    public void writeStringData(String data) throws IOException {
        instance.out.write(data.getBytes());
    }

    public void writeBytesData(byte[] data) throws IOException{
        instance.out.write(data);
    }

    public byte[] read(int MESSAGE_SIZE) throws IOException {
        final byte[] buffer = new byte[MESSAGE_SIZE];
        int total = 0;
        int read = 0;
        while (total < MESSAGE_SIZE
                && (read = instance.in.read(buffer, total, MESSAGE_SIZE - total)) >= 0) {
            total += read;
        }
        return buffer;
    }

    public byte[] ReadFromComm() throws IOException{

        byte[] buffer = null;
        int len = 0;

        while (instance.in.available() > 0) {
            len = instance.in.available();
            buffer = new byte[len];
            instance.in.read(buffer, 0, len);
        }

        return buffer;
    }

    public int waitFoData(int times, int waitTime) throws IOException {
        int count = 0;
        int len = 0;
        byte[] buff = new byte[4];
        while (len <=3 && count < times){
            len = instance.in.available();
            if (len > 3)
                return len;
            count++;
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }



}
