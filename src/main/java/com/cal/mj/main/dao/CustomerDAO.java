package com.cal.mj.main.dao;

import com.cal.mj.main.vo.ClientCustomerVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("CustomerDAO")
public class CustomerDAO
{
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public ClientCustomerVO selectCustomer(ClientCustomerVO clientCustomerVO)
    {
        return sqlSessionTemplate.selectOne("CustomerDAO.selectCustomer", clientCustomerVO);
    }

}
