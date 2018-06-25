package com.cictec.middleware.tsinghua.entity.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_device")
public class TDevice {
    public static final String DEVICE_OFF_LINE = "0";
    public static final String DEVICE_ON_LINE = "1";

    @Id
    @Column(name = "dev_uuid")
    private String devUuid;

    /**
     * 设备编号
     */
    @Column(name = "dev_code")
    private String devCode;

    /**
     * 型号
     */
    @Column(name = "dev_model_num")
    private String devModelNum;

    /**
     * 版本号
     */
    @Column(name = "dev_version")
    private String devVersion;

    @Column(name = "dev_plate_number")
    private String devPlateNumber;

    /**
     * sim卡号
     */
    @Column(name = "dev_sim_num")
    private String devSimNum;

    /**
     * 设备在线状态
0：断开
1：在线
     */
    @Column(name = "dev_online_status")
    private String devOnlineStatus;

    /**
     * 1 启用 0 禁用 
     */
    @Column(name = "dev_isvalid")
    private String devIsvalid;

    /**
     * 通用电话
     */
    @Column(name = "dev_phone")
    private String devPhone;

    @Column(name = "dev_create_user")
    private String devCreateUser;

    @Column(name = "dev_create_time")
    private Date devCreateTime;

    @Column(name = "dev_update_user")
    private String devUpdateUser;

    @Column(name = "dev_update_time")
    private Date devUpdateTime;

    /**
     * 删除标示 0：未删除 1 删除
     */
    @Column(name = "dev_drop_flag")
    private String devDropFlag;

    @Column(name = "dev_remark")
    private String devRemark;

    /**
     * 鉴权码
     */
    @Column(name = "dev_key")
    private String devKey;

    /**
     * @return dev_uuid
     */
    public String getDevUuid() {
        return devUuid;
    }

    /**
     * @param devUuid
     */
    public void setDevUuid(String devUuid) {
        this.devUuid = devUuid;
    }

    /**
     * 获取设备编号
     *
     * @return dev_code - 设备编号
     */
    public String getDevCode() {
        return devCode;
    }

    /**
     * 设置设备编号
     *
     * @param devCode 设备编号
     */
    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    /**
     * 获取型号
     *
     * @return dev_model_num - 型号
     */
    public String getDevModelNum() {
        return devModelNum;
    }

    /**
     * 设置型号
     *
     * @param devModelNum 型号
     */
    public void setDevModelNum(String devModelNum) {
        this.devModelNum = devModelNum;
    }

    /**
     * 获取版本号
     *
     * @return dev_version - 版本号
     */
    public String getDevVersion() {
        return devVersion;
    }

    /**
     * 设置版本号
     *
     * @param devVersion 版本号
     */
    public void setDevVersion(String devVersion) {
        this.devVersion = devVersion;
    }

    /**
     * @return dev_plate_number
     */
    public String getDevPlateNumber() {
        return devPlateNumber;
    }

    /**
     * @param devPlateNumber
     */
    public void setDevPlateNumber(String devPlateNumber) {
        this.devPlateNumber = devPlateNumber;
    }

    /**
     * 获取sim卡号
     *
     * @return dev_sim_num - sim卡号
     */
    public String getDevSimNum() {
        return devSimNum;
    }

    /**
     * 设置sim卡号
     *
     * @param devSimNum sim卡号
     */
    public void setDevSimNum(String devSimNum) {
        this.devSimNum = devSimNum;
    }

    /**
     * 获取设备在线状态
0：断开
1：在线
     *
     * @return dev_online_status - 设备在线状态
0：断开
1：在线
     */
    public String getDevOnlineStatus() {
        return devOnlineStatus;
    }

    /**
     * 设置设备在线状态
0：断开
1：在线
     *
     * @param devOnlineStatus 设备在线状态
0：断开
1：在线
     */
    public void setDevOnlineStatus(String devOnlineStatus) {
        this.devOnlineStatus = devOnlineStatus;
    }

    /**
     * 获取1 启用 0 禁用 
     *
     * @return dev_isvalid - 1 启用 0 禁用 
     */
    public String getDevIsvalid() {
        return devIsvalid;
    }

    /**
     * 设置1 启用 0 禁用 
     *
     * @param devIsvalid 1 启用 0 禁用 
     */
    public void setDevIsvalid(String devIsvalid) {
        this.devIsvalid = devIsvalid;
    }

    /**
     * 获取通用电话
     *
     * @return dev_phone - 通用电话
     */
    public String getDevPhone() {
        return devPhone;
    }

    /**
     * 设置通用电话
     *
     * @param devPhone 通用电话
     */
    public void setDevPhone(String devPhone) {
        this.devPhone = devPhone;
    }

    /**
     * @return dev_create_user
     */
    public String getDevCreateUser() {
        return devCreateUser;
    }

    /**
     * @param devCreateUser
     */
    public void setDevCreateUser(String devCreateUser) {
        this.devCreateUser = devCreateUser;
    }

    /**
     * @return dev_create_time
     */
    public Date getDevCreateTime() {
        return devCreateTime;
    }

    /**
     * @param devCreateTime
     */
    public void setDevCreateTime(Date devCreateTime) {
        this.devCreateTime = devCreateTime;
    }

    /**
     * @return dev_update_user
     */
    public String getDevUpdateUser() {
        return devUpdateUser;
    }

    /**
     * @param devUpdateUser
     */
    public void setDevUpdateUser(String devUpdateUser) {
        this.devUpdateUser = devUpdateUser;
    }

    /**
     * @return dev_update_time
     */
    public Date getDevUpdateTime() {
        return devUpdateTime;
    }

    /**
     * @param devUpdateTime
     */
    public void setDevUpdateTime(Date devUpdateTime) {
        this.devUpdateTime = devUpdateTime;
    }

    /**
     * 获取删除标示 0：未删除 1 删除
     *
     * @return dev_drop_flag - 删除标示 0：未删除 1 删除
     */
    public String getDevDropFlag() {
        return devDropFlag;
    }

    /**
     * 设置删除标示 0：未删除 1 删除
     *
     * @param devDropFlag 删除标示 0：未删除 1 删除
     */
    public void setDevDropFlag(String devDropFlag) {
        this.devDropFlag = devDropFlag;
    }

    /**
     * @return dev_remark
     */
    public String getDevRemark() {
        return devRemark;
    }

    /**
     * @param devRemark
     */
    public void setDevRemark(String devRemark) {
        this.devRemark = devRemark;
    }

    /**
     * 获取鉴权码
     *
     * @return dev_key - 鉴权码
     */
    public String getDevKey() {
        return devKey;
    }

    /**
     * 设置鉴权码
     *
     * @param devKey 鉴权码
     */
    public void setDevKey(String devKey) {
        this.devKey = devKey;
    }
}