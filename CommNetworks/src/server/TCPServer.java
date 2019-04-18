package server;

import java.io.*;
import java.net.*;

class TCPServer {
	public static void main(String argv[]) throws Exception {
		String clientSentence;
		String capitalizedSentence;

		ServerSocket welcomeSocket = new ServerSocket(6789);
		Socket connectionSocket = welcomeSocket.accept();
		System.out.println("Connected successfuly");
		while (true) {

			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream()));
			if (inFromClient.ready()) {
				clientSentence = inFromClient.readLine();
				System.out.println("From User:" + clientSentence + '\n');
			}
			BufferedReader inFromConsole = new BufferedReader(
					new InputStreamReader(System.in));
			DataOutputStream outToClient = new DataOutputStream(
					connectionSocket.getOutputStream());

			// int flag = 0; System.out.println(clientSentence); if (flag == 0)
			// { if (clientSentence == "CONNECT") flag = 1;
			// outToClient.writeBytes(""); }else {
			if (inFromConsole.ready()) {
				String console = inFromConsole.readLine();
				outToClient.writeBytes(console + '\n');
			}
			// capitalizedSentence = clientSentence.toUpperCase() + '\n';
			// System.out.println("console");
			// System.out.println(console);
			// outToClient.writeBytes(capitalizedSentence);
			// }

		}
	}
}