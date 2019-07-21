package life.majiang.community.comunity.mapper;

import life.majiang.community.comunity.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,creator,tag) values (#{title},#{description},#{gmt_create},#{creator},#{tag})")
    void create(Question question);
}
