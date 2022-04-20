package comLuz.processor.shared.infrastructure.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;


@JacksonXmlRootElement(localName = "reading")
@JsonPropertyOrder({"clientID", "period"})
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Reading {

    @JacksonXmlProperty(localName = "clientID", isAttribute = true)
    private String clientID;
    @JacksonXmlProperty(localName = "period", isAttribute = true)
    private String period;

    @JacksonXmlText
    private String amount;

    
    
    public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	@Override
	public String toString() {
		return "Reading [clientID=" + clientID + ", period=" + period + ", amount=" + amount + "]";
	}

	
	
}
