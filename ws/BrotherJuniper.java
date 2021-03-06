
package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BrotherJuniper", targetNamespace = "http://ws/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BrotherJuniper {


    /**
     * 
     * @param arg0
     * @return
     *     returns ws.ArrayList
     * @throws ClassNotFoundException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://ws/BrotherJuniper/retrieveBJOrderRequest", output = "http://ws/BrotherJuniper/retrieveBJOrderResponse", fault = {
        @FaultAction(className = ClassNotFoundException_Exception.class, value = "http://ws/BrotherJuniper/retrieveBJOrder/Fault/ClassNotFoundException")
    })
    public ArrayList retrieveBJOrder(
        @WebParam(name = "arg0", partName = "arg0")
        Order arg0)
        throws ClassNotFoundException_Exception
    ;

}
