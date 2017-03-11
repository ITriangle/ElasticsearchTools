[TOC]

# ElasticsearchTools
Elasticsearch 的导出工具,提供了 Restful API .可根据查询条件导出数据到 `json` 文件.每个文件的最大记录条数为5000.

**注意:环境依赖:**

- `Elasticsearch` 版本使用 `2.4.1`
- 依赖 `Elasticsearch Java Client` 为 `2.4.1`
- `Java JD`K 为 `1.8`
- `SpringBoot` 为 `1.4.3`

## 一.Restful API 格式说明
API  设计尽量参考 Elasticsearch 的API设计,并将其进行了简化.可迅速的将 Elasticsearch 中的查询参数迁移到本工具中.能力有限, 设计不可能全面,有什么好的意见可以提出.

没有参数的情况,后面说明.

### 1.命令格式:
```sh
curl -i -X<VERB> '<PROTOCOL>://<HOST>:<PORT>/<INDEX>/<TYPE>/_search' -d '<BODY>'
```

### 2.命令格式说明:

- `VERB`:指明HTTP方法：GET , POST , PUT
- `PROTOCOL`: http协议
- `HOST`: Elasticsearch Tools工具的IP地址,默认为 `localhost`
- `PORT`:Elasticsearch Tools HTTP服务所在的端口，默认为 `8080`
- `INDEX`:查询的索引
- `TYPE`:索引的类型可以省略,省略就是查询该索引下的所有类型.
- `BODY`:一个JSON格式的请求主体（ 如果请求需要的话）
- `i`:显示头部信息

## 二.举例说明

### 1.指定 `type` 

- 指定查询的 `type`

```sh
curl -XGET 'http://192.168.4.84:8080/index_mac/type/_search' -d ''
```

或者

- 不指定查询的 `type`,会查询该索引下所有的 `type`

```sh
curl -XGET 'http://192.168.4.84:8080/index_mac/_search' -d ''
```

### 2.详解 `BODY`
`BODY` 部分为一个 JSON 结构化数据,结构特征:

- 外层为 `query` 对象.
- 内部分为 `must` , `must_not` , `should` 查询条件的组合.
- 一组查询中包含, 一个 `range` 和 多个 `expression`(`expression` 中后缀从 `1` 开始).比如 `must` 中只能有一个 `range`,但可以有多个 `expression1`,`expression2`
- `range` 包含: 
    - 匹配的字段 `field` 
    - 大于条件 `gt`
    - 小于条件 `lt`
    - 下边界等于条件 `ge`:只能为 `true` 或者 `false`
    - 上边界等于条件 `le`:只能为 `true` 或者 `false`
- `expression` 包含:
    - 匹配的字段操作: `operation`,比如 `term` 精确匹配
    - 匹配的字段 `field` 
    - 查询条件值 `value`

**如下实例** : 查询索引中 `signal` 字段的数值范围 `80 <= signal.value < 10` 和 `id.value == 3815027` 和 `area_code.value == 120105` 的记录

```json
{
  "query": {
    "must": {
      "range": {
        "field": "signal",
        "gt": "-80",
        "ge": "true",
        "lt": "10",
        "le": "false"
      },
      "expression1": {
        "operation": "term",
        "field": "id",
        "value": "3815027"
      },
      "expression2": {
        "operation": "term",
        "field": "area_code",
        "value": "120105"
      }
    },
    "must_not": {},
    "should": {}
  }
}
```

**注意** : 不需要的部分是可以缺省的,比如 `range` 中 `ge` 和 `le` 缺省值为 `false`.当然 `must_not` 和 `should` 也是可以缺省的.如下面实例,缺省了 `ge` 和 `gt`,以及 `must_not` 和 `should`

```json
{
  "query": {
    "must": {
      "range": {
        "field": "signal",
        "lt": "10",
        "le": "false"
      },
      "expression1": {
        "operation": "term",
        "field": "id",
        "value": "3815027"
      },
      "expression2": {
        "operation": "term",
        "field": "area_code",
        "value": "120105"
      }
    }
  }
}
```

## 无参数情况
无参数情况,只是在现有的 `URL` 基础上加 `null`;

### 1.指明类型

```
http://localhost:8080/index_mac/type/_search/null
```

### 1.不指明类型

```
http://localhost:8080/index_mac/_search/null
```

## 导入功能
导入功能现在还没有完善,考虑到 Elasticsearch 有直接的 `bulk` API,用脚本导入速度会更快.后续有需要也可将该 API 加入到本工具中.

curl 批量导入命令如下:

```sh
curl -XPOST 'localhost:9200/index_mac/type/_bulk?pretty' --data-binary  @index_mac_type.json
```

## 部署执行
在当然工程根目录运行:

- 打包 `jar`:  `mvn package` 
- 运行 `jar`: `java -jar target/myproject-0.0.1-SNAPSHOT.jar`

## 使用样例

访问的URL都是: `http://localhost:8080/index_mac/type/_search`

### 1.获取 `index_mac` 的 `signal` 小于 10的记录

```json
{
  "query": {
    "must": {
      "range": {
        "field": "signal",
        "ge": "false",
        "lt": "10",
        "le": "false"
      }
    },
    "must_not": {},
    "should": {}
  }
}

```

### 2.获取 `index_mac` 的 `signal` 小于 10,且 `id` = 3815027 的记录

```json
{
  "query": {
    "must": {
      "range": {
        "field": "signal",
        "ge": "false",
        "lt": "10",
        "le": "false"
      },
      "expression1": {
        "operation": "term",
        "field": "id",
        "value": "3815027"
      }
    },
    "must_not": {},
    "should": {}
  }
}
```