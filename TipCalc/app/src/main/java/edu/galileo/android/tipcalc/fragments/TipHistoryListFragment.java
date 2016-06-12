package edu.galileo.android.tipcalc.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.tipcalc.R;
import edu.galileo.android.tipcalc.activities.TipDetailActivity;
import edu.galileo.android.tipcalc.adapters.OnItemSelectListener;
import edu.galileo.android.tipcalc.adapters.TipAdapter;
import edu.galileo.android.tipcalc.models.TipRecord;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipHistoryListFragment extends Fragment implements TipHistoryListFragmentListener, OnItemSelectListener {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private TipAdapter tipAdapter;

    public TipHistoryListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentip_history_list, container, false);
        ButterKnife.bind(this, view);
        initAdapter();
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(tipAdapter);
    }

    private void initAdapter() {
        if (tipAdapter == null) {
            tipAdapter = new TipAdapter(getActivity().getApplicationContext(), this);
        }
    }

    @Override
    public void addToList(TipRecord tipRecord) {
        tipAdapter.add(tipRecord);
    }

    @Override
    public void clearList() {
        tipAdapter.clear();
    }

    @Override
    public void onItemSelect(TipRecord tipRecord) {
        Intent intent = new Intent(getActivity(), TipDetailActivity.class);
        intent.putExtra(TipDetailActivity.TOTAL_KEY, tipRecord.getBill());
        intent.putExtra(TipDetailActivity.TIP_KEY, tipRecord.getTip());
        intent.putExtra(TipDetailActivity.DATE_KEY, tipRecord.getDateFormatted());

        startActivity(intent);
    }
}
