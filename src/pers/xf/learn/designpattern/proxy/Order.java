package pers.xf.learn.designpattern.proxy;

public class Order {
    private Object oderInfo;
    private Long createTime;
    private String id;

    public Object getOderInfo() {
        return oderInfo;
    }

    public void setOderInfo(Object oderInfo) {
        this.oderInfo = oderInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
