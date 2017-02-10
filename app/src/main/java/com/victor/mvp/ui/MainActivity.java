package com.victor.mvp.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.victor.mvp.model.data.Weather;
import com.victor.mvp.model.data.WeatherInfo;
import com.victor.mvp.presenter.WeatherPresenter;
import com.victor.mvp.presenter.impl.WeatherPresenterImpl;
import com.victor.mvp.ui.view.WeatherView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,WeatherView {
    private String TAG = "MainActivity";

    private EditText mEtCityNo;
    private Button mBtnGo;
    private TextView mTvCity;
    private TextView mTvCityNo;
    private TextView mTvTemp;
    private TextView mTvWD;
    private TextView mTvWS;
    private TextView mTvSD;
    private TextView mTvWSE;
    private TextView mTvTime;
    private TextView mTvNjd;

    private WeatherPresenter weatherPresenter;
    private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        initData();
    }

    private void initialize () {
        mEtCityNo = (EditText) findViewById(R.id.et_city_no);
        mBtnGo = (Button) findViewById(R.id.btn_go);
        mTvCity = (TextView) findViewById(R.id.tv_city);
        mTvCityNo = (TextView) findViewById(R.id.tv_city_no);
        mTvTemp = (TextView) findViewById(R.id.tv_temp);
        mTvWD = (TextView) findViewById(R.id.tv_WD);
        mTvWS = (TextView) findViewById(R.id.tv_WS);
        mTvSD = (TextView) findViewById(R.id.tv_SD);
        mTvWSE = (TextView) findViewById(R.id.tv_WSE);
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mTvNjd = (TextView) findViewById(R.id.tv_njd);

        mBtnGo.setOnClickListener(this);

        mEtCityNo.setText("101280601");
    }

    private void initData () {
        weatherPresenter = new WeatherPresenterImpl(this); //传入WeatherView
        loadingDialog = new ProgressDialog(this);
        loadingDialog.setTitle("加载天气中...");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_go:
                weatherPresenter.getWeather(mEtCityNo.getText().toString().trim());
                break;
        }
    }

    @Override
    public void showLoading() {
        loadingDialog.show();
    }

    @Override
    public void hideLoading() {
        loadingDialog.dismiss();
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWeatherInfo(Weather weather) {
        WeatherInfo info = weather.getWeatherinfo();
        mTvCity.setText(info.getCity());
        mTvCityNo.setText(info.getCityid());
        mTvTemp.setText(info.getTemp());
        mTvWD.setText(info.getWD());
        mTvWS.setText(info.getWS());
        mTvSD.setText(info.getSD());
        mTvWSE.setText(info.getWS());
        mTvTime.setText(info.getTemp());
        mTvNjd.setText(info.getNjd());
    }
}
