package com.example.springjiemi.chapter2;

public interface IFXNewsListener {
    String[] getAvailableNewsIds();

    FXNewsBean getNewsByPK(String newsId);

    void postProcessIfNecessary(String newsId);
}
