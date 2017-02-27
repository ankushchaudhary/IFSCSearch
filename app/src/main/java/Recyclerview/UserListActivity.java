package Recyclerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import slidenerd.vivz.navigationviewdemo.R;

/**
 * Created by ankush-pt1328 on 21/2/17.
 */

public class UserListActivity extends Fragment {
    ArrayList<String> contacts;
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.recyclerview, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView rvContacts = (RecyclerView) view.findViewById(R.id.rvContacts);

        // Initialize contacts
        contacts = new ArrayList<>();
        for(int i=1;i<20;i++)
        {
            contacts.add("name"+i+" "+"Branch"+i);
        }
        // Create adapter passing in the sample user data
        BranchAdapter adapter = new BranchAdapter(getActivity(), contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }
}

