package edu.qust.market.service;

import edu.qust.market.bean.Session;
import edu.qust.market.bean.SessionExample;
import edu.qust.market.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionMapper sessionMapper;

    public int insertSession(Session session){
        return sessionMapper.insert(session);
    }

    public List<Session> selectSessionByToken(String token){
        SessionExample sessionExample = new SessionExample();
        SessionExample.Criteria sec = sessionExample.createCriteria();
        sec.andTokenEqualTo(token);
        return sessionMapper.selectByExample(sessionExample);
    }

    public int deleteById(String id){
        return sessionMapper.deleteByPrimaryKey(id);
    }

    public int countSessionById(String Id){
        SessionExample sessionExample = new SessionExample();
        SessionExample.Criteria sec = sessionExample.createCriteria();
        sec.andIdEqualTo(Id);
        return sessionMapper.countByExample(sessionExample);
    }

    public int upDataSession(Session session){
        return sessionMapper.updateByPrimaryKeySelective(session);
    }

}
