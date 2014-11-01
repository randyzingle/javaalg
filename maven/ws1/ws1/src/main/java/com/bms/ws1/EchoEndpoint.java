package com.bms.ws1;

import java.io.IOException;

import javax.websocket.*;
import javax.websocket.server.*;

@ServerEndpoint("/echo")
public class EchoEndpoint {
	
	private Session myClientSession;
	
	@OnMessage
	public void onMessage(Session session, String msg) {
		try {
			// use session to get RemoteEndpoint.Basic (blocking method)
			// use the RemoteEndpoint to send text, binary, ping, data to client
			session.getBasicRemote().sendText(msg);
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
	}
	
	@OnOpen
	public void open(Session session, EndpointConfig conf) {
		myClientSession = session; // we have a single instance of Endpoint per client
		System.out.println("websocket opened: " + session.getId());
	}
	
	@OnClose
	public void close(Session session, CloseReason reason) {
		System.out.println("websocket closed: " + session.getId());
		System.out.println("reason closed: " + reason.getReasonPhrase());
	}

}
