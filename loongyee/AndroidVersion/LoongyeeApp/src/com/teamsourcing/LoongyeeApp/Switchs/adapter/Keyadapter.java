package com.teamsourcing.LoongyeeApp.Switchs.adapter;


import android.view.LayoutInflater;
import com.teamsourcing.LoongyeeApp.main.R;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.teamsourcing.LoongyeeApp.model.SwitchModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Chris
 * Date: 2013/12/16
 * Time: 上午 9:21
 * To change this template use File | Settings | File Templates.
 */
public class Keyadapter extends BaseAdapter {


    private List<SwitchModel> listItems;
    private LayoutInflater listInflater;


    public List<SwitchModel> getListItems() {
        return listItems;
    }


    @Override
    public long getItemId(int i) {
        return i;  //To change body of implemented methods use File | Settings | File Templates.
    }
    @Override
    public Object getItem(int i) {
        return listItems.get(i);  //To change body of implemented methods use File | Settings | File Templates.
    }
    @Override
    public int getCount() {
        return listItems.size();  //To change body of implemented methods use File | Settings | File Templates.
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = this.listInflater.inflate(R.layout.listviewswitch, null);
        TextView keyswitchs = (TextView)convertView.findViewById(R.id.keyswitch);
        final SwitchModel entity = (SwitchModel)this.listItems.get(position);

        return convertView;
    }
}
