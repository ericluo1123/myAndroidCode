package com.teamsourcing.LoongyeeApp.Switchs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import com.teamsourcing.LoongyeeApp.Switchs.adapter.Keyadapter;
import com.teamsourcing.LoongyeeApp.model.SwitchModel;
//import com.teamsourcing.LoongyeeApp.telnet.telnetservice;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Chris
 * Date: 2013/12/16
 * Time: 上午 9:17
 * To change this template use File | Settings | File Templates.
 */
public class SwitchsKey extends Activity {
    private ListView KeyList;
    private Keyadapter Keyadapter;
    private List<SwitchModel> allSwitch = new ArrayList<SwitchModel>();

    @Override
    public void onCreate(Bundle savedInstanceState) {



    }


}
