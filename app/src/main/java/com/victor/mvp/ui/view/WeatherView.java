package com.victor.mvp.ui.view;

import com.victor.mvp.model.data.Weather;


/**
 * Created by victor on 2017/2/8.
 */
public interface WeatherView {
    void showLoading();

    void hideLoading();

    void showError();

    void setWeatherInfo(Weather weather);
}
