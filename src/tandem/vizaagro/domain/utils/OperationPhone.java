package tandem.vizaagro.domain.utils;

/**
 * Created by User on 12.12.2016.
 */
public class OperationPhone {

    Comunication comunication;
    public static final String CALL_NUMBER = "ATD0664347606\r\n";


    public void callToPhone() throws Exception{
        byte[] answer = null;
        Comunication.NAMECOMPORT = "COM6";
        comunication = Comunication.getInstance();

        System.out.println("Write AT&F");
        /* Init modem */
        comunication.writeStringData("AT&F\r\n");
        int numbers = comunication.waitFoData(2, 1000);
        if (numbers == 0) {
            throw new Exception("Cannot intialize modem");
        }
        answer = new byte[numbers + 1];
        answer = comunication.ReadFromComm();
        String sAnswer = new String(answer);
        System.out.println(sAnswer);
        if (!sAnswer.toLowerCase().contains("ok")){
            throw new Exception("Cannot initialize modem 2");
        }
        /* call to modem */
        comunication.writeStringData(CALL_NUMBER);
        numbers = comunication.waitFoData(3, 1000);
        answer = new byte[numbers + 1];
        answer = comunication.ReadFromComm();
        sAnswer = new String(answer);
        System.out.println(sAnswer);
        if (!sAnswer.toLowerCase().contains("atd")){
            throw new Exception("Can not call to modem");
        }
        numbers = comunication.waitFoData(50, 1000);
        answer = comunication.ReadFromComm();
        sAnswer = new String(answer);
        System.out.println(sAnswer);
        if (!(new String(answer)).contains("CONNECT")){
            throw new Exception("MODEM did not get phone");
        }

    }

    public void turnOfPhone() throws Exception{
        byte[] answer = null;
        Comunication.NAMECOMPORT = "COM6";
        System.out.println("Strat write +++");
        comunication = Comunication.getInstance();
        comunication.writeStringData("+++");
        int numbers = comunication.waitFoData(25, 1000);
        answer = new byte[numbers + 1];
        answer = comunication.ReadFromComm();
        System.out.println(new String(answer));

        System.out.println("Write ATH");
        comunication.waitFoData(2, 1000);
        comunication.writeStringData("ATH\r\n");
        numbers = comunication.waitFoData(3, 1000);
        answer = new byte[numbers + 1];
        answer = comunication.ReadFromComm();
        System.out.println(new String(answer));
    }

}
