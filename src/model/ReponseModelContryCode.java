package model;

public class ReponseModelContryCode {
	Client client;
	String targetcode;

	public ReponseModelContryCode() {
		super();
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	public String getTargetcode() {
		return targetcode;
	}

	public void setTargetcode(String targetcode) {
		this.targetcode = targetcode;
	}

	public ReponseModelContryCode(Client client, String targetcode) {
		super();
		this.client = client;
		this.targetcode = targetcode;
	}
}