$(function () {
    $('#editModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var nombre = button.data('nombre'),
            precio = button.data('precio');// Extract info from data-* attributes

        var modal = $(this);
        modal.find('#inputPrecio').val(precio);
        modal.find('#inputNombre').val(nombre);
    })

    $('.btnModalEquip').on('click', submitEditEquip)

    function submitEditEquip() {
        $('form.editEquip').submit();
    }
});