package com.zeus.entity;


import java.util.List;

/**
 * @Description 角色
 * @Author wangdi
 * @Date 1/13/2019 11:30
 * @Version V1.0
 */
public class Role {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.id
     *
     * @mbggenerated Sun Jan 13 11:53:50 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.roleName
     *
     * @mbggenerated Sun Jan 13 11:53:50 CST 2019
     */
    private String rolename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.roleDesc
     *
     * @mbggenerated Sun Jan 13 11:53:50 CST 2019
     */
    private String roledesc;

    /**
     * 资源
     */
    private List<Permission> permissions;
    /**
     * 用户资源
     */
    private List<WorkUsers> users;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.id
     *
     * @return the value of role.id
     *
     * @mbggenerated Sun Jan 13 11:53:50 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.id
     *
     * @param id the value for role.id
     *
     * @mbggenerated Sun Jan 13 11:53:50 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.roleName
     *
     * @return the value of role.roleName
     *
     * @mbggenerated Sun Jan 13 11:53:50 CST 2019
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.roleName
     *
     * @param rolename the value for role.roleName
     *
     * @mbggenerated Sun Jan 13 11:53:50 CST 2019
     */
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.roleDesc
     *
     * @return the value of role.roleDesc
     *
     * @mbggenerated Sun Jan 13 11:53:50 CST 2019
     */
    public String getRoledesc() {
        return roledesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.roleDesc
     *
     * @param roledesc the value for role.roleDesc
     *
     * @mbggenerated Sun Jan 13 11:53:50 CST 2019
     */
    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc == null ? null : roledesc.trim();
    }
}