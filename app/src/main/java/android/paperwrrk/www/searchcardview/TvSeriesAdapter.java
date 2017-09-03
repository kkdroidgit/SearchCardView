package android.paperwrrk.www.searchcardview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kartik on 13-8-17.
 */

public class TvSeriesAdapter extends RecyclerView.Adapter<TvSeriesAdapter.ViewHolder> implements Filterable {


    private ArrayList<TvSeriesModel> mArrayList;
    private ArrayList<TvSeriesModel> mFilteredList;


    public TvSeriesAdapter(ArrayList<TvSeriesModel> arrayList) {
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_series_card, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_name.setText(mFilteredList.get(i).getName());
        viewHolder.tv_logo.setImageResource(mFilteredList.get(i).getDrawable());
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<TvSeriesModel> filteredList = new ArrayList<>();

                    for (TvSeriesModel androidVersion : mArrayList) {

                        if (androidVersion.getName().toLowerCase().contains(charString)) {

                            filteredList.add(androidVersion);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<TvSeriesModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private ImageView tv_logo;
        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.tv_name);
            tv_logo = (ImageView)view.findViewById(R.id.tv_image);

        }
    }




}
