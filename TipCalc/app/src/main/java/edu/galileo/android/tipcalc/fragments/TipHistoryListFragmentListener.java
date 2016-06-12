package edu.galileo.android.tipcalc.fragments;

import edu.galileo.android.tipcalc.models.TipRecord;

/**
 * Created by heril on 11/06/16.
 */
public interface TipHistoryListFragmentListener {

    void addToList(TipRecord tipRecord);
    void clearList();

}
