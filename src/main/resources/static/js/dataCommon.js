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