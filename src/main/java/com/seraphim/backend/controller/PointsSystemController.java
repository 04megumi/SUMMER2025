package com.seraphim.backend.controller;

import com.seraphim.backend.Constant;
import com.seraphim.backend.util.R;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/points-system")
public class PointsSystemController {

    /**
     * 获取当前用户积分接口
     *
     * 【功能描述】
     *     根据前端传入的 token 返回对应小朋友当前拥有的积分。
     *
     * 【请求方式】
     *     GET /points-system/points
     *
     * 【请求参数】
     *     - token（String，必传）：用户登录后的 token
     *
     * 【成功响应示例】
     * {
     *     "code": 100000,
     *     "msg": "获取小朋友积分成功",
     *     "data": 999
     * }
     *
     * 【失败响应示例】
     * {
     *     "code": 100900,
     *     "msg": "token 无效",
     *     "data": null
     * }
     */
    @GetMapping("/points")
    public R<Integer> getPointsByToken(@RequestParam("token") String token) {
        if (token == null || token.isEmpty()) {
            return R.failed("没携带 token");
        }
        if (!token.equals(Constant.token)) {
            return R.failed("token 无效");
        }
        return R.success("获取小朋友积分成功", 999);
    }

    /**
     * 获取积分排行榜接口
     *
     * 【功能描述】
     *     模拟获取前几名小朋友的积分排行榜，用于前端展示排名信息。
     *
     * 【请求方式】
     *     GET /points-system/rank
     *
     * 【请求参数】
     *     - token（String，必传）：用户登录后的 token
     *
     * 【成功响应示例】
     * {
     *     "code": 100000,
     *     "msg": "获取排行榜成功",
     *     "data": [
     *         {"rank": 1, "name": "小明", "avatar": "url1", "points": 1500},
     *         {"rank": 2, "name": "小红", "avatar": "url2", "points": 1400}
     *     ]
     * }
     *
     * 【失败响应示例】
     * {
     *     "code": 100900,
     *     "msg": "token 无效",
     *     "data": null
     * }
     */
    @GetMapping("/rank")
    public R<List<Map<String, Object>>> getRankList(@RequestParam("token") String token) {
        if (token == null || token.isEmpty()) {
            return R.failed("没携带 token");
        }
        if (!token.equals(Constant.token)) {
            System.out.println(Constant.token);
            return R.failed("token 无效");
        }


        List<Map<String, Object>> rankList = Arrays.asList(
                Map.of("rank", 1, "name", "小明", "avatar", "url1", "points", 1500),
                Map.of("rank", 2, "name", "小红", "avatar", "url2", "points", 1400),
                Map.of("rank", 3, "name", "小刚", "avatar", "url3", "points", 1300)
        );

        return R.success("获取排行榜成功", rankList);
    }

    /**
     * 获取积分获取记录接口
     *
     * 【功能描述】
     *     返回当前小朋友的积分获取历史记录。
     *
     * 【请求方式】
     *     GET /points-system/gain-records
     *
     * 【请求参数】
     *     - token（String，必传）：用户登录后的 token
     *
     * 【成功响应示例】
     * {
     *     "code": 100000,
     *     "msg": "获取积分获取记录成功",
     *     "data": [
     *         {"time": "2025-08-01 10:00", "source": "完成任务", "points": 100},
     *         {"time": "2025-08-02 14:30", "source": "表现优异", "points": 200}
     *     ]
     * }
     *
     * 【失败响应示例】
     * {
     *     "code": 100900,
     *     "msg": "token 无效",
     *     "data": null
     * }
     */
    @GetMapping("/gain-records")
    public R<List<Map<String, Object>>> getGainRecords(@RequestParam("token") String token) {
        if (token == null || token.isEmpty()) {
            return R.failed("没携带 token");
        }
        if (!token.equals(Constant.token)) {
            return R.failed("token 无效");
        }

        List<Map<String, Object>> records = Arrays.asList(
                Map.of("time", "2025-08-01 10:00", "source", "完成任务", "points", 100),
                Map.of("time", "2025-08-02 14:30", "source", "表现优异", "points", 200)
        );

        return R.success("获取积分获取记录成功", records);
    }

    /**
     * 获取商品列表接口
     *
     * 【功能描述】
     *     返回可兑换的商品列表，包括商品名称和所需积分。
     *
     * 【请求方式】
     *     GET /points-system/product-list
     *
     * 【请求参数】
     *     - token（String，必传）：用户登录后的 token
     *
     * 【成功响应示例】
     * {
     *     "code": 100000,
     *     "msg": "获取商品列表成功",
     *     "data": [
     *         {"name": "文具礼包", "points": 300},
     *         {"name": "拼图游戏", "points": 400}
     *     ]
     * }
     *
     * 【失败响应示例】
     * {
     *     "code": 100900,
     *     "msg": "token 无效",
     *     "data": null
     * }
     */
    @GetMapping("/product-list")
    public R<List<Map<String, Object>>> getProductList(@RequestParam("token") String token) {
        if (token == null || token.isEmpty()) {
            return R.failed("没携带 token");
        }
        if (!token.equals(Constant.token)) {
            return R.failed("token 无效");
        }

        return R.success("获取商品列表成功", Constant.productList);
    }

    /**
     * 商品兑换接口（根据商品名）
     *
     * 【功能描述】
     *     提供小朋友使用积分兑换商品的功能。校验 token、商品名和积分是否充足。
     *
     * 【请求方式】
     *     GET /points-system/exchange
     *
     * 【请求参数】
     *     - token（String，必传）：用户登录后的 token
     *     - productName（String，必传）：要兑换的商品名称（必须是商品列表中的有效值）
     *
     * 【成功响应示例】
     * {
     *     "code": 100000,
     *     "msg": "兑换成功，已消耗 300 积分兑换 文具礼包",
     *     "data": null
     * }
     *
     * 【失败响应示例】（商品不存在）
     * {
     *     "code": 100900,
     *     "msg": "商品不存在",
     *     "data": null
     * }
     *
     * 【失败响应示例】（积分不足）
     * {
     *     "code": 100900,
     *     "msg": "积分不足，无法兑换该商品",
     *     "data": null
     * }
     *
     * 【失败响应示例】（token无效）
     * {
     *     "code": 100900,
     *     "msg": "token 无效",
     *     "data": null
     * }
     */
    @GetMapping("/exchange")
    public R<String> exchangeProduct(@RequestParam("token") String token,
                                     @RequestParam("productName") String productName) {
        if (token == null || token.isEmpty()) {
            return R.failed("没携带 token");
        }
        if (!token.equals(Constant.token)) {
            return R.failed("token 无效");
        }
        // 模拟当前积分
        int currentPoints = 999;
        // 查找商品
        Map<String, Object> selectedProduct = Constant.productList.stream()
                .filter(p -> productName.equals(p.get("name")))
                .findFirst()
                .orElse(null);

        if (selectedProduct == null) {
            return R.failed("商品不存在");
        }
        int requiredPoints = (int) selectedProduct.get("points");
        if (currentPoints < requiredPoints) {
            return R.failed("积分不足，无法兑换该商品");
        }
        // 模拟成功兑换（真实业务应扣积分 + 添加兑换记录）
        return R.success("兑换成功，已消耗 " + requiredPoints + " 积分兑换 " + productName);
    }

    /**
     * 教室给小朋友加分接口
     *
     * 功能描述：
     *     教师根据加分项（如“表现优异”）给小朋友增加积分。
     *
     * 请求参数：
     *     - token（String）：用户令牌
     *     - actionTitle（String）：加分行为的标题，如“帮助他人”
     *     - childName（String）：小朋友姓名（模拟）
     *
     * 返回示例：
     * {
     *   "code": 100000,
     *   "msg": "加分成功：帮助他人 +80分",
     *   "data": {
     *       "name": "小明",
     *       "action": "帮助他人",
     *       "addedPoints": 80,
     *       "newTotalPoints": 1079
     *   }
     * }
     */
    @PostMapping("/gain-points")
    public R<Map<String, Object>> gainPoints(@RequestParam("token") String token,
                                             @RequestParam("actionTitle") String actionTitle,
                                             @RequestParam("childName") String childName) {
        if (token == null || token.isEmpty()) {
            return R.failed("没携带 token");
        }
        if (!token.equals(Constant.token)) {
            return R.failed("token 无效");
        }
        int currentPoints = 999;
        Map<String, Object> action = Constant.gainableActions.stream()
                .filter(a -> a.get("title").equals(actionTitle))
                .findFirst()
                .orElse(null);

        if (action == null) {
            return R.failed("无效的加分行为: " + actionTitle);
        }

        int addedPoints = (int) action.get("points");
        currentPoints += addedPoints;

        Map<String, Object> result = new HashMap<>();
        result.put("name", childName);
        result.put("action", actionTitle);
        result.put("addedPoints", addedPoints);
        result.put("newTotalPoints", currentPoints);

        return R.success("加分成功：" + actionTitle + " +" + addedPoints + "分", result);
    }

}
