function patasubcounty() {
  var county = document.getElementById("county").value;
    $.ajax({
        url: 'getsubcounty?county=' + county,
        type: 'post',
        dataType: 'html',
        success: function (data)
        {
            $("#subcounty").html(data.replace("<option value=''>Select sub-county</option>", ""));
            var select = document.getElementById('subcounty');
            //select.size = select.length;

            //  App.init();   
        }
 });

}
function patasubcounty_1() {
  var county = document.getElementById("county").value;
    $.ajax({
        url: 'getsubcounty?county=' + county,
        type: 'post',
        dataType: 'html',
        success: function (data)
        {
            $("#subcounty").html(data.replace("<option value=''>Select sub-county</option>", ""));
            var select = document.getElementById('subcounty');
            //select.size = select.length;

            //  App.init();   
        }
 });

}
function showTreatmentDate() {
    var selectBox = document.getElelmentByID('hivStatus');
    var userInput = selectBox.options[selectBox.selectedIndex].value;
    if (userInput === 'Pos') {
        document.getElelmentByID('dttreatment'.style.visibility = 'visible');
    } else {
        document.getElelmentByID('dttreatment'.style.visibility = 'visible');
    }
    return false;
}
function patafacility() {

    var subcounty = document.getElementById("subcounty").value;
    $.ajax({
        url: 'getfacility?subcounty=' + subcounty,
        type: 'post',
        dataType: 'html',
        success: function (data)
        {
            $("#facility").html(data.replace("<option value=''>Select facility</option>", ""));
            var select = document.getElementById('facility');
            // select.size = select.length;
            $('#facility').select();
        }
    });
}
function displayData() {

    $.ajax({
        url: './viewData',
        type: 'GET',
        success: function (data)
        {
            $("#data").html(data);
            //  $('#tb_report_table').DataTable();
            // $('#tb_report_table1').DataTable();

        },
        error: function (error) {
            $("#data").html(error);

        }
    });
}
function displayUpdateData() {

    $.ajax({
        url: './viewUpdate',
        type: 'GET',
        success: function (data)
        {
            $("#data_update").html(data);
            //  
            // $('#tb_report_table1').DataTable();

        },
        error: function (error) {
            $("#data_update").html(error);

        }
    });
}
function pataregfacility() {

    //var subcounty = document.getElementById("subcounty").value;
    $.ajax({
        url: 'get_facility',
        type: 'post',
        dataType: 'html',
        success: function (data)
        {
            $("#department").html(data.replace("<option value=''>Select facility</option>", ""));
            var select = document.getElementById('department');
            // select.size = select.length;
            $('#department').select2();
        }
    });
}
function checkEmail() {

    var email = document.getElementById("email").value;
    $.ajax({
        url: 'username_email_verification?subcounty=' + email,'
        type: 'post',
        dataType: 'html',
        success: function (data)
        {
            $("#email").html(data.replace("<option value=''>Select facility</option>", ""));
               }
    });
}











    