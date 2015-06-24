package com.example.listview_selectall;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity {
	ListView lv;
	CheckBox selectall;
	
	String[] gadgets = { "Laptop", "Tablet", "Mobile", "Desktop", "Keyboard","Mouse", "Hard Disk", "RAM", "Printer" };
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.listView1);
		selectall=(CheckBox)findViewById(R.id.checkBox1);
				
		//simple_list_item_multiple_choice - will make Listview with Multichoice Option
		ArrayAdapter<String>ad= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_multiple_choice, gadgets);
			
		lv.setAdapter(ad);
		
		//Making Listview with MultiChoice(Checkbox)
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		
		selectall.setOnCheckedChangeListener(new OnCheckedChangeListener() 
		{
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) 
			{
					// TODO Auto-generated method stub
					int itemCount = lv.getCount();
					for (int i = 0; i < itemCount; i++) 
					{
						//lv.setItemChecked(position, value)
						lv.setItemChecked(i, selectall.isChecked());
					}
		
				
			}
		});
	}
}