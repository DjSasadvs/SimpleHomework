package com.zyp.homework;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import adapters.ListViewAdapter;
import utils.Utility;

public class ListviewActivity extends AppCompatActivity {

    private TextView mTextViewShowSelect;
    private ListView mListViewCourse;
    private ListViewAdapter mListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        init();
        mListViewAdapter = new ListViewAdapter(this, getResources().getStringArray(R.array.list_view_items), getResources().getString(R.string.list_view_course));
        mListViewCourse.setAdapter(mListViewAdapter);
        Utility.setListViewHeightBasedOnChildren(mListViewCourse);
        mTextViewShowSelect.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
        mListViewCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mTextViewShowSelect.setText(mListViewAdapter.getItem(position).toString());
            }
        });
    }

    /*@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mTextViewShowSelect.setText(((ListViewAdapter) getListAdapter()).getItem(position).toString());
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_list, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_exit:
                //android.os.Process.killProcess(android.os.Process.myPid());
                this.finish();
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        mTextViewShowSelect = (TextView) findViewById(R.id.text_view_show_select);
        mListViewCourse = (ListView) findViewById(R.id.list_view_course);
    }
}

