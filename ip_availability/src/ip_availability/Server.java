package ip_availability;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	private final int port;

	public Server(int port) {
		this.port = port;
	}

	public void startServer() throws IOException {

		final ServerSocket serverSocket = new ServerSocket(port);
		final Socket socket = serverSocket.accept();
		final ClientHandler client = new ClientHandler(socket);
		client.run();
		serverSocket.close();

	}
}