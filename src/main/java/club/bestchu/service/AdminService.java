package club.bestchu.service;

import club.bestchu.entity.Admin;
import club.bestchu.utils.PageBean;

/**
 * Created by bestchu on 2017/7/16.
 */
public interface AdminService {
    void getAll(PageBean<Admin> pg);
}
