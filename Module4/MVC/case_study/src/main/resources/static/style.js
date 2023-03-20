let baseUrl = window.location.origin;

$(document).ready(function () {
    $("#createNew").on("click", function () {
        createNew();
    });
    $("#edit").on("click", function () {
        saveEdit();
    })
    $("#deleteThis").on("click", function () {
        deleteThis();
    })
})

function deleteThis() {

    $.ajax({
        // const id= document.getElementById("deleteId").value;
        type: "DELETE",
        url: `/api/${$("#deleteId").val()}`,
        dataType: "json",
        contentType: "application/json",
        success: function () {
            alert("ok");
            window.location = `${baseUrl}/contract`;
        },
        error: function () {
            alert("Delete not ok");
        }
    })
}
function saveEdit() {
    let jsonText = {
        "id": document.getElementById("idEdit").value,
        "startDate": document.getElementById("startDateEdit").value,
        "endDate": document.getElementById("endDateEdit").value,
        "deposit": document.getElementById("depositEdit").value,
        "facility": document.getElementById("facilityEdit").value,
        "customer": document.getElementById("customerEdit").value,
        "employee": document.getElementById("employeeEdit").value,
    }
    console.log(jsonText);
    $.ajax({
        type: "PATCH",
        url: "/api/",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(jsonText),
        success: function (event) {
            alert("edit ok")
            window.location = "http://localhost:8080/contract";
        },
        error: function (event) {
            checkError(event);
        }

    })
}
function showInfoEdit(id, startDate, endDate, deposit, facility_id, customer_id, employee_id) {
    document.getElementById("idEdit").value = id;
    document.getElementById("startDateEdit").value = startDate;
    document.getElementById("endDateEdit").value = endDate;
    document.getElementById("depositEdit").value = deposit;
    document.getElementById("facilityEdit").value = facility_id;
    document.getElementById("customerEdit").value = customer_id;
    document.getElementById("employeeEdit").value = employee_id;

}

function checkError(data) {
    switch (data.status) {
        case 400:
            $(".startDate").html(data.responseJSON.startDate);
            $(".endDate").html(data.responseJSON.endDate);
            $(".deposit").html(data.responseJSON.deposit);
            break;
        case 500:
            alert("loi he thong nhap lai di em");
            break;
    }

}

function createNew() {
    let startDate = document.getElementById("startDateNew").value;
    let endDate = document.getElementById("endDateNew").value;
    let deposit = document.getElementById("depositNew").value;
    let facility = document.getElementById("facilityNew").value;
    let customer = document.getElementById("customerNew").value;
    let employee = document.getElementById("employeeNew").value;
    let jsonText = {
        "startDate": startDate,
        "endDate": endDate,
        "deposit": deposit,
        "facility": facility,
        "customer": customer,
        "employee": employee,
    }
    console.log(jsonText);
    $.ajax({
        type: "POST",
        url: "/api/",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(jsonText),
        success: function () {
            alert("ok");
            window.location = `${baseUrl}/contract`;
        },
        error: function (event) {
            checkError(event)
        }

    })

    // function showInfoEdit(id) {
    //     console.log(id)
    //     $.ajax({
    //         type: 'GET',
    //         url: `${baseUrl}/api/${id}`,
    //         dataType: "json",
    //         contentType: "application/json",
    //         success: function (event) {
    //             console.log(event);
    //             document.getElementById("idEdit").innerText = event.id;
    //             document.getElementById("startDateEdit").innerText = event.startDate;
    //             document.getElementById("endDateEdit").innerText = event.endDate;
    //             document.getElementById("depositEdit").innerText = event.deposit;
    //             document.getElementById("facilityEdit").innerText = event.facility;
    //             document.getElementById("customerEdit").innerText = event.customer;
    //             document.getElementById("employeeEdit").innerText = event.employee;
    //         }
    //     })
    //
    // }
}