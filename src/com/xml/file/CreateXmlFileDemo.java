package com.xml.file;


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

import java.util.ArrayList;


	public class CreateXmlFileDemo {
		private static final String EXCEL_FILE_LOCATION = "C:\\Bikash Bhaiya Divestiture\\Divest.xls";
		private static long counter=0000; 

	   public static void main(String argv[]) {
		   Workbook workbook = null;

	      try {
	    	  File inputWorkbook = new File(EXCEL_FILE_LOCATION);
	            Workbook w;
	         
	         
	         
	         
	         
	                w = Workbook.getWorkbook(inputWorkbook);
	                // Get the first sheet
	                Sheet sheet = w.getSheet(0);
	                // Loop over first 10 column and lines

	                for (int i = 0; i < sheet.getRows(); i++) {
	                	
	                	
	                String ContinuumNativeID= null;
	                String ADNUPOCNativeID= null;
	                String PersonID= null;
	                ArrayList list1=new ArrayList<>();
	                        for (int j = 0; j < sheet.getColumns(); j++) {
	                            Cell cell = sheet.getCell(j,i);
	                            
	                            list1.add(cell.getContents());
	                            
	                            
	                        }
	                        ContinuumNativeID=(String)list1.get(0);
                            ADNUPOCNativeID=(String)list1.get(1);
                           PersonID=(String)list1.get(2);
	                	
	                        DocumentBuilderFactory dbFactory =
			       	       	         DocumentBuilderFactory.newInstance();
			       	       	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			       	       	         Document doc = dBuilder.newDocument();
			       	       	   
			       	       	        		 
			       	       	   	       	       	         
			       	        	 Element rootElement = doc.createElement("Attributes");
			       		         doc.appendChild(rootElement);
			       		      
			       		         // supercars element
			       		         Element supermap = doc.createElement("Map");
			       		         rootElement.appendChild(supermap);

	       		         // setting attribute to element
	       		      
	       		         // carname element
	       		         
	       		     
	       		    	 Element entryname = doc.createElement("entry");
	       		         Attr attrType1 = doc.createAttribute("key");
	       		         attrType1.setValue("launcher");
	       		      entryname.setAttributeNode(attrType1);
	                  Attr attrType2 = doc.createAttribute("value");
	       		      attrType2.setValue("2057666");
	       		      entryname.setAttributeNode(attrType2);
	       		   supermap.appendChild(entryname);
	       		         
	       		      entryname = doc.createElement("entry");
	       		          attrType1 = doc.createAttribute("key");
	       		         attrType1.setValue("identityName");
	       		      entryname.setAttributeNode(attrType1);
	                   attrType2 = doc.createAttribute("value");
	       		      attrType2.setValue(PersonID);
	       		      entryname.setAttributeNode(attrType2);
	       		   supermap.appendChild(entryname);
	       		         
	       		      entryname = doc.createElement("entry");
       		          attrType1 = doc.createAttribute("key");
       		         attrType1.setValue("flow");
       		      entryname.setAttributeNode(attrType1);
                   attrType2 = doc.createAttribute("value");
       		      attrType2.setValue("AccountsRequest");
       		      entryname.setAttributeNode(attrType2);
       		   supermap.appendChild(entryname);
       		   
       		Element entryname2 = doc.createElement("entry");
       		attrType1 = doc.createAttribute("key");
		         attrType1.setValue("plan");
		      entryname2.setAttributeNode(attrType1);
		      
       		   
       		Element entryname1 = doc.createElement("value");
       		
       		Element entryname3 = doc.createElement("ProvisioningPlan");
       		Attr attrType3 = doc.createAttribute("op");
       		System.out.println("ContinuumNativeID:"+ContinuumNativeID);
       		if(!ContinuumNativeID.equals("ABC"))
       		{
       		entryname = doc.createElement("AccountRequest");
       		
	         attrType1 = doc.createAttribute("application");
	         attrType1.setValue("Continuum");
	      entryname.setAttributeNode(attrType1);
	      
   attrType2 = doc.createAttribute("nativeIdentity");
	      attrType2.setValue(ContinuumNativeID);
	      entryname.setAttributeNode(attrType2);
	      
	      
	      attrType3.setValue("Disable");
	      entryname.setAttributeNode(attrType3);
       		
	      entryname3.appendChild(entryname);
       		}
       		if(!ADNUPOCNativeID.equals("ABC"))
       		{
	      entryname = doc.createElement("AccountRequest");
     		
	         attrType1 = doc.createAttribute("application");
	         attrType1.setValue("Active Directory - NUPOC");
	      entryname.setAttributeNode(attrType1);
	      
attrType2 = doc.createAttribute("nativeIdentity");
	      attrType2.setValue(ADNUPOCNativeID);
	      entryname.setAttributeNode(attrType2);
	      
	       attrType3 = doc.createAttribute("op");
	      attrType3.setValue("Disable");
	      entryname.setAttributeNode(attrType3);
	      
	      entryname3.appendChild(entryname);
       		}
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
       		entryname3.appendChild(entryname);
       		entryname1.appendChild(entryname3);
       		entryname2.appendChild(entryname1);
       		   
       		
		      supermap.appendChild(entryname2);
		      
		      
		  
       		   

		      
	       		       
		         
		         String globalCellValue=null;
	       		     
	       		       
	                   
	   	       		          
	   	       		          
	   	       		          
	   	       		          
	   	       		          
	   	       		          
	   	       		         
	                      
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
      		         File file1=new File("C:\\Bikash Bhaiya Divestiture\\Disable\\"+counter+"_EmpNO_"+PersonID+".xml");
      		         file1.createNewFile();
      		         StreamResult result = new StreamResult(file1);
      		       transformer.setOutputProperty(OutputKeys.INDENT,"yes");
      		     transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","10");
      		         transformer.transform(source, result);
      		      // Output to console for testing
      		         StreamResult consoleResult = new StreamResult(System.out);
      		      
      		         transformer.transform(source, consoleResult);
      		        
	         
	         // root element
	        
	        	
	        
	         
	         
	                }}catch (Exception e) {
	         e.printStackTrace();
	      }
	   
	   }}
