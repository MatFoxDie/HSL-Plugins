package hsl.matfox.mappers;

import hsl.matfox.models.Adventurer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdventurerDAO {
    public Integer insertAdventurer(@Param("Adventurer")Adventurer adventurer);
}
