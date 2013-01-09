package de.coolbytes.android.yakl.kml;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

import de.coolbytes.android.yakl.XmlFeed;

public class KmlFeed extends XmlFeed {

	private List<KmlObject> mData = null;
	
	public KmlFeed(InputStream src) {
		super(src);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see de.init.android.xml.XmlFeed#parse()
	 */
	@Override
	public void parse() throws IOException, URISyntaxException {
		parse(getFeedSource(),new KmlFeedHandler());
	}

	protected void parse(InputSource src, KmlFeedHandler handler)
			throws IOException, URISyntaxException {
		super.parse(src, handler);
		mData = handler.getData();
	}

	public List<KmlObject> getData(){
		return mData;
	}
}
