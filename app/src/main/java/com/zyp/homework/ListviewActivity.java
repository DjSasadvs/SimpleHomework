package com.zyp.homework;

import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import adapters.ListViewAdapter;
import utils.Utility;

public class ListviewActivity extends AppCompatActivity {

    private TextView mTextViewShowSelect;
    private ListView mListViewCourse;
    private Button mButtonNext;
    private ListViewAdapter mListViewAdapter;

    private static final int ITEM1 = Menu.FIRST;
    private static final int ITEM2 = Menu.FIRST + 1;
    private static final int ITEM3 = Menu.FIRST + 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        init();
        mListViewAdapter = new ListViewAdapter(this, getResources().getStringArray(R.array.list_view_items), getResources().getString(R.string.list_view_course));
        mListViewCourse.setAdapter(mListViewAdapter);
        Utility.setListViewHeightBasedOnChildren(mListViewCourse);
        /*mTextViewShowSelect.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                return true;
            }
        });*/
        registerForContextMenu(mTextViewShowSelect);
        mListViewCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mTextViewShowSelect.setText(mListViewAdapter.getItem(position).toString());
            }
        });
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListviewActivity.this, NameActivity.class);
                startActivity(intent);
            }
        });
    }

    /*@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mTextViewShowSelect.setText(((ListViewAdapter) getListAdapter()).getItem(position).toString());
    }*/

    private void init() {
        mTextViewShowSelect = (TextView) findViewById(R.id.text_view_show_select);
        mListViewCourse = (ListView) findViewById(R.id.list_view_course);
        mButtonNext = (Button) findViewById(R.id.btn_next);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("快捷菜单标题");
        menu.add(0, ITEM1, 0, R.string.copy);
        menu.add(0, ITEM2, 0, R.string.paste);
        menu.add(0, ITEM3, 0, R.string.cancel);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                mTextViewShowSelect.setText("您选则了快捷菜单：" + item.getTitle().toString());
                break;
        }
        return super.onContextItemSelected(item);
    }

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
                mTextViewShowSelect.setText("您选则了选项菜单：" + item.getTitle().toString());
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}

