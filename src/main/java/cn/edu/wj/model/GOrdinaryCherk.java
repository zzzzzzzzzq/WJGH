package cn.edu.wj.model;

import java.io.Serializable;

/**
 * g_ordinary_cherk
 * @author 
 */
public class GOrdinaryCherk implements Serializable {
    private Integer id;

    private Integer patientId;

    private String checkItem;

    private String checkResult;

    private String checkDoctor;

    /**

     * 1£ºÊÇ£º0£º²»ÊÇ

     */
    private Boolean isCompleted;

    private Integer checkDate;

    private Integer payNo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckDoctor() {
        return checkDoctor;
    }

    public void setCheckDoctor(String checkDoctor) {
        this.checkDoctor = checkDoctor;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Integer getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Integer checkDate) {
        this.checkDate = checkDate;
    }

    public Integer getPayNo() {
        return payNo;
    }

    public void setPayNo(Integer payNo) {
        this.payNo = payNo;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GOrdinaryCherk other = (GOrdinaryCherk) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()))
            && (this.getCheckItem() == null ? other.getCheckItem() == null : this.getCheckItem().equals(other.getCheckItem()))
            && (this.getCheckResult() == null ? other.getCheckResult() == null : this.getCheckResult().equals(other.getCheckResult()))
            && (this.getCheckDoctor() == null ? other.getCheckDoctor() == null : this.getCheckDoctor().equals(other.getCheckDoctor()))
            && (this.getIsCompleted() == null ? other.getIsCompleted() == null : this.getIsCompleted().equals(other.getIsCompleted()))
            && (this.getCheckDate() == null ? other.getCheckDate() == null : this.getCheckDate().equals(other.getCheckDate()))
            && (this.getPayNo() == null ? other.getPayNo() == null : this.getPayNo().equals(other.getPayNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPatientId() == null) ? 0 : getPatientId().hashCode());
        result = prime * result + ((getCheckItem() == null) ? 0 : getCheckItem().hashCode());
        result = prime * result + ((getCheckResult() == null) ? 0 : getCheckResult().hashCode());
        result = prime * result + ((getCheckDoctor() == null) ? 0 : getCheckDoctor().hashCode());
        result = prime * result + ((getIsCompleted() == null) ? 0 : getIsCompleted().hashCode());
        result = prime * result + ((getCheckDate() == null) ? 0 : getCheckDate().hashCode());
        result = prime * result + ((getPayNo() == null) ? 0 : getPayNo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", patientId=").append(patientId);
        sb.append(", checkItem=").append(checkItem);
        sb.append(", checkResult=").append(checkResult);
        sb.append(", checkDoctor=").append(checkDoctor);
        sb.append(", isCompleted=").append(isCompleted);
        sb.append(", checkDate=").append(checkDate);
        sb.append(", payNo=").append(payNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}