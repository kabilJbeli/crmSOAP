package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.cxf.aegis.type.java5.XmlElement;

import java.math.BigDecimal;


/**
 * The persistent class for the quote database table.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@NamedQuery(name="Quote.findAll", query="SELECT q FROM Quote q")
public class Quote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int idquote;
	private BigDecimal productprice;
	private String prooductname;
	private String deviseCode;
	@XmlTransient
	public String getDeviseCode() {
		return deviseCode;
	}

	public void setDeviseCode(String deviseCode) {
		this.deviseCode = deviseCode;
	}

	private BigDecimal quote;

	private int totalitems;

	//bi-directional many-to-one association to Client
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="idclient")
	private Client client;

	public Quote() {
	}
	@XmlTransient
	public int getIdquote() {
		return this.idquote;
	}

	public void setIdquote(int idquote) {
		this.idquote = idquote;
	}
	@XmlTransient
	public BigDecimal getProductprice() {
		return this.productprice;
	}

	public void setProductprice(BigDecimal productprice) {
		this.productprice = productprice;
	}
	@XmlTransient
	public String getProoductname() {
		return this.prooductname;
	}

	public void setProoductname(String prooductname) {
		this.prooductname = prooductname;
	}
	@XmlTransient
	public BigDecimal getQuote() {
		return this.quote;
	}

	public void setQuote(BigDecimal quote) {
		this.quote = quote;
	}
	@XmlTransient
	public int getTotalitems() {
		return this.totalitems;
	}

	public void setTotalitems(int totalitems) {
		this.totalitems = totalitems;
	}
	@XmlTransient
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}