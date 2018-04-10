package com.zhizus.forest.metrics.bean;

/**
 * Created by Dempe on 2017/1/5.
 */
public class App {
    private String appKey;
    private String serviceName;
    private long createAt;
    private String createBy;

    private String createTime;
    private String zookeeperUrl;
    private String topic;
    private String status;

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getCreateTime () {
        return createTime;
    }

    public void setCreateTime (String createTime) {
        this.createTime = createTime;
    }

    public String getZookeeperUrl () {
        return zookeeperUrl;
    }

    public void setZookeeperUrl (String zookeeperUrl) {
        this.zookeeperUrl = zookeeperUrl;
    }

    public String getTopic () {
        return topic;
    }

    public void setTopic (String topic) {
        this.topic = topic;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
