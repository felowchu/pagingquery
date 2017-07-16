package club.bestchu.service.impl;

import club.bestchu.dao.impl.AdminDaoImpl;
import club.bestchu.entity.Admin;
import club.bestchu.service.AdminService;
import club.bestchu.utils.PageBean;

/**
 * Created by bestchu on 2017/7/16.
 */
public class AdminServiceImpl implements AdminService{
    private AdminDaoImpl adminDao = new AdminDaoImpl();

    public void getAll(PageBean<Admin> pg) {
        try{
            adminDao.getAll(pg);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
