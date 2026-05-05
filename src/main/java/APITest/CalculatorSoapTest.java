package APITest;

import javax.xml.soap.*;
import java.net.URL;

public class CalculatorSoapTest {

    private static final String URL =
            "https://www.dneonline.com/calculator.asmx";

    public static void main(String[] args) throws Exception {

        System.out.println("ADD: " + callSOAP("Add", 10, 20));
        System.out.println("SUBTRACT: " + callSOAP("Subtract", 20, 10));
        System.out.println("MULTIPLY: " + callSOAP("Multiply", 5, 4));
        System.out.println("DIVIDE: " + callSOAP("Divide", 20, 5));

        System.out.println("DIVIDE BY ZERO TEST: " + callSOAP("Divide", 10, 0));
        System.out.println("NEGATIVE TEST: " + callSOAP("Add", -10, 5));
        System.out.println("BOUNDARY TEST: " + callSOAP("Multiply", 999999, 999999));
    }

    public static String callSOAP(String operation, int a, int b) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("tem", "http://tempuri.org/");

        SOAPBody body = envelope.getBody();
        SOAPElement operationElement = body.addChildElement(operation, "tem");
        operationElement.addChildElement("intA", "tem").addTextNode(String.valueOf(a));
        operationElement.addChildElement("intB", "tem").addTextNode(String.valueOf(b));

        soapMessage.saveChanges();

        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = soapConnectionFactory.createConnection();

        SOAPMessage response = connection.call(soapMessage, new URL(URL));

        connection.close();

        return response.getSOAPBody().getTextContent();
    }
}