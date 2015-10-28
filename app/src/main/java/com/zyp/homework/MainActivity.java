package com.zyp.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextName;
    private RadioGroup mRadioGroupSex;
    private RadioButton mRadioButtonSex;
    private Spinner mSpinnerMajor;
    private CheckBox mCheckBoxMusic;
    private CheckBox mCheckBoxSport;
    private CheckBox mCheckBoxSwim;
    private CheckBox mCheckBoxReading;
    private Button mButtonCancel;
    private Button mButtonSubmit;
    private Button mButtonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextName.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "请输入您的姓名！", Toast.LENGTH_LONG).show();
                else {
                    String str = "";
                    str += "你好，" + mEditTextName.getText().toString() + "!\n你的性别是：";
                    mRadioButtonSex = (RadioButton) findViewById(mRadioGroupSex.getCheckedRadioButtonId());
                    str += mRadioButtonSex.getText().toString() + "!\n你的专业是" + mSpinnerMajor.getSelectedItem().toString() + "!\n你的个人爱好有：";
                    if (mCheckBoxMusic.isChecked())
                        str += "音乐，";
                    if (mCheckBoxReading.isChecked())
                        str += "读书，";
                    if (mCheckBoxSwim.isChecked())
                        str += "游泳，";
                    if (mCheckBoxSport.isChecked())
                        str += "运动，";
                    if (str.endsWith("，"))
                        str = str.substring(0, str.length() - 1);
                    str += "!";
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
                }

            }
        });
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListviewActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
    }

    /*初始化*/
    private void init() {
        mEditTextName = (EditText) findViewById(R.id.edit_text_name);
        mRadioGroupSex = (RadioGroup) findViewById(R.id.radio_group_sex);
        mSpinnerMajor = (Spinner) findViewById(R.id.spinner_major);
        mCheckBoxMusic = (CheckBox) findViewById(R.id.check_box_music);
        mCheckBoxSport = (CheckBox) findViewById(R.id.check_box_sport);
        mCheckBoxSwim = (CheckBox) findViewById(R.id.check_box_swim);
        mCheckBoxReading = (CheckBox) findViewById(R.id.check_box_reading);
        mButtonCancel = (Button) findViewById(R.id.btn_cancel);
        mButtonSubmit = (Button) findViewById(R.id.btn_submit);
        mButtonNext = (Button) findViewById(R.id.btn_next);
    }

}

