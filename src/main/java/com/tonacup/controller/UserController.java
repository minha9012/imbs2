package com.tonacup.controller;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @GetMapping("/test")
    String getHome() {
        return "user test";
    }

    @RequestMapping(value="/signup.do", method= RequestMethod.POST)
    public Map<String, Object> checkEmail(@RequestBody Map<String,Object> paramMap) throws SQLException, Exception {
        System.out.println(paramMap);
        Map <String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("Test","OK");

        return resultMap;
    }
}
