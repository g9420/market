package edu.qust.market.bean;

import java.io.Serializable;

public class Stuff implements Serializable {
    private Long stuffId;

    private String stuffName;

    private String stuffInfo;

    private Double stuffPrice;

    private Integer stuffActive;

    private Long userId;

    private Long cateId;

    private Long createTime;

    private Long modifyTime;

    private Integer pageView;

    private static final long serialVersionUID = 1L;

    public Long getStuffId() {
        return stuffId;
    }

    public void setStuffId(Long stuffId) {
        this.stuffId = stuffId;
    }

    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName == null ? null : stuffName.trim();
    }

    public String getStuffInfo() {
        return stuffInfo;
    }

    public void setStuffInfo(String stuffInfo) {
        this.stuffInfo = stuffInfo == null ? null : stuffInfo.trim();
    }

    public Double getStuffPrice() {
        return stuffPrice;
    }

    public void setStuffPrice(Double stuffPrice) {
        this.stuffPrice = stuffPrice;
    }

    public Integer getStuffActive() {
        return stuffActive;
    }

    public void setStuffActive(Integer stuffActive) {
        this.stuffActive = stuffActive;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuffId=").append(stuffId);
        sb.append(", stuffName=").append(stuffName);
        sb.append(", stuffInfo=").append(stuffInfo);
        sb.append(", stuffPrice=").append(stuffPrice);
        sb.append(", stuffActive=").append(stuffActive);
        sb.append(", userId=").append(userId);
        sb.append(", cateId=").append(cateId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", pageView=").append(pageView);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}