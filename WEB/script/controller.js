var app = angular.module("app",[]);
app.controller("main_controller",function($scope,$http){
    $scope.posts=[];
    $scope.new_post = {};
    $scope.productos ={};
    $scope.get_productos=function(){     
        $http.post("http://localhost:8686/ApiV1/rest/api/get_products", {

        })
        .success(function(data,status,headers,config){
            $scope.productos=data;
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });
    };
    $scope.get_productos();
    $scope.add_post = function(){  
        $http.post("http://localhost:8686/ApiV1/rest/api/get_products", {
            usuario:"java",
            contrasena: "1234"
        })

        .success(function(data,status,headers,config){
            $scope.usuario=data;
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });
    };
    
});