package com.seraphim.backend.controller;

import com.seraphim.backend.Constant;
import com.seraphim.backend.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @GetMapping("getToken/success")
    public R<String> getTokenSuccess(String code) {
        return R.success(Constant.token);
    }

    @GetMapping("getToken/failed")
    public R<String> getTokenFailed(String code) {
        return R.failed();
    }
}
