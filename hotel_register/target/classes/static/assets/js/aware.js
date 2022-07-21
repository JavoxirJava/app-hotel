$(document).ready(function () {
    let id = '';
    let dataTable = $('#aware').DataTable({
        ajax: {
            url: '/aware/list',
            method: 'GET',
            dataSrc: ''
        },
        columns: [
            {title: 'T/r', data: 'tr'},
            {title: "Name", data: 'name'},
            {title: 'Action', data: 'id',
                render: function (date, type, row) {
                    return "<div class='row'>" +
                        "<div class='col'><button class='btn btn-warning' id='edit' data-toggle='modal'>Edit</button></div>" +
                        "<div class='col'><button class='btn btn-danger' id='delete' data-toggle='modal'>Delete</button></div>" +
                        "</div>"
                }
            }
        ]
    })

})