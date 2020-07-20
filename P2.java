import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static java.util.Map.*;

//myTask is a thread
class connectMoreSockets implements Runnable{
    BufferedReader stdIn = null;
    String strin;
    String host = null;
    Socket socket;
    int port = 0;
    P2 p2 =new P2();

    public connectMoreSockets(String host,int port) throws IOException {
        this.host = host;
        this.port = port;
    }

    @Override
    public synchronized void run(){

        try {
            p2.printReceviedData(host,port);
            System.out.println("Connected to Host: "+host);
            System.out.println("Port: "+port);
            System.out.println("Continue inputting...");
            //System.out.println("\nEnter support value: ");
        } catch (IOException e) {
            System.err.println("Invalid Socket..try again");
            return;
        }

    }
}

public class P2{
    private Socket socket =null;
    private DataInputStream  input   = null;
    private DataOutputStream out     = null;
    private PrintWriter pw = null;
    private static String host = null;
    private static int port = 0;
    private BufferedReader in;
    private String recvStream = null;
    private String recvId = null;
    private String recvURL = null;
    private Hashtable<Integer, Vector<String>> mfrTable = new Hashtable<Integer, Vector<String>>();
    private static LinkedHashMap<Integer, Vector<String>> wcsMap = new LinkedHashMap<Integer, Vector<String>>(); //before, mfrMap
    public static LinkedHashMap<Integer, Vector<Vector<String>>> finalmfrMap = new LinkedHashMap<>();
    public static Vector<Vector<String>> mfrList = new Vector<>();
    private Vector<String> mfrURLs = new Vector<>();
    public static int support = 1;

    public synchronized void printReceviedData(String host, int port)throws IOException{
        socket = new Socket(host, port);
        System.out.println("Connected socket(s): "+socket);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("\nRECEIVED INPUTS from socket("+socket+"):");
        while((recvStream = in.readLine()) != null){

            if(recvStream.split(",").length == 2){
                System.out.println(recvStream);
                recvId = recvStream.split(",")[0];
                recvURL = recvStream.split(",")[1];
            addMFRs(Integer.parseInt(recvId),recvURL);
            }
        }
    }

    //Print output after support is entered
    private synchronized void printOutput(){
        if(!wcsMap.isEmpty()){
            System.out.println("\n\nWEB CLICK SEQUENCES FOR EACH USER");
            Iterator<Entry<Integer, Vector<String>>> hmI = wcsMap.entrySet().iterator();
            while (hmI.hasNext()){
                Map.Entry<Integer, Vector<String>> mapElement =  hmI.next();
                System.out.println("WCS BY>> "+mapElement.getKey()+": \n\t"+mapElement.getValue());
            }
        }

        createMFRs();
    }

    //Creating MFRs
    public synchronized void createMFRs(){
        System.out.println("\n\nMAXIMAL FORWARD REFERENCES FOR EACH USER");
        Iterator<Map.Entry<Integer, Vector<String>>> hmIterator = wcsMap.entrySet().iterator();
        while (hmIterator.hasNext()){
            Entry<Integer, Vector<String>> mapElement = hmIterator.next();
            Vector<String> tempfrom = new Vector<>();
            tempfrom = mapElement.getValue();
            finalmfrMap.put( mapElement.getKey(),getSingleMFR(tempfrom));

        }

        Iterator<Map.Entry<Integer, Vector<Vector<String>>>> hmI = finalmfrMap.entrySet().iterator();
        while (hmI.hasNext()){
            Entry<Integer, Vector<Vector<String>>> mapElement = hmI.next();
            System.out.println("MFR BY>> "+mapElement.getKey()+": \n\t"+mapElement.getValue());
        }

//        System.out.println(finalmfrMap);

    }
    private synchronized Vector<Vector<String>> getSingleMFR(Vector<String> wcs){
        Vector<Vector<String>> mfr = new Vector<>();
        Vector<String> temp = new Vector<>();
        for(String s:wcs){
            if(temp.contains(s)){
                mfr.add(temp);
                temp = new Vector<>();
                temp.add(s);
            }else{
                temp.add(s);
            }

        }
        mfr.add(temp);
        return mfr;
    }

    public synchronized void createThread(String host,int port) throws IOException, InterruptedException {

        Runnable r = new connectMoreSockets(host,port);
        Thread task = new Thread(r);
        task.start();
//        task.join();
    }

private static String convertInputStreamToString(InputStream inputStream)
        throws IOException {
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString(StandardCharsets.UTF_8.name());

        }

    public synchronized static void addMFRs(int key,String value){
        Vector<String> mfrURLs;
        if(wcsMap.containsKey(key)){
            mfrURLs = wcsMap.get(key);
            mfrURLs.add(value);
        }
        else{
            mfrURLs = new Vector<>();
            mfrURLs.add(value);
            wcsMap.put(key,mfrURLs);
        }
    }

    private synchronized static boolean isInteger(String sf) {
        if(sf == null){
            return  false;
        }
        try{
            int i = Integer.parseInt(sf);
        }catch (Exception e){
            return false;
        }
        return true;

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        P2 p2 = new P2();

        System.out.println("Waiting for the std input for P2..." +
                "\nEnter socket in the form <hostname,portNumber> (NO SPACES)" +
                "\nNOTE: For multiple socket entries, make sure you include \"Enter (or Return) character\" while copying the data from other resource");

        while (true){
            String strin;
            Scanner con = new Scanner(System.in);
            while((strin = con.nextLine()) != null){
                if(strin.split(",").length > 1){//test for socket here
                    try{
                        host =strin.split(",")[0];
                        port = Integer.parseInt(strin.split(",")[1]);
                        p2.createThread(host,port);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid Socket enter in the form <hostname,portNumber> ,no spaces");
                        continue;
                    }

                }

                if(isInteger(strin)){
                    if(host == null || port == 0){
                        System.err.println("Please enter atleast one valid Socket!");
                        continue;
                    }

                    support = Integer.parseInt(strin);
                    System.out.println("Support: "+support);
                    p2.printOutput();
                }



            }
//            System.out.println("\nMAXIMAL FORWARD REFERENCES FOR ALL THE DATA INPUT SO FAR: ");
            //System.out.println(mfrMap);
            //System.out.println(mfrList);
        }

    }
}

