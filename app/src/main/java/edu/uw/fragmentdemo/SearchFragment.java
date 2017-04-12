package edu.uw.fragmentdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private OnSearchListener callback;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    interface OnSearchListener {
        void onSearchSubmitted(String searchTerm);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        final EditText text = (EditText)rootView. findViewById(R.id.txtSearch);

        Button button = (Button)rootView.findViewById(R.id.btnSearch);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerm = text.getText().toString();
                callback.onSearchSubmitted(searchTerm);
            }
        });

        return rootView;
    }

}
