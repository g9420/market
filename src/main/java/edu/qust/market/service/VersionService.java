package edu.qust.market.service;

import edu.qust.market.mapper.VerSionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author g9420
 * @date 2019/9/3 11:59
 */
@Service
public class VersionService {

    @Autowired
    private VerSionMapper verSionMapper;

    public int getVsersion(){
        return verSionMapper.selectByPrimaryKey(1).getVersion();
    }
}
