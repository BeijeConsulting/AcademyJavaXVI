package it.beije.boot.rubrica.controller.nicoleSOAP;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import it.beije.boot.rubrica.repository.nicole.FakeContactRepository;

@Endpoint
public class WebServiceEndPoint {
	private static final String NAMESPACE_URI = "http://javainuse.com";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOATest")
	@ResponsePayload
	public GetNamesResponse hello(@RequestPayload GetNames request) {

		String outputString = "Hello " + request.getNames() + "!";

		ObjectFactory factory = new ObjectFactory();
		GetNamesResponse response = new GetNamesResponse();
		response.getReturn();
		
		return response;
	}
}
