package com.cal.mj.main.service;

import com.cal.mj.main.dao.MjDAO;
import com.cal.mj.main.vo.MjVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UpdateMjService")
public class UpdateMjServiceImpl implements UpdateMjService
{
    @Autowired
    private MjDAO mjDAO;

    public void updateMj(MjVO mjVO)
    {
        mjDAO.updateMj(mjVO);
    }
}
