package com.linheimx.app.mpandroidchartplus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.linheimx.app.mpandroidchartplus.fragments.charts.LineChartFragment;
import com.linheimx.app.mpandroidchartplus.fragments.list.ItemFragment;
import com.linheimx.app.mpandroidchartplus.fragments.list.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // list
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.activity_main, ItemFragment.newInstance(1));
        ft.commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Fragment fragment = null;

        switch (item.content) {
            case DummyContent.TITLE_0:
                fragment = new LineChartFragment();  // 折线图：测试用
                break;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.activity_main, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
