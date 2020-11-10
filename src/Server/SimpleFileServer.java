package Server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFileServer {
    private ServerSocket FileServer;
    private String destinationDir = "";
    private Socket clientSocket;
    private DataInputStream dis;
    private FileOutputStream fos;
    private int Port;
    public SimpleFileServer(int Port, String destinationDir) {
        try {
            FileServer = new ServerSocket(Port);
            this.Port = Port;
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.destinationDir = destinationDir;
    }
    public void listen() {
        System.out.println("Listening on port " + this.Port);
        while (true) {
            try {
                clientSocket = FileServer.accept();
                dis = new DataInputStream(clientSocket.getInputStream());
                String filename = dis.readUTF();
                int filesize = Integer.parseInt(dis.readUTF());
                fos = new FileOutputStream(destinationDir + "/" + filename);
                byte[] buffer = new byte[filesize];
                //int filesize = 2807910; // Send file size in separate msg
                int read = 0;
                int totalRead = 0;
                int remaining = filesize;
                while ((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
                    totalRead += read;
                    remaining -= read;
                    //System.out.println("read " + totalRead + " bytes.");
                    fos.write(buffer, 0, read);
                }
                stop();
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }

    }
    public void stop() {
        try {
            fos.close();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
