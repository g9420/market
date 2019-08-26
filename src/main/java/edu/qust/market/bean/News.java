package edu.qust.market.bean;

import java.io.Serializable;

public class News implements Serializable {
    private Integer id;

    private Integer disscussId;

    private Integer uid;

    private Integer active;

    private Integer type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDisscussId() {
        return disscussId;
    }

    public void setDisscussId(Integer disscussId) {
        this.disscussId = disscussId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", disscussId=").append(disscussId);
        sb.append(", uid=").append(uid);
        sb.append(", active=").append(active);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}