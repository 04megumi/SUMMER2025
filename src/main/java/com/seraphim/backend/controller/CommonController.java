package com.seraphim.backend.controller;

import com.seraphim.backend.Constant;
import com.seraphim.backend.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通用接口控制器，用于模拟微信小程序登录流程中的 wx.login() 行为
 */
@RestController
@RequestMapping("/getToken")
public class CommonController {

    /**
     * 模拟微信登录成功接口
     *
     * 【接口功能】
     *   模拟微信小程序调用 wx.login 后，将 code 发送给后端，后端返回一个模拟 token，
     *   表示登录成功。
     *
     * 【请求方式】
     *   GET
     *
     * 【请求地址】
     *   /getToken/success
     *
     * 【请求参数】
     *   - code（String）：微信登录凭证（不能为空）
     *     示例：GET /getToken/success?code=123456
     *
     * 【响应结果】
     *   成功（code 有值）：
     *   {
     *     "code": 100000,
     *     "msg": "success",
     *     "data": "your_token_value"
     *   }
     *
     *   失败（code 缺失）：
     *   {
     *     "code": 100900,
     *     "msg": "缺少 code 参数",
     *     "data": null
     *   }
     */
    @GetMapping("/success")
    public R<String> getTokenSuccess(@RequestParam String code) {
        if (code == null || code.isEmpty()) {
            return R.failed("缺少 code 参数");
        }
        return R.success(Constant.token); // 例如 Constant.token = "mock-token-abc123"
    }

    /**
     * 模拟微信登录失败接口
     *
     * 【接口功能】
     *   模拟微信小程序登录失败的场景，即使前端传了 code，也强制返回失败信息。
     *
     * 【请求方式】
     *   GET
     *
     * 【请求地址】
     *   /getToken/failed
     *
     * 【请求参数】
     *   - code（String）：微信登录凭证（任意值）
     *     示例：GET /getToken/failed?code=123456
     *
     * 【响应结果】
     *   {
     *     "code": 100900,
     *     "msg": "模拟登录失败",
     *     "data": null
     *   }
     */
    @GetMapping("/failed")
    public R<String> getTokenFailed(@RequestParam String code) {
        return R.failed("模拟登录失败");
    }
}