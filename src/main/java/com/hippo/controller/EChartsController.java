package com.hippo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hippo.vo.EchartData;
import com.hippo.vo.Series;

@Controller  
//@RequestMapping("echarts")  
public class EChartsController {

	@RequestMapping("echarts")  
    @ResponseBody  
    public EchartData lineData() {  
          
        List<String> legend = new ArrayList<String>(Arrays.asList(new String[]{"蒸发量","降水量"}));//数据分组  
        List<String> category = new ArrayList<String>(Arrays.asList(new String []{"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"}));//横坐标  
        List<Series> series = new ArrayList<Series>();//纵坐标  
        
        Series series1 = new Series("蒸发量", "bar",
        		new ArrayList<Double>(Arrays.asList(2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3)));
        Series series2 = new Series("降水量", "bar",
        		new ArrayList<Double>(Arrays.asList(2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3)));
        series.add(series1);  
        series.add(series2);  

        EchartData data=new EchartData(legend, category, series);  
        return data;  
    }  
}
