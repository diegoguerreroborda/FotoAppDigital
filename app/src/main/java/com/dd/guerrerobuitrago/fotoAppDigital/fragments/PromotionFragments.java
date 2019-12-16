package com.dd.guerrerobuitrago.fotoAppDigital.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dd.guerrerobuitrago.fotoAppDigital.R;
import com.dd.guerrerobuitrago.fotoAppDigital.adapters.PromotionRVAdapter;
import com.dd.guerrerobuitrago.fotoAppDigital.models.Promotion;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PromotionFragments extends Fragment {

    private ArrayList<Promotion> promotionsList;

    private RecyclerView rvPromotion;
    private PromotionRVAdapter rvAdapter;
    private FloatingActionButton btnFloat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View promotionView = inflater.inflate(R.layout.fragment_promotion_fragments, container, false);
        initComponents(promotionView);
        return promotionView;
    }

    private void initComponents(View view) {
        btnFloat = view.findViewById(R.id.btn_float);
        rvPromotion = view.findViewById(R.id.rv_promotion);
        initRecyclerView();
        btnFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promotionsList.add(new Promotion("Component"));
                rvAdapter.notifyItemInserted(promotionsList.size());
            }
        });
    }

    private void initRecyclerView() {
        promotionsList = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                        RecyclerView.VERTICAL,
                        false);
        rvAdapter = new PromotionRVAdapter(promotionsList);
        rvAdapter.setListener(new PromotionRVAdapter.onItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                promotionsList.remove(position);
                rvAdapter.notifyItemRemoved(position);
            }
        });
        rvPromotion.setLayoutManager(layoutManager);
        rvPromotion.setAdapter(rvAdapter);
        rvPromotion.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1) && promotionsList.size() > 2) {
                    btnFloat.hide();
                }else {
                    btnFloat.show();
                }
            }
        });
    }

    public static PromotionFragments newInstance(){
        Bundle args = new Bundle();
        PromotionFragments fragment = new PromotionFragments();
        fragment.setArguments(args);
        return fragment;
    }
}
