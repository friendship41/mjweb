package com.cal.mj.main.controller;

import com.cal.mj.main.service.SelectCustomerService;
import com.cal.mj.main.vo.ClientCustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController
{
    @Autowired
    private SelectCustomerService selectCustomerService;

    @RequestMapping(value = "index.do")
    public String goToIndex()
    {
        return "index";
    }

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public String loginProc(ClientCustomerVO clientCustomerVO)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        ClientCustomerVO dbCustomer = selectCustomerService.selectSingleCustomer(clientCustomerVO);
        if(clientCustomerVO != null && dbCustomer != null)
        {
            if(encoder.matches(clientCustomerVO.getCustomerTbPassword(), dbCustomer.getCustomerTbPassword()))
            {
                return "mj-main";
            }
        }

        return "index";
    }
}
