package com.example.classdesign.controllers;

import com.example.classdesign.results.Result;
import com.example.classdesign.results.SuccessResult;
import com.example.classdesign.services.CameraService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.bytedeco.javacv.FrameGrabber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by waynamigo on 19-5-14
 */

@RestController
@RequestMapping("/Camera/")
public class CameraController {

    @Autowired
    CameraService cameraService;

    @ApiOperation(value = "record", notes = "根据编号调用摄像头", response = Result.class)
    @GetMapping(value = "/record/")
    public Result recording(@ApiParam(value = "video_id" ,required=true ) @RequestParam String video_id) throws FrameGrabber.Exception, InterruptedException {
        return cameraService.record(video_id);
    }
    @ApiOperation(value = "record2rtmp", notes = "推流", response = Result.class)
    @GetMapping(value = "/record2rtmpServer/")
    public Result record2rtmp(@ApiParam(value = "video_id" ,required=true ) @RequestParam String video_id) throws Exception {
        return cameraService.record2rtmpServer(video_id);
    }
}