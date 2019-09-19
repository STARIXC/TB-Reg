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
    $('#mailexist_err').html('<img src="images/25.gif"> loading...');
    var email = document.getElementById("email").value;
    $.ajax({
        url: 'username_email_verification?email=' + email,
        type: 'post',
        dataType: 'html',
        success: function (data)
        {
            setTimeout(function () {
                $('#mailexist_err').html(data);
                // $('#form_data')[0].reset();
            }, 2000);
        }
    });
}
function checkUsername() {
    $('#usernameexits').html('<img src="images/25.gif"> loading...');
    var username = document.getElementById("username").value;
    $.ajax({
        url: 'username_verification?username=' + username,
        type: 'post',
        dataType: 'html',
        success: function (data)
        {
            setTimeout(function () {
                $('#usernameexits').html(data);
                // $('#form_data')[0].reset();
            }, 2000);
        }
    });
}

function getData() {
// $('#usernameexits').html('<img src="images/25.gif"> loading...');
    var userid = document.getElementById("id").value;
    $.ajax({
        url: 'viewData?userid=' + userid,
        type: 'post',
        dataType: 'json',
        success: function (data)
        {
            var json = jQuery.parseJSON(data);
            //iterate the json Arat and print it in tarbular format
            $.each(json, function (idx, obj) {
                $('#database tr:last').after(

                        '<tr><td>'
                        + obj.SerialNumber +
                        '</td><td>'
                        + obj.SubPartnerID +
                        '</td><td>'
                        + obj.SubCountyRegNo +
                        '</td><td>'
                        + obj.Mflcode +
                        '</td><td>'
                        + obj.SubPartnerNom +
                        '</td><td>'
                        + obj.hivStatus +
                        '</td><td>'
                        + obj.artStatus +
                        '</td><td>'
                        + obj.sex +
                        '</td><td>'
                        + obj.sex +
                        '</td><td>'
                        + obj.age +
                        '</td><td>'
                        + obj.registrationdate +
                        '</td><td><a class="btn btn-sm btn-success" title="Edit" href="edit.jsp?id="' + obj.id + '""><i class="glyphicon glyphicon-edit"></i></a>'
                        + '</td></tr>'


                        );
               // die();
            });
        }
    });
}
getData();








