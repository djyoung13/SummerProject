
package ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BrotherJuniperImplService", targetNamespace = "http://ws/", wsdlLocation = "http://localhost:8000/ws/BrotherJuniper?wsdl")
public class BrotherJuniperImplService
    extends Service
{

    private final static URL BROTHERJUNIPERIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException BROTHERJUNIPERIMPLSERVICE_EXCEPTION;
    private final static QName BROTHERJUNIPERIMPLSERVICE_QNAME = new QName("http://ws/", "BrotherJuniperImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8000/ws/BrotherJuniper?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BROTHERJUNIPERIMPLSERVICE_WSDL_LOCATION = url;
        BROTHERJUNIPERIMPLSERVICE_EXCEPTION = e;
    }

    public BrotherJuniperImplService() {
        super(__getWsdlLocation(), BROTHERJUNIPERIMPLSERVICE_QNAME);
    }

    public BrotherJuniperImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BROTHERJUNIPERIMPLSERVICE_QNAME, features);
    }

    public BrotherJuniperImplService(URL wsdlLocation) {
        super(wsdlLocation, BROTHERJUNIPERIMPLSERVICE_QNAME);
    }

    public BrotherJuniperImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BROTHERJUNIPERIMPLSERVICE_QNAME, features);
    }

    public BrotherJuniperImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BrotherJuniperImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BrotherJuniper
     */
    @WebEndpoint(name = "BrotherJuniperImplPort")
    public BrotherJuniper getBrotherJuniperImplPort() {
        return super.getPort(new QName("http://ws/", "BrotherJuniperImplPort"), BrotherJuniper.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BrotherJuniper
     */
    @WebEndpoint(name = "BrotherJuniperImplPort")
    public BrotherJuniper getBrotherJuniperImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws/", "BrotherJuniperImplPort"), BrotherJuniper.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BROTHERJUNIPERIMPLSERVICE_EXCEPTION!= null) {
            throw BROTHERJUNIPERIMPLSERVICE_EXCEPTION;
        }
        return BROTHERJUNIPERIMPLSERVICE_WSDL_LOCATION;
    }

}
