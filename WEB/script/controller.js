var app = angular.module('APP',[]);
app.controller('Controller', ['$scope','$http', function($scope,$http) {
    var url = "http://localhost:8686/ApiV1/rest/api/";
    $scope.tab = 1;
    $scope.modal = 0;
    $scope.productos ={};
    $scope.categorias={};
    $scope.unidades_medida={};
    $scope.marca={};
    $scope.marcas={};
    
    $scope.setTab = function(newTab){
      $scope.tab = newTab;
    };
    $scope.isSet = function(tabNum){
      return $scope.tab === tabNum;
    };

    $scope.setModal = function(newModal){
        $scope.modal = newModal;
    };
    $scope.isSetModalPanel = function(modalNum){
        return $scope.modal === modalNum;
    };
    $scope.isSetModal = function(){
        return $scope.modal > 0;
    };

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
    //$scope.get_productos();
    
    $scope.get_categorias();
    //$scope.get_unidades_medida();
    
    // Funciones marca

    
    $scope.getMarcas=function(){     
        $http.post(url+"get_marcas", {

        })
        .success(function(data,status,headers,config){
            $scope.marcas=data;
            console.log($scope.marcas);
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });
    };

    $scope.putMarca=function(){     
        $http.post(url+"put_marca", {
            id_marca: $scope.marca.id_marca,
            nombre: $scope.marca.nombre
        })
        .success(function(data,status,headers,config){
            $scope.marca.nombre ="";
            $scope.marca.id_marca ="";
            $scope.getMarcas();
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });
    };

    $scope.getMarcas();


}]);
