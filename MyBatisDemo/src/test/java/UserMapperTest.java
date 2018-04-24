import com.sun.istack.internal.NotNull;
import entity.User;
import mapper.AnnotationUserMapper;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.DemoFactory;

/**
 * @Description : TODO
 * @Author : Ellie
 * @Date : 2018/4/24
 */
public class UserMapperTest {
    private SqlSession sqlSession = null;

    @Before
    public void getConnection() {
        sqlSession = DemoFactory.getSqlSession();
    }

    @After
    public void closeConnection() {
        sqlSession.close();
    }

    @Test
    public void testDemoFactory() {
        Assert.assertNotNull(sqlSession);
    }

    @Test
    public void insertTest() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(12);
        user.setName("insertUser");
        mapper.insertUser(user);

        User tester = mapper.findUserById(user.getId());
        Assert.assertNotNull(tester);

        mapper.deleteUser(user);
        System.out.println("insert user ok!");
    }

    @Test
    public void insertTestOfAnnotationMapper() {
        AnnotationUserMapper mapper = sqlSession.getMapper(AnnotationUserMapper.class);
        User user = new User();
        user.setId(12);
        user.setName("insertUser");
        mapper.insertUser(user);

        User tester = mapper.findUserById(user.getId());
        Assert.assertNotNull(tester);

        mapper.deleteById(user.getId());
        System.out.println("[AnnotationMapper] insert user ok!");
    }

    @Test
    public void updateTest() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(12);
        user.setName("insertUser");
        mapper.insertUser(user);

        User tester = mapper.findUserById(user.getId());
        Assert.assertNotNull(tester);
        tester.setName("updateUser");

        mapper.updateUser(tester);
        User updatedTester = mapper.findUserById(tester.getId());
        Assert.assertTrue(updatedTester.getName().equals("updateUser"));

        mapper.deleteUser(updatedTester);
        System.out.println("update user ok!");
    }

    @Test
    public void updateTestOfAnnotationMapper() {
        AnnotationUserMapper mapper = sqlSession.getMapper(AnnotationUserMapper.class);
        User user = new User();
        user.setId(12);
        user.setName("insertUser");
        mapper.insertUser(user);

        User tester = mapper.findUserById(user.getId());
        Assert.assertNotNull(tester);
        tester.setName("updateUser");

        mapper.updateUser(tester.getName(), tester.getId());
        User updatedTester = mapper.findUserById(tester.getId());
        Assert.assertTrue(updatedTester.getName().equals("updateUser"));

        mapper.deleteById(updatedTester.getId());
        System.out.println("[AnnotationMapper] update user ok!");
    }
}
