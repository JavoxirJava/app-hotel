$(document).ready(function (){
    let id = '';
    let dataTable = $('#regions').DataTable({
        ajax:{
            url:'/region/list',
            type:'GET',
            dataSrc: ''
        },
        columns:[
            {title :"T/r", data : 'tr'},
            {title: "Region Name", data: 'name'},
            {title: 'Action', data: 'id',
                render: function (data, type, row){
                    return "<div class='row' >"+
                       "<div class='col'><button class='btn btn-warning' id='edit' data-toggle='modal'>Edit</button></div>"+
                       "<div class='col'><button class='btn btn-danger' id='delete' data-toggle='modal'>Delete</button></div>"+
                    +"</div>"
                }
            }
        ]
    });



    $('#saveRegion').click(function (){
        const countryId = document.getElementById('countrySelect').value;
        const obj = {name : regioName , countryId : countryId}
        $.ajax({
            url: '/region',
            method:'POST',
            contentType: 'application/json',
            data:JSON.stringify(obj)
        });
        window.location.reload();
    });



    $(dataTable.table().body()).on('click', '#edit', function (){
        const data = dataTable.row($(this).parents('tr')).data();
        id = data.id;
        $('#regionEditModal').modal('toggle');
    });

    $('#editRegion').click(function (){
        const regionName = document.getElementById('regionNameEdit').value;
        const countryId = document.getElementById('selectCountry').value;
        const obj = {name : regionName , countryId : countryId, id: id};
        $.ajax({
            url: '/region/' + id,
            method: "PUT",
            contentType: 'application/json',
            data:JSON.stringify(obj)
        })
        $('#regionEditModal').modal('toggle');
        window.location.reload();
    });



    $(dataTable.table().body()).on('click','#delete', function () {
        const data = dataTable.row($(this).parents('tr')).data();
        id = data.id;
        $('#regionDeleteModal').modal('toggle');
    });

    $('#deleteRegion').click(function (){
        $.ajax({
            url: '/region/' + id,
            method: "DELETE",
        });
        $('#regionDeleteModal').modal('toggle');
        window.location.reload();
    });


})