package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the quote database table.
 * 
 */
@Entity
@NamedQuery(name="Quote.findAll", query="SELECT q FROM Quote q")
public class Quote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int idquote;

	private BigDecimal productprice;

	private String prooductname;

	private BigDecimal quote;

	private int totalitems;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="idclient")
	private Client client;

	public Quote() {
	}

	public int getIdquote() {
		return this.idquote;
	}

	public void setIdquote(int idquote) {
		this.idquote = idquote;
	}

	public BigDecimal getProductprice() {
		return this.productprice;
	}

	public void setProductprice(BigDecimal productprice) {
		this.productprice = productprice;
	}

	public String getProoductname() {
		return this.prooductname;
	}

	public void setProoductname(String prooductname) {
		this.prooductname = prooductname;
	}

	public BigDecimal getQuote() {
		return this.quote;
	}

	public void setQuote(BigDecimal quote) {
		this.quote = quote;
	}

	public int getTotalitems() {
		return this.totalitems;
	}

	public void setTotalitems(int totalitems) {
		this.totalitems = totalitems;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}