## 笔记项目 接口文档

### 1. 登陆

**请求url：**http://localhost:8080/ding_note/user/login.do

**请求方式：**post

**参数类型：**

| 参数     | 是否必选 | 类型   | 说明   |
| :------- | :------: | :----- | :----- |
| username |    Y     | string | 用户名 |
| password |    Y     | string | 密码   |

**返回实例：**

```json
{
    "status": 0,
    "msg": "登录成功",
    "data": {
        "cn_user_id": "48595f52-b22c-4485-9244-f4004255b972",
        "cn_user_name": "demo",
        "cn_user_password": "123456",
        "cn_user_token": null,
        "cn_user_nick": null
    }
}
```

