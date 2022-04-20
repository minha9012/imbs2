package com.tonacup.domain.user;

import com.tonacup.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    /**
     * @return 전체조회
     */
    @GetMapping
    @ResponseBody
    public List<User> list() {
        return userService.findUsers();
    }

    /**
     * 등록된 유저 id로 조회
     *
     */
    @GetMapping("/{userId}")
    public Optional<User> searchId(@PathVariable Long userId) {
        //TODO : Long 검증
        return userService.findId(userId);
    }
    /*
        POST(/users/id) : 등록
    * */

    /**
     * 등록
     * TODO:api 협의필요, ID 클라이언트에서 채번할지
     */
    @PostMapping("/{userId}")
    public void register(@RequestBody User user) {
        log.info("userId:{}", user.getId());
        log.info("userName:{}", user.getUsername());
        log.info("userEmail:{}", user.getEmail());
        userService.join(user);
    }

    @GetMapping("/test")
    String getHome() {
        return "user test";
    }

    @RequestMapping(value = "/signup.do", method = RequestMethod.POST)
    public Map<String, Object> checkEmail(@RequestBody Map<String, Object> paramMap) {
        System.out.println(paramMap);
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("Test", "OK");

        return resultMap;
    }
}
