package com.example.pawel.filharmonia.adapters;


import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pawel.filharmonia.BuildConfig;
import com.example.pawel.filharmonia.R;
import com.example.pawel.filharmonia.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter  extends BaseAdapter implements Filterable {

    private List<News> newsAdapter;
    private List<News> filteredResults;

    public NewsAdapter() {}

    private static class ThreadPreconditions {
        static void checkOnMainThread() {
            if (BuildConfig.DEBUG) {
                if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                    throw new IllegalStateException("This method should be called from the Main Thread");
                }
            }
        }
    }

    public void setData(List<News> newslist){
        this.newsAdapter = newslist;

        notifyDataSetChanged();
    }
    public void updateNews(List<News> newsAdapter) {
        NewsAdapter.ThreadPreconditions.checkOnMainThread();
        this.newsAdapter = newsAdapter;
        notifyDataSetChanged();
    }

    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<News> results = new ArrayList<>();
                if (filteredResults == null)
                    filteredResults = newsAdapter;
                if (constraint != null) {
                    if (filteredResults != null && filteredResults.size() > 0) {
                        for (final News g : filteredResults) {
                            if (g.getTitle().toLowerCase()
                                    .contains(constraint.toString()))
                                results.add(g);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {
                newsAdapter = (ArrayList<News>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        News news =  getItem(position);
        ViewHolder viewHolder = null;

        if (convertView == null || !(convertView.getTag() instanceof ViewHolder)) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_table_cell, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.newsTitle = (TextView) convertView.findViewById(R.id.txt_view_title_single_row);
            viewHolder.newsSubtitle = (TextView) convertView.findViewById(R.id.txt_view_article_single_row);
            viewHolder.newsImage = (ImageView) convertView.findViewById(R.id.img_view_min);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.newsTitle.setText(news.getTitle());
        viewHolder.newsSubtitle.setText(news.getContent());
        Glide.with(parent.getContext()).load(news.getImage_link()).into(viewHolder.newsImage);

        return convertView;
    }

    private static class ViewHolder {
        TextView newsTitle;
        TextView newsSubtitle;
        ImageView newsImage;

    }

    @Override
    public int getCount() {
        return newsAdapter.size();
    }

    @Override
    public News getItem(int position) {
        return newsAdapter.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}