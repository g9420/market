package edu.qust.market.service;

import edu.qust.market.bean.News;
import edu.qust.market.bean.NewsExample;
import edu.qust.market.framework.bean.WebModel;
import edu.qust.market.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;

    public int insertNews(News news){
        return newsMapper.insertSelective(news);
    }

    public void selectNewsByUid(int uid, WebModel webModel){
        NewsExample newsExample = new NewsExample();
        newsExample.setLimitStart(webModel.getLimitStart());
        newsExample.setPageSize(webModel.getPs());
        newsExample.setOrderByClause("`Id` DESC");
        NewsExample.Criteria nec = newsExample.createCriteria();
        nec.andUidEqualTo(uid);
        nec.andActiveBetween(0,1);
        webModel.setData(newsMapper.selectByExample(newsExample));
    }

    public int selectNewsByUid(int uid){
        NewsExample newsExample = new NewsExample();
        NewsExample.Criteria nec = newsExample.createCriteria();
        nec.andUidEqualTo(uid);
        nec.andActiveEqualTo(0);
        return newsMapper.countByExample(newsExample);
    }

    public int readOneByid(News news){
        return newsMapper.updateByPrimaryKeySelective(news);
    }

    public int readAllByUid(int uid){
        News news = new News();
        news.setActive(1);
        NewsExample newsExample = new NewsExample();
        NewsExample.Criteria nec = newsExample.createCriteria();
        nec.andUidEqualTo(uid);
        return newsMapper.updateByExampleSelective(news,newsExample);
    }
}
