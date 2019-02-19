package com.zeus.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.dao.RecycleSiteMapper;
import com.zeus.entity.RecycleSite;
import com.zeus.entity.Users;
import com.zeus.exception.CommonCode;
import com.zeus.service.RecycleSiteService;
import com.zeus.utils.EmptyUtil;
import com.zeus.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 回收站点服务实现类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
public class RecycleSiteServiceImpl implements RecycleSiteService {

    @Autowired
    private RecycleSiteMapper recycleSiteMapper;

    /**
     * @param []
     * @return com.zeus.common.Response
     * @methodName RecycleStieFandAll 查询出所有状态等于0的站点
     * @author wangdi
     * @date 2019/1/10
     */
    @Override
    public Map recycleStieFandAll(Integer page, Integer size) {
        if (EmptyUtil.isEmpty(page) || EmptyUtil.isEmpty(size)) {
            Map map = new HashMap<>();
            map.put("code", Result.FALL_CODE);
            map.put("msg", "");
            return map;
        }

        //分页参数
        if (page <= 0) {
            page = 1;
        }
        //page = page -1;
        if (size <= 0) {
            size = 10;
        }
        PageHelper.startPage(page, size);
        List<RecycleSite> recycleSites = recycleSiteMapper.fandAll();
        Map<String, Object> map = new HashMap<>();
        PageInfo<RecycleSite> pageInfo = new PageInfo<>(recycleSites);
        map.put("code", Result.SUCCESS_CODE);
        map.put("msg", "");
        map.put("data", pageInfo.getList());
        map.put("count", pageInfo.getTotal());
        return map;
    }

    /**
     * @param [id]
     * @return java.util.Map
     * @methodName recycleSiteDelete 删除站点
     * @author wangdi
     * @date 2019/1/30
     */
    @Override
    public Map recycleSiteDelete(Long id) {
        if (EmptyUtil.isEmpty(id)) {
            Map map = new HashMap<>();
            map.put("code", Result.FALL_CODE);
            map.put("msg", "");
            return map;
        }
        recycleSiteMapper.deleteByPrimaryKey(id);

        Map map = new HashMap<>();
        map.put("code", Result.SUCCESS_CODE);
        map.put("msg", "");
        return map;
    }
}
