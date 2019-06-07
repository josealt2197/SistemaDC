/* Greybox Redux
 * Required: http://jquery.com/
 * Written by: John Resig
 * Based on code by: 4mir Salihefendic (http://amix.dk)
 * License: LGPL (read more in LGPL.txt)
 *Update by Jonathan Thames.
 */

var GB_DONE = false;
var GB_HEIGHT = 400;
var GB_WIDTH = 400;

function GB_show(caption,contexto,accion,data,page,height,width) {
    GB_URL=contexto+accion;
    GB_PAGE=contexto+page;
    GB_HEIGHT = height || 400;
    GB_WIDTH = width || 400;
    if(!GB_DONE) {
        $(document.body)
        .append("<div id='GBwindow'><div id='GBcaption'></div><div id='GBLoading'>"
            +"<img class='loading' align='center' src='"+contexto+"/images/loading1.gif' alt='Cargando'/></div>"
            +"<img class='salir' src='"+contexto+"/images/Exit.png' alt='Close window'/></div>");
        $("#GBwindow img").click(GB_hide);
        $(window).resize(GB_position);
        GB_DONE = true;
    }
    else
    {
        $("#GBLoading").css("display", "block");
    }
    $("#GBframe").remove();
    $("#GBcaption").html(caption);
    GB_position();  
    $("#GBwindow").show();
    $.ajax({
        url: GB_URL,
        data:data,
        beforeSend: function(){
            $("#GBLoading").show();
        },
        complete: function(){
            $("#GBLoading").hide();
            $("#GBwindow").append("<iframe id='GBframe' src='"+GB_PAGE+"'></iframe>");
            GB_position();
            $("#GBwindow img.salir").show();
        },
        type: "GET"
    });
}

function GB_hide() {
    $("#GBwindow").hide();
}

function GB_position() {
    var de = document.documentElement;
    var w = self.innerWidth || (de&&de.clientWidth) || document.body.clientWidth;
    $("#GBwindow").css({
        width:GB_WIDTH+"px",
        height:GB_HEIGHT+"px",
        left: ((w - GB_WIDTH)/2)+"px"
    });
    $("#GBframe").css("height",GB_HEIGHT - 32 +"px");
}
