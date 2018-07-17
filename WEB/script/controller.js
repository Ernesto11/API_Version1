var app = angular.module('APP',[]);

app.filter('searchFilter', function() {
    return function(arr, searchString,page,size_page,scope,index) {
        
        if(!searchString) {
            scope.total_page=Math.ceil(arr.length/size_page);
            
            return arr.slice(page*size_page,(page+1)*size_page);
        }

        searchString =angular.lowercase(searchString) ;

        var result = [];

        angular.forEach(arr, function(el){
            if( angular.lowercase(el[index]).indexOf(searchString) != -1) {
                result.push(el);
            }
        });
        scope.total_page=Math.ceil(result.length/size_page);
        
        return result.slice(page*size_page,(page+1)*size_page);
    };
});

app.controller('Controller', ['$scope','$http', function($scope,$http) {
    var url = "http://localhost:8686/ApiV1/rest/api/";
    $scope.tab = 1;
    $scope.modal = 0;
    $scope.productos ={};
    $scope.value_categoria={};
    $scope.value_marca={};

    $scope.categorias={};
    $scope.unidades_medida={};
    $scope.marcas={};

    $scope.isPost=true;   
    $scope.imagen="";
    $scope.tests=[{value:"alla"},{value:"a2"},{value:"a3"},{value:"ass4"},{value:"a5"},
                  {value:"asa"},{value:"a7ss"},{value:"a8s"},{value:"aa9"},{value:"a0"},
                  {value:"aal"},{value:"aba"},{value:"acs"},{value:"ads"},{value:"ae"},
                  {value:"afa"},{value:"aga"},{value:"ahs"},{value:"aiaa"},{value:"aj"},
                  {value:"bafa"},{value:"baga"},{value:"bahs"},{value:"baiaa"},{value:"baj"},
                  {value:"bafa"},{value:"baga"},{value:"bahs"},{value:"baiaa"},{value:"baj"}];
    //Math.ceil($scope.tests.length/5)
    $scope.page=0;
    $scope.total_page=0;
    $scope.isPage=function(numPage){
        return $scope.page===numPage;
    }
    //paginacion

    $scope.range=function(star,end){
        var range = [];
        for(var i=star;i<end;i++){
            range.push(i);
        }
        return range;
    }
    $scope.pageAdd=function(){
        $scope.page=$scope.page+1;
    }
    $scope.pageSet=function(page){
        $scope.page=page;
    }
    $scope.pageSub=function(){
        $scope.page=$scope.page-1;
    }
    $scope.paginacion= function(lista,sub,page){
        return lista.slice(page*sub,(page+1)*sub);
    }
    //imagen
    $scope.subir_imagen=function(){
        $scope.imagen= document.getElementById("file").value;
        console.log($scope.imagen);
    };
    //productos
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

    //Categorias
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

    $scope.post_categoria=function(){     
        
        $http.post(url+"post_categoria", {
            nombreCategoria:$scope.value_categoria.nombreCategoria
        })
        .success(function(data,status,headers,config){
            $scope.get_categorias();
            $scope.modal=0;
            $scope.value_categoria={};
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });
 
    };
    
    $scope.put_categoria=function(){     
 

        $http.post(url+"put_categoria", {
            id_categoria: $scope.value_categoria.id_categoria,
            nombreCategoria: $scope.value_categoria.nombreCategoria
        })
        .success(function(data,status,headers,config){
            $scope.get_categorias();
            $scope.modal=0;
            $scope.value_categoria={};
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });
    };
    
    $scope.delete_categoria=function(){

        for (i = 0; i < $scope.categorias.length; i++) {
            if($scope.categorias[i].value){
                $scope.value_categoria.id_categoria=$scope.categorias[i].id_categoria;
                $scope.value_categoria.nombreCategoria=$scope.categorias[i].nombreCategoria;
            }
        }
        
        $http.post(url+"delete_categoria", {
            id_categoria:$scope.value_categoria.id_categoria
        })
        .success(function(data,status,headers,config){
            $scope.get_categorias();
            $scope.value_categoria={};
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });

        
         //   $scope.get_categorias();
       //     $scope.value_categoria={};
       
    };
    //Unidades de medida
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
    $scope.get_marcas=function(){     
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

    $scope.post_marca=function(){     
        
        $http.post(url+"post_marca", {
            nombre:$scope.value_marca.nombre
        })
        .success(function(data,status,headers,config){
            $scope.get_marcas();
            $scope.modal=0;
            $scope.value_marca={};
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });
 
    };

    $scope.put_marca=function(){     
 

        $http.post(url+"put_marca", {
            id_marca: $scope.value_marca.id_marca,
            nombre: $scope.value_marca.nombre
        })
        .success(function(data,status,headers,config){
            $scope.get_marcas();
            $scope.modal=0;
            $scope.value_marca={};
        })
        .error(function(err,status,headers,config){
            console.log(err);
        });
    };

    $scope.delete_marca=function(){

        for (i = 0; i < $scope.marcas.length; i++) {
            if($scope.marcas[i].value){
                $scope.value_marca.id_marca=$scope.marcas[i].id_marca;
                $scope.value_marca.nombre=$scope.marcas[i].nombre;
                $http.post(url+"delete_marca", {
                    id_marca:$scope.value_marca.id_marca
                })
                .success(function(data,status,headers,config){
                    $scope.get_marcas();
                    $scope.value_marca={};
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
        if(newModal===3){
            for (i = 0; i < $scope.categorias.length; i++) {
                if($scope.categorias[i].value){
                    $scope.value_categoria=$scope.categorias[i];
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
