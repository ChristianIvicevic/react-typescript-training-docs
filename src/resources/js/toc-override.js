var toctitle = document.getElementById('toctitle');
var path = window.location.pathname;
if (toctitle != null) {
    tocbot.init({
        contentSelector: '#content',
        headingSelector: 'h1, h2, h3, h4, h5',
        positionFixedSelector: 'body',
        fixedSidebarOffset: 90,
        smoothScroll: false,
        // This will expand all TOC elements right away which most of the time is preferred anyways
        collapseDepth: 6
    });
}
