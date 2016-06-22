> log4j主要由3个部分组成：logger, appender, layout  

- Logger 对象  
最上一层是 Logger 对象，该对象负责获取日志信息，并存储于一个分层的命名空间之中。  

- Layout 对象  
Layout 层提供了用于以各种风格格式化日志信息的对象，在发布日志信息之前，它为 appender 对象提供支持。  
Layout 对象对于发布日志信息非常重要，它使日志变得可读、可复用。  

- Appender 对象  
该对象位于分层架构中的较低一层，Appender 对象负责将日志信息发布到不同目的地，比如数据库、文件、控制台、Unix Syslog 等。  

[Log4j教程](http://wiki.jikexueyuan.com/project/log4j)

