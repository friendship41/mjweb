package com.cal.mj.main.service;

import com.cal.mj.main.dao.MjDAO;
import com.cal.mj.main.vo.MjVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("DeleteMjService")
public class DeleteMjServiceImpl implements DeleteMjService
{
    @Autowired
    public MjDAO mjDAO;

    public void deleteMj(MjVO mjVO)
    {
        mjDAO.deleteMj(mjVO);
    }
}
