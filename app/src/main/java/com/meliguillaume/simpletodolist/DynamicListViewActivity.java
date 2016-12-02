package com.meliguillaume.simpletodolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class DynamicListViewActivity extends AppCompatActivity {

    private EditText item;
    private Button add;
    private ListView dynamicListView;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // get reference to UI widgets
        item = (EditText) findViewById(R.id.itemEditText);
        add = (Button) findViewById(R.id.addItemButton);
        dynamicListView = (ListView) findViewById(R.id.itemsListView);

        // initialize the list and add item
        list = new ArrayList<>();
        list.add("Naruto is the best anime ever");

        // initialized the arrayAdapter
        adapter = new ArrayAdapter<>(DynamicListViewActivity.this, android.R.layout.simple_list_item_1, list);

        // setting the adapter to the listView
        dynamicListView.setAdapter(adapter);


        // add item to the listView on click button (add)
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    // add editText Value to the list
                    list.add(item.getText().toString());

                    // apply changes on the adapter to refresh the listView
                    adapter.notifyDataSetChanged();

                    // clear the editText for the new Item
                    item.setText("");
                }
            });


            // delete item on the long click on the item
             dynamicListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                    // remove the item from list
                    list.remove(position);


                    // apply changes on the adapter to refresh the listView
                    adapter.notifyDataSetChanged();

                    return false;



                }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dynamic_list_view, menu);
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
