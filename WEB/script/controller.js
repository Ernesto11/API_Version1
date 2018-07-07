var app = angular.module("app",[]);
app.controller("main_controller",function($scope,$http){
    var url = "http://localhost:8686/ApiV1/rest/api/";
    $scope.productos ={};
    $scope.categorias={};
    $scope.unidades_medida={};
    $scope.text = "hola";
    $scope.get_productos=function(){     
        $http.post(url+"get_products", {

        })
        .success(function(data,status,headers,config){
            $scope.productos=data;
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });
    };
    $scope.get_categorias=function(){     
        $http.post(url+"get_categorias", {

        })
        .success(function(data,status,headers,config){
            $scope.categorias=data;
            
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });
    };

    $scope.get_unidades_medida=function(){     
        $http.post(url+"get_unidades_medida", {

        })
        .success(function(data,status,headers,config){
            $scope.unidades_medida=data;
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });
    };
    $scope.post_producto = function(){
        $scope.text = "hola mundo";
    };
    $scope.get_productos();
    $scope.get_categorias();
    $scope.get_unidades_medida();

    
});