package com.terabits.portfolio.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.terabits.portfolio.R;

import java.util.ArrayList;
import java.util.List;


public class PortfolioFragment extends Fragment implements PortfolioCallback{

    List<PortfolioItem> mdata;
    RecyclerView rv_portfolio;
    PortfolioAdapter portfolioAdapter;



    public PortfolioFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_portfolio = view.findViewById(R.id.rv_portfolio);

        //create a list of portfolio items
        mdata = new ArrayList<>();
        mdata.add(new PortfolioItem(R.drawable.project7));
        mdata.add(new PortfolioItem(R.drawable.project3));
        mdata.add(new PortfolioItem(R.drawable.project4));
        mdata.add(new PortfolioItem(R.drawable.project0));
        mdata.add(new PortfolioItem(R.drawable.project2));
        mdata.add(new PortfolioItem(R.drawable.project3));
        mdata.add(new PortfolioItem(R.drawable.project7));
        mdata.add(new PortfolioItem(R.drawable.project1));
        mdata.add(new PortfolioItem(R.drawable.project5));


        portfolioAdapter = new PortfolioAdapter(mdata, this);


        //setup grid recyclerView

        rv_portfolio.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rv_portfolio.setAdapter(portfolioAdapter);







    }

    @Override
    public void onPortfolioItemClick(int pos) {
        //handle click listener event when portflio utem clicked


        //first we need to create a fragment bottom shhet instance
        PortfolioFragmentDetails portfolioFragmentDetails = new PortfolioFragmentDetails();

        // now we need to send portflio item to portfilio dialog fragment
        //we will use bundle for that
        //also we need our porftfolio item data class to implement serializable interface so we can send it

        Bundle bundle = new Bundle();
        bundle.putSerializable("object", mdata.get(pos));
        portfolioFragmentDetails.setArguments(bundle);

        //now let´s open the portfolio botton sheet fragment

        portfolioFragmentDetails.show(getActivity().getSupportFragmentManager(), "tagname");



    }
}