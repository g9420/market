package edu.qust.market.service;

import edu.qust.market.bean.Footprint;
import edu.qust.market.bean.FootprintExample;
import edu.qust.market.mapper.FootprintMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootPrintService {

    @Autowired
    private FootprintMapper footprintMapper;

    public List<Footprint> selectFootPrintByUid(int uid){
        FootprintExample footprintExample = new FootprintExample();
        FootprintExample.Criteria fec = footprintExample.createCriteria();
        fec.andUidEqualTo(uid);
        return footprintMapper.selectByExample(footprintExample);
    }

    public int insertFootprint(Footprint footprint){
        return footprintMapper.insert(footprint);
    }
}
