package com.ditaoktaria.classic;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.String;


public class MainActivity extends ActionBarActivity {

    private TextView responseTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.enableDefaults();
        responseTextView = (TextView) this.findViewById(R.id.responseTextView);

        //new GetAllLecturerTask().execute(new ApiConnector());

        Button wv = (Button) findViewById(R.id.button_wv);
        wv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(),com.ditaoktaria.classic.pdfplayer.class);
                startActivityForResult(myIntent,0);
            }
        });

        Button hm = (Button) findViewById(R.id.bt_home_materials);
        hm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent2 = new Intent(v.getContext(), ManageMaterials.class);
                startActivityForResult(myIntent2, 0);
            }
        });

    }

    public void setTextToTextView(JSONArray jsonArray)
    {
        String s = "";
        for (int i=0; i<jsonArray.length();i++) {

        JSONObject json = null;
        try {
            json = jsonArray.getJSONObject(i);
            s= s+
                    "id lecturer "+json.getInt("idLecturer")+"\n"+
                    "username : "+json.getString("username")+"\n"+
                    "full name : "+json.getString("fullName")+"\n\n";
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
        this.responseTextView.setText(s);
    }


    private class GetAllLecturerTask extends AsyncTask<ApiConnector,Long,JSONArray>
    {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            //it is executed on Background thread
            return params[0].GetAllLecturers();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            setTextToTextView(jsonArray);
        }
    }

}
