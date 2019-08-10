package life.majiang.community.comunity.mapper;

import life.majiang.community.comunity.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,creator,tag) values (#{title},#{description},#{gmtCreate},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question")
    List<Question> list();
}
