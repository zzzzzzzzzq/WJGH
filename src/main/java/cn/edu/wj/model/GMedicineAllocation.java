package cn.edu.wj.model;

import java.io.Serializable;

/**
 * g_medicine_allocation
 * @author 
 */
public class GMedicineAllocation implements Serializable {
    private Integer id;

    private Integer patientId;

    private Integer medicineId;

    private Integer medicineNum;

    private String medicineDoctor;

    /**
     * 1：是：0：不是
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

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getMedicineNum() {
        return medicineNum;
    }

    public void setMedicineNum(Integer medicineNum) {
        this.medicineNum = medicineNum;
    }

    public String getMedicineDoctor() {
        return medicineDoctor;
    }

    public void setMedicineDoctor(String medicineDoctor) {
        this.medicineDoctor = medicineDoctor;
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
        GMedicineAllocation other = (GMedicineAllocation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()))
            && (this.getMedicineId() == null ? other.getMedicineId() == null : this.getMedicineId().equals(other.getMedicineId()))
            && (this.getMedicineNum() == null ? other.getMedicineNum() == null : this.getMedicineNum().equals(other.getMedicineNum()))
            && (this.getMedicineDoctor() == null ? other.getMedicineDoctor() == null : this.getMedicineDoctor().equals(other.getMedicineDoctor()))
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
        result = prime * result + ((getMedicineId() == null) ? 0 : getMedicineId().hashCode());
        result = prime * result + ((getMedicineNum() == null) ? 0 : getMedicineNum().hashCode());
        result = prime * result + ((getMedicineDoctor() == null) ? 0 : getMedicineDoctor().hashCode());
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
        sb.append(", medicineId=").append(medicineId);
        sb.append(", medicineNum=").append(medicineNum);
        sb.append(", medicineDoctor=").append(medicineDoctor);
        sb.append(", isCompleted=").append(isCompleted);
        sb.append(", checkDate=").append(checkDate);
        sb.append(", payNo=").append(payNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}