<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my_activity.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/facturacion.css">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="${pageContext.request.contextPath}/resources/jquery-3.2.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>

<body>
<input type="hidden" id=username name=username value=${username}>


<nav class="navbar navbar-expand-sm navbar-light navbar-custom">
    <a class="navbar-brand" href="#"><img alt="inube"id="foto" src="${pageContext.request.contextPath}/img/inube_logo.png"></a>
    <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId"
            aria-controls="collapsibleNavId"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavId">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="#" style="font-size: large">Facturación<span class="sr-only">(current)</span></a>
            </li>
        </ul>

        <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
            <li><img alt="user image" src="${pageContext.request.contextPath}/img/user_icon_white.png" style="height: 45px;"></li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true"
                  aria-expanded="false" style="color: white">${username}</a>
                <div class="dropdown-menu pull-right" aria-labelledby="dropdownId">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/LogoutServlet">Log out</a>
                </div>
            </li>
        </ul>
    </div>
</nav>


<div class="container ml-5">
    <div class="row pt-4 h-100">
        <div class="col-md-4">
            <div id="checkbox_estilizadas">
                <input type="radio" name="mode" id="Diaria" value="facturacion-diaria" checked="checked" hidden>
                <label for="Diaria">Diaria</label>
                <input type="radio" name="mode" id="Semanal" value="facturacion-semanal" hidden>
                <label for="Semanal">Semanal</label>
                <input type="radio" name="mode" id="Mensual" value="facturacion-mensual" hidden>
                <label for="Mensual">Mensual</label>
            </div>
        </div>
        <div class="col-md-8 pt-4">
            <script src="${pageContext.request.contextPath}/resources/code/highcharts.js"></script>
            <script src="${pageContext.request.contextPath}/resources/code/modules/series-label.js"></script>
            <script src="${pageContext.request.contextPath}/resources/code/modules/exporting.js"></script>
            <script src="${pageContext.request.contextPath}/resources/code/modules/export-data.js"></script>

            <div class="facturacion-display" id="facturacion-diaria">
                <div id="date-select">Escoge un dia:&nbsp;&nbsp;<input id="date-selector" type="date"></div>
                <div id="graphic-container-day"></div>

                <script type="text/javascript">
                    var today = new Date();
                    var dd = String(today.getDate()).padStart(2, '0');
                    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
                    var yyyy = today.getFullYear();

                    today = "Fecha:  " + dd + '/' + mm + '/' + yyyy;

                    Highcharts.chart('graphic-container-day', {

                        title: {
                            text: today
                        },

                        yAxis: {
                            title: {
                                text: 'Facturación (€)'
                            }
                        },

                        xAxis: {
                            title: {
                                text: 'Hora'
                            }
                        },

                        legend: {
                            layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'middle'
                        },

                        plotOptions: {
                            series: {
                                label: {
                                    connectorAllowed: false
                                },
                                pointStart: 8
                            }
                        },

                        series: [{
                            name: 'Facturación',
                            //data: [5, 7, 9, 13, 20, 21, 19, 18, 22, 6, 13, 15, 12, 8]
                        	data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
                        }],

                        responsive: {
                            rules: [{
                                condition: {

                                },
                                chartOptions: {
                                    legend: {
                                        layout: 'horizontal',
                                        align: 'center',
                                        verticalAlign: 'bottom'
                                    }
                                }
                            }]
                        }

                    })


                    $('#date-selector').change(function(){
                        var fecha = "Fecha:  " + $("#date-selector").val().toString().split("-").reverse().join("/");
                        jQuery.get("FacturaDia/?dia="+ $("#date-selector").val()+"&username="+$("#username").val(), function(response) {// Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
             
                        	 Highcharts.chart('graphic-container-day', {

                                 title: {
                                     text: fecha
                                 },

                                 yAxis: {
                                	 min: 0,
                                     title: {
                                         text: 'Facturación (€)'
                                     }
                                 },

                                 xAxis: {
                                     title: {
                                         text: 'Hora'
                                     }
                                 },

                                 legend: {
                                     layout: 'vertical',
                                     align: 'right',
                                     verticalAlign: 'middle'
                                 },

                                 plotOptions: {
                                     series: {
                                         label: {
                                             connectorAllowed: false
                                         },
                                         pointStart: 0
                                     }
                                 },

                                 series: [{
                                     name: 'Facturación',
                                     data: response
                                 }],

                                 responsive: {
                                     rules: [{
                                         condition: {

                                         },
                                         chartOptions: {
                                             legend: {
                                                 layout: 'horizontal',
                                                 align: 'center',
                                                 verticalAlign: 'bottom'
                                             }
                                         }
                                     }]
                                 }

                             })
                        });

                        }
                    )
                </script>
            </div>
            <div class="facturacion-display" id="facturacion-semanal">
                <div id="date-select2">Escoge un dia de la semana que deseas ver:&nbsp;&nbsp;<input id="date-selector2" type="date"></div>
                <div id="graphic-container-week" style="min-width: 300px; height: 400px; margin: 0 auto"></div>



            <script type="text/javascript">
                Highcharts.chart('graphic-container-week', {
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Facturación de esta semana'
                    },
                    xAxis: {
                        type: 'category',
                        labels: {
                            rotation: 0,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif'
                            }
                        }
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Facturación (€)'
                        }
                    },
                    legend: {
                        enabled: false
                    },
                    series: [{
                        name: 'Facturación',
                        data: [
                            ['Lunes', 0],
                            ['Martes', 0],
                            ['Miércoles', 0],
                            ['Jueves', 0],
                            ['Viernes', 0],
                            ['Sábado', 0],
                            ['Domingo', 0]
                        ],
                        dataLabels: {
                            enabled: true,
                            rotation: -90,
                            color: '#FFFFFF',
                            align: 'right',
                            format: '{point.y:.1f}', // one decimal
                            y: 10, // 10 pixels down from the top
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif'
                            }
                        }
                    }]
                });

                $('#date-selector2').change(function(){
                    var fecha = $("#date-selector2").val().toString().split("-").reverse().join("/");
                    jQuery.get("FacturaSemana/?dia="+ $("#date-selector2").val()+"&username="+$("#username").val(), function(response) {// Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                    	var datos = [['Lunes',response[0]],['Martes',response[1]],['Miercoles',response[2]],['Jueves',response[3]],['Viernes',response[4]],['Sabado',response[5]],['Domingo',response[6]]];
                    	Highcharts.chart('graphic-container-week', {
                             chart: {
                                 type: 'column'
                             },
                             title: {
                                 text: 'Facturación de la semana del ' + fecha
                             },
                             xAxis: {
                                 type: 'category',
                                 labels: {
                                     rotation: 0,
                                     style: {
                                         fontSize: '13px',
                                         fontFamily: 'Verdana, sans-serif'
                                     }
                                 }
                             },
                             yAxis: {
                                 min: 0,
                                 title: {
                                     text: 'Facturación (€)'
                                 }
                             },
                             legend: {
                                 enabled: false
                             },
                             series: [{
                                 name: 'Facturación',
                                 data: datos,
                                 dataLabels: {
                                     enabled: true,
                                     rotation: -90,
                                     color: '#FFFFFF',
                                     align: 'right',
                                     format: '{point.y:.1f}', // one decimal
                                     y: 10, // 10 pixels down from the top
                                     style: {
                                         fontSize: '13px',
                                         fontFamily: 'Verdana, sans-serif'
                                     }
                                 }
                             }]
                         })
                    	 
                    });


                   });
            </script>

            </div>
            <div class="facturacion-display" id="facturacion-mensual">
                <div id="date-select3">
                Selecciona un mes y un año
                <form><select id="month">
                    <option value="">Mes</option>
                    <option value="Enero">Enero</option>
                    <option value="Febrero">Febrero</option>
                    <option value="Marzo">Marzo</option>
                    <option value="Abril">Abril</option>
                    <option value="Mayo">Mayo</option>
                    <option value="Junio">Junio</option>
                    <option value="Julio">Julio</option>
                    <option value="Agosto">Agosto</option>
                    <option value="Septiembre">Septiembre</option>
                    <option value="Octubre">Octubre</option>
                    <option value="Noviembre">Noviembre</option>
                    <option value="Diciembre">Diciembre</option>
                </select>
                    <select id="year">
                        <option>Año</option>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                    </select></form></div>

                <div id="graphic-container-month" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
                <script type="text/javascript">
                    Highcharts.chart('graphic-container-month', {
                        chart: {
                            type: 'column'
                        },
                        title: {
                            text: 'Facturación del mes actual'
                        },
                        xAxis: {
                            type: 'category',
                            labels: {
                                rotation: 0,
                                style: {
                                    fontSize: '13px',
                                    fontFamily: 'Verdana, sans-serif'
                                }
                            }
                        },
                        yAxis: {
                            min: 0,
                            title: {
                                text: 'Facturación (€)'
                            }
                        },
                        legend: {
                            enabled: false
                        },
                        series: [{
                            name: 'Facturación',
                            data:                [
                                ['1', 0],
                                ['2', 0],
                                ['3', 0],
                                ['4', 0],
                                ['5', 0],
                                ['6', 0],
                                ['7', 0],
                                ['8', 0],
                                ['9', 0],
                                ['10', 0],
                                ['11', 0],
                                ['12', 0],
                                ['13', 0],
                                ['14', 0],
                                ['15', 0],
                                ['16', 0],
                                ['17', 0],
                                ['18', 0],
                                ['19', 0],
                                ['20', 0],
                                ['21', 0],
                                ['22', 0],
                                ['23', 0],
                                ['24', 0],
                                ['25', 0],
                                ['26', 0],
                                ['27', 0],
                                ['28', 0],
                                ['29', 0],
                                ['30', 0],
                                ['31', 0]
                            ],
                            dataLabels: {
                                enabled: true,
                                rotation: -90,
                                color: '#FFFFFF',
                                align: 'right',
                                format: '{point.y:.1f}', // one decimal
                                y: 10, // 10 pixels down from the top
                                style: {
                                    fontSize: '13px',
                                    fontFamily: 'Verdana, sans-serif'
                                }
                            }
                        }]
                    });

                    $('#year, #month').change(function(){

                        var fecha = "Facturación de " + $("#month").val() + " de "+ $("#year").val();

                        var username = "${username}";
                        var query = "FacturaMes/?dia="+$("#year").val()+"-"+$("#month").val()+"&user="+username;
                        var datos=[];
                        jQuery.get(query, function(response) {
                        	debugger;
                        	var paso;
                        	for (paso = 0; paso < response.length; paso++) {
                        	  datos[paso]=[paso+1,response[paso]];
                        	};
                        	debugger;
                        console.log(response);
                        Highcharts.chart('graphic-container-month', {
                            chart: {
                                type: 'column'
                            },
                            title: {
                                text: fecha
                            },
                            xAxis: {
                                type: 'category',
                                labels: {
                                    rotation: 0,
                                    style: {
                                        fontSize: '13px',
                                        fontFamily: 'Verdana, sans-serif'
                                    }
                                }
                            },
                            yAxis: {
                                min: 0,
                                title: {
                                    text: 'Facturación (€)'
                                }
                            },
                            legend: {
                                enabled: false
                            },
                            series: [{
                                name: 'Facturación',
                                data: datos,
                                dataLabels: {
                                    enabled: true,
                                    rotation: -90,
                                    color: '#FFFFFF',
                                    align: 'right',
                                    format: '{point.y:.1f}', // one decimal
                                    y: 10, // 10 pixels down from the top
                                    style: {
                                        fontSize: '13px',
                                        fontFamily: 'Verdana, sans-serif'
                                    }
                                }
                            }]
                        });
                        });
                    });
                </script>


            </div>
        </div>
    </div>
</div>



<!-- Tab panes -->
<div class="tab-content">
    <div class="tab-pane fade show active" id="tab1Id" role="tabpanel"></div>
    <div class="tab-pane fade" id="tab2Id" role="tabpanel"></div>
    <div class="tab-pane fade" id="tab3Id" role="tabpanel"></div>
    <div class="tab-pane fade" id="tab4Id" role="tabpanel"></div>
    <div class="tab-pane fade" id="tab5Id" role="tabpanel"></div>
</div>

<script>
    $('#navId a').click(e => {
        e.preventDefault();
        $(this).tab('show');
    });

    $(document).ready(function(){
        $("#facturacion-mensual").hide();
        $("#facturacion-semanal").hide();


        $('input[type="radio"]').click(function(){
            var divToShow = $(this).val();
            $("div.facturacion-display").hide();
            $("#"+divToShow).show();
        });
    });
</script>
</body>
</html>