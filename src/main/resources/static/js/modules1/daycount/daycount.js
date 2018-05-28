var vm = new Vue({
    el: '#rrapp',
    data: {
        dayCounts:[[]],
        q:{
            startDate:'2018-05-01',
            endDate:'2018-05-09',
            customerIds:[]
        },
        multiple: {
            originOptions: [],
            selectedList: []
        }
    },
    mounted: function() {
        //装载
        var start = AddDays(-7);
        var end = AddDays(0);
        this.q.startDate = start;
        this.q.endDate = end;
        //数据组装
        this.queryData();
        // this.getCustomerDayCounts();
    },
    methods: {
        queryData: function(){
            var mySelf = this;
            //do ajax here
            $.ajax({
                url: baseURL + "customer/listAll",
                type:"POST",
                data:{},
                success:function (r) {
                    if (r.code==0){
                        for (var i=0; i<r.customers.length; i++){
                            mySelf.multiple.originOptions.push({"id":r.customers[i].customerId,"name":r.customers[i].customer});
                        }
                        mySelf.multiple.selectedList = [{"id":r.customers[0].customerId,"name":r.customers[0].customer}];
                    }
                }
            });
            // mySelf.multiple.originOptions = [{"id":"1","name":"lemon"},{"id":"2","name":"mike"},{"id":"3","name":"lara"},{"id":"4","name":"zoe"},{"id":"5","name":"steve"},{"id":"6","name":"nolan"}];
            // mySelf.multiple.selectedList = [{"id":"3","name":"lara"}];

            //以上执行完毕，执行这个任务
            this.$nextTick(function(){

            });
        },
        getSelectIds:function () {
            var ids = [];
           for (var i=0; i< this.multiple.selectedList.length; i++){
               ids.push(this.multiple.selectedList[i].id);
           }
           return ids;
        },
        initChars:function () {
            //销毁 上次查询残存的图表
            echarts.dispose(document.getElementById('main'));
            var myChart = echarts.init(document.getElementById('main'));
            setTimeout(function () {
                option = {
                    legend: {},
                    tooltip: {
                        trigger: 'axis',
                        showContent: false
                    },
                    dataset: {
                        source: vm.dayCounts/*[
                            ['product', '2012', '2013', '2014', '2015', '2016', '2017'],
                            ['Matcha Latte', 41.1, 30.4, 65.1, 53.3, 83.8, 98.7],
                            ['Milk Tea', 86.5, 92.1, 85.7, 83.1, 73.4, 55.1],
                            ['Cheese Cocoa', 24.1, 67.2, 79.5, 86.4, 65.2, 82.5],
                            ['Walnut Brownie', 55.2, 67.1, 69.2, 72.4, 53.9, 39.1]
                        ]*/
                    },
                    xAxis: {type: 'category'},
                    yAxis: {gridIndex: 0},
                    grid: {top: '55%'},
                    series: [
                        {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                        {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                        {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                        {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                        {
                            type: 'pie',
                            id: 'pie',
                            radius: '30%',
                            center: ['50%', '25%'],
                            label: {
                                formatter: '{b}: {@'+vm.q.startDate+'} ({d}%)'
                            },
                            encode: {
                                itemName: 'customer',
                                value: vm.q.startDate,
                                tooltip: vm.q.startDate
                            }
                        }
                    ]
                };

                myChart.on('updateAxisPointer', function (event) {
                    var xAxisInfo = event.axesInfo[0];
                    if (xAxisInfo) {
                        var dimension = xAxisInfo.value + 1;
                        myChart.setOption({
                            series: {
                                id: 'pie',
                                label: {
                                    formatter: '{b}: {@[' + dimension + ']} ({d}%)'
                                },
                                encode: {
                                    value: dimension,
                                    tooltip: dimension
                                }
                            }
                        });
                    }
                });

                myChart.setOption(option);

            });
        },
        getCustomerDayCounts:function () {
            var selectIds = this.getSelectIds();
            var params = {customerIds:selectIds,startDate:this.q.startDate,endDate:this.q.endDate};
            $.ajax({
               url: baseURL + "dayCounts/list",
               type:"POST",
               contentType:"application/json",
               data:JSON.stringify(params),
               success:function (r) {
                   if (r.code==0){

                       var dayCounts = [];
                       dayCounts[0] = [];
                       dayCounts[0].push('customer');
                       for (var j=0; j<r.customerDayCounts[0].dayCounts.length; j++){
                           dayCounts[0].push(r.customerDayCounts[0].dayCounts[j].countDate);
                       }
                       for(var i=0; i<r.customerDayCounts.length; i++){
                           dayCounts[i+1] = [];
                           dayCounts[i+1].push(r.customerDayCounts[i].customer);
                           for (var j=0; j<r.customerDayCounts[i].dayCounts.length; j++){
                               dayCounts[i+1].push(r.customerDayCounts[i].dayCounts[j].flowCount);
                           }
                       }
                       vm.dayCounts = dayCounts;
                       // vm.$set(vm.dayCounts,dayCounts);
                       vm.initChars();
                   }
               }
            });
        },
        multipleCallback: function(data){
            this.multiple.selectedList = data;
            // console.log('父级元素调用multipleSelected 选中的是' + JSON.stringify(data))
        }
    }
});