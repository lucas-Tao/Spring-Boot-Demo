package com.hgicreate.rno.demo.repository;

import com.hgicreate.rno.demo.domain.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Tao.xj
 * @date in 17:09 2017/10/12
 */
public interface AreaRepository extends JpaRepository<Area,Long> {
    /**
     * 查询指定级别的地区
     * @param areaLevel 地区级别 如"省"
     * @return 地区列表
     */
    List<Area> findByAreaLevel(String areaLevel);

    /**
     * 查询指定地区的下级地市
     *@param parentId 指定地区的ID
     *@return 地区列表
     */
    List<Area> findByParentId(Long parentId);
}
