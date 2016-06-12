package edu.galileo.android.tipcalc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.tipcalc.R;

public class TipDetailActivity extends AppCompatActivity {

    @Bind(R.id.txtTip)
    TextView txtTip;
    @Bind(R.id.txtTotal)
    TextView txtTotal;
    @Bind(R.id.txtTimestamp)
    TextView txtTimestamp;

    public static final String TIP_KEY = "tip";
    public static final String DATE_KEY = "timestamp";
    public static final String TOTAL_KEY = "total";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String strTotal = String.format(getString(R.string.tipdetail_message_total), intent.getFloatExtra(TOTAL_KEY, 0f));
        String strTip = String.format(getString(R.string.global_message_tip), intent.getFloatExtra(TIP_KEY, 0f));

        txtTotal.setText(strTotal);
        txtTip.setText(strTip);
        txtTimestamp.setText(intent.getStringExtra(DATE_KEY));
    }
}
