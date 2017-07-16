package club.bestchu.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * Created by bestchu on 2017/7/16.
 */
public class JdbcUtil {
    private static ComboPooledDataSource dataSource = null;
    static{
        dataSource = new ComboPooledDataSource();
    }

    public static QueryRunner getQueryRunner(){
       return new QueryRunner(dataSource);
    }
}
