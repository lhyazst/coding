package com.zeus.service.impl;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.common.Response;
import com.zeus.constant.Constants;
import com.zeus.dao.*;
import com.zeus.entity.*;
import com.zeus.exception.CommonCode;
import com.zeus.service.OrcService;

import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 扫描二维码
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
public class OrcServiceImpl implements OrcService {
    @Autowired
    private OrcMapper orcMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private BagsMapper bagsMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ArticleStdmodeMapper articleStdmodeMapper;
    @Autowired
    private WarehouseBagsMapper warehouseBagsMapper;
    @Autowired
    private WorkUsersMapper workUsersMapper;
    @Autowired
    private RecycleUserNumMapper recycleUserNumMapper;
    @Autowired
    private WorkMoneyMapper workMoneyMapper;
    @Autowired
   private SiteWorkUsersMapper siteWorkUsersMapper;
    /**
     * @param
     * @return com.zeus.common.Response
     * @methodName orcFandOne 回收员扫描二维码返回回收袋编号和用户信息要求状态必须为0,或者扫描回收箱设置回收箱状态为1，二维码状态为0
     * @author wangdi           扫描仓库二维码类型为三
     * @date 2019/1/10
     */
    @Override
    public QueryResponseResult orcFandOne(Long orcid, String username) {
        Orc orc1 = orcMapper.selectByPrimaryKey(orcid);
        WorkUsers workUsers = workUsersMapper.selectuserName(username);

         if(orc1==null){
             return new QueryResponseResult(CommonCode.FAIL,null);
         }
        //回收员扫描回收箱
        if (Constants.TWO_NUM.equals(orc1.getOrcType())) {
            orcMapper.updateBinStatus(orc1.getId());
            //当回收员扫描回收箱时记录站点，这里使用的时二维码id充当站点id
            SiteWorkUsers siteWorkUsers = new SiteWorkUsers();
            siteWorkUsers.setCreateTime(new Date());
            siteWorkUsers.setSiteId(orc1.getId());
            siteWorkUsers.setWorkUsers(workUsers.getId());
            siteWorkUsersMapper.insert(siteWorkUsers);
            QueryResult<Object> objectQueryResult = new QueryResult<>();
            objectQueryResult.setT(orc1);
            return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
        } else if (Constants.ONE_NUM.equals(orc1.getOrcType())) {
            //回收员扫描回收袋
            Users users = usersMapper.selectByPrimaryKey(orc1.getUserId());
            Address address = addressMapper.selectByPrimaryKey(users.getId());
            Bags bags = bagsMapper.selecttow(orc1.getUserId(), orc1.getOrcNumber());
            Map map = new HashMap<>(16);
            map.put("orc", orc1);
            map.put("users", users);
            map.put("bags", bags);
            map.put("address", address);
            QueryResult<Object> objectQueryResult = new QueryResult<>();
            objectQueryResult.setT(map);

            return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
        } else if (Constants.THREE_NUM.equals(orc1.getOrcType())) {
            //回收员扫描仓库将仓库二维码和回收袋进行绑定

            List<Orc> orc = orcMapper.selectusers(workUsers.getId());
            for (Orc orc2 : orc) {
                if (!Constants.ONE_NUM.equals(orc2.getStatus())) {
                    continue;
                }
                Bags bags = bagsMapper.selectorcid(orc2.getId());
                WarehouseBags warehouseBags = new WarehouseBags();
                warehouseBags.setBagsId(bags.getId());
                warehouseBags.setWarehouseId(orcid);
                warehouseBags.setCreateTime(new Date());
                warehouseBagsMapper.insert(warehouseBags);

            }
            //回收员扫描仓库将回收员id跟仓库进行绑定
            RecycleUserNum recycleUserNum = new RecycleUserNum();
            recycleUserNum.setCreateTime(new Date());
            recycleUserNum.setRecycleUserId(workUsers.getId());
            recycleUserNum.setWarehouseId(orcid);
            recycleUserNumMapper.insert(recycleUserNum);
            synchronized(OrcServiceImpl.class) {
                WorkMoney workMoney = workMoneyMapper.selectFandOne("1");
                workUsers.setMoney(workUsers.getMoney() + workMoney.getMoney());
                workUsersMapper.updateByPrimaryKey(workUsers);

            }
            return new QueryResponseResult(CommonCode.SUCCESS, null);


        }

        return new QueryResponseResult(CommonCode.FAIL, null);

    }


    /**
     * @param [orcId]
     * @return java.lang.Boolean
     * @methodName updateStatus  回收员回收过后更改二维码状态为1 ，并出入回收员id
     * @author wangdi
     * @date 2019/1/16
     */
    @Override
    public Boolean updateStatus(Long orcId, Long userid) {
        try {
            orcMapper.updatestatus(orcId, userid,new Date());
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @param [orcid]
     * @return com.zeus.common.QueryResponseResult
     * @methodName workUserOrcFandOne  仓管员扫描回收袋返回用户信息和物品所有种类
     * @author wangdi
     * @date 2019/1/17
     */
    @Override
    public QueryResponseResult workUserOrcFandOne(Long orcid) {
        if (EmptyUtil.isEmpty(orcid)) {
            throw new IllegalArgumentException();
        }

        Orc orc = orcMapper.selectByPrimaryKey(orcid);
        Bags bags = bagsMapper.selectorcid(orcid);
        Users users = usersMapper.selectByPrimaryKey(bags.getUserId());
        Address address = addressMapper.selectByPrimaryKey(users.getId());
        QueryResult<Object> objectQueryResult = new QueryResult<>();
        List<ArticleStdmode> articleStdmodes = articleStdmodeMapper.fandAll();
        Map map = new HashMap(16);
        map.put("orc", orc);
        map.put("users", users);
        map.put("address", address);
        map.put("articleStdmodes", articleStdmodes);
        objectQueryResult.setT(map);
        return new QueryResponseResult<>(CommonCode.SUCCESS, objectQueryResult);
    }
}










