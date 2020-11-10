# SimpleFileSocket
Simple Socket Java Library to easily transfer files over the network.\n 
Easy implementation to drop into your java project.\n
Grab the SimpleFileSocket.jar file from /out/artifacts/SimpleFileSocket_jar/.


## Usage
### Server Side
Create a SimpleFileServer object and instantiate with args(Port, FileDestinationDirectory).
```bash
SimpleFileServer Server = new SimpleFileServer(8080, "/file/destination/directory");
Server.listen();
```
### Client Side
Create a SimpleFileClient object and instantiate with args(Host, Port, FileToSend).
```bash
File file = new File("/Documents/file.jpg");
SimpleFileClient Client = new SimpleFileClient("127.0.0.1", 8080, file);
Client.send();
```
