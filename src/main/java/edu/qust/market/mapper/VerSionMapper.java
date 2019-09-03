package edu.qust.market.mapper;

import edu.qust.market.bean.VerSion;
import edu.qust.market.bean.VerSionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface VerSionMapper {
    int countByExample(VerSionExample example);

    int deleteByExample(VerSionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VerSion record);

    int insertSelective(VerSion record);

    List<VerSion> selectByExample(VerSionExample example);

    VerSion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VerSion record, @Param("example") VerSionExample example);

    int updateByExample(@Param("record") VerSion record, @Param("example") VerSionExample example);

    int updateByPrimaryKeySelective(VerSion record);

    int updateByPrimaryKey(VerSion record);
}