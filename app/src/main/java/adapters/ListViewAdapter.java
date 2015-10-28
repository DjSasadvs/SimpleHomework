package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyp.homework.R;

/**
 * Created by Administrator on 2015/10/27.
 */
public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private String[] texts;
    private String tagString;

    private ListCourse mListCourse = null;

    public ListViewAdapter(Context context, String[] texts, String tagString)
    {
        super();
        this.context = context;
        this.texts = texts;
        this.tagString = tagString;
        mLayoutInflater = LayoutInflater.from(this.context);
    }

    // 获得长度，一般返回数据的长度即可
    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return texts.length;
    }

    @Override
    public Object getItem(int position)
    {
        // TODO Auto-generated method stub
        return texts[position];
    }

    @Override
    public long getItemId(int position)
    {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        // convertView对象就是item的界面对象，只有为空的时候我们才需要重新赋值一次，这样可以提高效率，如果有这个对象的话，系统会自动复用
        if (convertView == null)
        {
            if (tagString.toString().equals("ListViewCourse") || convertView != null)
            {
                convertView = mLayoutInflater.inflate(R.layout.list_view_course, null);
                mListCourse = new ListCourse();
                mListCourse.mThingTextView = (TextView) convertView.findViewById(R.id.text_view_course);
                convertView.setTag(mListCourse);
            }
        }
        if (mListCourse != null)
        {
            mListCourse = (ListCourse) convertView.getTag();
            // 设置文本和图片，然后返回这个View，用于ListView的Item的展示
            mListCourse.mThingTextView.setText(texts[position]);
            // mThingReleaseList.mImgView.setImageResource(R.drawable.ic_action_next_item);
        }
        return convertView;
    }

    // list_view_course.xml布局里的对象
    private static class ListCourse
    {
        private TextView mThingTextView;
    }

}
