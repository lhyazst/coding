package com.zeus.service.impl;


import com.zeus.common.Response;
import com.zeus.dao.AppointmentRecycleSiteMapper;
import com.zeus.dao.UsersMapper;
import com.zeus.entity.AppointmentRecycleSite;
import com.zeus.entity.Users;
import com.zeus.service.AppointmentRecycleSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description 回收站点服务实现类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
public class AppointmentRecycleSiteServiceImpl implements AppointmentRecycleSiteService {

    @Autowired
    private AppointmentRecycleSiteMapper appointmentRecycleSiteMapper;
    @Autowired
    private UsersMapper usersMapper;
    /**
     *
     *
     * @methodName  appointmentRecycleSiteAdd  存入用户填写的预约地址
     * @author wangdi
     * @param [url, date]
     * @return com.zeus.common.Response
     * @date 2019/1/11
     */
    @Override
    public Response appointmentRecycleSiteAdd(String url, Date date, String username) {

        Users users = usersMapper.selectByName(username);
        AppointmentRecycleSite appointmentRecycleSite = new AppointmentRecycleSite();
        appointmentRecycleSite.setCreateTime(new Date());
        appointmentRecycleSite.setUpdateTime(new Date());
        appointmentRecycleSite.setAppointmentTime(date);
        appointmentRecycleSite.setRecycleName(url);
        appointmentRecycleSite.setStatus("0");
        appointmentRecycleSite.setUserId(users.getId());

        appointmentRecycleSiteMapper.insert(appointmentRecycleSite);
        Response objectResponse = new Response<>();

        return objectResponse;
    }
}
