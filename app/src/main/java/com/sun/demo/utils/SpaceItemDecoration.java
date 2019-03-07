package com.sun.demo.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.View;

/**
 * Created by sun on 18/7/4.
 */

public class SpaceItemDecoration extends ItemDecoration {
    int mSpaceLeft;
    int mSpaceTop;
    int mSpaceRight;
    int mSpaceBottom;

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mSpaceLeft;
        outRect.right = mSpaceRight;
        outRect.bottom = mSpaceBottom;
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = mSpaceTop;
        }

    }

    public SpaceItemDecoration(int spaceLeft, int spaceTop, int spaceRight, int spaceBottom) {
        this.mSpaceLeft = spaceLeft;
        this.mSpaceTop = spaceTop;
        this.mSpaceRight = spaceRight;
        this.mSpaceBottom = spaceBottom;
    }
}
