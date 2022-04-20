package comLuz.apps.processor.command;

import shared.comLuz.infrastructure.bus.event.file.FileRecordsConsumer;
import shared.comLuz.infrastructure.cli.ConsoleCommand;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import comLuz.processor.shared.infrastructure.persistence.Readings;


public final class ConsumeFileRecordsCommand extends ConsoleCommand {
    private final FileRecordsConsumer consumer;

    public ConsumeFileRecordsCommand(FileRecordsConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void execute(String[] args) {
       
    
    	
    		String fileName = args[0];
        	
    		XmlMapper xmlMapper = new XmlMapper();
    		try {
    	        // Reads from XML and converts to POJO
    			Readings readings = xmlMapper.readValue(
    	                StringUtils.toEncodedString(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8),
    	                Readings.class);
    	        System.out.println(readings);
    			
    			//ProcessorReadingsXMLConfiguration readings = xmlMapper.readValue(fileName, ProcessorReadingsXMLConfiguration.class);
				
				
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
            /*JAXBContext context = JAXBContext.newInstance( ProcessorReadingsXMLConfiguration.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ProcessorReadingsXMLConfiguration readings = (ProcessorReadingsXMLConfiguration)unmarshaller.unmarshal(
                new File(fileName) );
             
            System.out.println(readings.getClientID());
            System.out.println(readings.getPeriod());
            System.out.println(readings.getAmount());*/
 
    	
    	
    	consumer.consume();
    }
}
