package com.zeus.service;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.entity.Orc;

/**
 * @Description  二维码
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface OrcService {

   /**
    *
    *
    * @methodName  orcFandOne 扫描二维码获取编号
    * @author wangdi
    * @param [id]
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/14
    */
    QueryResponseResult orcFandOne(Long id);
  /**
   *
   *
   * @methodName  addOrcUsername  用户扫描绑定回收箱
   * @author wangdi
   * @param [id, username]
   * @return com.zeus.common.QueryResponseResult
   * @date 2019/1/14
   */
    QueryResponseResult addOrcUsername(Long id, String username);
    /**
     *
     *
     * @methodName  addOrcUsernum  用户输入编号绑定回收箱
     * @author wangdi
     * @param [num, username]
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/16
     */
    QueryResponseResult addOrcUsernum(Long num, String username);
    /**
     *
     *
     * @methodName  addOrcUsernameBags 用户绑定普通回收袋
     * @author wangdi
     * @param [id, username]
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/16
     */
    QueryResponseResult addOrcUsernameBags(Long id, String username);
   /**
    *
    *
    * @methodName  addOrcUsernameBagsWaste  用户绑定厨余回收袋
    * @author wangdi
    * @param [id, username]
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/16
    */
    QueryResponseResult addOrcUsernameBagsWaste(Long id, String username);



}
