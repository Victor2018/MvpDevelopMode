package com.victor.mvp.presenter;

/**
 * Created by victor on 2017/2/8.
 * 天气 Presenter接口
 */
public interface WeatherPresenter {
    /**
     * 获取天气的逻辑
     */
    void getWeather(String cityNO);

}
