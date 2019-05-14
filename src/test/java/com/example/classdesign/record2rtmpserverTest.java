package com.example.classdesign;

import com.example.classdesign.utils.record2rtmpserver;
import org.junit.Test;

/**
 * Created by waynamigo on 19-5-9
 */
public class record2rtmpserverTest {

    @Test
    public void recordCameratest() throws Exception {
//        String rtmp_server= "http://139.199.22.224:81/hls/test.m3u8"
        String rtmp_push ="rtmp://139.199.22.224:1935/hls";
        record2rtmpserver.recordCamera(rtmp_push,25);
        try{
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}