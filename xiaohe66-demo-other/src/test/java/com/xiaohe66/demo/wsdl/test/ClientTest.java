/*
package com.xh.demo.wsdl.test;

import org.codehaus.xfire.client.Client;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

*/
/**
 * @author xh
 * @date 2017-12-8
 *//*

public class ClientTest {


    @Test
    public void test1() {
        Client client = null;
        try {
            String url = "http://111.121.126.226:10001/gzwsp/services/QryUserInfoServices?wsdl";
            client = new Client(new URL(url));

            Object[] result1 = client.invoke("qryUserInfo", new Object[]{"{\"qryType\":\"1\",\"qryValue\":\"cj_grl\",\"appCode\":\"GZW_002\"}"});
            String rt = URLDecoder.decode("" + result1[0], "utf-8");
            System.out.println(rt);

//            JSONObject jsonObject = JSONObject.fromString(rt);
//            String result = jsonObject.getString("result");
//            System.out.println("result＝" + result);
//            JSONObject userInfoObject = jsonObject.getJSONObject("userInfo");
//            System.out.println("telphone＝" + userInfoObject.getString("telphone"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void xFireTest2() throws Exception{
        System.setProperty("http.proxyHost", "192.168.8.100");
        System.setProperty("https.proxyHost", "192.168.8.100");
        System.setProperty("http.proxyPort", "8888");
        System.setProperty("https.proxyPort", "8888");
        String wsdlUrl = "http://www.webservicex.com/globalweather.asmx?WSDL";
        URL url = new URL(wsdlUrl);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.connect();
        Client client = new Client(connection.getInputStream(), (Class)null);
        client.setProperty("disable-keep-alive", "true");
        client.setProperty("disable.expect-continue", "true");
        client.setUrl(wsdlUrl);
        String[] params = new String[]{"China"};
        Object[] result = client.invoke("GetCitiesByCountry",params);
        String resultStr = result[0].toString();
        System.out.println(resultStr);
    }

}
*/
