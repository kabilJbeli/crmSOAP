package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAccessType;

import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int idclient;
	private String adress;
	private String clientname;

	//bi-directional many-to-one association to Quote
	
	@OneToMany(mappedBy="client")
	@XmlTransient
	private List<Quote> quotes;
	private String countrycode;
	private String telephonenumber;
	@XmlTransient
	public String getTelephonenumber() {
		return telephonenumber;
	}

	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}
	@XmlTransient
	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public Client() {
	}
	@XmlTransient
	public int getIdclient() {
		return this.idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	@XmlTransient
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	@XmlTransient
	public String getClientname() {
		return this.clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	@XmlTransient
	public List<Quote> getQuotes() {
		return this.quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	public Quote addQuote(Quote quote) {
		getQuotes().add(quote);
		quote.setClient(this);

		return quote;
	}

	public Quote removeQuote(Quote quote) {
		getQuotes().remove(quote);
		quote.setClient(null);

		return quote;
	}

}