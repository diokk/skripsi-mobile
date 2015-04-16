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

import java.io.IOException;

/**
 * Created by ditaoktaria on 4/13/15.
 */
public class ApiConnector {

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
