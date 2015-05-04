package com.ditaoktaria.classic;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;


public class ManageMaterials extends ActionBarActivity {
    private ListView material_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_materials);

        this.material_list = (ListView) this.findViewById(R.id.material_list);

        new getAllCourseTask().execute(new ApiConnectorCourse());
       /* String[] list_values = new String []{
                "Algoritma Evolusi","Keamanan Jaringan","Pengembangan Aplikasi Perangkat Bergerak"
        };
        ArrayAdapter<String> list_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list_values);

        material_list.setAdapter(list_adapter);
        */

        Button ac = (Button) findViewById(R.id.bt_account);
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), EditAccount.class);
                startActivityForResult(myIntent, 0);
            }
        });

    }

    public void setListAdapter(JSONArray jsonArray){
        this.material_list.setAdapter(new CourseListViewAdapter(jsonArray,this));
    }

    private class getAllCourseTask extends AsyncTask<ApiConnector,Long,JSONArray>
    {
        protected JSONArray doInBackground(ApiConnector... params) {
            // it is executed on Background thread
            return  params[0].GetAllLecturers();
        }
        protected void onPostExecute(JSONArray jsonArray){
            setListAdapter(jsonArray);
        }

        //iko di tutorial idak ado, tapi kalo iko di hapus, error
        public void execute(ApiConnectorCourse apiConnectorCourse) {
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_materials, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
