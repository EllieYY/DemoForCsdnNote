package mapper;

import entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AnnotationUserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    public User findUserById(int id);

    @Insert("insert into user values(null,#{user.name},#{user.birthday},#{user.address})")
    @Options(keyProperty="user.id", useGeneratedKeys=true)
    public int insertUser(@Param("user")User user);

    @Update("update user set name=#{name} where id=#{id}")
    public int updateUser(@Param("name")String name, @Param("id")int id);


    @Delete("delete from user where id=#{id}")
    public int deleteById(@Param("id") int id);

//    @Select("select * from user")
//    @ResultMap("userMap")
//    public List<User> findAllUser();
}
