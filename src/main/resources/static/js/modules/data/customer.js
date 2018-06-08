$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'customer/list',
        datatype: "json",
        colModel: [			
			{ label: '机器ID', name: 'customerId', index: "customer_id", width: 45, key: true },
			{ label: '机器名', name: 'customer', width: 75 },
			{ label: '总检测数量', name: 'totalCheck', width: 75,formatter:numberFormatter}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			username: null
		},
        allTotalCheck:0,
		showList: true,
		title:null,
		roleList:{},
		user:{
			status:1,
			roleIdList:[]
		}
	},
	mounted:function () {
        this.queryAllTotalCheck();
    },
	methods: {
		query: function () {
			vm.reload();
		},
		reload: function () {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'customer': vm.q.customer},
                page:page
            }).trigger("reloadGrid");
		},
		queryAllTotalCheck: function(){
            var mySelf = this;
		 		$.ajax({
					url: baseURL + "customer/allTotalCheck",
					type:"post",
					data:{},
					success:function (r) {
						if (r.code == 0){
                            mySelf.allTotalCheck = NumFormat(r.allTotalCheck);
						}
                    }
				})
		},
        validator: function () {
            if(isBlank(vm.user.username)){
                alert("用户名不能为空");
                return true;
            }

            if(vm.user.userId == null && isBlank(vm.user.password)){
                alert("密码不能为空");
                return true;
            }

            if(isBlank(vm.user.email)){
                alert("邮箱不能为空");
                return true;
            }

            if(!validator.isEmail(vm.user.email)){
                alert("邮箱格式不正确");
                return true;
			}
        }
	}
});

function numberFormatter(value, options, row) {
	return NumFormat(value);
}