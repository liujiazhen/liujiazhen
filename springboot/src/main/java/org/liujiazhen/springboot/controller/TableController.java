package org.liujiazhen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TableController {
    @RequestMapping("/table_basic")
    public String tableBasic() {
        return "table_basic";
    }
    @RequestMapping("/table_bootstrap")
    public String tableBootstrap() {
        return "table_bootstrap";
    }
    @RequestMapping("/table_data_tables")
    public String tableDataTables() {
        return "table_data_tables";
    }
    @RequestMapping("/table_foo_table")
    public String tableFooTable() {
        return "table_foo_table";
    }
    @RequestMapping("/table_jqgrid")
    public String tableJqgrid() {
        return "table_jqgrid";
    }
}
