package com.zyp.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapters.ListViewAdapter;

public class NameActivity extends AppCompatActivity {

    private ListView mListViewName;
    private ListViewAdapter mListViewAdapter;

    private static final int ITEM_SELECT_REQUEST = 1;

    private List<Map<String, Object>> mListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        init();
        //mListViewAdapter = new ListViewAdapter(this, getResources().getStringArray(R.array.list_view_name), getResources().getString(R.string.list_view_name));
        //mListViewAdapter = new ListViewAdapter(this, name_array, getResources().getString(R.string.list_view_name));
        mListViewAdapter = new ListViewAdapter(this, mListData, getResources().getString(R.string.list_view_name));
        mListViewName.setAdapter(mListViewAdapter);
        mListViewName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent();
                mIntent.putExtra(HandleNameSelectActivity.ITEM_SELECT_TEXT, mListViewAdapter.getItem(position).toString());
                mIntent.putExtra(HandleNameSelectActivity.ITEM_POSITION, position);
                Log.d("item_select_text", mListViewAdapter.getItem(position).toString());
                mIntent.setClass(NameActivity.this, HandleNameSelectActivity.class);
                startActivityForResult(mIntent, ITEM_SELECT_REQUEST);
            }
        });
    }

    private void init() {
        mListData = setData();
        mListViewName = (ListView) findViewById(R.id.list_view_name);
    }

    private List<Map<String, Object>> setData() {

        List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tittle", "张三");
        mList.add(map);
        map = new HashMap<String, Object>();
        map.put("tittle", "李四");
        mList.add(map);
        map = new HashMap<String, Object>();
        map.put("tittle", "王二");
        mList.add(map);
        map = new HashMap<String, Object>();
        map.put("tittle", "赵五");
        mList.add(map);
        return mList;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case ITEM_SELECT_REQUEST:
                if (resultCode == RESULT_OK) {
                    mListData.remove(data.getIntExtra(HandleNameSelectActivity.ITEM_POSITION, 0));
                    mListViewAdapter.notifyDataSetChanged();
                    mListViewName.invalidate();
                }
                break;
            default:
                break;
        }
    }
}
