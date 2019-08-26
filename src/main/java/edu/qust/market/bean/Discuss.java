package edu.qust.market.bean;

import java.io.Serializable;

public class Discuss implements Serializable {
    private Long discussId;

    private String discussDesc;

    private Long discussTime;

    private Long userId;

    private Long stuffId;

    private Integer receiveDiscussId;

    private static final long serialVersionUID = 1L;

    public Long getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Long discussId) {
        this.discussId = discussId;
    }

    public String getDiscussDesc() {
        return discussDesc;
    }

    public void setDiscussDesc(String discussDesc) {
        this.discussDesc = discussDesc == null ? null : discussDesc.trim();
    }

    public Long getDiscussTime() {
        return discussTime;
    }

    public void setDiscussTime(Long discussTime) {
        this.discussTime = discussTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStuffId() {
        return stuffId;
    }

    public void setStuffId(Long stuffId) {
        this.stuffId = stuffId;
    }

    public Integer getReceiveDiscussId() {
        return receiveDiscussId;
    }

    public void setReceiveDiscussId(Integer receiveDiscussId) {
        this.receiveDiscussId = receiveDiscussId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", discussId=").append(discussId);
        sb.append(", discussDesc=").append(discussDesc);
        sb.append(", discussTime=").append(discussTime);
        sb.append(", userId=").append(userId);
        sb.append(", stuffId=").append(stuffId);
        sb.append(", receiveDiscussId=").append(receiveDiscussId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}