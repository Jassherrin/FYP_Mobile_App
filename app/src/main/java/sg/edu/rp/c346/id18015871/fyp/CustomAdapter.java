package sg.edu.rp.c346.id18015871.fyp;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sg.edu.rp.c346.id18015871.fyp.Model.Booking;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context parent_context;
    List<Booking> booking;
    private ItemClickListener mClickListener;
    private SharedPreferences.OnSharedPreferenceChangeListener prefsListener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView note;
        public TextView dot;

        public MyViewHolder(View view) {
            super(view);
            note = view.findViewById(R.id.textViewNameDate);
            dot = view.findViewById(R.id.textViewVersionTime);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layoutId=R.layout.row;

        LayoutInflater inflater = LayoutInflater.from(parent_context);
        View itemView = inflater.inflate(layoutId, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Booking datetime = booking.get(position) ;
        holder.note.setText(datetime.getHeDate());
        holder.dot.setText(datetime.getHeTime());
    }

    @Override
    public int getItemCount() {
        return booking.size();
    }
    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public CustomAdapter (Context context,
                          List<Booking> objects) {
        parent_context=context;
        booking=objects;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNameDate;
        public TextView tViewTime;
        public View mView;
        public ViewHolder(View itemView) {
            super(itemView);

            tvNameDate =  itemView.findViewById(R.id.textViewNameDate);
            tViewTime = itemView.findViewById(R.id.textViewVersionTime);
            mView = itemView;
        }
    }
}