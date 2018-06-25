package com.cictec.middleware.tsinghua.entity.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_warn_media")
public class TWarnMedia {
    public static final int DOWNLOAD_TYPE_UNDOWNLOAD = 0;
    public static final int DOWNLOAD_TYPE_SUCCESS = 1;
    public static final int DOWNLOAD_TYPE_ERROR = 2;



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
     * 图片暂存路径
     */
    @Column(name = "media_url")
    private String mediaUrl;

    /**
     * 多媒体类型：0：图像；1：音频；2：视频
     */
    @Column(name = "media_type")
    private Integer mediaType;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private String createUser;

    /**
     * 图片最终下载路径
     */
    @Column(name = "download_url")
    private String downloadUrl;

    @Column(name = "download_time")
    private Date downloadTime;

    /**
     * 图片下载状态：0:未下载，1：下载成功，2：下载失败
     */
    @Column(name = "download_type")
    private Integer downloadType;

    /**
     * 多媒体格式：JPEG、TIF、MP3、WAV、WMV、H264
     */
    @Column(name = "media_encoding")
    private String mediaEncoding;

    /**
     * 多媒体ID
     */
    @Column(name = "hex_media_id")
    private String hexMediaId;

    /**
     * 定位消息转16进制字符串，多媒体证据跟位置汇报可以通过此字符串及hexDevIdno一致进行关联
     */
    @Column(name = "hex_localtion_buf")
    private String hexLocaltionBuf;

    /**
     * 媒体信息保存方式:0：系统文件夹，1：fastdfs，2：alibabaOSS
     */
    @Column(name = "save_type")
    private Short saveType;

    /**
     * 媒体信息保存路径
     */
    @Column(name = "save_path")
    private String savePath;

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
     * 获取图片暂存路径
     *
     * @return media_url - 图片暂存路径
     */
    public String getMediaUrl() {
        return mediaUrl;
    }

    /**
     * 设置图片暂存路径
     *
     * @param mediaUrl 图片暂存路径
     */
    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    /**
     * 获取多媒体类型：0：图像；1：音频；2：视频
     *
     * @return media_type - 多媒体类型：0：图像；1：音频；2：视频
     */
    public Integer getMediaType() {
        return mediaType;
    }

    /**
     * 设置多媒体类型：0：图像；1：音频；2：视频
     *
     * @param mediaType 多媒体类型：0：图像；1：音频；2：视频
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
     * 获取图片最终下载路径
     *
     * @return download_url - 图片最终下载路径
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * 设置图片最终下载路径
     *
     * @param downloadUrl 图片最终下载路径
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
     * 获取图片下载状态：0:未下载，1：下载成功，2：下载失败
     *
     * @return download_type - 图片下载状态：0:未下载，1：下载成功，2：下载失败
     */
    public Integer getDownloadType() {
        return downloadType;
    }

    /**
     * 设置图片下载状态：0:未下载，1：下载成功，2：下载失败
     *
     * @param downloadType 图片下载状态：0:未下载，1：下载成功，2：下载失败
     */
    public void setDownloadType(Integer downloadType) {
        this.downloadType = downloadType;
    }

    /**
     * 获取多媒体格式：JPEG、TIF、MP3、WAV、WMV、H264
     *
     * @return media_encoding - 多媒体格式：JPEG、TIF、MP3、WAV、WMV、H264
     */
    public String getMediaEncoding() {
        return mediaEncoding;
    }

    /**
     * 设置多媒体格式：JPEG、TIF、MP3、WAV、WMV、H264
     *
     * @param mediaEncoding 多媒体格式：JPEG、TIF、MP3、WAV、WMV、H264
     */
    public void setMediaEncoding(String mediaEncoding) {
        this.mediaEncoding = mediaEncoding;
    }

    /**
     * 获取多媒体ID
     *
     * @return hex_media_id - 多媒体ID
     */
    public String getHexMediaId() {
        return hexMediaId;
    }

    /**
     * 设置多媒体ID
     *
     * @param hexMediaId 多媒体ID
     */
    public void setHexMediaId(String hexMediaId) {
        this.hexMediaId = hexMediaId;
    }

    /**
     * 获取定位消息转16进制字符串，多媒体证据跟位置汇报可以通过此字符串及hexDevIdno一致进行关联
     *
     * @return hex_localtion_buf - 定位消息转16进制字符串，多媒体证据跟位置汇报可以通过此字符串及hexDevIdno一致进行关联
     */
    public String getHexLocaltionBuf() {
        return hexLocaltionBuf;
    }

    /**
     * 设置定位消息转16进制字符串，多媒体证据跟位置汇报可以通过此字符串及hexDevIdno一致进行关联
     *
     * @param hexLocaltionBuf 定位消息转16进制字符串，多媒体证据跟位置汇报可以通过此字符串及hexDevIdno一致进行关联
     */
    public void setHexLocaltionBuf(String hexLocaltionBuf) {
        this.hexLocaltionBuf = hexLocaltionBuf;
    }

    /**
     * 获取媒体信息保存方式:0：系统文件夹，1：fastdfs，2：alibabaOSS
     *
     * @return save_type - 媒体信息保存方式:0：系统文件夹，1：fastdfs，2：alibabaOSS
     */
    public Short getSaveType() {
        return saveType;
    }

    /**
     * 设置媒体信息保存方式:0：系统文件夹，1：fastdfs，2：alibabaOSS
     *
     * @param saveType 媒体信息保存方式:0：系统文件夹，1：fastdfs，2：alibabaOSS
     */
    public void setSaveType(Short saveType) {
        this.saveType = saveType;
    }

    /**
     * 获取媒体信息保存路径
     *
     * @return save_path - 媒体信息保存路径
     */
    public String getSavePath() {
        return savePath;
    }

    /**
     * 设置媒体信息保存路径
     *
     * @param savePath 媒体信息保存路径
     */
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}