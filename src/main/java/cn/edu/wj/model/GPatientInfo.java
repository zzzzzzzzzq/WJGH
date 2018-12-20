package cn.edu.wj.model;

import java.io.Serializable;

/**
 * g_patient_info
 * @author 
 */
public class GPatientInfo implements Serializable {
    private Integer id;

    private String patientName;

    private String patientSex;

    private Byte patientAge;

    private Integer patientcardId;

    private String patientIdentityid;

    /**
     * 1：是：0：不是
     */
    private Boolean isPreference;

    private Integer time;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public Byte getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Byte patientAge) {
        this.patientAge = patientAge;
    }

    public Integer getPatientcardId() {
        return patientcardId;
    }

    public void setPatientcardId(Integer patientcardId) {
        this.patientcardId = patientcardId;
    }

    public String getPatientIdentityid() {
        return patientIdentityid;
    }

    public void setPatientIdentityid(String patientIdentityid) {
        this.patientIdentityid = patientIdentityid;
    }

    public Boolean getIsPreference() {
        return isPreference;
    }

    public void setIsPreference(Boolean isPreference) {
        this.isPreference = isPreference;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
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
        GPatientInfo other = (GPatientInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPatientName() == null ? other.getPatientName() == null : this.getPatientName().equals(other.getPatientName()))
            && (this.getPatientSex() == null ? other.getPatientSex() == null : this.getPatientSex().equals(other.getPatientSex()))
            && (this.getPatientAge() == null ? other.getPatientAge() == null : this.getPatientAge().equals(other.getPatientAge()))
            && (this.getPatientcardId() == null ? other.getPatientcardId() == null : this.getPatientcardId().equals(other.getPatientcardId()))
            && (this.getPatientIdentityid() == null ? other.getPatientIdentityid() == null : this.getPatientIdentityid().equals(other.getPatientIdentityid()))
            && (this.getIsPreference() == null ? other.getIsPreference() == null : this.getIsPreference().equals(other.getIsPreference()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPatientName() == null) ? 0 : getPatientName().hashCode());
        result = prime * result + ((getPatientSex() == null) ? 0 : getPatientSex().hashCode());
        result = prime * result + ((getPatientAge() == null) ? 0 : getPatientAge().hashCode());
        result = prime * result + ((getPatientcardId() == null) ? 0 : getPatientcardId().hashCode());
        result = prime * result + ((getPatientIdentityid() == null) ? 0 : getPatientIdentityid().hashCode());
        result = prime * result + ((getIsPreference() == null) ? 0 : getIsPreference().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", patientName=").append(patientName);
        sb.append(", patientSex=").append(patientSex);
        sb.append(", patientAge=").append(patientAge);
        sb.append(", patientcardId=").append(patientcardId);
        sb.append(", patientIdentityid=").append(patientIdentityid);
        sb.append(", isPreference=").append(isPreference);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}