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
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.junit.Test;

import java.util.Date;

/**
 * @author xh
 * @date 2017-12-12
 */
public class Axis2Test {
    private EndpointReference targetEPR =
            new EndpointReference("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl");

    private OMFactory fac = OMAbstractFactory.getOMFactory();
    private OMNamespace omNs = fac.createOMNamespace("http://WebXml.com.cn/", "tns");



    @Test
    public void test1() throws AxisFault {
        Date start = new Date();
        System.out.println("start:" + start);
        ServiceClient sender = new ServiceClient();


        sender.setOptions(buildOptions("http://WebXml.com.cn/getWeatherbyCityName"));
        OMElement result = sender.sendReceive(buildParam("getWeatherbyCityName", new String[]{"theCityName"}, new String[]{"上海"}));

        System.out.println(result);
        Date end = new Date();
        System.out.println("end:" + end);
        System.out.println("between:" + (end.getTime() - start.getTime()));
    }

    /**
     * @return
     * @see 调用webservice得到天气预报支持的城市
     */
    public OMElement buildParam(String method, String[] arg, String[] val) {
        OMElement data = fac.createOMElement(method, omNs);
        for (int i = 0; i < arg.length; i++) {
            OMElement inner = fac.createOMElement(arg[i], omNs);
            inner.setText(val[i]);
            data.addChild(inner);
        }
        return data;

    }


    /**
     * @return
     * @see 设置连接属性
     */
    public Options buildOptions(String action) {
        Options options = new Options();
        options.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
        //options.setSoapVersionURI(action);
        options.setAction("http://WebXml.com.cn/getSupportCity");
        options.setTo(targetEPR);
        options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
        options.setProperty(HTTPConstants.CHUNKED, "false");//设置不受限制.
//        options.setProperty(HTTPConstants.PROXY, buildProxy());
        options.setProperty(Constants.Configuration.HTTP_METHOD, HTTPConstants.HTTP_METHOD_POST);
        // options.setAction(action);
        return options;

    }

    /**
     * @return
     * @see 设置代理属性
     */

    public HttpTransportProperties.ProxyProperties buildProxy() {
        HttpTransportProperties.ProxyProperties proxyProperties = new HttpTransportProperties.ProxyProperties();
        proxyProperties.setProxyName("172.19.18.22");
        proxyProperties.setProxyPort(8080);
        return proxyProperties;
    }
}
