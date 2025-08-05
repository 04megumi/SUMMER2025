package com.seraphim.backend;

import java.util.List;
import java.util.Map;

public interface Constant {

    public final String token = "token-test";

    List<Map<String, Object>> productList = List.of(
            Map.of(
                    "name", "文具礼包",
                    "points", 300,
                    "image", "https://example.com/images/stationery.jpg",
                    "description", "包含多种实用文具，适合学习使用"
            ),
            Map.of(
                    "name", "奖励卡",
                    "points", 150,
                    "image", "https://example.com/images/reward-card.jpg",
                    "description", "可用于兑换特殊奖励或权限"
            ),
            Map.of(
                    "name", "玩具车",
                    "points", 500,
                    "image", "https://example.com/images/toy-car.jpg",
                    "description", "精致的儿童玩具小汽车"
            ),
            Map.of(
                    "name", "绘本",
                    "points", 250,
                    "image", "https://example.com/images/book.jpg",
                    "description", "启发想象力的儿童绘本"
            ),
            Map.of(
                    "name", "拼图游戏",
                    "points", 400,
                    "image", "https://example.com/images/puzzle.jpg",
                    "description", "开发智力的益智拼图游戏"
            )
    );

    public static final List<Map<String, Object>> gainableActions = List.of(
            Map.of(
                    "title", "表现优异",
                    "points", 100,
                    "description", "课堂或活动中表现突出，受到老师表扬",
                    "time", "2025-08-01 09:30"
            ),
            Map.of(
                    "title", "帮助他人",
                    "points", 80,
                    "description", "主动帮助同学或老师完成任务",
                    "time", "2025-08-02 14:00"
            ),
            Map.of(
                    "title", "按时完成作业",
                    "points", 60,
                    "description", "高质量地完成作业并按时提交",
                    "time", "2025-08-03 18:00"
            ),
            Map.of(
                    "title", "卫生值日积极",
                    "points", 70,
                    "description", "积极参与班级卫生工作，保持环境整洁",
                    "time", "2025-08-04 08:00"
            ),
            Map.of(
                    "title", "积极发言",
                    "points", 50,
                    "description", "在课堂上积极思考，勇于表达观点",
                    "time", "2025-08-05 10:15"
            )
    );
}
