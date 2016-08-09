package com.recyclerview.demo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/8.
 */
public class PhotoView  extends  RecyclerView.ViewHolder implements View.OnClickListener  {
    ImageView imageView;

    TextView titleView;

    private MyItemClickListener mListener;

    public PhotoView(View itemView,MyItemClickListener listener){
        super(itemView);

        imageView= (ImageView) itemView.findViewById(R.id.photo_item_img );

        titleView= (TextView) itemView.findViewById(R.id.photo_item_title);

        this.mListener = listener;

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(mListener != null){
            mListener.onItemClick(view,getPosition());
        }
    }
}
