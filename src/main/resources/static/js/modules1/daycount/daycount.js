var vm = new Vue({
    el: '#rrapp',
    data: {
        dayCounts:[[]]
    },
    methods: {
        initChars:function () {

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
                                formatter: '{b}: {@2018-05-01} ({d}%)'
                            },
                            encode: {
                                itemName: 'customer',
                                value: '2018-05-01',
                                tooltip: '2018-05-01'
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
            var params = {customerIds:[],startDate:'2018-05-01',endDate:'2018-05-09'};
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
        }
    },
    created:function () {
        this.getCustomerDayCounts();
    }
});