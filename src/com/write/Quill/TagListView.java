package com.write.Quill;

import com.write.Quill.TagManager.TagSet;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class TagListView extends RelativeLayout {
	private static final String TAG = "TagsListView";

	protected Context context;
	protected View layout;
	protected TagSetAdapter adapter = null;
	protected ListView list;
	protected EditText edittext;

	public TagListView(Context mContext, AttributeSet attrs) {
		super(mContext, attrs);
		context = mContext;
		createLayout(context);
	}

	public TagListView(Context mContext) {
		super(mContext);
		context = mContext;
		createLayout(context);
	}
	
	private void createLayout(Context context) {
		Log.d(TAG, "created layout");
		LayoutInflater layoutInflater = (LayoutInflater)
			context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layout = layoutInflater.inflate(R.layout.tag_list, this);
        list = (ListView) findViewById(R.id.tag_list);     
        edittext = (EditText) findViewById(R.id.tag_text);	
    }

	public void setTagSet(TagSet tags) {
        Log.d(TAG, "setTagSet");

		adapter = new TagSetAdapter(context, tags);
        Log.d("adapter size", String.format("%d",adapter.getCount()));
        list.setOnItemClickListener(adapter);
        list.setAdapter(adapter);
        list.setOnItemClickListener(adapter);
        edittext.setOnKeyListener(adapter);
	}
	
}
