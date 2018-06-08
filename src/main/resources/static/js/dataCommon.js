/**
 * 日期 组件
 */
Vue.component('datetimepicker', {
    props: {
        value: String,
        format: {type: String, default: 'yyyy-mm-dd'},
        minview: {type: String, default: 'month'},
        maxview: {type: String, default: 'decade'},
        startview: {type: String, default: 'month'},
        language: {type: String, default: 'zh-CN'},
        disabled: {type: Boolean, default: false}
    },
    template: ' <div class="datetimepicker input-group date  limitDate" data-date-format="YYYY-MM-DD">\n' +
    '<input type="text" :value="value" :disabled="disabled"  class="form-control widths" />\n' +
    '<span class="input-group-addon"><span class="fa fa-calendar"></span></span>\n' +
    '</div>',
    methods: {
        updateValue: function (value) {
            this.$emit('input', value);
        }
    },
    mounted: function () {
        var vm = this;
        $(this.$el).datetimepicker({
            format: vm.format,
            minView: vm.minview,
            maxView: vm.maxview,
            startView: vm.startview,
            autoclose: true,
            language: vm.language
        }).on('hide', function (ev) {
            vm.$emit('input', this.children[0].value);
            vm.$emit('date-change');
        });
    },
    watch: {
        value: function (value) {

        }
    },
    destroyed: function () {
        $(this.$el).off().datetimepicker('destroy')
    }
});


function NumFormat(value) {
    if(!value) return '0';

    var intPart = Number(value).toFixed(0); //获取整数部分
    var intPartFormat = intPart.toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,'); //将整数部分逢三一断
    return intPartFormat;


}
function AddDays(dayIn) {
    var date=new Date();
    var myDate=new Date(date.getTime()+dayIn*24*60*60*1000);
    var year=myDate.getFullYear();
    var month=myDate.getMonth()+1;
    var day=myDate.getDate();
    CurrentDate=year+"-";
    if(month>=10)
    {
        CurrentDate = CurrentDate+month+"-";
    }
    else
    {
        CurrentDate = CurrentDate+"0"+month+"-";
    }
    if(day>=10)
    {
        CurrentDate = CurrentDate+day;
    }
    else
    {
        CurrentDate = CurrentDate+"0"+day;
    }
    return CurrentDate;
}

function getAddYearMonth(monthIn) {
    var date=new Date();
    var myDate=new Date(date.getTime()+0*24*60*60*1000);
    var year=myDate.getFullYear();
    var month=myDate.getMonth()+1;
    CurrentDate=year+"-";
    month = month + monthIn;
    if (month >12){
        month =12;
    }
    if (month <1){
        month = 1;
    }
    if(month>=10)
    {
        CurrentDate = CurrentDate+month;
    }
    else
    {
        CurrentDate = CurrentDate+"0"+month;
    }
    return CurrentDate;
}

function getAddYear(yearIn) {
    var date=new Date();
    var myDate=new Date(date.getTime()+0*24*60*60*1000);
    var year=myDate.getFullYear();
    CurrentDate = year+yearIn;

    return CurrentDate;
}

