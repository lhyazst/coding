package com.zeus.service.impl;


        import com.zeus.common.QueryResponseResult;
        import com.zeus.common.QueryResult;
        import com.zeus.dao.*;
        import com.zeus.entity.*;
        import com.zeus.exception.CommonCode;
        import com.zeus.service.ActivityProductParticularsService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;


/**
 * @Description 活动详情操作服务实现类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
public class ActivityProductParticularsServiceImpl implements ActivityProductParticularsService {
    @Autowired
    private ActivityProductParticularsMapper activityProductParticularsMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private CommentsUserMapper commentsUserMapper;
    @Autowired
    private ActivityUserMapper activityUserMapper;
    @Autowired
    private BagsMapper bagsMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleStdmodeMapper articleStdmodeMapper;

    /**
     * @param
     * @return com.zeus.common.Response
     * @methodName activityProductParticularsServicefandOne   返回详情及用户评论
     * @author wangdi
     * @date 2019/1/5
     */
    @Override
    public QueryResponseResult activityProductParticularsServicefandOne(Long activityProductId) {

        Map activityProductmap = new HashMap(16);
        List<ActivityProductParticulars> activityProductParticulars = activityProductParticularsMapper.selectActivityList(activityProductId);
        //查询出所有的评论
        List<CommentsUser> commentsUsers1 = commentsUserMapper.fanAllActivityProductId(activityProductId);

        List list = new ArrayList();
        for (CommentsUser commentsUser : commentsUsers1) {
            //查询出所有参与评论的用户
            Long userId = commentsUser.getUserId();

            Users users = usersMapper.selectByPrimaryKey(userId);
            Long bags = bagsMapper.fanduserId(userId);
            commentsUser.setUsers(users);
            commentsUser.setBags(bags);
            list.add(commentsUser);
        }
        //查询出参与活动的用户
        List list1 = new ArrayList();
        List<ActivityUser> articles = activityUserMapper.fanAllActivityProductId(activityProductId);
        for (ActivityUser activityUser : articles) {
            List<Article> list2 = new ArrayList();
            Users users1 = usersMapper.selectByPrimaryKey(activityUser.getUserId());
            List<ArticleStdmode> articleStdmodes = articleStdmodeMapper.warehousearticleFanAll();

            List<Article> article = null;
            //查询出该用户的物品
            for (ArticleStdmode articleStdmode : articleStdmodes) {
                double weiht = 0;
                article = articleMapper.selectName(articleStdmode.getArticleName());
                if (article == null || article.size() < 1) {
                    continue;
                }
                Article article2 = new Article();
                for (Article article1 : article) {
                    weiht += article1.getArticleWeight();
                }
                article2.setArticleWeight(weiht);
                article2.setArticleName(articleStdmode.getArticleName());
                list2.add(article2);
            }
            if (list2.size() > 0) {
                users1.setArticles(list2);
            }
            list1.add(users1);
        }
        activityProductmap.put("users", list1);
        activityProductmap.put("commentsUsers", list);
        QueryResult objectQueryResult = new QueryResult<>();
        activityProductmap.put("activityProduct", activityProductParticulars);

        objectQueryResult.setT(activityProductmap);

        return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
    }
}
