package com.example.pawel.filharmonia.adapters;

import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pawel.filharmonia.BuildConfig;
import com.example.pawel.filharmonia.R;
import com.example.pawel.filharmonia.model.Gallery;

import java.util.List;

public class GalleryAdapter extends BaseAdapter{
    private List<Gallery> galleryAdapter;

    public GalleryAdapter (List<Gallery> galleryAdapter) {
        this.galleryAdapter = galleryAdapter;
    }

    private static class ThreadPreconditions {
        static void checkOnMainThread() {
            if (BuildConfig.DEBUG) {
                if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                    throw new IllegalStateException("This method should be called from the Main Thread");
                }
            }
        }
    }


    public void updateGallery(List<Gallery> galleryAdapter) {
        ThreadPreconditions.checkOnMainThread();
        this.galleryAdapter = galleryAdapter;
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Gallery imageGallery =  getItem(position);
        GalleryAdapter.ViewHolder viewHolder = null;

        if (convertView == null || !(convertView.getTag() instanceof GalleryAdapter.ViewHolder)) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridview_cell, parent, false);
            viewHolder = new  GalleryAdapter.ViewHolder();

            viewHolder.txtViewGrid = (TextView) convertView.findViewById(R.id.txt_view_grid);
            viewHolder.gridImage = (ImageView) convertView.findViewById(R.id.img_view_grid);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = ( GalleryAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.txtViewGrid.setText(imageGallery.getImageTitle());
        Glide.with(parent.getContext()).load(imageGallery.getImage_link()).into(viewHolder.gridImage);

        return convertView;
    }

    private static class ViewHolder {
        TextView txtViewGrid;
        ImageView gridImage;

    }


    @Override
    public int getCount() {
        return galleryAdapter.size();
    }

    @Override
    public Gallery getItem(int position) {
        return galleryAdapter.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
