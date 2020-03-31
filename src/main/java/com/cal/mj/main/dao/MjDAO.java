package com.cal.mj.main.dao;

import com.cal.mj.main.vo.MjVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository("MjDAO")
public class MjDAO
{
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<MjVO> selectMjList(MjVO mjVO)
    {
        return sqlSessionTemplate.selectList("MjDAO.selectMjList", mjVO);
    }

    public void insertMj(MjVO mjVO)
    {
        sqlSessionTemplate.insert("MjDAO.insertMj", mjVO);
    }

    public MjVO selectMjSingle(MjVO mjVO)
    {
        return sqlSessionTemplate.selectOne("MjDAO.selectMjSingle", mjVO);
    }

    public void updateMj(MjVO mjVO)
    {
        sqlSessionTemplate.update("MjDAO.updateMj", mjVO);
    }

    public void deleteMj(MjVO mjVO)
    {
        sqlSessionTemplate.delete("MjDAO.deleteMj", mjVO);
    }
}
