/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*Ocultar alerta cada n segundos*/
$(document).ready(function() {
    setTimeout(function() {
        $(".message").fadeOut(5000);
    },500);
});

$(document).ready(function() {
    setTimeout(function() {
        $(".error").fadeOut(10000);
    },500);
});