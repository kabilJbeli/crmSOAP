 package serviceImpl;

import java.util.List;

import model.Quote;
import model.ReponseModelContryCode;

public interface IcrmSoapService {
	public Quote GetFinalQuote(int id);
	public ReponseModelContryCode GetClient(int id);
	public List<Object> VIPCustomer ();
}
