//引用指定模块
layui.use(['table', 'layer'], function(){
    var layer = parent.layer ==undefined ? layui.layer :top.layer
        ,$ =layui.jquery
        ,table=layui.table;

    //do something

    //第一个实例
    table.render({
        elem: '#studentquerylist'
        ,height: 'full-125'
        ,url: '/query/list' //数据接口
        ,page: true //开启分页
        ,limit:5
        ,limits:[10,15,20]
        ,cols: [[ //表头
            {field: 'sid', title: '编号', sort: true, fixed: 'left'}
            , {field: 'sno', title: '学号', sort: true, fixed: 'center'}
            , {field: 'sname', title: '名字', sort: true, fixed: 'center'}
            , {field: 'sjob', title: '职位', sort: true, fixed: 'center'}
            , {field: 'stel', title: '电话', sort: true, fixed: 'center'}
            , {field: 'sdid', title: '工号', sort: true, fixed: 'center'}

        ]]
    });
});