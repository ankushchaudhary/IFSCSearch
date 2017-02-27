package Recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import slidenerd.vivz.navigationviewdemo.R;

/**
 * Created by ankush-pt1328 on 21/2/17.
 */
public class BranchAdapter extends
        RecyclerView.Adapter<BranchAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView text1;
        public TextView text2;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            text1 = (TextView) itemView.findViewById(R.id.row_text1);
            text2 = (TextView) itemView.findViewById(R.id.row_text2);
        }
    }

    private List<String> mContacts;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public BranchAdapter(Context context, ArrayList<String> contacts) {
        mContacts = contacts;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    @Override
    public BranchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recyclerview_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(BranchAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        String contact[] = mContacts.get(position).split(" ");

        // Set item views based on your views and data model

        TextView textView1 = viewHolder.text1;
        textView1.setText(contact[0]);
        TextView textView2 = viewHolder.text2;
        textView2.setText(contact[1]);

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
