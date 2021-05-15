package serviceImpl;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import javax.jws.WebService;


import org.oorsprong.www.websamples_countryinfo.CountryInfoServiceSoapTypeProxy;

import model.Client;
import model.Quote;
import model.ReponseModelContryCode;
import repository.CrmRepository;

@WebService(targetNamespace = "http://serviceImpl/", portName = "CrmSoapServiceImplPort", serviceName = "CrmSoapServiceImplService")
public class CrmSoapServiceImpl implements IcrmSoapService {

	 private CrmRepository repository = new CrmRepository();

	public Quote GetFinalQuote(int id) {

		 Quote quote = repository.getQuoteByID(id);

		BigDecimal price = quote.getProductprice().multiply(new BigDecimal(quote.getTotalitems()));;
		quote.setQuote(price);		
		return quote;
	}
	public ReponseModelContryCode GetClient(int id) {

		ReponseModelContryCode responseModel = new ReponseModelContryCode();
		Client client = repository.getClientByID(id);
		responseModel.setClient(client);
		try {
			CountryInfoServiceSoapTypeProxy proxy = new CountryInfoServiceSoapTypeProxy();

			String code =	proxy.countryIntPhoneCode(client.getCountrycode());
			responseModel.setTargetcode(code);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return responseModel;
	}
	
	
}
