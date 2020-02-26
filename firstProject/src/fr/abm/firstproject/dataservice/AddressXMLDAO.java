package fr.abm.firstproject.dataservice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.abm.firstproject.entity.Address;

public class AddressXMLDAO {

	public static final String ADDRESS_FILE = "address.xml";

	public boolean create(Address address) {
		try {
			Document doc = getDocument(); // récupération du fichier xml dans le doc

			Element newAddress = doc.createElement("address");
			Element streetNumber = doc.createElement("streetNumber");
			Element streetName = doc.createElement("streetName");
			Element phoneNumber = doc.createElement("phoneNumber");
			Element mail = doc.createElement("mail");

			streetNumber.setTextContent(String.valueOf(address.getStreetNumber()));
			streetName.setTextContent(address.getStreetName());
			phoneNumber.setTextContent(address.getPhoneNumber());
			mail.setTextContent(address.getMail());
			newAddress.appendChild(streetNumber);
			newAddress.appendChild(streetName);
			newAddress.appendChild(phoneNumber);
			newAddress.appendChild(mail);
			doc.getDocumentElement().appendChild(newAddress);

			transformXML(doc); // propagation des changements vers le fichier xml
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	private void transformXML(Document doc)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		TransformerFactory fact = TransformerFactory.newInstance(); // une foie l'objet mis à jour
		Transformer transformer = fact.newTransformer(); // on écrit dans le fichier xml
		transformer.transform(new DOMSource(doc), new StreamResult(ADDRESS_FILE)); // les mises à jour
	}

	private Document getDocument() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new File(ADDRESS_FILE)); // le contenu du xml est mis dans
																// l'objet doc
		return doc;
	}

	public List<Address> readAllLines() {
		List<Address> listAddress = new ArrayList<Address>();
		try {
			Document doc = getDocument();
			NodeList nodeList = doc.getElementsByTagName("address");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element element = (Element) nodeList.item(i);
				Element streetNumberElement = (Element) element.getElementsByTagName("streetNumber").item(0);
				Element streetNameElement = (Element) element.getElementsByTagName("streetName").item(0);
				Element phoneNumberElement = (Element) element.getElementsByTagName("phoneNumber").item(0);
				Element mailElement = (Element) element.getElementsByTagName("mail").item(0);
				
				Address address = new Address(Integer.valueOf(streetNumberElement.getTextContent()), 
						streetNameElement.getTextContent(), 
						phoneNumberElement.getTextContent(), 
						mailElement.getTextContent());
				listAddress.add(address);
			}
		} catch (Exception e) {
			
		}

		return listAddress;
	}

//	public boolean update(Address address) {
//
//	}

	public boolean delete(Address address) {
		try {
			Document doc = getDocument();
			Element elementToDelete = null;
			NodeList nodeList = doc.getElementsByTagName("address");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element element = (Element) nodeList.item(i);
				Element streetNumberElement = (Element) element.getElementsByTagName("streetNumber").item(0);
				Element streetNameElement = (Element) element.getElementsByTagName("streetName").item(0);
				Element phoneNumberElement = (Element) element.getElementsByTagName("phoneNumber").item(0);
				Element mailElement = (Element) element.getElementsByTagName("mail").item(0);

				if (Integer.valueOf(streetNumberElement.getTextContent()).equals(address.getStreetNumber())
						&& streetNameElement.getTextContent().equals(address.getStreetName())
						&& phoneNumberElement.getTextContent().equals(address.getPhoneNumber())
						&& mailElement.getTextContent().equals(address.getMail())) {
					elementToDelete = element;
				}
			}
			doc.getDocumentElement().removeChild(elementToDelete);

			transformXML(doc);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
