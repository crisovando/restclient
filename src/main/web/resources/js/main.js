$(function () {
    $('#editModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var nombre = button.data('nombre'),
            precio = button.data('precio');// Extract info from data-* attributes

        var modal = $(this);
        modal.find('#inputPrecio').val(precio);
        modal.find('#inputNombre').val(nombre);
    });

    $('#deleteModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var id = button.data('id');

        var modal = $(this);
        modal.find('#hddId').val(id);
    });

    $('.btnModalEquip').on('click', submitEdit);
    $('.btnModalEquipDel').on('click', submitDel)


    function submitEdit() {
        $('form.editEquip').submit();
    }
    function submitDel() {
        var data = {},
            url = $('#hddUrl').val();
        data["id"] = $("#hddId").val();
        $.ajax({
            url: url,
            type: 'POST',
            contentType : 'application/json;',
            data: JSON.stringify(data),
            processData: false,
            success: function(result) {
                location = location;
            }
        });
    }
});