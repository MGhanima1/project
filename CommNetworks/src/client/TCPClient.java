package client;

import java.io.*;
import java.net.*;

class TCPClient {
	public static void main(String argv[]) throws Exception {
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));
		if (inFromUser.readLine().equals("CONNECT")) {
			Socket clientSocket = new Socket("127.0.0.1", 6789);

			while (true) {
				BufferedReader inFromUser1 = new BufferedReader(
						new InputStreamReader(System.in));
				// do {
				DataOutputStream outToServer = new DataOutputStream(
						clientSocket.getOutputStream());

				if (inFromUser1.ready()) {
					sentence = inFromUser1.readLine();

					outToServer.writeBytes(sentence + '\n');

				}
				BufferedReader inFromServer = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));

				if (inFromServer.ready()) {
					modifiedSentence = inFromServer.readLine();

					System.out.println("FROM SERVER: " + modifiedSentence);

				}

				// } while (!(inFromUser.readLine().equals("Over")));

				// clientSocket.close();

			}
		}
	}
}
