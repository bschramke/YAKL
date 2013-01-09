package de.coolbytes.android.yakl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.charset.MalformedInputException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Björn Schramke
 *
 */
public class XmlFeed {

	private InputStream _feedStream = null;

	/**
	 * @param src
	 */
	public XmlFeed(InputStream src) {
		_feedStream = src;
	}

	/**
	 * @throws IOException, URISyntaxException
	 */
	public void parse() throws IOException, URISyntaxException {
		parse(getFeedSource(),new XmlFeedHandler());
	}

	/**
	 * @param src
	 * @throws IOException, URISyntaxException
	 */
	protected void parse(InputSource src,DefaultHandler handler) throws IOException, URISyntaxException {
		
		try {
			SAXParser sp = SAXParserFactory.newInstance().newSAXParser();
			
			sp.parse(src,handler);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected InputStream getFeedStream(){
		return _feedStream;
	}

	protected InputSource getFeedSource(){
		return new InputSource(this._feedStream);
	}

}
