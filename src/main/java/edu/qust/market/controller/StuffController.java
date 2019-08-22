package edu.qust.market.controller;


import edu.qust.market.bean.File_form;
import edu.qust.market.bean.Stuff;
import edu.qust.market.bean.StuffExample;
import edu.qust.market.framework.bean.WebModel;
import edu.qust.market.framework.message.ErrorEnum;
import edu.qust.market.framework.message.Message;
import edu.qust.market.mapper.StuffMapper;
import edu.qust.market.service.FileFormService;
import edu.qust.market.service.SessionService;
import edu.qust.market.service.StuffService;
import edu.qust.market.service.UserService;
import edu.qust.market.utils.FileUpload;
import edu.qust.market.utils.Md5Util;
import edu.qust.market.utils.ZylToken;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.rmi.MarshalException;
import java.util.List;

@RequestMapping("/stuff")
@RestController
public class StuffController {
    static int i = 0;
    private static final Logger log = LoggerFactory.getLogger(StuffController.class);

    @Autowired
    private StuffService stuffService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserService userService;
    @Autowired
    private FileFormService fileFormService;

    @RequestMapping("/selectAll")
    public Message selectAll(WebModel webModel) {
        try {
            stuffService.selectAll(webModel);
            return Message.createSuccessMessage(webModel);
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/selectStuffById")
    public Message selectStuffById(@RequestParam("id") Long id) {
        try {
            Stuff stuff = stuffService.selectStuffById(id);
            stuffService.pageViewAdd(id);
            return Message.createSuccessMessage(stuff);
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/selectStuffByCid")
    public Message selectStuffByCid(@RequestParam("cid") Long cid, WebModel webModel) {
        try {
            stuffService.getStuffByCategory(cid, webModel);
            return Message.createSuccessMessage(webModel);
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/searchByKeyWords")
    public Message searchByKeyWords(@RequestParam("keyWords") String keyWords, WebModel webModel) {
        try {
            stuffService.searchByKeyWords(keyWords, webModel);
            return Message.createSuccessMessage(webModel);
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/addStuffByToken")
    public Message addStuffByToken(@RequestParam("token") String token, Stuff stuff) {
        try {
            String openId = sessionService.selectSessionByToken(token).get(0).getId();
            long userId = userService.selectIdByOpenId(openId).get(0).getId();
            stuff.setUserId(userId);
            stuff.setCreateTime(System.currentTimeMillis());
            System.out.println(stuff);
            stuffService.insertStuff(stuff);
            return Message.createSuccessMessage(ZylToken.addKey(stuff.getStuffId()));
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/upload")
    public Message uploadFile(HttpServletRequest httpServletRequest,@RequestParam("token_key") String token_key,@RequestParam("id") long id) {
        try {
            System.out.println(token_key);
            System.out.println("222222222");
            System.out.println(id);
            System.out.println("222222");
            File_form file_form = new File_form();
            file_form.setUrl(FileUpload.savaFile(httpServletRequest));
            file_form.setTable("tb_stuff");
            file_form.setTypeId(1);
            if (!ZylToken.portKey(id,token_key)){
                return Message.createFailureMessage(ErrorEnum.IllegalOperation);
            }
            file_form.setTableId((int) id);
            fileFormService.insertFile(file_form);
            return Message.createSuccessMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }
}
