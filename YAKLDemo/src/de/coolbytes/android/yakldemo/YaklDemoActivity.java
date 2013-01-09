/**
 * Copyright 2012 Björn Schramke - http://www.coolbytes.de/
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.coolbytes.android.yakldemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

import de.coolbytes.android.yakl.kml.KmlFeed;

public class YaklDemoActivity extends Activity {
	private static final String TAG = YaklDemoActivity.class.getSimpleName();
	
	private static final String _feedUrl = "http://feeds.feedburner.com/mobile-tuts-summary?format=xml";
	private TextView mLogText;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yakl_demo);
        
        this.mLogText = (TextView)findViewById(R.id.logText);
        
        try {
            this.mLogText.append("Try to load placemark.kml from assets\n");   
            InputStream is = getResources().getAssets().open("placemark.kml");        	
            KmlFeed feed = new KmlFeed(is);
            this.mLogText.append("Try to parse KML-Data from placemark.kml\n");
			feed.parse();
//			feed.getData();
			
            this.mLogText.append("Try to load sample.kml from assets\n");   
			is = getResources().getAssets().open("sample.kml");        	
            feed = new KmlFeed(is);
            this.mLogText.append("Try to parse KML-Data from sample.kml\n");
			feed.parse();
//
//            this.mLogText.append("Try to load KML_Samples.kml from assets\n");   
//            is = getResources().getAssets().open("KML_Samples.kml");        	
//            feed = new KmlFeed(is);
//            this.mLogText.append("Try to parse KML-Data from KML_Samples.kml\n");
//			feed.parse();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_yakl_demo, menu);
        return true;
    }
}
