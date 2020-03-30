package com.cal.mj.main.service;

import com.cal.mj.main.dao.CustomerDAO;
import com.cal.mj.main.vo.ClientCustomerVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SelectCustomerService")
public class SelectCustomerServiceImpl implements SelectCustomerService
{
    @Autowired
    private CustomerDAO customerDAO;

    public ClientCustomerVO selectSingleCustomer(ClientCustomerVO clientCustomerVO)
    {
        return customerDAO.selectCustomer(clientCustomerVO);
    }
}
