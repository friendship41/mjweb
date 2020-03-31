package com.cal.mj.main.service;

import com.cal.mj.main.dao.MjDAO;
import com.cal.mj.main.vo.MjVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("InsertMjService")
public class InsertMjServiceImpl implements InsertMjService
{
    @Autowired
    private MjDAO mjDAO;


    public void insertMj(MjVO mjVO)
    {
        mjDAO.insertMj(mjVO);
    }
}
