package com.example.springjiemi.chapter2;

import org.apache.commons.lang3.ArrayUtils;

public class FXNewsProvider {

    private IFXNewsListener newsListener;
    private IFXNewsPersistence newsPersistence;

//    public FXNewsProvider() {
//        newsListener = new DowJonesNewsListener();
//        newsPersistence = new DownJonesNewsPersistence();
//    }

//    public FXNewsProvider(IFXNewsListener newsListener, IFXNewsPersistence newsPersistence) {
//        // 1. 构造方法注入
//        this.newsListener = newsListener;
//        this.newsPersistence = newsPersistence;
//    }


//    /*
//    2. setter 方法注入
    public IFXNewsListener getNewsListener() {
        return newsListener;
    }

    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public IFXNewsPersistence getNewsPersistence() {
        return newsPersistence;
    }

    public void setNewsPersistence(IFXNewsPersistence newsPersistence) {
        this.newsPersistence = newsPersistence;
    }
//     */

    // 3 注解注入

    public void getAndPersistNews() {
        var newsIds = newsListener.getAvailableNewsIds();
        if (ArrayUtils.isEmpty(newsIds)) {
            return;
        }
        for (String newsId: newsIds) {
            var newsBean = newsListener.getNewsByPK(newsId);
            newsPersistence.persistNews(newsBean);
            newsListener.postProcessIfNecessary(newsId);
        }
    }
}
