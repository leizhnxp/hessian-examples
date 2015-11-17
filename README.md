# hessian-examples

## 缘起

* 现在可能还不适合说太多，知道的知道，不知道的也没必要知道，就当是兴趣使然，也未尝不可

## 结论

> 先说结论有时候没坏处

* 跟spring结合起来还是很简单的，有点太简单了，简单好，可以专注于业务

## 概述

* 描述一个和RPC相关的概念上完整的结构，需要一个示例接口定义，一个客户端，一个服务端，然后就是把这些粘合在一起的基础设施和框架需要做的适配

## 工程说明

### hessian-examples-api

* 接口定义
* 形式上，所有的RPC也都是这种思路，一个接口，在client和server两端使用，然后两端分别用特定的、匹配的技术栈来实现stub

> 扯到这里，可以参考一下[spring整合各种remoting通路的文档](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/remoting.html)，也许其他的序列化形式也可以考虑...

* 内容上，这实际上是业务的核心，规格定义预示或暗含了，如何切分业务粒度是最重要的事情

### hessian-examples-service-consumer

* spring mvc对外暴露接口
* mvn clean jetty:run 
* 跑起来在9090端口
* curl http://localhost:9090/service-consumer/asdfasf，是的，最后一个参数目前没固定，总都是调用provider的那个示例接口

### hessian-examples-service-provider

* spring mvc + hessian端点配置
* mvn clean jetty:run
* 跑起来在8080
* curl http://localhost:8080/service-provider/AccountService，当然这个操作是多余的，这个地址配到了consumer里，这里访问了也没东西，不过看到是个POST，心里很不爽，我就是调用了一个典型的幂等操作啊，它非给我整一个POST，暗暗怀恨在心...或者也许有什么我还不知道的秘密...

## 后续

* 写的很随意，就为了连通，印证一下概念，但是，总得弄得好看点：
  * insert给填上，这个POC的目的决定了没有持久层，但是它会引诱你思考，有副作用的操作才是有意思的地方
  * 定义一个更合理的接口名称，返回和操作行为一致的结果
* 因为还是经过HTTP的（好吧，又做了万恶的把http当传输层协议的事情），所以概念上看，consumer和provider之间，有nginx做LB然后做水平扩展，应该没问题的，具体测一下保险
