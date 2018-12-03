package com.cvpp.ds;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XmlParser {
	private static Logger log = LoggerFactory.getLogger(XmlParsingApplication.class);
	
	public void Parse() {

		try {
		       File inputFile = new File("sample.xml");
		       SAXReader reader = new SAXReader();
		       Document document = reader.read(inputFile);
		       		       
		       Element rootElement = document.getRootElement();
		       log.info("Root element :" + rootElement.getName());
		       Iterator itr = rootElement.elementIterator();
		       log.info("----------------------------");
		       while (itr.hasNext()) {
		         Node node = (Node)itr.next();
		         
		         log.info("\nCurrent Element :" + node.getName());
		         log.info("Employee Id : " + node.valueOf("@id"));
		         log.info("Age : "+ node.selectSingleNode("age").getText());
		         log.info("First Name : "+ node.selectSingleNode("firstname").getText());
		         log.info("Last Name : "+ node.selectSingleNode("lastname").getText());
		         log.info("Role : "+ node.selectSingleNode("role").getText());
		      }
	    }
		catch (DocumentException e) {
		    e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void create() {
		try {
	         Document document = DocumentHelper.createDocument();
	         Element root = document.addElement("Employees");
	         Element employeeElement = root.addElement("Employee").addAttribute("id", "1");
	         employeeElement.addElement("age").addText("28");
	         employeeElement.addElement("firstname").addText("Arun");
	         employeeElement.addElement("lastname").addText("Kumar");
	         employeeElement.addElement("role").addText("Developer");
	         root.addComment("This is a comment");
	 
	         // print the document to System.out
	         OutputFormat format = OutputFormat.createPrettyPrint();
	         XMLWriter writer = new XMLWriter(System.out, format);
	         writer.write(document);
	         // Save the contents to a file
	         XMLWriter fileWriter = new XMLWriter(
	                              new FileOutputStream("Dom4jEmployee.xml"), format);
	         fileWriter.write(document);
	      } catch (IOException e) {
	            e.printStackTrace();
	     }
	}
}
