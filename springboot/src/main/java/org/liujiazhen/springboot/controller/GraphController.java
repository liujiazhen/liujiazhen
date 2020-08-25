package org.liujiazhen.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GraphController {
    private static final Logger logger = LoggerFactory.getLogger(GraphController.class);

    @RequestMapping("/graph_echarts")
    public String graphEcharts() {
        return "graph_echarts";
    }
    @RequestMapping("/graph_flot")
    public String graphFlot() {
        return "graph_flot";
    }
    @RequestMapping("/graph_morris")
    public String graphMorris() {
        return "graph_morris";
    }
    @RequestMapping("/graph_rickshaw")
    public String graphRickshaw() {
        return "graph_rickshaw";
    }
    @RequestMapping("/graph_peity")
    public String graphPeity() {
        return "graph_peity";
    }
    @RequestMapping("/graph_sparkline")
    public String graphSparkline() {
        return "graph_sparkline";
    }
    @RequestMapping("/graph_metrics")
    public String graphMetrics() {
        return "graph_metrics";
    }

}
