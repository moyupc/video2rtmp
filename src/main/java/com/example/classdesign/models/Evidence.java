package com.example.classdesign.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by waynamigo on 19-5-14
 */
@Entity
public class Evidence implements Serializable {
    @Id
    @GeneratedValue
    private String evidence_id;
    private String pictures_url;
    private String face_id;
    private Date record_time;
    private String stu_id;
    public Evidence() {
    }

    public Evidence(String evidence_id, String pictures_url, String face_id, Date record_time,String stu_id) {
        this.evidence_id = evidence_id;
        this.pictures_url = pictures_url;
        this.face_id = face_id;
        this.record_time = record_time;
        this.stu_id = stu_id;
    }

    public String getEvidence_id() {
        return evidence_id;
    }

    public void setEvidence_id(String evidence_id) {
        this.evidence_id = evidence_id;
    }

    public String getPictures_url() {
        return pictures_url;
    }

    public void setPictures_url(String pictures_url) {
        this.pictures_url = pictures_url;
    }

    public String getFace_id() {
        return face_id;
    }

    public void setFace_id(String face_id) {
        this.face_id = face_id;
    }

    public Date getRecord_time() {
        return record_time;
    }

    public void setRecord_time(Date record_time) {
        this.record_time = record_time;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }
}
