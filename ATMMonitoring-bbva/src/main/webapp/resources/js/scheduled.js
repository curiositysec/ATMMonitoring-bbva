$(document).ready(function() {
    initSchedulerCalendar();
    initSchedulerToggle();
});

function initSchedulerCalendar() {
    $("#schedulerCalendar").fullCalendar({
        events: 'terminals/schedules/updates',
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month, agendaWeek, agendaDay'
        },
        firstDay: 1,
        height: 450,
        allDaySlot: false,
        allDayDefault: false,
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
        timeFormat: {
            agenda: 'H:mm{ - H:mm}', // 5:00 - 6:30
            '': 'HH:mm'            // 19:00
        },
        titleFormat: {
            month: 'MMMM yyyy',                             // September 2009
            week: "d[ yyyy] [MMM]{ '&#8212;'d MMM yyyy}", // 7 - 13 Sep 2009
            day: 'dddd, d MMM yyyy'                  // Tuesday, 8 Sep 2009
        },
        columnFormat: {
            month: 'ddd',    // Mon
            week: 'ddd d/M', // Mon 20/12
            day: 'dddd d/M'  // Monday 20/12
        },
        buttonText: {
            prev:     '&lsaquo;', // <
            next:     '&rsaquo;', // >
            prevYear: '&laquo;',  // <<
            nextYear: '&raquo;',  // >>
            today:    'hoy',
            month:    'mes',
            week:     'semana',
            day:      'día'
        },
        eventRender: function(event, element) {
            element.find(".fc-event-inner").append("<a class='close' onclick='deleteScheduledUpdate(" + event.id + "); return false;' href='#'><span>delete</span></a>");
        }
    });
}

function initSchedulerToggle() {
    $("#toggleSchedulerView li").click(function (event) {
        event.preventDefault();
        var current = $(".scheduler:visible");
        var hide = $(".scheduler:hidden");
        current.hide();
        hide.fadeIn();
        $(this).addClass("current");
        $(this).siblings().removeClass("current");
    });
}
