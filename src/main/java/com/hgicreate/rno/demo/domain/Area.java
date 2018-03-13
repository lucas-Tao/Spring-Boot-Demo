package com.hgicreate.rno.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tao.xj
 * @date in 17:03 2017/10/12
 */
@Data
@Entity
@Table(name = "SYS_AREA")
public class Area {
    @Id
    private Long areaId;
    private String name;
    private String areaLevel;
    private Long parentId;
}
