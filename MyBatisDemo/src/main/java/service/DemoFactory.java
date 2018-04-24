package service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @Description : TODO
 * @Author : Ellie
 * @Date : 2018/4/23
 */
public class DemoFactory {
    private volatile static SqlSessionFactory sqlSessionFactory = null;
    private static final Class CLASS_LOCK = SqlSessionFactory.class;

    // 创建session factory 的单例
    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
            synchronized (CLASS_LOCK) {
                if (null == sqlSessionFactory) {
                    sqlSessionFactory = new SqlSessionFactoryBuilder()
                            .build(inputStream);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取 SqlSession对象
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    // 获取 SqlSessionFactory 对象
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
