package com.example.classdesign.controllers;

import com.example.classdesign.results.Result;
import com.example.classdesign.results.SuccessResult;
import com.example.classdesign.services.EvidenceService;
import com.example.classdesign.services.Userservice;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by waynamigo on 19-5-24
 */
@RestController
@RequestMapping("/evidence/")
public class EvidenceController {
    @Autowired
    EvidenceService evidenceService;

    @ApiOperation(value = "getbyevid", notes = "查询一条，供其他接口使用", response = Result.class)
    @PostMapping(value = "/getbyevid/")
    public Result getevidence(@ApiParam(value = "evid" ,required=true ) @RequestParam Integer evid){
        return evidenceService.getEvidence(evid);
    }
    @ApiOperation(value = "getallbystuid", notes = "查询一个学生所有记录", response = Result.class)
    @PostMapping(value = "/getallbystuid/")
    public Result getevidences(@ApiParam(value = "stuid" ,required=true ) @RequestParam String stuid){
        return evidenceService.getEvidencelist(stuid);
    }
    @ApiOperation(value = "getallbystuid", notes = "增加一条", response = Result.class)
    @PostMapping(value = "/add/")
    public Result addoneevidence(@ApiParam(value = "stuid" ,required=true ) @RequestParam String stuid,
                                 @ApiParam(value = "bahavior" ,required=true ) @RequestParam String bahavior){
        return evidenceService.addEvidence(stuid,bahavior);
    }
}
