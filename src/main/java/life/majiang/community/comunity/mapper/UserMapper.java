package life.majiang.community.comunity.mapper;

import life.majiang.community.comunity.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name,accountID,token,gmtCreate,gmtModified) values(#{name},#{accountID},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("select * from user where token =#{token}")
    User findByToken(@Param("token") String token);
}
