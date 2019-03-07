package com.sun.demo.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sun.demo.R;
import com.sun.demo.home.bean.StocksCategoryBean;
import com.sun.demo.intf.ItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sun on 18/7/10.
 */

public class StocksFragmentAdapter extends RecyclerView.Adapter<StocksFragmentAdapter.MyViewHolder> {

    private Context mContext;
    private List<StocksCategoryBean> mList;
    private ItemClickListener mItemClickListener;

    public StocksFragmentAdapter(Context mContext, List<StocksCategoryBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_stocks_fragment, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        StocksCategoryBean bean = mList.get(position);
        holder.mName.setText(bean.name);
        holder.mName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.click(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public void setItemClickListener(ItemClickListener clickListener) {
        mItemClickListener = clickListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView mName;

        public MyViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
