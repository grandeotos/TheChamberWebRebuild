package mx.itesm.TheChamberWebRebuild.model;

import java.io.Serializable;

public class Applicant implements Serializable {
    private int applicantId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String experienceName;
    private String profileName;
    private String reviewStatusName;
    private int reviewStatus;

    public Applicant() {

    }

    public Applicant(int applicantId, String firstName, String lastName, String email, String phoneNumber, String experienceName, String profileName, String reviewStatusName, int reviewStatus) {
        this.applicantId = applicantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.experienceName = experienceName;
        this.profileName = profileName;
        this.reviewStatusName = reviewStatusName;
        this.reviewStatus = reviewStatus;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExperienceName() {
        return experienceName;
    }

    public void setExperienceName(String experienceName) {
        this.experienceName = experienceName;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getReviewStatusName() {
        return reviewStatusName;
    }

    public void setReviewStatusName(String reviewStatusName) {
        this.reviewStatusName = reviewStatusName;
    }

    public int getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(int reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicantId=" + applicantId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", experienceName='" + experienceName + '\'' +
                ", profileName='" + profileName + '\'' +
                ", reviewStatusName='" + reviewStatusName + '\'' +
                ", reviewStatus=" + reviewStatus +
                '}';
    }
}
