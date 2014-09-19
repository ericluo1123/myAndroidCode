package com.teamsourcing.LoongyeeApp.main;

import android.view.View;
import android.widget.ListView;

/**
 * Created by teamsourcing on 2014/4/17.
 */
public interface DragListener {

    void onStopDrag(View itemView);
    void onStartDrag(View itemView);
    void onDrag(int x, int y, ListView listView);
}
