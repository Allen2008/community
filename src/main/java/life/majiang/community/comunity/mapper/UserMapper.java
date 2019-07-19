package life.majiang.community.comunity.mapper;

import life.majiang.community.comunity.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name,accountID,token,gmtCreate,gmtModified) values(#{name},#{accountID},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

}
