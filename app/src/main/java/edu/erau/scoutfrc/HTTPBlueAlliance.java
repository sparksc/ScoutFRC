package edu.erau.scoutfrc;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class borrows heavily from The Blue Alliance (link found below) to connect and GET data from
 * The Blue Alliance website. This class is called upon anytime a GET request is to be made.
 *
 * To use: HTTPBlueAlliance.GET(url). All other methods within the class are used by the GET() method
 * to complete the request and add the appropriate headers.
 *
 * Source: https://github.com/the-blue-alliance/the-blue-alliance-android/blob/master/android/src/main/java/com/thebluealliance/androidclient/datafeed/HTTP.java
 * Created by Cierra Sparks on 4/20/2015.
 */
public class HTTPBlueAlliance {

    /**
     * Retrieves a response from The Blue Alliance using the provided url and later ensures the
     * appropriate headers are used with the GET request.
     *
     * @param url - the request url to retrieve information from
     * @return a formatted String of the response
     */
    public static String GET(String url) {
        HttpResponse response = getRequest(url);
        if (response == null) return null;

        return dataFromResponse(response);
    }

    /**
     * Takes in the url provided by the user and gets a new request that was not previously updated.
     * @param url - the url to GET data from
     * @return an HttpResponse that executes the httpGet request
     */
    private static HttpResponse getRequest(String url) {
        return getRequest(url, null);
    }

    /**
     * Takes in the url provided by the user and gets a new request that was not previously updated.
     * @param url - the url to GET data from
     * @param lastUpdated
     * @return an HttpResponse that executes the httpGet request
     */
    private static HttpResponse getRequest(String url, String lastUpdated) {
        // HTTP
        try {
            HttpClient httpclient = new DefaultHttpClient(); // for port 80 requests!
            HttpGet httpget = new HttpGet(url);
            httpget.addHeader("X-TBA-App-Id", "frc48:scouting-system:v" + BuildConfig.VERSION_NAME.replace(":", ""));
            if (lastUpdated != null) {
                httpget.addHeader("If-Modified-Since", lastUpdated);
            }
            return httpclient.execute(httpget);
        } catch (Exception e) {
            Log.w("tba-android", "Exception while fetching " + url);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads the content found from the response and stores the content into a String.
     *
     * @param response - an HttpResponse that executed the httpGet request
     * @return the response of the content found at the provided url
     */
    private static String dataFromResponse(HttpResponse response) {
        InputStream is;
        String result = "";
        // Read response to string
        if (response != null) {
            try {
                HttpEntity entity = response.getEntity();

                is = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                is.close();
                result = sb.toString();
                return result;
            } catch (Exception e) {
                Log.w("tba-android", "Exception while fetching data from " + response.toString());
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
