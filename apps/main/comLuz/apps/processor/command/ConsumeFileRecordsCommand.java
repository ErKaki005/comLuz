package comLuz.apps.processor.command;

import shared.comLuz.infrastructure.bus.event.file.FileRecordsConsumer;
import shared.comLuz.infrastructure.cli.ConsoleCommand;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import comLuz.processor.shared.infrastructure.persistence.Reading;
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

   			Readings readings;
			try {
				readings = xmlMapper.readValue(
				        StringUtils.toEncodedString(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8),
				        Readings.class);
				for (Reading reading : readings.getReading()){
					consumer.consume(reading.getClientID(), reading.getPeriod(), reading.getAmount());
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
   	
    }
}
