package com.example.classdesign.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by waynamigo on 19-5-14
 */
@Entity
public class Camera implements Serializable {
    @Autowired
    @Id
    private String video_id;

    public Camera() {
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }
}
