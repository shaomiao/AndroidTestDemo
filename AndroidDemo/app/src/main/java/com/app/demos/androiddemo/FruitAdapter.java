package com.app.demos.androiddemo;import android.content.Context;import android.support.annotation.NonNull;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.ArrayAdapter;import android.widget.ImageView;import android.widget.TextView;import org.w3c.dom.Text;import java.util.List;/** * Created by shaomiao on 2016-12-1. */public class FruitAdapter extends ArrayAdapter<Fruit> {    private int resourceId;    public FruitAdapter(Context context, int resource, List<Fruit> objects) {        super(context, resource, objects);        resourceId = resource;    }    @NonNull    @Override    public View getView(int position, View convertView, ViewGroup parent) {        //convertView参数，这个参数用于将之前加载好的 布局进行缓存，以便之后可以进行重用        Fruit fruit = getItem(position);        View view;        ViewHolder viewHolder;        // adapter优化        //每次在getView()方法中还是会调用View的findViewById()方法来获取一次控件的实例。 我们可以借助一个 ViewHolder来对这部分性能进行优化，        if (convertView == null) {            view = LayoutInflater.from(getContext()).inflate(resourceId, null);            viewHolder = new ViewHolder();            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);            view.setTag(viewHolder); // 将ViewHolder存储在view中        } else {            view = convertView;            viewHolder = (ViewHolder) view.getTag(); // 重新获取V        }        viewHolder.fruitImage.setImageResource(fruit.getImageId());        viewHolder.fruitName.setText(fruit.getName());        return view;    }    class ViewHolder {        ImageView fruitImage;        TextView fruitName;    }}