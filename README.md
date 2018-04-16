

# 注意，目前还没有封装完成，还在开发中ing...


# 相关blogs
[可能是迄今最完美的RecyclerView的Adapter封装（一）](http://www.jianshu.com/p/618d115c92d6)
[http://www.jianshu.com/p/618d115c92d6](http://www.jianshu.com/p/618d115c92d6)

# SuperRecyclerAdapter
Android RecyclerView万能Adapter，实现原理巧妙，代码量非常小，功能却很强大，使用非常简单

在线上项目中使用很长时间，无bug产生，非常完美，代码很简单，没有那么复杂，实现的比较巧妙，特别是实现支持多类型item的时候，不需要设置item的type，不需要add各种东西，可以直接兼容RecyclerView横向布局，网格布局等的单类型item和多类型item,几乎兼容所有的列表需求，也可以实现楼层那种复杂列表，类似淘宝首页那种多种楼层（当然淘宝应该是使用vLayout来实现的吧，vLayout对于这种非常复杂的楼层列表性能更好，以后有时间会去研究一下vLayout源码）

```java
	   //就这段代码直接支持RecyclerView横向布局，网格布局等的单类型item和多类型item
        mAdapter = new SuperRecyclerAdapter<TicketEntity>(this, list) {
            @Override public void convert(SuperRecyclerHolder holder, TicketEntity entity, int viewType, int position) {
                
            }

            @Override public int getLayoutAsItemViewType(TicketEntity entity, int position) {
                return 0;
            }
        };

```
上边的简单的代码就是一个new就创建了一个兼容各种情况的Adapter，是不是很强大，而且兼容多布局，demo就暂时还没写

