package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zyp.homework.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/27.
 */
public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private String[] texts;
    private String tagString;
    private List<Map<String, Object>> mList;

    private ListCourse mListCourse = null;

    public ListViewAdapter(Context context, String[] texts, String tagString) {
        super();
        this.context = context;
        this.texts = texts;
        this.tagString = tagString;
        mLayoutInflater = LayoutInflater.from(this.context);
    }

    public ListViewAdapter(Context context, List<Map<String, Object>> mList, String tagString) {
        super();
        this.context = context;
        this.mList = mList;
        this.tagString = tagString;
        mLayoutInflater = LayoutInflater.from(this.context);
    }

    // 获得长度，一般返回数据的长度即可
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return tagString.toString().equals("ListViewCourse") ? texts.length : mList.size();

    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return tagString.toString().equals("ListViewCourse") ? texts[position] : (String) mList.get(position).get("tittle");
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        // convertView对象就是item的界面对象，只有为空的时候我们才需要重新赋值一次，这样可以提高效率，如果有这个对象的话，系统会自动复用
        if (convertView == null) {
            if (tagString.toString().equals("ListViewCourse")) {
                convertView = mLayoutInflater.inflate(R.layout.list_view_course, null);
                mListCourse = new ListCourse();
                mListCourse.mCourseTextView = (TextView) convertView.findViewById(R.id.text_view_course);
                convertView.setTag(mListCourse);
            } else if (tagString.toString().equals("ListViewName")) {
                convertView = mLayoutInflater.inflate(R.layout.list_view_course, null);
                mListCourse = new ListCourse();
                mListCourse.mCourseTextView = (TextView) convertView.findViewById(R.id.text_view_course);
                convertView.setTag(mListCourse);
            }
        }
        if (mListCourse != null) {
            mListCourse = (ListCourse) convertView.getTag();
            // 设置文本和图片，然后返回这个View，用于ListView的Item的展示
            if (tagString.toString().equals("ListViewCourse")) {
                mListCourse.mCourseTextView.setText(texts[position]);
                // mThingReleaseList.mImgView.setImageResource(R.drawable.ic_action_next_item);
            } else if (tagString.toString().equals("ListViewName")) {
                mListCourse.mCourseTextView.setText((String) mList.get(position).get("tittle").toString());
                // mThingReleaseList.mImgView.setImageResource(R.drawable.ic_action_next_item);
            }
        }
        return convertView;
    }

    // list_view_course.xml布局里的对象
    private static class ListCourse {
        private TextView mCourseTextView;
    }

}
