# SimpleFileSocket
Simple Java Library to easily transfer files over the network.\
Grab the SimpleFileSocket.jar file from /out/artifacts/SimpleFileSocket_jar/\
Easy implementation with only a few lines!

## Usage
### Server Side
Create a SimpleFileServer object and instantiate with args(Port, FileDestinationDirectory).
```bash
SimpleFileServer Server = new SimpleFileServer(8080, "/file/destination/directory");
Server.listen();
```
### Client Side
Create a SimpleFileClient object and instantiate with args(Host, Port).
```bash
SimpleFileClient Client = new SimpleFileClient("127.0.0.1", 8080);
File file = new File("/Documents/file.jpg");
Client.send(file);
```

### All Done
Close out the socket connections.
```bash
Server.stop()
Client.stop()
```
