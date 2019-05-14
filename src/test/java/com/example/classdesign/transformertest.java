package com.example.classdesign;

import com.example.classdesign.utils.transformer;
import org.junit.Test;

/**
 * Created by waynamigo on 19-5-9
 */
public class transformertest {
    @Test
    public void testtrans() throws Exception {

        String inputFile = "rtsp://admin:admin@192.168.2.236:37779/cam/realmonitor?channel=1&subtype=0";

        String outputFile="rtmp://192.168.30.21/live/pushFlow";

        transformer.recordPush(inputFile, outputFile,25);
    }
}
