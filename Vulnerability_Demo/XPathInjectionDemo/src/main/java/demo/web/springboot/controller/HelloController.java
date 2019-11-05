package demo.web.springboot.controller;

import org.springframework.boot.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

import java.net.URLEncoder;

@Controller
public class HelloController {

	@RequestMapping(value={"/LoginController"})
	public String index(@RequestParam String username,@RequestParam String  password) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		try {
			builder = factory.newDocumentBuilder();
			ApplicationHome home = new ApplicationHome(getClass());
			File sysfile = home.getSource();
			String Path = sysfile.getParentFile().toString();

			doc = builder.parse(Path + "/classes/tools/database.xml");

			// Create XPathFactory object
			XPathFactory xpathFactory = XPathFactory.newInstance();

			// Create XPath object
			XPath xpath = xpathFactory.newXPath();

			String un = username;
			String pw = password;
			String command = "//user[name/text()='" + sanitize(un.trim()) + "' and password/text()='" + sanitize(pw.trim()) + "']";

			if (authenticateUser(doc, xpath, un, pw) == true) {


				return "redirect:/pages/success.html"+"?command=" + URLEncoder.encode(command);

			} else {
				return "redirect:/pages/error.html"+"?command=" + URLEncoder.encode(command);


			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return null;


	}

	private static Boolean authenticateUser (Document doc, XPath xpath, String login, String password){
		boolean isValid = false;
		try {
			XPathExpression expr =
					xpath.compile("//user[name/text()='" + login.trim() + "' and password/text()='" + password.trim() + "']");
			isValid = (boolean) expr.evaluate(doc, XPathConstants.BOOLEAN);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return isValid;
	}

	static String sanitize (String text){
		return text.replace("&", "&amp;").replace("'", "&apos;");
	}
}
