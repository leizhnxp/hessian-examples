# hessian-examples

## 缘起，现在还不适合说

## 先说结论，跟spring结合起来还是很简单的

## 工程说明

### hessian-examples-api

* 接口定义
* 形式上，所有的RPC也都是这种思路，一个接口，在client和server两端使用，然后两端分别用特定的、匹配的技术栈来实现stub
> 扯到这里，可以参考一下[spring整合各种remoting通路的文档](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/remoting.html)，
* 内容上，这实际上是业务的核心，如何切分业务粒度是最重要的事情

## 后续，因为还是经过HTTP的，所以中间靠nginx做LB应该没问题的，具体测一下保险
