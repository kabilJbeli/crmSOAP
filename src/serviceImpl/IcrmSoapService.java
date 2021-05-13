 package serviceImpl;

import model.ReponseModelContryCode;
import model.ResponseModel;

public interface IcrmSoapService {
	public ResponseModel GetFinalQuote(int id);
	public ReponseModelContryCode GetClient(int id);

}
