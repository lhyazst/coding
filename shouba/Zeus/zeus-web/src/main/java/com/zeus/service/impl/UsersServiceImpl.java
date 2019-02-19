package com.zeus.service.impl;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.dao.AddressMapper;
import com.zeus.dao.EcsAccountLogMapper;
import com.zeus.dao.SmsMapper;
import com.zeus.dao.UsersMapper;
import com.zeus.entity.Address;
import com.zeus.entity.EcsAccountLog;
import com.zeus.entity.Sms;
import com.zeus.entity.Users;
import com.zeus.exception.CommonCode;
import com.zeus.service.UsersService;
import com.zeus.sms.SmsUtil;
import com.zeus.utils.EmptyUtil;
import org.mortbay.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @author:wangdi
 * @date:2019/1/13
 * @ver:1.0
 */
@Service
@PropertySource("classpath:application.properties")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private EcsAccountLogMapper ecsAccountLogMapper;
    @Autowired
    private SmsMapper smsMapper;
   @Autowired
    private AddressMapper addressMapper;
    @Value("${template_code}")
    private String template_code;

    @Value("${sign_name}")
    private String sign_name;
   /**
    *
    *
    * @methodName  createSmsCode  发送验证码
    * @author wangdi
    * @param [phone]
    * @return void
    * @date 2019/1/15
    */
    @Override
    public void createSmsCode(final String phone) {
        //1.生成一个6位随机数（验证码）
        final String smscode = (long) (Math.random() * 1000000) + "";
        System.out.println("验证码：" + smscode);

        //2.将验证码放入数据库
        Sms sms = new Sms();
        sms.setCreateTime(new Date());
        long a = System.currentTimeMillis();
        long time = a + 5 * 60 * 1000;
        sms.setPhone(Long.getLong(phone));
        sms.setSmsNumber(Long.getLong(smscode));
        sms.setEndTime(new Date(time));
        smsMapper.insert(sms);

        //3.将短信内容发送给sms
        Map map = new HashMap(16);
        map.put("number", smscode);
        SmsUtil smsUtil = new SmsUtil();

        try {
            SendSmsResponse response = smsUtil.sendSms(phone, template_code, sign_name, smscode, JSON.toString(map));
            System.out.println("code:" + response.getCode());
            System.out.println("message:" + response.getMessage());

        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     *
     * @methodName  checkSmsCode 校验验证码
     * @author wangdi
     * @param [phone, code]
     * @return boolean
     * @date 2019/1/15
     */
    @Override
    public boolean checkSmsCode(String phone, String code) {

       Sms sms = smsMapper.selectPhone(phone);
        long timeMillis = System.currentTimeMillis();
        if(timeMillis > sms.getEndTime().getTime()){
           return false;
       }
      boolean b =  sms.getSmsNumber().equals(Long.getLong(code));
       if(b){
           smsMapper.deleteByPrimaryKey(sms.getId());
       }
        return b;
    }
    /**
     *
     *
     * @methodName  add  添加用户
     * @author wangdi
     * @param [user, phone]
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/27
     */
    @Override
    public QueryResponseResult add(Users user,String phone) {

        if (EmptyUtil.isEmpty(user )) {
            return new QueryResponseResult(CommonCode.INVALID_PARAM,null);
        }
        try{
            user.setTelephone(phone);
            user.setNickName(phone);
            usersMapper.insert(user);
        }catch (Exception e){
            e.printStackTrace();
            return new QueryResponseResult(CommonCode.ADD_SUCCESSFUL,null);
        }

        return new QueryResponseResult(CommonCode.SUCCESS,null);
    }
    /**
     *
     *
     * @methodName  fanOne  查询出该用户的账户
     * @author wangdi
     * @param [username]
     * @return com.zeus.entity.EcsAccountLog
     * @date 2019/1/16
     */
    @Override
    public EcsAccountLog fanOne(String username) {

        Users users = usersMapper.selectByName(username);
        EcsAccountLog ecsAccountLog = ecsAccountLogMapper.selectUserEscAccountLog(users.getId());

        return ecsAccountLog;
    }
    /**
     *
     *
     * @methodName  userfandOne 查询出用户信息
     * @author wangdi
     * @param []
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/27
     */
    @Override
    public QueryResponseResult userfandOne(String username) {

        EcsAccountLog ecsAccountLog = fanOne(username);
        Users users = usersMapper.selectByName(username);
        Address address = addressMapper.selectByPrimaryKey(users.getId());

        QueryResult<Object> objectQueryResult = new QueryResult<>();

        Map map = new HashMap();
        map.put("ecsAccountLog",ecsAccountLog);
        map.put("users",users);
        map.put("address",address);

         objectQueryResult.setT(map);
        return new QueryResponseResult(CommonCode.SUCCESS,objectQueryResult);
    }


}
