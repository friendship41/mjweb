package com.cal.mj.main.controller;

import com.cal.mj.main.service.*;
import com.cal.mj.main.vo.ClientCustomerVO;
import com.cal.mj.main.vo.MjVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class MjController
{
    @Autowired
    private SelectMjList selectMjList;
    @Autowired
    private InsertMjService insertMjService;
    @Autowired
    private SelectMjSingleService selectMjSingleService;
    @Autowired
    private UpdateMjService updateMjService;
    @Autowired
    private DeleteMjService deleteMjService;



    @RequestMapping(value = "/mjmain.mdo")
    public String gotoMjMainPage(HttpSession session, Model model, MjVO mjVO)
    {
        mjVO.setCustomerTbNo(((ClientCustomerVO)session.getAttribute("mjcustomer")).getCustomerTbNo());

        if(mjVO.getStartDate() == null)
        {
            Date today = new Date();
            mjVO.setStartDate(new java.sql.Date(today.getTime()));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(today);
            calendar.add(Calendar.YEAR, 1);
            mjVO.setEndDate(new java.sql.Date(calendar.getTimeInMillis()));
        }
        else
        {
            mjVO.setEndDate(mjVO.getStartDate());
            model.addAttribute("nowDate", mjVO.getStartDate());
        }

        model.addAttribute("mjList", selectMjList.selectMjList(mjVO));
        return "mj-main";
    }

    @RequestMapping(value = "/insertmj.mdo", method = RequestMethod.GET)
    public String insertMjPage()
    {
        return "mj-insert";
    }

    @RequestMapping(value = "/insertmj.mdo", method = RequestMethod.POST)
    public String insertMjProc(MjVO mjVO, HttpSession session)
    {
        mjVO.setMjLoc(mjVO.getMjloc1()+" "+mjVO.getMjloc2());

//        System.out.println(mjVO.getMjdate());
//        System.out.println(mjVO.getMjtime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd/hh:mma");
        try
        {
            Date date = simpleDateFormat.parse(mjVO.getMjdate()+"/"+mjVO.getMjtime());
            mjVO.setMjDate(new java.sql.Date(date.getTime()));
//            System.out.println(mjVO);
            mjVO.setCustomerTbNo(((ClientCustomerVO)session.getAttribute("mjcustomer")).getCustomerTbNo());
            insertMjService.insertMj(mjVO);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return "redirect:mjmain.mdo";
    }


    @RequestMapping(value = "/updatemj.mdo", method = RequestMethod.GET)
    public String gotoUpdatePage(MjVO mjVO, Model model)
    {
        model.addAttribute("mj", selectMjSingleService.selectMjSingle(mjVO));
        return "mj-update";
    }

    @RequestMapping(value = "/updatemj.mdo", method = RequestMethod.POST)
    public String updateMjProc(MjVO mjVO, HttpSession session)
    {
        mjVO.setMjLoc(mjVO.getMjloc1()+" "+mjVO.getMjloc2());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd/hh:mma");
        try
        {
            Date date = simpleDateFormat.parse(mjVO.getMjdate()+"/"+mjVO.getMjtime());
            mjVO.setMjDate(new java.sql.Date(date.getTime()));
            mjVO.setCustomerTbNo(((ClientCustomerVO)session.getAttribute("mjcustomer")).getCustomerTbNo());
            updateMjService.updateMj(mjVO);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return "redirect:mjmain.mdo";
    }

    @RequestMapping(value = "/deletemj.mdo", method = RequestMethod.GET)
    public String deleteMjProc(MjVO mjVO)
    {
        deleteMjService.deleteMj(mjVO);
        return "redirect:mjmain.mdo";
    }

}
