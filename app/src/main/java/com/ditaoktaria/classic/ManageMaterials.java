package com.ditaoktaria.classic;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ManageMaterials extends ActionBarActivity {
    private ListView material_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_materials);

        this.material_list = (ListView) this.findViewById(R.id.material_list);
        String[] list_values = new String []{
                "Algoritma Evolusi","Keamanan Jaringan","Pengembangan Aplikasi Perangkat Bergerak"
        };
        ArrayAdapter<String> list_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list_values);

        material_list.setAdapter(list_adapter);

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
