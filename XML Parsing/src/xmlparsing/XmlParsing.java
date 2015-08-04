package xmlparsing;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;




import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * public class XmlParsing
 * used for performing Xml Parsing on a particular Xml file
 */

public class XmlParsing {

	/*
	 * method: public void parseXml()
	 * Used for performing XML parsing using DOM parser
	 */
	public void parseXml(){
		
		long totalSalary = 0;
		try{
			/*
			 * Opening XML file
			 */
			File file = new File("E:\\Workspace2\\XML Parsing\\employee.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document newDocument = builder.parse(file); //Parsing XML file
		
			System.out.println("Root Element: "+newDocument.getDocumentElement().getNodeName());
		
			NodeList list = newDocument.getElementsByTagName("employee");
			Node node = null;
			/*
			 * Computing total salary of all emeployees using input from xml file
			 */
			for(int count = 0; count < list.getLength(); count++){
				node =  list.item(count);
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element)node;
					totalSalary += Integer.parseInt(element.getElementsByTagName("salary").item(0).getTextContent());
				}
			}
		}catch(Exception exception){
			
			exception.printStackTrace();
		}
		System.out.println("Total Salary = "+totalSalary);
	
	}
	public static void main(String [] args){
		
		new XmlParsing().parseXml();
	}
	
}
