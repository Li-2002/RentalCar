package com.qfedu.sys.controller;

import com.qfedu.sys.service.IAccountService;
import com.qfedu.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 转账控制器
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService service;

    @RequestMapping("hello")
    public void test(){
        System.out.println("111");
    }

    @RequestMapping("transfer")
    @ResponseBody
    @Transactional
    public ResultObj accountTransfer(String inName , String outName , double money){
        int status = service.updateTransfer(inName, outName, money);  //status == 1 转账成功 , status==0 转账失败
        if(status > 0 ){ //转账成功
            return ResultObj.STATUS_TRUE;
        }else {
            return ResultObj.STATUS_FALSE;
        }
    }
}
