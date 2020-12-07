package com.drew.service;

import com.drew.dao.CustomerDao;
import com.drew.pojo.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;

    public List<Customer> findAllCustomer(){
        return customerDao.findAllCustomer();
    }

    public Customer findCustomerByID(String cusID){
        return customerDao.findCustomerByID(cusID);
    }

    public boolean isCustomerExist(String cusID) {
        if (customerDao.findCustomerByID(cusID) != null)
            return true;
        else
            return false;
    }

    public boolean addCustomer(Customer customer){
        return customerDao.addCustomer(customer.getCusID(),customer.getCusName(),customer.getCusPwd(),customer.getCusTel(),customer.getCusEmail(),customer.getCusAddress());
    }

    public boolean deleteCustomerByID(String cusID){
        return customerDao.deleteCustomerByID(cusID);
    }

    public boolean editCustomerByID(Customer customer){
        return customerDao.updateCustomerByID(customer.getCusID(),customer.getCusName(),customer.getCusPwd(),customer.getCusTel(),customer.getCusEmail(),customer.getCusAddress());
    }
}
