package com.example.gooutportsmouth.app;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.gooutportsmouth.adapter.GridViewImageAdapter;
import com.example.gooutportsmouth.helper.AppConstant;
import com.example.gooutportsmouth.helper.Utils;

import java.util.ArrayList;

public class GridViewFragment extends Fragment {

    private Utils utils;
    private AppConstant constants;
    private ArrayList<String> imageThumbs = new ArrayList<String>();
    private GridViewImageAdapter adapter;
    private GridView gridView;
    private int columnWidth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_grid_view, container, false);

        gridView = (GridView) rootView.findViewById(R.id.grid_view);

        utils = new Utils(getActivity().getApplicationContext());
        constants = new AppConstant();

        ClubPage activity = (ClubPage) getActivity();

        // Initializing Grid View
        InitilizeGridLayout();

        // loading all image paths from SD card
        //imagePaths = utils.getFilePaths();

        //get links
        switch (activity.getPosition()) {
            case 0:
                imageThumbs = utils.grabLiquidThumbs(constants.LIQUID_THUMB_SERVER);
                break;
            case 1:
                imageThumbs = utils.grabTigerImages(constants.TIGER_IMAGE_SERVER);
                break;
            default:
                break;
        }

        // Gridview adapter
        adapter = new GridViewImageAdapter(getActivity(), imageThumbs,
                columnWidth);

        // setting grid view adapter
        gridView.setAdapter(adapter);

        return rootView;
    }

    private void InitilizeGridLayout() {
        Resources r = getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                AppConstant.GRID_PADDING, r.getDisplayMetrics());

        columnWidth = (int) ((utils.getScreenWidth() - ((AppConstant.NUM_OF_COLUMNS + 1) * padding)) / AppConstant.NUM_OF_COLUMNS);

        gridView.setNumColumns(AppConstant.NUM_OF_COLUMNS);
        gridView.setColumnWidth(columnWidth);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setPadding((int) padding, (int) padding, (int) padding,
                (int) padding);
        gridView.setHorizontalSpacing((int) padding);
        gridView.setVerticalSpacing((int) padding);
    }

}
