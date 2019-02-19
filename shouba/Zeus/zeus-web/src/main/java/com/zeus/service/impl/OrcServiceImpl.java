package com.zeus.service.impl;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.constant.Constants;
import com.zeus.dao.BagsMapper;
import com.zeus.dao.OrcMapper;
import com.zeus.dao.RecycleBinMapper;
import com.zeus.dao.UsersMapper;
import com.zeus.entity.Bags;
import com.zeus.entity.Orc;
import com.zeus.entity.RecycleBin;
import com.zeus.entity.Users;
import com.zeus.exception.CommonCode;
import com.zeus.service.OrcService;
import com.zeus.utils.EmptyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Description 扫描二维码
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class OrcServiceImpl implements OrcService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrcServiceImpl.class);
    @Autowired
    private OrcMapper orcMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private BagsMapper bagsMapper;
    @Autowired
    private RecycleBinMapper recycleBinMapper;

    /**
     * @param [id]
     * @return com.zeus.common.QueryResponseResult
     * @methodName orcFandOne 用户扫描二维码获取编号要求二维码状态必须为3,并且要判断是否是回收箱的二维码；
     * @author wangdi
     * @date 2019/1/14
     */
    @Override
    public QueryResponseResult orcFandOne(Long id) {

        if (EmptyUtil.isEmpty(id)) {
            LOGGER.error("二维码id为空:{}", id);
            return new QueryResponseResult(CommonCode.INVALID_PARAM, null);

        }
        Orc orc = orcMapper.selectByPrimaryKey(id);
        if (EmptyUtil.isEmpty(orc)) {
            LOGGER.error("数据不存在:{}", id);
            return new QueryResponseResult(CommonCode.DATA_NOT_FOUND, null);

        }
        QueryResult objectQueryResult = new QueryResult<>();
        //判断是否是回收箱，如果是回收箱判断他的状态是否为0，是
        if (Constants.TWO_NUM.equals(orc.getOrcType())) {
            if (Constants.ZERO_NUM.equals(orc.getStatus())) {
                orcMapper.updateBinStatus(orc.getId());
                return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
            }

        }
        objectQueryResult.setT(orc);
        return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
    }

    /**
     * @param [id, username]
     * @return com.zeus.common.QueryResponseResult
     * @methodName addOrcUsername用户绑定回收箱
     * @author wangdi
     * @date 2019/1/14
     */
    @Override
    public QueryResponseResult addOrcUsername(Long id, String username) {
        if (EmptyUtil.isEmpty(id) || EmptyUtil.isEmpty(username)) {
            LOGGER.error("二维码id为空或则userName为空:{}", id, username);
            return new QueryResponseResult(CommonCode.INVALID_PARAM, null);

        }
        Users users = usersMapper.selectByName(username);
        Orc orc = orcMapper.selectByPrimaryKey(id);
        //获取回收箱里面的回收袋数
        Long num = bagsMapper.fandAllNum(users.getId());
        //查询出回收袋对象
        List<Bags> bags = bagsMapper.selectFandUserId(users.getId());
        //更新回收袋站点
        updateBagsRecycleSiteName(bags, orc);
        //更新二维码状态
        update(orc, users.getId());
        //更改回收箱
        updateRecycleBin(orc, users.getId(), num);

        return new QueryResponseResult(CommonCode.SUCCESS, null);
    }

    /**
     * @param [bags, orc]
     * @return void
     * @methodName updateBagsRecycleSiteName  更新回收袋的站点名称
     * @author wangdi
     * @date 2019/1/17
     */
    private void updateBagsRecycleSiteName(List<Bags> bags, Orc orc) {

        for (Bags bags1 : bags) {
            bags1.setUpdateTime(new Date());
            bags1.setRecycleBinSerialNumber(orc.getSiteId());
        }

    }

    /**
     * @param [num, username]
     * @return com.zeus.common.QueryResponseResult
     * @methodName addOrcUsernum  通过编号获取二维码
     * @author wangdi
     * @date 2019/1/14
     */
    @Override
    public QueryResponseResult addOrcUsernum(Long num, String username) {

        Orc orc = orcMapper.selectByOrcNum(num);

        return addOrcUsername(orc.getId(), username);
    }

    /**
     * @param [id, username]
     * @return com.zeus.common.QueryResponseResult
     * @methodName addOrcUsernameBags  用户添加回收袋
     * @author wangdi
     * @date 2019/1/15
     */
    @Override
    public QueryResponseResult addOrcUsernameBags(Long id, String username) {

        if (EmptyUtil.isEmpty(id) || EmptyUtil.isEmpty(username)) {
            LOGGER.error("二维码id为空或则userName为空:{}", id, username);
            return new QueryResponseResult(CommonCode.INVALID_PARAM, null);

        }
        Users users = usersMapper.selectByName(username);
        Orc orc = orcMapper.selectByPrimaryKey(id);
        //获取回收箱里面的回收袋数
        Long num = bagsMapper.fandAllNum(users.getId());
        //更新二维码状态
        update(orc, users.getId());
        //添加回收袋
        addBags(orc, users.getId());

        return new QueryResponseResult(CommonCode.SUCCESS, null);

    }

    /**
     * @param [id, username]
     * @return com.zeus.common.QueryResponseResult
     * @methodName addOrcUsernameBagsWaste 用户绑定厨余回收袋
     * @author wangdi
     * @date 2019/1/16
     */
    @Override
    public QueryResponseResult addOrcUsernameBagsWaste(Long id, String username) {
        if (EmptyUtil.isEmpty(id) || EmptyUtil.isEmpty(username)) {
            LOGGER.error("二维码id为空或则userName为空:{}", id, username);
            return new QueryResponseResult(CommonCode.INVALID_PARAM, null);

        }
        Users users = usersMapper.selectByName(username);
        Orc orc = orcMapper.selectByPrimaryKey(id);
        update(orc, users.getId());


        //添加回收袋
        addBagsWaste(orc, users.getId());

        return new QueryResponseResult(CommonCode.SUCCESS, null);


    }

    /**
     * @param [orc, id]
     * @return void
     * @methodName addBagsWaste  添加厨余回收袋
     * @author wangdi
     * @date 2019/1/16
     */
    private void addBagsWaste(Orc orc, Long userId) {
        Bags bags = new Bags();
        bags.setUserId(userId);
        bags.setStatus("0");
        bags.setSerialNumber(orc.getOrcNumber());
        bags.setUpdateTime(new Date());
        bags.setCreateTime(new Date());
        bags.setOrcId(orc.getId());
        bags.setBagstype("2");
        bagsMapper.insert(bags);

    }

    /**
     * @param [id, userid]
     * @return void
     * @methodName addRecycleBin  更改回收箱并将回收箱的状态设置为0
     * @author wangdi
     * @date 2019/1/14
     */
    private void updateRecycleBin(Orc orc, Long userid, Long num) {

        RecycleBin recycleBin = recycleBinMapper.selectByPrimaryKey(orc.getId());
        recycleBin.setUserid(userid);
        recycleBin.setUpdateTime(new Date());
        recycleBin.setOrcId(orc.getId());
        recycleBin.setStatus("0");
        recycleBin.setSerialNumber(orc.getOrcNumber());
        recycleBin.setRecycleSiteName(orc.getSiteName());
        recycleBin.setRecycleSiteId(orc.getSiteId());
        recycleBin.setBagsnum(recycleBin.getBagsnum() + num);
        recycleBinMapper.updateByPrimaryKey(recycleBin);


    }

    /**
     * @param [orc, userId]
     * @return void
     * @methodName addBags  添加普通回收袋
     * @author wangdi
     * @date 2019/1/14
     */
    private void addBags(Orc orc, Long userId) {
        Bags bags = new Bags();
        bags.setUserId(userId);
        bags.setStatus("0");
        bags.setSerialNumber(orc.getOrcNumber());
        bags.setUpdateTime(new Date());
        bags.setCreateTime(new Date());
        bags.setOrcId(orc.getId());
        bags.setBagstype("1");
        bagsMapper.insert(bags);
    }

    /**
     * @param [orc, id]
     * @return void
     * @methodName update 用户扫描二维码更改状态
     * @author wangdi
     * @date 2019/1/14
     */
    private void update(Orc orc, long id) {
        orc.setStatus("0");
        orc.setUpdateTime(new Date());
        orc.setUserId(id);
        orcMapper.updateByPrimaryKey(orc);

    }


}










