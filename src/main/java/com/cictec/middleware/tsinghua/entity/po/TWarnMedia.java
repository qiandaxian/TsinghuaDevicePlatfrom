package com.cictec.middleware.tsinghua.entity.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_warn_media")
public class TWarnMedia {
    /**
     * 报警图片表主键uuid
     */
    @Id
    @Column(name = "media_uuid")
    private String mediaUuid;

    /**
     * 报警信息uuid
     */
    @Column(name = "warn_uuid")
    private String warnUuid;

    /**
     * 报警图片名称
     */
    @Column(name = "media_name")
    private String mediaName;

    /**
     * 报警图片相对路径
     */
    @Column(name = "media_url")
    private String mediaUrl;

    /**
     * 报警图片序号
     */
    @Column(name = "media_type")
    private Integer mediaType;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "save_path")
    private String savePath;

    @Column(name = "download_url")
    private String downloadUrl;

    @Column(name = "download_time")
    private Date downloadTime;

    @Column(name = "download_type")
    private Integer downloadType;

    @Column(name = "media_encoding")
    private String mediaEncoding;

    @Column(name = "hex_media_id")
    private String hexMediaId;

    @Column(name = "hex_localtion_buf")
    private String hexLocaltionBuf;

    /**
     * 获取报警图片表主键uuid
     *
     * @return media_uuid - 报警图片表主键uuid
     */
    public String getMediaUuid() {
        return mediaUuid;
    }

    /**
     * 设置报警图片表主键uuid
     *
     * @param mediaUuid 报警图片表主键uuid
     */
    public void setMediaUuid(String mediaUuid) {
        this.mediaUuid = mediaUuid;
    }

    /**
     * 获取报警信息uuid
     *
     * @return warn_uuid - 报警信息uuid
     */
    public String getWarnUuid() {
        return warnUuid;
    }

    /**
     * 设置报警信息uuid
     *
     * @param warnUuid 报警信息uuid
     */
    public void setWarnUuid(String warnUuid) {
        this.warnUuid = warnUuid;
    }

    /**
     * 获取报警图片名称
     *
     * @return media_name - 报警图片名称
     */
    public String getMediaName() {
        return mediaName;
    }

    /**
     * 设置报警图片名称
     *
     * @param mediaName 报警图片名称
     */
    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    /**
     * 获取报警图片相对路径
     *
     * @return media_url - 报警图片相对路径
     */
    public String getMediaUrl() {
        return mediaUrl;
    }

    /**
     * 设置报警图片相对路径
     *
     * @param mediaUrl 报警图片相对路径
     */
    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    /**
     * 获取报警图片序号
     *
     * @return media_type - 报警图片序号
     */
    public Integer getMediaType() {
        return mediaType;
    }

    /**
     * 设置报警图片序号
     *
     * @param mediaType 报警图片序号
     */
    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return save_path
     */
    public String getSavePath() {
        return savePath;
    }

    /**
     * @param savePath
     */
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    /**
     * @return download_url
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * @param downloadUrl
     */
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    /**
     * @return download_time
     */
    public Date getDownloadTime() {
        return downloadTime;
    }

    /**
     * @param downloadTime
     */
    public void setDownloadTime(Date downloadTime) {
        this.downloadTime = downloadTime;
    }

    /**
     * @return download_type
     */
    public Integer getDownloadType() {
        return downloadType;
    }

    /**
     * @param downloadType
     */
    public void setDownloadType(Integer downloadType) {
        this.downloadType = downloadType;
    }

    /**
     * @return media_encoding
     */
    public String getMediaEncoding() {
        return mediaEncoding;
    }

    /**
     * @param mediaEncoding
     */
    public void setMediaEncoding(String mediaEncoding) {
        this.mediaEncoding = mediaEncoding;
    }

    /**
     * @return hex_media_id
     */
    public String getHexMediaId() {
        return hexMediaId;
    }

    /**
     * @param hexMediaId
     */
    public void setHexMediaId(String hexMediaId) {
        this.hexMediaId = hexMediaId;
    }

    /**
     * @return hex_localtion_buf
     */
    public String getHexLocaltionBuf() {
        return hexLocaltionBuf;
    }

    /**
     * @param hexLocaltionBuf
     */
    public void setHexLocaltionBuf(String hexLocaltionBuf) {
        this.hexLocaltionBuf = hexLocaltionBuf;
    }
}