package org.demo.simpledemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends Activity {

    static final String HTML =
            "<!DOCTYPE html><html><body>\n" +
            "<select>\n" +
            "  <option value=\"volvo\">Volvo</option>\n" +
            "  <option value=\"saab\">Saab</option>\n" +
            "  <option value=\"opel\">Opel</option>\n" +
            "</select>\n" +
            "</body></html>";

    SystemUiHider _systemUiHider;

    WebView _webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _systemUiHider = new SystemUiHider(getWindow());

        _webView = new WebView(this);
        _webView.loadData(HTML, "text/html", "UTF-8");

        setContentView(_webView);
    }

}
