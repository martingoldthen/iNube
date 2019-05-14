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
                <a class="nav-link" href="#" style="font-size: large">Fidelidad<span class="sr-only">(current)</span></a>
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
                <input type="radio" name="mode" id="Visitas" value="fidelidad-visitas" checked="checked" hidden>
                <label for="Visitas">Visitas</label>
                <input type="radio" name="mode" id="Edad" value="fidelidad-edad" hidden>
                <label for="Edad">Edad</label>
                <input type="radio" name="mode" id="Gasto" value="fidelidad-gasto" hidden>
                <label for="Gasto">Gasto</label>
            </div>
        </div>
        <div class="col-md-8 pt-4">
            <script src="${pageContext.request.contextPath}/resources/code/highcharts.js"></script>
            <script src="${pageContext.request.contextPath}/resources/code/modules/series-label.js"></script>
            <script src="${pageContext.request.contextPath}/resources/code/modules/exporting.js"></script>
            <script src="${pageContext.request.contextPath}/resources/code/modules/export-data.js"></script>

            <div class="fidelidad-display" id="fidelidad-visitas">
                <div id="graphic-container-visitas" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
                <script type="text/javascript">
                    var query = "VisitasClientela/?user="+"${username}";
                    var data;
                    jQuery.get(query, function(response) {
                        data=response;
                        Highcharts.chart('graphic-container-visitas', {
                            chart: {
                                plotBackgroundColor: null,
                                plotBorderWidth: null,
                                plotShadow: false,
                                type: 'pie'
                            },
                            title: {
                                text: '¿Cuánto han repetido tus clientes en el último mes?'
                            },
                            tooltip: {
                                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                            },
                            plotOptions: {
                                pie: {
                                    allowPointSelect: true,
                                    cursor: 'pointer',
                                    dataLabels: {
                                        enabled: true,
                                        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                                        style: {
                                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                        }
                                    }
                                }
                            },
                            series: [{
                                name: 'Porcentaje',
                                colorByPoint: true,
                                data: [{
                                    name: 'No han repetido',
                                    y: data[0],
                                    color: "#5da8ec"
                                }, {
                                    name: 'Han repetido una vez',
                                    y: data[1],
                                    color: "#4aff4b"
                                }, {
                                    name: 'Han repetido dos veces',
                                    y: data[2],
                                    color: "#fdd61e"
                                },
                                    {
                                        name: 'Han repetido tres veces o más',
                                        y: data[3],
                                        color: "#ff1b91"
                                    }]
                            }]
                        });
                    });
                    $('input[name=mode]').change(function () {
                        var query = "VisitasClientela/?user="+"${username}";
                        var data;
                        jQuery.get(query, function(response) {
                            data=response;
                            Highcharts.chart('graphic-container-visitas', {
                                chart: {
                                    plotBackgroundColor: null,
                                    plotBorderWidth: null,
                                    plotShadow: false,
                                    type: 'pie'
                                },
                                title: {
                                    text: '¿Cuánto han repetido tus clientes en el último mes?'
                                },
                                tooltip: {
                                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                                },
                                plotOptions: {
                                    pie: {
                                        allowPointSelect: true,
                                        cursor: 'pointer',
                                        dataLabels: {
                                            enabled: true,
                                            format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                                            style: {
                                                color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                            }
                                        }
                                    }
                                },
                                series: [{
                                    name: 'Porcentaje',
                                    colorByPoint: true,
                                    data: [{
                                        name: 'No han repetido',
                                        y: data[0],
                                        color: "#5da8ec"
                                    }, {
                                        name: 'Han repetido una vez',
                                        y: data[1],
                                        color: "#4aff4b"
                                    }, {
                                        name: 'Han repetido dos veces',
                                        y: data[2],
                                        color: "#fdd61e"
                                    },
                                        {
                                            name: 'Han repetido tres veces o más',
                                            y: data[3],
                                            color: "#ff1b91"
                                        }]
                                }]
                            });
                        });});

                </script>
            </div>

            <div class="fidelidad-display" id="fidelidad-edad">
                <div id="graphic-container-edad" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
                <script type="text/javascript">
                    $('input[name=mode]').change(function () {
                    var query = "EdadClientela/?user="+"${username}";
                    var data;
                    jQuery.get(query, function(response) {
                      data=response;
                        Highcharts.chart('graphic-container-edad', {
                            chart: {
                                plotBackgroundColor: null,
                                plotBorderWidth: null,
                                plotShadow: false,
                                type: 'pie'
                            },
                            title: {
                                text: '¿Cual es la edad de tu clientela?'
                            },
                            tooltip: {
                                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                            },
                            plotOptions: {
                                pie: {
                                    allowPointSelect: true,
                                    cursor: 'pointer',
                                    dataLabels: {
                                        enabled: true,
                                        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                                        style: {
                                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                        }
                                    }
                                }
                            },
                            series: [{
                                name: 'Porcentaje',
                                colorByPoint: true,
                                data: [{
                                    name: '- 25 años',
                                    y: data[1][0],
                                    color: "#5da8ec"
                                }, {
                                    name: 'Entre 26 y 36',
                                    y: data[1][1],
                                    color: "#4aff4b"
                                }, {
                                    name: 'Entre 37 y 50',
                                    y: data[1][2],
                                    color: "#fdd61e"
                                },
                                    {
                                        name: '+50 años',
                                        y: data[1][3],
                                        color: "#ff1b91"
                                    }]
                            }]
                        });
                    });});

                </script>
            </div>


            <div class="fidelidad-display" id="fidelidad-gasto">

                <div id="graphic-container-gasto" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
                <script type="text/javascript"> 
                	$('input[name=mode]').change(function () {
                    var query = "GastoClientela/?user="+"${username}";
                    var data;
                    jQuery.get(query, function(response) {
                      data=response;
                      Highcharts.chart('graphic-container-gasto', {
                          chart: {
                              plotBackgroundColor: null,
                              plotBorderWidth: null,
                              plotShadow: false,
                              type: 'pie'
                          },
                          title: {
                              text: '¿Cuánto gastan de media tus clientes cada vez que van?'
                          },
                          tooltip: {
                              pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                          },
                          plotOptions: {
                              pie: {
                                  allowPointSelect: true,
                                  cursor: 'pointer',
                                  dataLabels: {
                                      enabled: true,
                                      format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                                      style: {
                                          color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                      }
                                  }
                              }
                          },
                          series: [{
                              name: 'Porcentaje',
                              colorByPoint: true,
                              data: [{
                                  name: 'Menos de 20 euros',
                                  y: data[0],
                                  color: "#5da8ec"
                              }, {
                                  name: 'Entre 20 y 50 euros',
                                  y: data[1],
                                  color: "#4aff4b"
                              }, {
                                  name: 'Entre 50 y 100 euros',
                                  y: data[2],
                                  color: "#fdd61e"
                              },
                                  {
                                      name: 'Más de 100 euros',
                                      y: data[3],
                                      color: "#ff1b91"
                                  }]
                          }]
                      });
                    });});
                    
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
        $("#fidelidad-edad").hide();
        $("#fidelidad-gasto").hide();


        $('input[type="radio"]').click(function(){
            var divToShow = $(this).val();
            $("div.fidelidad-display").hide();
            $("#"+divToShow).show();
        });
    });
</script>
</body>
</html>