package com.home.homelinus;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.util.Log;

public class XMLParser {


	// constructor
	public XMLParser() {

	}

	/**
	 * Getting XML from URL making HTTP request
	 * @param url string
	 * */
	public String getXmlFromUrl(String url) {
		String xml = null;

		try {
			// defaultHttpClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			
			//by post not working.
//			HttpPost httpPost = new HttpPost(url);
//			HttpResponse httpResponse = httpClient.execute(httpPost);
			
			//by get works.!
	        HttpGet httpget = new HttpGet(url);
	        HttpResponse httpResponse = httpClient.execute(httpget);
			
			HttpEntity httpEntity = httpResponse.getEntity();
			xml = EntityUtils.toString(httpEntity);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// return XML
		return xml;
	}
	
    public ArrayList<String> parsexml(InputStream inputS, String XPathexp, int type) {
        ArrayList<String> devicelist = new ArrayList<String>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();

            Document doc = builder.parse(inputS);
            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();
            // 选取所有class元素的name属性
            // XPath语法介绍： http://w3school.com.cn/xpath/
            XPathExpression expr = xpath.compile(XPathexp);
            NodeList nodes = (NodeList) expr.evaluate(doc,
                    XPathConstants.NODESET);
            switch (type) {
            
            case R.integer.text: 
                for (int i = 0; i < nodes.getLength(); i++) {
                    Log.v("devon",
                            "devon MediaDevice xml parserser "
                                    + nodes.item(i).getNodeValue() + " "
                                    + nodes.getLength() + " "
                                    + nodes.item(i).getNodeName() + " "
                                    + nodes.item(i).getTextContent());
                    devicelist.add(nodes.item(i).getTextContent());
                }
                break;
            case R.integer.attr:
                for (int i = 0; i < nodes.getLength(); i++) {
                    Log.v("devon",
                            "devon MediaDevice xml parserser "
                                    + nodes.item(i).getNodeValue() + " "
                                    + nodes.getLength() + " "
                                    + nodes.item(i).getNodeName() + " "
                                    + nodes.item(i).getTextContent());
                    devicelist.add(nodes.item(i).getNodeValue());
                }
                break;
            default:
                for (int i = 0; i < nodes.getLength(); i++) {
                    Log.v("devon",
                            "devon MediaDevice xml parserser "
                                    + nodes.item(i).getNodeValue() + " "
                                    + nodes.getLength() + " "
                                    + nodes.item(i).getNodeName() + " "
                                    + nodes.item(i).getTextContent());
                    devicelist.add(nodes.item(i).getNodeName());
                }
                break;
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return devicelist;
    }
}
