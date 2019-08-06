package com.example.gopal.stickyheader;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gopal on 8/6/2019.
 */

public class SimpleRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements StickyHeaderInterface {
    private List<Data> mData;
    public static final int HEADER_TYPE_1 = 1;
    public static final int HEADER_TYPE_2 = 2;

    public SimpleRecyclerView() {
        mData = new ArrayList<>();
        mData.add(new Data(1));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(1));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(1));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(1));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(1));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(0));
        mData.add(new Data(2));

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEADER_TYPE_1:
                return new SimpleRecyclerView.HeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.header1_item_recycler, parent, false));
            case HEADER_TYPE_2:
                return new SimpleRecyclerView.Header2ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.header2_item_recycler, parent, false));
            default:
                return new SimpleRecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).bindData(position);
        } else if (holder instanceof HeaderViewHolder){
            ((HeaderViewHolder) holder).bindData(position);
        } else if (holder instanceof Header2ViewHolder){
            ((Header2ViewHolder) holder).bindData(position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // Interface method
    @Override
    public int getHeaderPositionForItem(int itemPosition) {
        int headerPosition = 0;
        do {
            if (this.isHeader(itemPosition)) {
                headerPosition = itemPosition;
                break;
            }
            itemPosition -= 1;
        } while (itemPosition >= 0);
        return headerPosition;
    }

    @Override
    public int getHeaderLayout(int headerPosition) {
       /* if (mData.get(headerPosition).getViewType() == 1){
            return R.layout.header1_item_recycler;}
        else if(mData.get(headerPosition).getViewType() == 2){
            return R.layout.header2_item_recycler;
        }*/
        return R.layout.header1_item_recycler;
    }



    @Override
    public void bindHeaderData(View header, int headerPosition) {

    }

    @Override
    public boolean isHeader(int itemPosition) {
        if (mData.get(itemPosition).getViewType() == 1 || mData.get(itemPosition).getViewType() == 2)
            return true;
        else
            return false;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeader;

        HeaderViewHolder(View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.tvHeader);
        }

        void bindData(int position) {
            tvHeader.setText(String.valueOf(position));
        }
    }

    class Header2ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeader;

        Header2ViewHolder(View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.tvHeader);
        }

        void bindData(int position) {
            tvHeader.setText(String.valueOf(position));
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvRows;

        ViewHolder(View itemView) {
            super(itemView);
            tvRows = itemView.findViewById(R.id.tvRows);
        }

        void bindData(int position) {
            tvRows.setText("Item" + position);
            ((ViewGroup) tvRows.getParent()).setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    class Data {
        int viewType;

        public Data(int viewType) {
            this.viewType = viewType;
        }

        public int getViewType() {
            return viewType;
        }

        public void setViewType(int viewType) {
            this.viewType = viewType;
        }
    }
}
