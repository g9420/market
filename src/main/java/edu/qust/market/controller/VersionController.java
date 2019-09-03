package edu.qust.market.controller;

import edu.qust.market.framework.message.Message;
import edu.qust.market.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author g9420
 * @date 2019/9/1 13:32
 */
@RestController
@RequestMapping("/version")
public class VersionController {

    @Autowired
    private VersionService versionService;

    @RequestMapping("/getVersion")
    public Message getVersion() {
        int version = versionService.getVsersion();
        return Message.createSuccessMessage(version);
    }
}
