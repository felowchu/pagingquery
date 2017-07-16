package club.bestchu.dao;

import club.bestchu.entity.Admin;
import club.bestchu.utils.PageBean;

/**
 * Created by bestchu on 2017/7/16.
 */
public interface AdminDao {
    public void getAll(PageBean<Admin> pb);

    public int getTotalCount();
}
