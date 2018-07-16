var app = angular.module('APP',[]);

app.controller('Controller', ['$scope','$http', function($scope,$http) {
    var url = "http://localhost:8686/ApiV1/rest/api/";
    $scope.tab = 1;
    $scope.modal = 0;
    
    $scope.usuarios={};
    $scope.value_usuario={};

    $scope.isPost=true;   
    
    //Funciones Usuario

    $scope.get_usuarios=function(){     
        $http.post(url+"get_usuarios", {

        })
        .success(function(data,status,headers,config){
            $scope.usuarios=data;
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });
    };

    $scope.post_usuario=function(){
        if(angular.equals($scope.value_usuario.contrasena, $scope.value_usuario.contrasena2)){
        $http.post(url+"post_usuario", {
            nombre:$scope.value_usuario.nombre,
            contrasena:$scope.value_usuario.contrasena,
            tipo:$scope.value_usuario.tipo
        })
        .success(function(data,status,headers,config){
            $scope.get_usuarios();
            $scope.modal=0;
            $scope.value_usuario={};
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });
        }     
        else{
            alert("Las contraseñas ingresadas deben ser iguales");
        }

    };

    $scope.delete_usuario=function(){

        for (i = 0; i < $scope.usuarios.length; i++) {
            if($scope.usuarios[i].value){
                $scope.value_usuario.nombre=$scope.usuarios[i].nombre;
                $http.post(url+"delete_usuario", {
                    nombre:$scope.value_usuario.nombre
                })
                .success(function(data,status,headers,config){
                    $scope.get_usuarios();
                    $scope.value_usuario={};
                })
                .error(function(err,status,headers,config){
                    console.log(err);
                });
            }
        }
    };


    $scope.setTab = function(newTab){
        $scope.tab = newTab;
    };
    $scope.isSet = function(tabNum){
        return $scope.tab === tabNum;
    };

    $scope.setModalPost = function(newModal){
        $scope.isPost=true;
        $scope.modal = newModal;
    };
    
    $scope.setModalPut = function(newModal){
        if(newModal===1){
            for (i = 0; i < $scope.usuarios.length; i++) {
                if($scope.usuarios[i].value){
                    $scope.value_usuario=$scope.usuarios[i];
                }
            }
        }

        if(newModal===5){
            for (i = 0; i < $scope.marcas.length; i++) {
                if($scope.marcas[i].value){
                    $scope.value_marca=$scope.marcas[i];
                }
            }
        }
        $scope.isPost=false;
        $scope.modal = newModal;
    };

    $scope.isSetModalPanel = function(modalNum){
        return $scope.modal === modalNum;
    };
    $scope.isSetModal = function(){
        return $scope.modal > 0;
    };

}]);
