# 为什么还没到用JPA JDBC 的时候

## delete children on saving parent

当保存 aggregate root 时， aggregate children 会被删除再重建。性能上不值得。

舍弃hibernate 换来的 无 Proxy 无 lazy load 得到的丁点性能提升，被 delete children on saving root 消耗了。

## MappedCollection id 无法自定义

无法自定义 aggregate child 的外键， 除非 NameStrategy， 但这样就很啰嗦且引入了不必要的学习项。

默认的 外键和 排序key 为 tableName_{id} 及 tableName_key

如果不想 delete on saving , 则必须自己维护子对象集合，这样相当于要自己实现 lazy loading, saving cascade等逻辑，得不偿失。

## 动态查询支持不好

最动态的只是 Example 查询，但是不支持 and/or 的聚合，只有简单的单标字段 and 连接。

和 spring specification 功能上差距很大。

## Auto persist when finishing transaction

这个是 hibernate 的一个好功能，让人专注业务，
如果代码跑在transaction 外，就是on the fly 计算。
如果代码跑在事务内，就是持久化更改，代码效率高。

且在函数式编程环境中，没有save 意味着没有副作用，纯函数。

JDBC需要显式repo.save，破坏函数纯度，增加复杂性。

## 加锁没有方言

如果写sql (@Query的方式)进行加锁， 加锁语句必须跟数据库绑定。

# 已经支持的好的地方

## compound id (embedded id ) to avoid id obsession

hibernate 也已经支持。