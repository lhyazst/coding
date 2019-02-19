package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.dao.ActivityProductMapper;
import com.zeus.dao.OrcMapper;
import com.zeus.dao.SiteWorkUsersMapper;
import com.zeus.dao.WorkUsersMapper;
import com.zeus.entity.ActivityProduct;
import com.zeus.entity.Orc;
import com.zeus.entity.WorkUsers;
import com.zeus.exception.CommonCode;
import com.zeus.service.ActivityProductService;
import com.zeus.service.SiteWorkUsersService;
import com.zeus.utils.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Description 活动操作服务实现类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
public class SiteWorkUsersServiceImpl implements SiteWorkUsersService {
    @Autowired
    private SiteWorkUsersMapper siteWorkUsersMapper;
    @Autowired
    private WorkUsersMapper workUsersMapper;
    @Autowired
    private OrcMapper orcMapper;

    /**
     * @param []
     * @return com.zeus.common.QueryResponseResult
     * @methodName siteWorkUsersSelect 回收员查询出回收管理里面的统计回收袋数量和站点数量
     * @author wangdi
     * @date 2019/1/27
     */
    @Override
    public QueryResponseResult siteWorkUsersSelect(String username) {
        WorkUsers workUsers = workUsersMapper.selectuserName(username);
        //查询出所有站点的数量
        Long num = siteWorkUsersMapper.selectSiteWorkUser(workUsers.getId());
        //更具时间查询站点当天的数量
        String date = DateUtils.date2String(new Date(), "yyyy-MM-dd");
        Long dateNum = siteWorkUsersMapper.selectSiteWorkUserDate(date, workUsers.getId());
        //查询出所有回收袋的数量
        List<Orc> bagsnum = orcMapper.selectusers(workUsers.getId());
        //查询出当天回收袋的数量
        List<Orc> bagsnumDate = orcMapper.selectusersDate(date, workUsers.getId());

        HashMap map = new HashMap();
        map.put("num", num);
        map.put("datenum", dateNum);
        map.put("bagsnum", bagsnum.size());
        map.put("bagsnumDate", bagsnumDate.size());

        QueryResult queryResult = new QueryResult();
        queryResult.setT(map);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }
}
