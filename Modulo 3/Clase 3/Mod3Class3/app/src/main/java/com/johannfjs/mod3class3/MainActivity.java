package com.johannfjs.mod3class3;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.johannfjs.fragments.ColorFragment;
import com.johannfjs.fragments.DetalleFragment;
import com.johannfjs.sliding.BaseActivity;
import com.johannfjs.sliding.SampleListFragment;


public class MainActivity extends BaseActivity {
    private Fragment mContent;

    public MainActivity() {
        super(R.string.app_name);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null)
            mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
        if (mContent == null)
            mContent = new DetalleFragment();

        // set the Above View
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, mContent)
                .commit();

        // set the Behind View
        setBehindContentView(R.layout.menu_frame);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.menu_frame, new SampleListFragment())
                .commit();

        // customize the SlidingMenu
        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "mContent", mContent);
    }

    public void switchContent(Fragment fragment) {
        mContent = fragment;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        getSlidingMenu().showContent();
    }
}
