package com.zyp.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandleNameSelectActivity extends AppCompatActivity {

    private String mItemSelectTextString;
    private int mItemSelectPositionInt;

    private TextView mTextViewItemSelect;
    private Button mButtonClickAffirm;
    private Button mButtonClickCancel;

    public static final String ITEM_POSITION = "ITEM_SELECT_POSITION";
    public static final String ITEM_SELECT_TEXT = "ITEM_SELECT_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_name_select);
        Intent mIntent = getIntent();
        mItemSelectTextString = mIntent.getStringExtra(ITEM_SELECT_TEXT);
        mItemSelectPositionInt = mIntent.getIntExtra(ITEM_POSITION, 0);
        init();
        mTextViewItemSelect.setText("删除 " + mItemSelectTextString + " 的记录吗？");
        mButtonClickAffirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                mIntent.putExtra(ITEM_POSITION, mItemSelectPositionInt);
                setResult(RESULT_OK, mIntent);
                finish();
            }
        });
        mButtonClickCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                setResult(RESULT_CANCELED, mIntent);
                finish();
            }
        });

    }

    private void init() {
        mTextViewItemSelect = (TextView) findViewById(R.id.text_view_item_select);
        mButtonClickAffirm = (Button) findViewById(R.id.btn_click_affirm);
        mButtonClickCancel = (Button) findViewById(R.id.btn_click_cancel);
    }
}
