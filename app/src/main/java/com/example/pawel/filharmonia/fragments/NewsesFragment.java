package com.example.pawel.filharmonia.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pawel.filharmonia.R;
import com.example.pawel.filharmonia.adapters.NewsAdapter;
import com.example.pawel.filharmonia.connection.Rest;
import com.example.pawel.filharmonia.model.News;
import com.example.pawel.filharmonia.model.Newses;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsesFragment extends BaseFragment implements SearchView.OnQueryTextListener,AdapterView.OnItemClickListener {
    private ListView listViewNewses;
    private NewsAdapter adapter = new NewsAdapter();
    private List<News> allNewses = new ArrayList<>();
    private ProgressDialog progressDialog;
    private TextView topBarTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newses,container,false);
        View topBar = inflater.inflate(R.layout.fragment_top_bar,container,false);
        topBarTitle = (TextView) topBar.findViewById(R.id.topBarTitle);
        topBarTitle.setText("sadasdas");
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(getString(R.string.newsLoading));
        progressDialog.show();
        SearchView searchView = (SearchView) view.findViewById(R.id.searchViewNewses) ;
        searchView.setQueryHint("Search");
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(true);
        listViewNewses = (ListView) view.findViewById(R.id.listViewNewses);
        listViewNewses.setOnItemClickListener(this);

        sendRequest();

        return view;
    }

    public void sendRequest(){
        Rest.init();
        Rest.getRest().loadData().enqueue(new Callback<Newses>() {
            @Override
            public void onResponse(Call<Newses> call, Response<Newses> response) {
                allNewses = response.body().getLoadData();
                adapter.updateNews(allNewses);

                if (allNewses.isEmpty()) {
                    Toast.makeText(getContext(), "Brak aktualności", Toast.LENGTH_SHORT).show();}
                else if (response.isSuccessful()){
                    progressDialog.hide();
                    listViewNewses.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Newses> call, Throwable t) {
                if (allNewses.isEmpty()) {
                    Toast.makeText(getContext(), "Brak połączenia z internetem", Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                }
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        if (TextUtils.isEmpty(s)) {
            listViewNewses.clearTextFilter();
            adapter.updateNews(allNewses);
        } else {
            listViewNewses.setFilterText(s);
            adapter.getFilter().filter(s);
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Bundle bundle = new Bundle();
        News newsClass = (News) adapterView.getItemAtPosition(i);
        bundle.putString("Title",newsClass.getTitle());
        bundle.putString("Image",newsClass.getImage_link());
        bundle.putString("Full_Content",newsClass.getFull_content());
        navigationListener.onNavigate(SingleNewsFragment.newInstance(bundle));
    }
}
