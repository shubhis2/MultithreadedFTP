
package Server;

import java.net.ServerSocket;

public class NormalThread implements Runnable {
	private Server server;
	private ServerSocket nSocket;

	public NormalThread(Server server, ServerSocket nSocket) {
		this.server = server;
		this.nSocket = nSocket;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " NormalThread Started");
		while (true) {
			try {
				(new Thread(new NormalThread(server, nSocket.accept()))).start();
			} catch (Exception e) {
				System.out.println(Thread.currentThread().getName() + " NormalThread failed to start NormalCommander");
			}
		}
	}
}