package cn.edu.wj.model;

public class GPatientHistory {

	private Integer id;

	private String patientIdentityid;

	private String diseaseTitle;

	private String diseaseContent;

	private String doctor;
	 
	private Boolean isCompleted;
	
	private Integer date;
	
	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPatientIdentityid() {
		return patientIdentityid;
	}

	public void setPatientIdentityid(String patientIdentityid) {
		this.patientIdentityid = patientIdentityid;
	}

	public String getDiseaseTitle() {
		return diseaseTitle;
	}

	public void setDiseaseTitle(String diseaseTitle) {
		this.diseaseTitle = diseaseTitle;
	}

	public String getDiseaseContent() {
		return diseaseContent;
	}

	public void setDiseaseContent(String diseaseContent) {
		this.diseaseContent = diseaseContent;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
