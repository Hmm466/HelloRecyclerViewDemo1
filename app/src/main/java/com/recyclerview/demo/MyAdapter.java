package com.recyclerview.demo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/8.
 */
public class MyAdapter extends RecyclerView.Adapter<PhotoView> {
    //定义数据模型
    private List<Photo> products;

    private MyItemClickListener mItemClickListener;

    //够着方法
    public MyAdapter(List<Photo> list) {
        products=list;
    }
    /**
     * 设置Item点击监听
     * @param listener
     */
    public void setOnItemClickListener(MyItemClickListener listener){
        this.mItemClickListener = listener;
    }
    //创建每一条小牧
    @Override
    public PhotoView onCreateViewHolder(ViewGroup viewGroup, int i) {
        //加载布局
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_item, viewGroup, false);

        return new PhotoView(view,mItemClickListener);
    }
    //banding数据的数据模型
    @Override
    public void onBindViewHolder(final PhotoView photoView, int position) {

        photoView.imageView.setImageResource(products.get(position).getImage());

        photoView.titleView.setText(products.get(position).getTitle());
    }
    //获取数据的大小
    @Override
    public int getItemCount() {
        return products.size();
    }
    //增加一项
    public void addData(int position,Photo photo) {
        products.add(position,photo);
        notifyItemInserted(position);
    }


    //删除一项
    public void removeData(int position) {
        products.remove(position);
        notifyItemRemoved(position);
    }
}
