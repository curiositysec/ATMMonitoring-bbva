(function() {
    var base = document.getElementsByTagName('base')[0].getAttribute('href');
    window.location.assignWithBase = function(relativeUrl) {
        window.location.assign(base + relativeUrl);
    }
})()