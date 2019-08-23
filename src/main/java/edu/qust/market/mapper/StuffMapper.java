package edu.qust.market.mapper;

import edu.qust.market.bean.Stuff;
import edu.qust.market.bean.StuffExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface StuffMapper {
    int countByExample(StuffExample example);

    int deleteByExample(StuffExample example);

    int deleteByPrimaryKey(Long stuffId);

    int insert(Stuff record);

    int insertSelective(Stuff record);

    List<Stuff> selectByExample(StuffExample example);

    Stuff selectByPrimaryKey(Long stuffId);

    int updateByExampleSelective(@Param("record") Stuff record, @Param("example") StuffExample example);

    int updateByExample(@Param("record") Stuff record, @Param("example") StuffExample example);

    int updateByPrimaryKeySelective(Stuff record);

    int updateByPrimaryKey(Stuff record);
}