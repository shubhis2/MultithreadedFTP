package Server;

import java.net.ServerSocket;

public class TerminateThread implements Runnable {
	private Server Server;
	private ServerSocket tSocket;
	
	public TerminateThread(Server Server, ServerSocket tSocket) {
		this.Server = Server;
		this.tSocket = tSocket;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " TerminateDaemon Started");
		while (true) {
			try {
				(new Thread(new TerminateCommander(Server, tSocket.accept()))).start();
			} catch (Exception e) {
				System.out.println(Thread.currentThread().getName() + " TerminateDaemon failed to start TerminateWorker");
			}
		}
	}
}