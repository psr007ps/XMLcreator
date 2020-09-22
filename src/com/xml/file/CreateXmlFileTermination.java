package com.file.xml;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
public class CreateXmlFileTermination {
	private static String EXCEL_FILE_LOCATION = "C:\\xmldivestiture\\MyFirstExcel.xls";
	private static long counter=000; 

   public static void main(String argv[]) {
	   Workbook workbook = null;

      try {
    	  File inputWorkbook = new File(EXCEL_FILE_LOCATION);
            Workbook w;
         
        
                w = Workbook.getWorkbook(inputWorkbook);
                // Get the first sheet
                Sheet sheet = w.getSheet(1);
                // Loop over first 10 column and lines

                for (int i = 1; i < sheet.getRows(); i++) {
                	
                	String userName=null;
                	
                	
                	DocumentBuilderFactory dbFactory =
       	       	         DocumentBuilderFactory.newInstance();
       	       	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       	       	         Document doc = dBuilder.newDocument();
       	       	  
       	       	         doc .setXmlStandalone(true);
       	       	   
       	       	        		 
       	       	   	       	       	         
       	        	 Element rootElement = doc.createElement("Attributes");
       		         doc.appendChild(rootElement);

       		         Element supermap = doc.createElement("Map");
       		         rootElement.appendChild(supermap);

       		         // setting attribute to element
     		     
       		    	 Element entryname = doc.createElement("entry");
       		         Attr attrType1 = doc.createAttribute("key");
       		         attrType1.setValue("requestType");
       		      entryname.setAttributeNode(attrType1);
                  Attr attrType2 = doc.createAttribute("value");
       		      attrType2.setValue("terminateUser");
       		      entryname.setAttributeNode(attrType2);
       		   supermap.appendChild(entryname);
       		   
       		 entryname = doc.createElement("entry");
		          attrType1 = doc.createAttribute("key");
		         attrType1.setValue("requestor");
		      entryname.setAttributeNode(attrType1);
          attrType2 = doc.createAttribute("value");
		      attrType2.setValue("8123");
		      entryname.setAttributeNode(attrType2);
		   supermap.appendChild(entryname);
   		       System.out.println(sheet.getColumns());
       		    System.out.println(sheet.getRows());
                    for (int j = 1; j < sheet.getColumns(); j++) {
                        Cell cell = sheet.getCell(j,i);
                        String cellValue = cell.getContents();
                       System.out.println(j+"_-"+i+"_"+cellValue);
                            
                           entryname = doc.createElement("entry");
			    
                            if(j==1){
    	   		   	 userName=cellValue;
    	   		   }
    	   	       		          
			    if(j==2){
			    if(!cellValue.equals("")){
			userName=userName+"_"+cellValue;}
			    }

			if(j==3){
    	   	       			
    	   	      	if(!cellValue.equals("")){
    	   	       		userName=userName+"_"+cellValue;}
    	   	      	}
    	   	       		
                            
                            if(j==4 ){
                            	attrType1 = doc.createAttribute("key");
                                attrType2 = doc.createAttribute("value");
                                 attrType1.setValue("personID");
	   	       		        
	   	       		               attrType2.setValue(cellValue);
	   	       		         entryname.setAttributeNode(attrType1);
	    	       		        
	                           
	                            entryname.setAttributeNode(attrType2);
	                            
	                            supermap.appendChild(entryname);
	   	       	
                            }
                    }
                
             // write the content into xml file
                    
                    
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	       	       	Transformer transformer = transformerFactory.newTransformer();	       	
	       	       	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	       	       	transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
	       	       	transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	       	       	DOMImplementation domImpl = doc.getImplementation();
	       	       	DocumentType doctype = domImpl.createDocumentType("doctype",
	       	       	    "sailpoint.dtd",
	       	       	    "sailpoint.dtd");
	       	       	transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
	       	       	transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
	       	       	DOMSource source = new DOMSource(doc);
                    
  		         counter+=1;
  		        
  		         File file1=new File("C:\\xmldivestiture\\Terminate\\terminate_"+counter+"_"+userName+".xml");
  		         file1.createNewFile();
  		         StreamResult result = new StreamResult(file1);
  		       transformer.setOutputProperty(OutputKeys.INDENT,"yes");
  		     transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","10");
  		     
  		   /*StringWriter sw = new StringWriter();
  		 StreamResult result1 = new StreamResult(sw);
  		 DOMSource source1 = new DOMSource(doc);*/
  		transformer.transform(source, result);
  		/* String xmlString = sw.toString();
  		     
  		         transformer.transform(source, result);*/
  		      // Output to console for testing
  		         StreamResult consoleResult = new StreamResult(System.out);
  		      
  		         transformer.transform(source, consoleResult);
  		        
         // root element
         
  		          }}catch (Exception e) {
         e.printStackTrace();
      }
   }
}
