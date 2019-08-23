package edu.qust.market.service;

import edu.qust.market.bean.Stuff;
import edu.qust.market.bean.User;
import edu.qust.market.bean.UserExample;
import edu.qust.market.mapper.StuffMapper;
import edu.qust.market.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StuffMapper stuffMapper;

    public int insertUser(User user){
        return userMapper.insertSelective(user);
    }

    public int CountByOpenid(String openid){
        UserExample userExample = new UserExample();
        UserExample.Criteria uec = userExample.createCriteria();
        uec.andOpenidEqualTo(openid);
        return userMapper.countByExample(userExample);
    }

    public int updateUserByOpenid(User user){
        UserExample userExample = new UserExample();
        UserExample.Criteria uec = userExample.createCriteria();
        uec.andOpenidEqualTo(user.getOpenid());
        return userMapper.updateByExampleSelective(user,userExample);
    }

    public List<User> selectIdByOpenId(String openId){
        UserExample userExample = new UserExample();
        UserExample.Criteria uec = userExample.createCriteria();
        uec.andOpenidEqualTo(openId);
        return userMapper.selectByExample(userExample);
    }

    public String selectUserAvatarById(int id){
        UserExample userExample = new UserExample();
        UserExample.Criteria uec = userExample.createCriteria();
        uec.andIdEqualTo(id);
        List<User> data = userMapper.selectByExample(userExample);
        return data.get(0).getAvatarurl();
    }

    public int updataStuffByStuffId(Stuff stuff){
        return stuffMapper.updateByPrimaryKeySelective(stuff);
    }

    public int updataUserById(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public User selectUserById(int id){
        return userMapper.selectByPrimaryKey(id);
    }

}
