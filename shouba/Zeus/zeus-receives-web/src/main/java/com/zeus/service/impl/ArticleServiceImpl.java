package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.commons.Articles;
import com.zeus.constant.Constants;
import com.zeus.dao.*;
import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.*;
import com.zeus.exception.CommonCode;
import com.zeus.service.ArticleService;
import com.zeus.service.EcsAccountLogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

/**
 * @Description 物品操作服务层
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private WorkUsersMapper workUsersMapper;
    @Autowired
    private OrcMapper orcMapper;
    @Autowired
    private BagsMapper bagsMapper;
    @Autowired
    private EcsAccountLogService ecsAccountLogService;
    @Autowired
    private UsersLogMapper usersLogMapper;
    @Autowired
    private WorkMoneyMapper workMoneyMapper;
    /**
     * @param
     * @return void
     * @methodName add   回收员添加活动物品回收，并将物品状态修改为1
     * @author wangdi
     * @date 2019/1/10
     */
    @Override
    public QueryResponseResult add(Articles articles, String username) {

        WorkUsers workUsers = workUsersMapper.selectuserName(username);
        Long userId = articles.getUserId();

        List<Article> article1s = articles.getArticle();

        try {
            for (Article article : article1s) {

                article.setStatus("1");
                article.setCreateTime(new Date());
                article.setUserId(userId);
                article.setUpdateTime(new Date());
                article.setRecycleUserId(workUsers.getId());

                Integer insert = articleMapper.insert(article);

            }
        } catch (Exception e) {
            e.printStackTrace();
            new QueryResponseResult<>(CommonCode.ADD_FAIL, null);
        }
        return new QueryResponseResult(CommonCode.ADD_SUCCESSFUL, null);
    }

    @Override
    public Response fanAll() {
        List<Article> articles = articleMapper.fandAll();
        Response objectResponse = new Response<>();
        objectResponse.setData(articles);

        return objectResponse;
    }

    @Override
    public void add1(Article article) {

        articleMapper.insert(article);
    }

    /**
     * @param [articles, username]
     * @return com.zeus.common.QueryResponseResult
     * @methodName warehouseArticleAdd 仓管员回收物品，
     * 1.添加物品将状态修改为2，
     * 2.并修改二维码和回收袋的状态为2,
     * 3.并返回虚拟币给客户
     * 4.添加用户的回收日志
     * @author wangdi
     * @date 2019/1/18
     */
    @Override
    public QueryResponseResult warehouseArticleAdd(Articles articles, String username, Long orcid, String pricenum,String type) {

        //获取出仓管员的用户
        WorkUsers workUsers = workUsersMapper.selectuserName(username);
        //获取出用户的id
        Long userId = articles.getUserId();
        //获取出物品
        List<Article> articles1 = articles.getArticle();
        //查询出二维码和回收袋
        Orc orc = orcMapper.selectByPrimaryKey(orcid);
        Bags bags = bagsMapper.selectorcid(orcid);
        //将计算好的金额交给客户，并添加用户的交易日志
        userMoney(articles1, userId, workUsers.getId(), pricenum);
        //存入物品
        articlesadd(articles1, userId, workUsers.getId(),bags.getId());

        orcMapper.updateworkUsersStatus(orc.getId());
        bagsMapper.updateworkUsersStatus(bags.getId());
        //跟仓管员加虚拟币
        workUsersMoney(workUsers,type);

        return new QueryResponseResult<>(CommonCode.SUCCESS, null);

    }
  /**
   *
   *
   * @methodName  workUsersMoney 跟仓管员加虚拟币
   * @author wangdi
   * @param [workUsers]
   * @return void
   * @date 2019/1/19
   */
    private void workUsersMoney(WorkUsers workUsers,String type) {
        synchronized(ArticleServiceImpl.class) {
            //3.为细分
            if (Constants.THREE_NUM.equals(type)) {

                WorkMoney workMoney = workMoneyMapper.selectFandOne("3");
                workUsers.setMoney(workUsers.getMoney() + workMoney.getMoney());
                workUsersMapper.updateByPrimaryKey(workUsers);

            } else if (Constants.FOUR_NUM.equals(type)) {
                //4为粗分
                WorkMoney workMoney = workMoneyMapper.selectFandOne("2");
                workUsers.setMoney(workUsers.getMoney() + workMoney.getMoney());
                workUsersMapper.updateByPrimaryKey(workUsers);


            }
        }
    }

  /**
   *
   *
   * @methodName  articlesadd 存入物品
   * @author wangdi
   * @param [articles, userId, id, bagsid]
   * @return void
   * @date 2019/1/23
   */
    private void articlesadd(List<Article> articles, Long userId, Long id ,Long bagsid) {

        for (Article article : articles) {
            article.setStatus("2");
            article.setUpdateTime(new Date());
            article.setCreateTime(new Date());
            article.setWarehouseId(id);
            article.setUserId(userId);
            article.setBagsid(bagsid);
            articleMapper.insert(article);
        }
    }

    /**
     * @param [article]
     * @return void
     * @methodName userMoney   //将计算好的金额交给客户，并添加用户的交易日志
     * @author wangdi
     * @date 2019/1/18
     */
    @Transactional(rollbackFor = { Exception.class })
    public void userMoney(List<Article> articles, Long userid, Long workUsersId, String pricenum) {
        Double money = 0D;
        synchronized(ArticleServiceImpl.class) {
        try {
            //获取物品总金额
            //1为分类
            if (Constants.ONE_NUM.equals(pricenum)) {

                for (Article article : articles) {
                    Double articleWeight = article.getArticleWeight();
                    Double articlePrice = article.getArticlePrice();
                    Double money1 = articleWeight * articlePrice;
                    money += money1;
                }

            } else {
                //2为未分类
                for (Article article : articles) {
                    Double articleWeight = article.getArticleWeight();
                    Double articlePrice = article.getArticlePrice() + article.getPrice();
                    Double money1 = articleWeight * articlePrice;
                    money += money1;
                }
            }
            //计算好金额
            ecsAccountLogService.updateUser(userid, money);

            UsersLog usersLog = new UsersLog();
            usersLog.setCreateTime(new Date());
            usersLog.setMoney(money);
            usersLog.setParticulars("物品回收");
            usersLog.setUserId(userid);
            usersLog.setWarehouseId(workUsersId);
            usersLogMapper.insert(usersLog);


        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }


}
