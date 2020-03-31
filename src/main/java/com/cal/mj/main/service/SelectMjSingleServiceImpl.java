package com.cal.mj.main.service;

import com.cal.mj.main.dao.MjDAO;
import com.cal.mj.main.vo.MjVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SelectMjSingleService")
public class SelectMjSingleServiceImpl implements SelectMjSingleService
{
    @Autowired
    private MjDAO mjDAO;

    public MjVO selectMjSingle(MjVO mjVO)
    {
        return mjDAO.selectMjSingle(mjVO);
    }
}
