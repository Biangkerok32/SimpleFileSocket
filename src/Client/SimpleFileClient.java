package Client;
import java.io.*;
import java.net.Socket;
import java.io.File;

public class SimpleFileClient {
    private File file;
    private String Host;
    private int Port;
    private Socket FileClient;
    private DataOutputStream dos;
    private FileInputStream fis;
    public SimpleFileClient(String Host, int Port) {

        this.Host = Host;
        this.Port = Port;
    }
    public void send(File file) {
        this.file = file;
        try {
            FileClient = new Socket(Host, Port);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            dos = new DataOutputStream(FileClient.getOutputStream());
            fis = new FileInputStream(file);
            dos.writeUTF(file.getName());
            dos.writeUTF(String.valueOf((int) file.length()));
            byte[] buffer = new byte[(int) file.length()];
            while (fis.read(buffer) > 0) {
                dos.write(buffer);
            }
            System.out.println("File Sent");
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void stop() {
        try {
            fis.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
