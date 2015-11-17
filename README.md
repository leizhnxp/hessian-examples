# hessian-examples

## 缘起

* 现在可能还不适合说太多，就当是兴趣使然

## 结论

* 先说了
* 跟spring结合起来还是很简单的

## 工程说明

### hessian-examples-api

* 接口定义
* 形式上，所有的RPC也都是这种思路，一个接口，在client和server两端使用，然后两端分别用特定的、匹配的技术栈来实现stub

> 扯到这里，可以参考一下[spring整合各种remoting通路的文档](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/remoting.html)，也许其他的序列化形式也可以考虑...

* 内容上，这实际上是业务的核心，规格定义预示或暗含了，如何切分业务粒度是最重要的事情

### hessian-examples-service-consumer

* spring mvc对外暴露接口，mvn clean jetty:run 跑起来在9090端口，curl http://localhost:9090/service-consumer/asdfasf，是的，最后一个参数目前每固定

### hessian-examples-service-provider

* spring mvc + hessian端点配置
* mvn clean jetty:run
* 跑起来在8080
* curl http://localhost:8080/service-provider/AccountService，当然这个操作是多余的，这个地址配到了consumer里，这里访问了也没东西，不过看到是个POST，心里很不爽，我就是调用了一个典型的幂等操作啊，它非给我整一个POST，暗暗怀恨在心...或者也许有什么我不知道的秘密...

## 后续

* 写的很随意，就为了连通，调一下概念，总得弄得好看点吧：
  * insert给填上
  * 而且返回一个操作行为一致的结果
* 因为还是经过HTTP的（好吧，又做了万恶的把http当传输层协议的事情），所以概念上看，consumer和provider之间，有nginx做LB然后做水平扩展，应该没问题的，具体测一下保险
