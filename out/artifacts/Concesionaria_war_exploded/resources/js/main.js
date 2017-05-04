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

    $('.btnModalEquip').on('click', submitEditEquip);
    $('.btnModalEquipDel').on('click', submitDelEquip)


    function submitEditEquip() {
        $('form.editEquip').submit();
    }
    function submitDelEquip() {
        var data = {};
        data["id"] = $("#hddId").val();
        $.ajax({
            url: '/equip_del',
            type: 'POST',
            contentType : 'application/json;',
            data: JSON.stringify(data),
            processData: false,
            success: function(result) {
                location = '/equip';
            }
        });
    }
});