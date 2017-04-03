package com.zx.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 97038 on 2017-04-02.
 */
@Controller
public class MainController {

//    @Autowired
//    private Girl girl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
//        return "main" + "-------" + girl;
        return "index";
    }
}
