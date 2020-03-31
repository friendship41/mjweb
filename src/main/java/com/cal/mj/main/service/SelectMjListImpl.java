package com.cal.mj.main.service;

import com.cal.mj.main.dao.MjDAO;
import com.cal.mj.main.vo.MjVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service("SelectMjList")
public class SelectMjListImpl implements SelectMjList
{
    @Autowired
    private MjDAO mjDAO;


    public List<MjVO> selectMjList(MjVO mjVO)
    {
        List<MjVO> list = mjDAO.selectMjList(mjVO);
        java.util.Date newDate = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:a");

        for(int i=0; i<list.size(); i++)
        {
            Date date = list.get(i).getMjDate();
            newDate.setTime(date.getTime());
            String tempTime = simpleDateFormat.format(newDate);
            list.get(i).setHour(tempTime.split(":")[0]);
            list.get(i).setMin(tempTime.split(":")[1]);
        }
        return list;
    }
}
