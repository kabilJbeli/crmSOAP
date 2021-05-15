 package serviceImpl;

import model.Quote;
import model.ReponseModelContryCode;

public interface IcrmSoapService {
	public Quote GetFinalQuote(int id);
	public ReponseModelContryCode GetClient(int id);
}
