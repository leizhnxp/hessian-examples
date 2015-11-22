# hessian-examples

## 缘起

* 现在可能还不适合说太多，知道的知道，不知道的也没必要知道，就当是兴趣使然，也未尝不可
* mybatis部分是后来加上的，可以用来进一步说明，hessian consumer和provider部分的区别，当然也有其它原因

## 结论

> 先说结论有时候没坏处

* 任何玩意儿跟spring结合起来都很简单的，仅hessian部分有点太简单了，简单倒是可以专注于业务；spring粘合剂的名声绝不是盖的
* 顺便再show一下最近一直想表达却没机会表达的东西——持久层如果依赖schema做自动代码创建，并且你又用maven，应该如何做，这背后的主题是：设计要素到系统构建的自动化，才是那些拿敏捷方法论粉饰面具的人们应该关注的实质，否则，那里剩下的就是劳动密集型，都不必争论了

## 概述

* 描述一个和RPC相关的概念上完整的结构，需要一个示例接口定义，一个客户端，一个服务端，然后就是把这些粘合在一起的基础设施和框架需要做的适配，这是最主要的目的
* 再前一个结构的基础上，增加引入mybatis后的样例，包括自动代码创建部分；这是次要的目的，但是项目应用时比较显示的需求
* 额外的润滑剂部分，比如使用了Spring MVC，也就是认可了这种侵入性之后，索性彻底缴械披上它全部盔甲，比如message convertors功能
* 上述“润滑剂”的简便性，却不好集中的表达，特别是和别的概念演示混合在一起的时候，主要是这种东西，连曾经极为醉心的那种奇技淫巧都不是，充其量也就是上上下下左右左右BA时的公开秘笈

## 工程说明

### 最前

* 因为增加了持久化那一部分，所以需要有个数据库，有个表

### hessian-examples-api

* 接口定义
* 形式上，所有的RPC也都是这种思路，一个接口，在client和server两端使用，然后两端分别用特定的、匹配的技术栈来实现stub

> 扯到这里，可以参考一下[spring整合各种remoting通路的文档](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/remoting.html)，也许其他的序列化形式也可以考虑...

* 内容上，这实际上是业务的核心，规格定义预示或暗含了，如何切分业务粒度是最重要的事情

### hessian-examples-dao

* 让人慢下来的那一部分，却是连接业务上最重要的数字资产的那部分
* 这里主要表达的就是mbg工具的使用

### hessian-examples-service-consumer

* spring mvc对外暴露接口
* mvn clean jetty:run 
* 跑起来在9090端口
* curl http://localhost:9090/service-consumer/accounts?name=abcde

### hessian-examples-service-provider

* spring mvc + hessian端点配置
* mvn clean jetty:run
* 跑起来在8080
* curl http://localhost:8080/service-provider/AccountService，当然这个操作是多余的，这个地址配到了consumer里，这里访问了也没东西，不过看到是个POST，心里很不爽，我就是调用了一个典型的幂等操作啊，它非给我整一个POST，暗暗怀恨在心...或者也许有什么我还不知道的秘密...

## 后续

* 写的很随意，就为了连通，印证一下概念，但是，总得弄得好看点：
  * insert给填上，~~这个POC的目的决定了没有持久层，但是~~它会引诱你思考，有副作用的操作才是有意思的地方
  * 定义一个更合理的接口名称，返回和操作行为一致的结果
  * 和服务相关的名字，写在了spring的ctx文件中，properties化是必须的
    * 再进一步要仔细考量这个问题：从一个工匠角度来看，如果一个服务发现和名称管理的基础设施（dubble或者干脆就是更古老的WSDL）没有好用的可以启发式的或者搜索补全式的工具，这个基础设施的价值很是值得商榷，也许一个定义良好的URI，其实并不比那样一个基础设施能力在应用中表现的更差
* 因为还是经过HTTP的（好吧，又做了万恶的把http当传输层协议的事情），所以概念上看，consumer和provider之间，有nginx做LB然后做水平扩展，应该没问题的，具体测一下保险
