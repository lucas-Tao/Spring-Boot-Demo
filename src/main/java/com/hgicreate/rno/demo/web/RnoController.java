package com.hgicreate.rno.demo.web;

import com.hgicreate.rno.demo.domain.Area;
import com.hgicreate.rno.demo.repository.AreaRepository;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Tao.xj
 * @date in 17:18 2017/10/12
 */
@Slf4j
@Controller
public class RnoController {

    private static final Logger logger = LoggerFactory.getLogger(RnoController.class);

    private final AreaRepository areaRepository;

    public RnoController(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @GetMapping("/")
    public String index(){
        logger.debug("访问首页");
        return "index";
    }

    @GetMapping("/provinces")
    public String showProvinces(Map<String ,Object> model){
        logger.debug("显示指定地区");
        List<Area> provinces = areaRepository.findByAreaLevel("省");
        model.put("provinces",provinces);
        return "provinces";
    }

    @GetMapping("/text")
    public String showReacts(){
        logger.debug("显示React");
//        List<Area> provinces = areaRepository.findByAreaLevel("省");
//        model.put("provinces",provinces);
        return "text";
    }

    @GetMapping("/cities/{provinceId}")
    public String showCities(@PathVariable("provinceId") Long provinceId,Map<String,Object> model){
        logger.debug("显示地区，上级地区ID={}",provinceId);
        List<Area> cities = areaRepository.findByParentId(provinceId);
        model.put("cities",cities);
        return "cities";
    }
}
