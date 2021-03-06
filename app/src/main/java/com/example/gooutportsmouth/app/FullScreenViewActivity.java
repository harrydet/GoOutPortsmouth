package com.example.gooutportsmouth.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.gooutportsmouth.adapter.FullScreenImageAdapter;
import com.example.gooutportsmouth.helper.AppConstant;
import com.example.gooutportsmouth.helper.Utils;

import java.util.ArrayList;

public class FullScreenViewActivity extends Activity {

    private Utils utils;
    private FullScreenImageAdapter adapter;
    private ViewPager viewPager;
    private AppConstant constants;
    private ArrayList<String> imagePaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_view);

        viewPager = (ViewPager) findViewById(R.id.pager);

        utils = new Utils(getApplicationContext());
        constants = new AppConstant();

        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);

        switch (i.getIntExtra("calledFrom", 0)) {
            case 0:
                imagePaths = utils.grabLiquidImages(constants.LIQUID_THUMB_SERVER);
                break;
            case 1:
                imagePaths = utils.grabTigerImages(constants.TIGER_IMAGE_SERVER);
                break;
            default:
                break;
        }

        adapter = new FullScreenImageAdapter(FullScreenViewActivity.this, imagePaths);

        viewPager.setAdapter(adapter);

        // displaying selected image first
        viewPager.setCurrentItem(position);
    }
}
