package club.bestchu.dao.impl;

import club.bestchu.dao.AdminDao;
import club.bestchu.entity.Admin;
import club.bestchu.utils.JdbcUtil;
import club.bestchu.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

/**
 * Created by bestchu on 2017/7/16.
 */
public class AdminDaoImpl implements AdminDao{

    public void getAll(PageBean<Admin> pb) {
        int totalCount = this.getTotalCount();
        pb.setTotalCount(totalCount);
        if(pb.getCurrentPage() <= 0)
            pb.setCurrentPage(1);
        else if(pb.getCurrentPage() > pb.getTotalPage())
            pb.setCurrentPage(pb.getTotalPage());
        int start = (pb.getCurrentPage() - 1)*pb.getPageCount();
        String sql = "select * from admin limit ?,?";
        try{
            QueryRunner qr = JdbcUtil.getQueryRunner();
            List<Admin> pageDate = qr.query(sql, new BeanListHandler<Admin>(Admin.class), start, pb.getPageCount());
            pb.setPageDate(pageDate);
        }catch(Exception e){
            throw new RuntimeException();
        }
    }

    public int getTotalCount() {
        String sql = "select count(*) from admin";
        try{
            QueryRunner qr = JdbcUtil.getQueryRunner();
            Long totalCount = qr.query(sql, new ScalarHandler<Long>());
            return totalCount.intValue();
        }catch(Exception e){
            throw new RuntimeException();
        }
    }
}
