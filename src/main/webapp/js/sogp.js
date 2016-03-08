var menuStatus = true;

window.addEventListener('resize', function(evt)
{
    showHideMenuByResolution();
});

function showHideMenuByResolution()
{
    var width = window.innerWidth;
    
    if(width >= 990)
    {
        $('#divMenuBar').show();
    }
    else
    {
        $('#divMenuBar').hide();
    }
}

function showHideMenu()
{
    if(menuStatus)
    {
        $('#divMenuBar').hide();
        menuStatus = !menuStatus;
    }
    else
    {
        $('#divMenuBar').show();    
        menuStatus = !menuStatus;
    }
}