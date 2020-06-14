package com.example.demo.controller.base;

import com.example.demo.entity.User;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.LoginModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@CrossOrigin()
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ApiResponse login(@RequestBody LoginModel loginModel) {
        String username = loginModel.getUsername();
        String password = loginModel.getPassword();
        String result = "";
        HttpStatus httpStatus = null;
        User user = userService.getUserByUsernamePassword(username, password);
        try {
            if(user != null){
                result = "Đăng nhập thành công!";
                httpStatus = HttpStatus.OK;
                return ApiResponse.success(user);
            }
        }catch (Exception ex){
            result = "Đã có lỗi xảy ra";
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ApiResponse.fail("Sai tai khoan hoac mat khau");
    }

//    @GetMapping("login/{id}")
//    public ApiResponse getUsername(@PathVariable("id")Long id) {
//        try {
//            User user = userRepository.findById(id).get();
//            return ApiResponse.success(user.getFirstname());
//        }catch (Exception e) {
//            e.printStackTrace();
//            return ApiResponse.fail(e.getLocalizedMessage());
//        }
//    }
}
