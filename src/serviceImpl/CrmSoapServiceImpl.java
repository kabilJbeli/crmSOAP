package serviceImpl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Calendar;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.oorsprong.www.websamples_countryinfo.CountryInfoServiceSoapTypeProxy;
import org.tempuri.ConverterSoapProxy;

import model.Client;
import model.Quote;
import model.ReponseModelContryCode;
import model.ResponseModel;
import repository.CrmRepository;

@WebService(targetNamespace = "http://serviceImpl/", portName = "CrmSoapServiceImplPort", serviceName = "CrmSoapServiceImplService")
public class CrmSoapServiceImpl implements IcrmSoapService {

	 private CrmRepository repository = new CrmRepository();

	public ResponseModel GetFinalQuote(int id) {

		ResponseModel responseModel = new ResponseModel();
		responseModel.setQuote(repository.getQuoteByID(id));
		Calendar cal;

		BigDecimal price = null;
		try {
			 ConverterSoapProxy proxy = new ConverterSoapProxy();

			BigDecimal convertedPrice =	proxy.getConversionAmount("USD","TND", Calendar.getInstance(), price);
			responseModel.setConvertedDevise(convertedPrice);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseModel;
	}
	
	public ReponseModelContryCode GetClient(int id) {

		ReponseModelContryCode responseModel = new ReponseModelContryCode();
		Client client = repository.getClientByID(id);
		responseModel.setClient(client);
		Calendar cal;

		BigDecimal price = null;
		try {
			CountryInfoServiceSoapTypeProxy proxy = new CountryInfoServiceSoapTypeProxy();

			String code =	proxy.countryIntPhoneCode(client.getCountrycode());
			responseModel.setTargetcode(code);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseModel;
	}
	
	
}
