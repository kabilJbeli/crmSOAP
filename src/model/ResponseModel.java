package model;

import java.math.BigDecimal;

public class ResponseModel {
Quote quote;
BigDecimal convertedDevise;

public ResponseModel() {
	super();
}
public ResponseModel(Quote quote, BigDecimal convertedDevise) {
	super();
	this.quote = quote;
	this.convertedDevise = convertedDevise;
}
public Quote getQuote() {
	return quote;
}
public void setQuote(Quote quote) {
	this.quote = quote;
}
public BigDecimal getConvertedDevise() {
	return convertedDevise;
}
public void setConvertedDevise(BigDecimal convertedDevise) {
	this.convertedDevise = convertedDevise;
}
}
