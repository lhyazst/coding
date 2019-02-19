package com.zeus.service.impl;


import com.zeus.common.QRCodeUrl;
import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.common.Response;
import com.zeus.dao.*;
import com.zeus.entity.*;
import com.zeus.exception.CommonCode;
import com.zeus.service.AppointmentRecycleSiteService;
import com.zeus.utils.EmptyUtil;
import com.zeus.utils.IdWorker;
import com.zeus.utils.QRCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
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
    @Autowired
    private BagsMapper bagsMapper;
    @Autowired
    private OrcMapper orcMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private AddressMapper addressMapper;

    /**
     * @param []
     * @return com.zeus.common.Response
     * @methodName appointmentRecycleSiteServiceFandAll   更具小区名称查询出所有的预约回收站点；
     * @author wangdi
     * @date 2019/1/8
     */
    @Override
    public QueryResponseResult appointmentRecycleSiteServiceFandAll(String username) {

        List<AppointmentRecycleSite> appointmentRecycle = appointmentRecycleSiteMapper.recycleSiteFandAll(username);
        //查询出所有有预约的用户小区名称
        List<Address> addresses = recycleSiteAddressFandAll();

        QueryResult<Object> objectQueryResult = new QueryResult<>();

        Map map = new HashMap(16);
        map.put("appointmentRecycle", appointmentRecycle);
        map.put("addresses", addresses);
        objectQueryResult.setT(map);

        return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
    }

    /**
     * @param []
     * @return java.util.List<com.zeus.entity.Address>
     * @methodName recycleSiteAddressFandAll  查询出所有有预约的用户小区名称
     * @author wangdi
     * @date 2019/1/18
     */
    private List<Address> recycleSiteAddressFandAll() {

        return addressMapper.fandAll();
    }


    /**
     * @param [userId]
     * @return com.zeus.common.Response
     * @methodName appointmentRecycleSiteServicefanOne 生产二维码和用户信息并返回用户和二维码；
     * @author wangdi
     * @date 2019/1/8
     */
    @Override
    public Response appointmentRecycleSiteServicefanOne(Long userId) {


        Users users = usersMapper.selectByPrimaryKey(userId);
        QRCodeUrl qrcode = qrcode(userId);
        Response objectResponse = new Response();
        Map map = new HashMap<>(16);
        map.put("users", users);
        map.put("qrcode", qrcode);
        objectResponse.setData(map);

        return objectResponse;
    }

    /**
     * @param
     * @return java.lang.Boolean
     * @methodName appointmentRecycle 添加二维码和回收袋
     * @author wangdi
     * @date 2019/1/8
     */

    @Override
    public Boolean appointmentRecycle(QRCodeUrl qrCodeUrl, Long userId) {
        try {
            qrCode(qrCodeUrl, userId);
            addbags(userId, qrCodeUrl);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }


        return true;
    }
    /**
     *
     *
     * @methodName  siteName 查询出小区的名称当作查询条件
     * @author wangdi
     * @param []
     * @return java.lang.String
     * @date 2019/1/18
     */
    @Override
    public String siteName() {

        //查询出所有有预约的用户小区名称
        List<Address> addresses = recycleSiteAddressFandAll();
        String community = addresses.get(0).getCommunity();
        return community;
    }

    /**
     * @param
     * @return void
     * @methodName addbags 添加回收袋方法
     * @author wangdi
     * @date 2019/1/8
     */
    private void addbags(Long userId, QRCodeUrl qrCodeUrl) {

        Bags bags = new Bags();
        bags.setCreateTime(new Date());
        bags.setBagstype("3");
        bags.setUpdateTime(new Date());
        bags.setStatus("1");
        bags.setSerialNumber(qrCodeUrl.getQrCidenum());
        bags.setUserId(userId);
        bags.setOrcId(qrCodeUrl.getIdWorker());
        bagsMapper.insert(bags);
    }

    /**
     * @param
     * @return void
     * @methodName qrCode 添加二维码方法
     * @author wangdi
     * @date 2019/1/8
     */
    private void qrCode(QRCodeUrl qrCodeUrl, Long userId) {

        Orc orc = new Orc();
        orc.setId(qrCodeUrl.getIdWorker());
        orc.setCreateTime(new Date());
        orc.setOrcNumber(qrCodeUrl.getQrCidenum());
        orc.setOrcUrl(qrCodeUrl.getQrCideUrl());
        //回收员id需要更换
        orc.setRecycleUserId(121L);
        orc.setStatus("1");
        orc.setUpdateTime(new Date());
        orc.setUserId(userId);
        orcMapper.insert(orc);
    }


    /**
     * @param [userId]
     * @return void
     * @methodName qrcode 生产二维码和回收袋编号
     * @author wangdi
     * @date 2019/1/8
     */
    private QRCodeUrl qrcode(Long userId) {

        QRCodeUrl orcurl = QRCode.orc(userId, "d:/", idWorker.nextId());
        List<Orc> orcs = orcMapper.selectOrcNumber(Long.getLong(orcurl.getQrCideUrl()), userId);
        if (!EmptyUtil.isEmpty(orcs)) {
            File file = new File(orcurl.getQrCideUrl());
            file.delete();
            return qrcode(userId);
        }

        return orcurl;

    }


}
