package com.example.ace02;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ace on 2017/5/31 0031.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<HashMap<String, Object>> dataList = new ArrayList<>();
    private Context context;

    public MyRecyclerViewAdapter(Context context, ArrayList<HashMap<String, Object>> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_view_item, parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        holder.mLeftIv.setImageResource(Integer.parseInt(dataList.get(position).get("leftimg").toString()));
        holder.mTextView.setText(dataList.get(position).get("middletext").toString());
        holder.mRightIv.setImageResource(Integer.parseInt(dataList.get(position).get("rightimg").toString()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView mTextView;
    ImageView mLeftIv;
    ImageView mRightIv;

    public MyViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.item_middle_tv);
        mLeftIv = (ImageView) itemView.findViewById(R.id.item_left_iv);
        mRightIv = (ImageView) itemView.findViewById(R.id.item_right_iv);
    }
}
