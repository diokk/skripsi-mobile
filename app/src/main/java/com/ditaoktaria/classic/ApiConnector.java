package com.ditaoktaria.classic;

import android.util.Log;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ditaoktaria on 4/13/15.
 */
public class ApiConnector {

    public JSONArray GetAllCourses() {
        // TODO: Can you move my previous get remote data code?
        // You just need to modify the url to make it works.
        // With assumptions, that all your API List call will
        // return JSONArray. Just move it here.
        // If something bad happened in the middle of the process,
        // this method should return null.
        //iko _url emang null? Iyap, kan diisinyo di dalam try .. catch.
        // I
        // ko lah pasti jalan harusnya Dit.
        String url = "http://192.168.56.1/classicdevel/server/getAllCourses.php";

        URL _url = null;
        HttpURLConnection connection = null;

        try {
            _url = new URL(url);

            connection = (HttpURLConnection) _url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String data = "";
            String line = null;
            while((line = reader.readLine()) != null) {
                data += line;
            }

            Log.d("skripsi-client", data);

            JSONArray response = new JSONArray(data);
            return response;
        }
        catch (Exception ex) {
            Log.d("skripsi-client", "Exception: " + ex.getMessage());
        }

        return null;
    }

    public JSONArray GetAllLecturers()
    {
        //URL for getting all lecturers

        String url = "http://10.0.0.61/classic/getAllLecturers.php";

        // Get HttpResponse Object from URL.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try
        {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();

        } catch (ClientProtocolException e) {
            // signals error in http protocol
            e.printStackTrace();

            // Log Errors here

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert HttpEntity into JSON Array
        JSONArray jsonArray = null;

        if (httpEntity !=null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);
                Log.e("Entity Response : ", entityResponse);
                jsonArray = new JSONArray(entityResponse);

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return jsonArray;

    }

}
