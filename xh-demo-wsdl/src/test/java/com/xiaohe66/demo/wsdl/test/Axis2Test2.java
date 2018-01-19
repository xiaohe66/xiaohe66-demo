package com.xiaohe66.demo.wsdl.test;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.junit.Test;

/**
 * @author xh
 * @date 2017-12-12
 */
public class Axis2Test2 {

    private static final String WSDL_URL = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl";
    private static final String NAME_SPACE = "http://WebXml.com.cn/";
    private static final String OPTIONS_ACTION = "http://WebXml.com.cn/getMobileCodeInfo";
    private static final String METHOD_NAME = "getMobileCodeInfo";
    private static final String[] PARAM_NAME = new String[]{"mobileCode"};
    private static final String[] PARAM_VALUE =  new String[]{"15218904445"};

    @Test
    public void test1(){

        System.setProperty("http.proxyHost", "localhost");
        System.setProperty("http.proxyPort", "8888");
        try {
            invoke();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }

    public void invoke() throws AxisFault {
        EndpointReference targetEPR = new EndpointReference(WSDL_URL);
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(NAME_SPACE, "");

        ServiceClient sender = new ServiceClient();

        //选项
        Options options = new Options();
        options.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
        //options.setSoapVersionURI(action);
        options.setAction(OPTIONS_ACTION);
        options.setTo(targetEPR);
        options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
        options.setProperty(HTTPConstants.CHUNKED, "false");//设置不受限制.
//        options.setProperty(HTTPConstants.PROXY, buildProxy());
        options.setProperty(Constants.Configuration.HTTP_METHOD, HTTPConstants.HTTP_METHOD_POST);

        sender.setOptions(options);


        //参数
        OMElement data = fac.createOMElement(METHOD_NAME, omNs);
        for (int i = 0; i < PARAM_NAME.length; i++) {
            OMElement inner = fac.createOMElement(PARAM_NAME[i], omNs);
            inner.setText(PARAM_VALUE[i]);
            data.addChild(inner);
        }

        //send
        OMElement result = sender.sendReceive(data);

        System.out.println(result);
    }

    /*public HttpTransportProperties.ProxyProperties buildProxy() {
        HttpTransportProperties.ProxyProperties proxyProperties = new HttpTransportProperties.ProxyProperties();
        proxyProperties.setProxyName("172.19.18.22");
        proxyProperties.setProxyPort(8080);
        return proxyProperties;
    }*/

}
