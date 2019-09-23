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
        dataType: 'json',
        success: function (data){
            if (data.data.length) {
                $.each(data.data, function (i, data) {

                    alert(data + ": " + data);
                    var display = '<tr><td>'
                            + data.SerialNumber +
                            '</td><td>'
                            + data.SubPartnerID +
                            '</td><td>'
                            + data.SubCountyRegNo +
                            '</td><td>'
                            + data.Mflcode +
                            '</td><td>'
                            + data.SubPartnerNom +
                            '</td><td>'
                            + data.hivStatus +
                            '</td><td>'
                            + data.artStatus +
                            '</td><td>'
                            + data.sex +
                            '</td><td>'
                            + data.sex +
                            '</td><td>'
                            + data.age +
                            '</td><td>'
                            + data.registrationdate +
                            '</td><td><a class="btn btn-sm btn-success" title="Edit" href="edit.jsp?id="' + data.id + '""><i class="glyphicon glyphicon-edit"></i></a>'
                            + '</td></tr>';
                });
                
            } else {
          $('#databody').html("No results");
            }

        },
        error: function (error) {
            $("#data").html(error);
        }
    });
}

displayData();

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

//function getData() {
//// $('#usernameexits').html('<img src="images/25.gif"> loading...');
//    var userid = document.getElementById("id").value;
//    $.ajax({
//        url: 'viewData?userid=' + userid,
//        type: 'post',
//        dataType: 'json',
//        success: function (data)
//        {
//            var json = jQuery.parseJSON(data);
//            //iterate the json Arat and print it in tarbular format
//            $.each(json, function (idx, data) {
//                
//                $('#database tr:last').after(
//
//                        '<tr><td>'
//                        + obj.SerialNumber +
//                        '</td><td>'
//                        + obj.SubPartnerID +
//                        '</td><td>'
//                        + obj.SubCountyRegNo +
//                        '</td><td>'
//                        + obj.Mflcode +
//                        '</td><td>'
//                        + obj.SubPartnerNom +
//                        '</td><td>'
//                        + obj.hivStatus +
//                        '</td><td>'
//                        + obj.artStatus +
//                        '</td><td>'
//                        + obj.sex +
//                        '</td><td>'
//                        + obj.sex +
//                        '</td><td>'
//                        + obj.age +
//                        '</td><td>'
//                        + obj.registrationdate +
//                        '</td><td><a class="btn btn-sm btn-success" title="Edit" href="edit.jsp?id="' + obj.id + '""><i class="glyphicon glyphicon-edit"></i></a>'
//                        + '</td></tr>'
//
//
//                        );
//               // die();
//            });
//        }
//    });
//}
//getData();

//function loadSavedRecordData(id, Mflcode) {
//    //load from tb_data db where id is as selected  
//     $.ajax({
//        url: 'viewData?userid=' + userid,
//        type: 'post',
//        dataType: 'json',
//        success: function (data)
//        {
//            var doc = jQuery.parseJSON(data);
//            //iterate the json Arat and print it in tarbular format
//             //populate div with respective content
//        $("#rowid").val(id);
//
//        //$('select#facilityname').find("option[value='"+mflanddates[0]+"_"+facility+"']").prop('selected', true); 
//        $("#serialNumber").val(doc.serialno);
//        $("#dateOfRegistration").val(doc.registrationdate);
//        $("#subCountyRegNo").val(doc.subcounty_regno);
//        //$("#county").val(doc.hiv_pos_target_adult);
//        // $("#subcounty").val(doc.hiv_pos_target_total);
//        $('select#facility_select').find("option[value='" + doc.subPartnerNom + "']").prop('selected', true);
//        $('select#sex').find("option[value='" + doc.sex + "']").prop('selected', true);
//        $("#ageOnRegistration").val(doc.age);
//        $("#xray").val(doc.xray);
//        $('select#hivStatus').find("option[value='" + doc.hivstatus + "']").prop('selected', true);
//        $("#hivTestDate").val(doc.hivtestdate);
//        $("#dateTreatmentStarted").val(doc.treatmentdate);
//        $('select#art').find("option[value='" + doc.artstatus + "']").prop('selected', true);
//        $("#artdate").val(doc.artdate);
//        $('select#sputumSmear').find("option[value='" + doc.smear0 + "']").prop('selected', true);
//        $("#generalExpert").val(doc.genexpert);
//        $("#withinFacility").val(doc.tested_within_facility);
//        $('select#hivModality').find("option[value='" + doc.initial_modality + "']").prop('selected', true);
//
//        $("#save_data").hide();
//        $("#updatebutton").show();
//
//               // die();
//            });
//        }
//    });
//  
//
//}






