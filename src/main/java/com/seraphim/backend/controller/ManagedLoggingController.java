package com.seraphim.backend.controller;

import com.seraphim.backend.util.R;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/managed-logging")
public class ManagedLoggingController {

    /**
     * 教师录入或修改学生托管日志
     *
     * 请求方式：POST
     * 请求地址：/managed-logging/log
     *
     * 请求参数（JSON 请求体）示例：
     * {
     *     "studentName": "小明",
     *     "date": "2025-08-05",
     *     "chinesePerformance": "完成良好",
     *     "mathPerformance": "需加强计算",
     *     "englishPerformance": "朗读清晰",
     *     "habitPerformance": "专注度高",
     *     "literacyTraining": "积极主动",
     *     "teacherComment": "整体表现很好",
     *     "todayPoints": 30
     * }
     *
     * 响应成功示例：
     * {
     *     "code": 100000,
     *     "msg": "日志保存成功",
     *     "data": null
     * }
     */
    @PostMapping("/log")
    public R<String> saveOrUpdateLog(@RequestBody Map<String, Object> logRequest) {
        return R.success("日志保存成功");
    }

    /**
     * 家长查看某一天的学生托管日志
     *
     * 请求方式：GET
     * 请求地址：/managed-logging/log
     *
     * 请求参数：
     * - studentName（String）：学生姓名
     * - date（String）：日期（格式：yyyy-MM-dd）
     *
     * 响应成功示例：
     * {
     *     "code": 100000,
     *     "msg": "日志查询成功",
     *     "data": {
     *         "studentName": "小明",
     *         "date": "2025-08-05",
     *         "chinesePerformance": "完成良好",
     *         "mathPerformance": "需加强计算",
     *         "englishPerformance": "朗读清晰",
     *         "habitPerformance": "有礼貌",
     *         "literacyTraining": "能主动完成",
     *         "teacherComment": "整体不错",
     *         "todayPoints": 50
     *     }
     * }
     */
    @GetMapping("/log")
    public R<Map<String, Object>> getLog(@RequestParam String studentName, @RequestParam String date) {
        return R.success("日志查询成功", Map.of(
                "studentName", studentName,
                "date", date,
                "chinesePerformance", "完成良好",
                "mathPerformance", "需加强计算",
                "englishPerformance", "朗读清晰",
                "habitPerformance", "有礼貌",
                "literacyTraining", "能主动完成",
                "teacherComment", "整体不错",
                "todayPoints", 50
        ));
    }

    /**
     * 教师上传学生当日任务完成情况
     *
     * 请求方式：POST
     * 请求地址：/managed-logging/tasks
     *
     * 请求参数（JSON 请求体）示例：
     * {
     *     "studentName": "小明",
     *     "subject": "数学",
     *     "content": "第5页计算题",
     *     "completed": true,
     *     "corrected": false,
     *     "imageUrl": "https://example.com/image1.jpg",
     *     "comment": "需加强订正"
     * }
     *
     * 响应成功示例：
     * {
     *     "code": 100000,
     *     "msg": "任务记录上传成功",
     *     "data": null
     * }
     */
    @PostMapping("/tasks")
    public R<String> uploadTasks(@RequestBody Map<String, Object> taskRequest) {
        return R.success("任务记录上传成功");
    }

    /**
     * 家长查看学生所有任务完成情况
     *
     * 请求方式：GET
     * 请求地址：/managed-logging/tasks
     *
     * 请求参数：
     * - studentName（String）：学生姓名
     *
     * 响应成功示例：
     * {
     *     "code": 100000,
     *     "msg": "任务记录获取成功",
     *     "data": [
     *         {
     *             "studentName": "小明",
     *             "subject": "语文",
     *             "content": "阅读理解第三题",
     *             "completed": true,
     *             "corrected": true,
     *             "imageUrl": "https://example.com/image1.jpg",
     *             "comment": "完成良好"
     *         }
     *     ]
     * }
     */
    @GetMapping("/tasks")
    public R<List<Map<String, Object>>> getTaskRecords(@RequestParam String studentName) {
        return R.success("任务记录获取成功", List.of(
                Map.of(
                        "studentName", studentName,
                        "subject", "语文",
                        "content", "阅读理解第三题",
                        "completed", true,
                        "corrected", true,
                        "imageUrl", "https://example.com/image1.jpg",
                        "comment", "完成良好"
                )
        ));
    }

    /**
     * 家长为孩子添加关注事项
     *
     * 请求方式：POST
     * 请求地址：/managed-logging/attention
     *
     * 请求参数（JSON 请求体）示例：
     * {
     *     "studentName": "小明",
     *     "content": "希望每天朗读10分钟"
     * }
     *
     * 响应成功示例：
     * {
     *     "code": 100000,
     *     "msg": "关注事项添加成功",
     *     "data": null
     * }
     */
    @PostMapping("/attention")
    public R<String> addAttentionItem(@RequestBody Map<String, Object> attentionRequest) {
        return R.success("关注事项添加成功");
    }

    /**
     * 教师查看某学生关注事项列表
     *
     * 请求方式：GET
     * 请求地址：/managed-logging/attention
     *
     * 请求参数：
     * - studentName（String）：学生姓名
     *
     * 响应成功示例：
     * {
     *     "code": 100000,
     *     "msg": "关注事项获取成功",
     *     "data": [
     *         {
     *             "studentName": "小明",
     *             "content": "希望加强口算能力"
     *         }
     *     ]
     * }
     */
    @GetMapping("/attention")
    public R<List<Map<String, Object>>> getAttentionList(@RequestParam String studentName) {
        return R.success("关注事项获取成功", List.of(
                Map.of(
                        "studentName", studentName,
                        "content", "希望加强口算能力"
                )
        ));
    }

    /**
     * 家长在日志中留言
     *
     * 请求方式：POST
     * 请求地址：/managed-logging/comment
     *
     * 请求参数（JSON 请求体）示例：
     * {
     *     "studentName": "小明",
     *     "content": "谢谢老师，孩子最近有进步",
     *     "timestamp": "2025-08-05 10:30"
     * }
     *
     * 响应成功示例：
     * {
     *     "code": 100000,
     *     "msg": "留言成功",
     *     "data": null
     * }
     */
    @PostMapping("/comment")
    public R<String> leaveComment(@RequestBody Map<String, Object> commentRequest) {
        return R.success("留言成功");
    }

    /**
     * 教师查看某学生所有家长留言
     *
     * 请求方式：GET
     * 请求地址：/managed-logging/comments
     *
     * 请求参数：
     * - studentName（String）：学生姓名
     *
     * 响应成功示例：
     * {
     *     "code": 100000,
     *     "msg": "留言获取成功",
     *     "data": [
     *         {
     *             "studentName": "小明",
     *             "content": "谢谢老师的反馈！",
     *             "timestamp": "2025-08-05 10:30"
     *         }
     *     ]
     * }
     */
    @GetMapping("/comments")
    public R<List<Map<String, Object>>> getComments(@RequestParam String studentName) {
        return R.success("留言获取成功", List.of(
                Map.of(
                        "studentName", studentName,
                        "content", "谢谢老师的反馈！",
                        "timestamp", "2025-08-05 10:30"
                )
        ));
    }
}
