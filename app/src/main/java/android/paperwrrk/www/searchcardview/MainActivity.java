package android.paperwrrk.www.searchcardview;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import static android.support.v4.view.MenuItemCompat.getActionView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<TvSeriesModel> mArrayList;
    private TvSeriesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_series);

        initViews();
        loadData();


    }

    private void initViews(){
        mRecyclerView = (RecyclerView)findViewById(R.id.tv_series_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        GridLayoutManager manager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
    }

    private void loadData(){
        mArrayList = new ArrayList<>();
        mArrayList.add(new TvSeriesModel("MBox",R.drawable.app_icon));
        mArrayList.add(new TvSeriesModel("bb ki vines",R.drawable.download));
        mArrayList.add(new TvSeriesModel("got",R.drawable.second_img));
        mArrayList.add(new TvSeriesModel("screen patti",R.drawable.sc));
        mArrayList.add(new TvSeriesModel("TVF Pitchers",R.drawable.tvf));
        mArrayList.add(new TvSeriesModel("Inside Edge",R.drawable.ie));
        mArrayList.add(new TvSeriesModel("marsh",R.drawable.app_icon));
        mArrayList.add(new TvSeriesModel("Inside Edge",R.drawable.ie));
        mArrayList.add(new TvSeriesModel("marsh",R.drawable.app_icon));
        mArrayList.add(new TvSeriesModel("Inside Edge",R.drawable.ie));
        mArrayList.add(new TvSeriesModel("marsh",R.drawable.app_icon));
        mArrayList.add(new TvSeriesModel("Inside Edge",R.drawable.ie));
        mArrayList.add(new TvSeriesModel("marsh",R.drawable.app_icon));
        mArrayList.add(new TvSeriesModel("Inside Edge",R.drawable.ie));
        mArrayList.add(new TvSeriesModel("marsh",R.drawable.app_icon));
        mArrayList.add(new TvSeriesModel("Inside Edge",R.drawable.ie));
        mArrayList.add(new TvSeriesModel("marsh",R.drawable.app_icon));
        mArrayList.add(new TvSeriesModel("Inside Edge",R.drawable.ie));
        mArrayList.add(new TvSeriesModel("marsh",R.drawable.app_icon));
        mArrayList.add(new TvSeriesModel("Inside Edge",R.drawable.ie));
        mArrayList.add(new TvSeriesModel("marsh",R.drawable.app_icon));
        mArrayList.add(new TvSeriesModel("Inside Edge",R.drawable.ie));
        mArrayList.add(new TvSeriesModel("marsh",R.drawable.app_icon));
        mArrayList.add(new TvSeriesModel("Inside Edge",R.drawable.ie));
        mArrayList.add(new TvSeriesModel("marsh",R.drawable.app_icon));
        mArrayList.add(new TvSeriesModel("Inside Edge",R.drawable.ie));
        mArrayList.add(new TvSeriesModel("marsh",R.drawable.app_icon));

        mAdapter = new TvSeriesAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_series, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) search.getActionView();
        
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }


}
