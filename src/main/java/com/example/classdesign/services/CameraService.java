package com.example.classdesign.services;

import com.example.classdesign.results.Result;
import com.example.classdesign.results.SuccessResult;
import com.example.classdesign.utils.record2rtmpserver;
import org.apache.juli.logging.Log;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;

/**
 * Created by waynamigo on 19-5-14
 */
@Service
public class CameraService {
    @Autowired
    CameraService cameraService;
    public Result record(String video_id) throws FrameGrabber.Exception,InterruptedException {
        try{
            OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
            grabber.start();   //开始获取摄像头数据
            CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
            canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            canvas.setAlwaysOnTop(true);

            while(true) {
                if(!canvas.isDisplayable()) {//窗口是否关闭
                    grabber.stop();//停止抓取
                    System.exit(2);//退出
                }
                canvas.showImage(grabber.grab());//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像

                Thread.sleep(50);//50毫秒刷新一次图像
            }
        }catch ( Exception e){
            e.printStackTrace();
        }
        return Result.success("测试根据id选取摄像头");


    }
    public Result record2rtmpServer(String video_id) throws Exception {
        //        String rtmp_server= "http://139.199.22.224:81/hls/test.m3u8"
        String rtmp_push ="rtmp://139.199.22.224:1935/hls";
        record2rtmpserver.recordCamera(rtmp_push,25);
        try{
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.success(rtmp_push,"pushing to rtmp server");
    }
}
