package com.cal.mj.main.controller;

import com.cal.mj.main.service.SelectCustomerService;
import com.cal.mj.main.service.SelectMjList;
import com.cal.mj.main.vo.ClientCustomerVO;
import com.cal.mj.main.vo.MjVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController
{
    @Autowired
    private SelectCustomerService selectCustomerService;

    @RequestMapping(value = "/index.mdo")
    public String goToIndex()
    {
        return "index";
    }

    @RequestMapping(value = "/login.mdo", method = RequestMethod.POST)
    public String loginProc(ClientCustomerVO clientCustomerVO, HttpSession session)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        ClientCustomerVO dbCustomer = selectCustomerService.selectSingleCustomer(clientCustomerVO);
        if(clientCustomerVO != null && dbCustomer != null)
        {
            if(encoder.matches(clientCustomerVO.getCustomerTbPassword(), dbCustomer.getCustomerTbPassword()))
            {
                session.setAttribute("mjcustomer", dbCustomer);
                return "redirect:mjmain.mdo";
            }
        }
        return "index";
    }
}
